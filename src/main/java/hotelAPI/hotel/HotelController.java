package hotelAPI.hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import hotelAPI.DBFile.DBFileService;
import hotelAPI.roomType.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
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
		hotel.setMainPhoto(dbFileService.getNoPhotoAvailableGraphic());
		service.add(hotel);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/hotels/{id}")
	public void addHotel(@RequestBody Hotel hotel, @PathVariable int id) {
		service.add(hotel);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/Hotels/{id}")
	public void deleteHotel(@RequestBody Hotel Hotel, @PathVariable int id) {
		service.deleteById(id);
	}
	
	
}
