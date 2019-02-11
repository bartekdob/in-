package hotelAPI.hotel;

import hotelAPI.DBFile.DBFileService;
import hotelAPI.roomType.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HotelController {

	@Autowired
	private HotelService service;
	@Autowired
	private DBFileService dbFileService;
	@Autowired
	private RoomTypeService rtService;
	
	@RequestMapping("/hotels")
	public List<HotelViewModel> getAllHotels() {
		ArrayList<HotelViewModel> resp = new ArrayList<>();
		service.getAll().forEach(hotel -> {	HotelViewModel hvm = new HotelViewModel(hotel);
											try{
												hvm.setPhoto(dbFileService.getFile(hotel.getMainPhoto().getId()).getData());
											}
											catch (Exception ex){

											}
											resp.add(hvm);
											});
		return resp;
	}
	
	@RequestMapping("/hotels/{id}")
	public Optional<HotelDetailsViewModel> getHotel(@PathVariable int id) {
		HotelDetailsViewModel hdvm = new HotelDetailsViewModel(service.getEntity(id).get());
		if(hdvm != null){
			dbFileService.getHotelPhotos(id).forEach(hotelPhoto-> hdvm.getRoomPhotos().add(hotelPhoto.getData()));
			hdvm.setRoomTypes(rtService.getHotelRoomTypes(id));
		}
		return Optional.of(hdvm);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/hotels")
	public void addHotel(@RequestBody Hotel hotel) {
		service.add(hotel);
	}

	@RequestMapping(method = RequestMethod.POST, value ="/hotels/createHotel")
	public ResponseEntity createHotel(@RequestBody HotelCreateDTO hotelCreateDTO)
	{
		HashMap<String, Object> resp = new HashMap<>();
		int hotelId = service.createHotel(hotelCreateDTO);
		if (hotelId != 0) {
			resp.put("message", "Dodano hotel");
			resp.put("hotelId", hotelId);
			return ResponseEntity.status(HttpStatus.OK).body(resp);
		}
		else
		{
			resp.put("message", "Nie utworzono hotelu");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
		}
	}
/*
	@RequestMapping(method=RequestMethod.PUT, value="/hotels/{id}")
	public void addHotel(@RequestBody Hotel hotel, @PathVariable int id) {
		service.add(hotel);
	}
	*/
	@PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
	@RequestMapping(method=RequestMethod.DELETE, value="/hotels/{id}")
	public void deleteHotel(@PathVariable int id) {
		service.deleteById(id);
	}

	@RequestMapping(value = "/hotels/managedHotels", method = RequestMethod.GET)
	public ArrayList<HotelViewModel> getManagedHotels()
	{
		Set<Hotel> managedHotels = service.getManagedHotels();
		ArrayList<HotelViewModel> resp = new ArrayList<>();
		managedHotels.forEach(hotel -> {
			HotelViewModel hvm = new HotelViewModel(hotel);
			try{
				hvm.setPhoto(dbFileService.getFile(hotel.getMainPhoto().getId()).getData());
			}
			catch (Exception ex){

			}
			resp.add(hvm);
		});
		return resp;
	}

	@RequestMapping(value = "/uploadHotelMainPhoto/{hotelId}", method = RequestMethod.POST)
	public ResponseEntity uploadMainPhoto(@RequestBody MultipartFile files, @PathVariable int hotelId)
	{
		Map<String, Object> resp = new HashMap<>();
		if(service.saveMainPhoto(files, hotelId))
		{
			resp.put("message", "Dodano zdjecie");
			return ResponseEntity.ok(resp);
		}
		else
		{
			resp.put("message", "Nie udalo sie dodac zdjecia");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
		}
	}


}
