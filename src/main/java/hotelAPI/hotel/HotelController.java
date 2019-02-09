package hotelAPI.hotel;

import java.util.*;

import hotelAPI.DBFile.DBFileService;
import hotelAPI.roomType.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
												hvm.setPhoto(dbFileService.getFile(hotel.getMainPhotoId()).getData());
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
		if (service.createHotel(hotelCreateDTO)) {
			resp.put("message", "Dodano hotel");
			return ResponseEntity.status(HttpStatus.OK).body(resp);
		}
		else
		{
			resp.put("message", "Nie utworzono hotelu");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
		}
	}

	@RequestMapping(method=RequestMethod.PUT, value="/hotels/{id}")
	public void addHotel(@RequestBody Hotel hotel, @PathVariable int id) {
		service.add(hotel);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/Hotels/{id}")
	public void deleteHotel(@RequestBody Hotel Hotel, @PathVariable int id) {
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
				hvm.setPhoto(dbFileService.getFile(hotel.getMainPhotoId()).getData());
			}
			catch (Exception ex){

			}
			resp.add(hvm);
		});
		return resp;
	}
}
