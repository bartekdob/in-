package hotelAPI.hotel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HotelController {

	@Autowired
	private HotelService service;
	
	@RequestMapping("/hotels")
	public List<Hotel> getAllHotels() {
		return service.getAll();
	}
	
	@RequestMapping("/hotels/{id}")
	public Optional<Hotel> getHotel(@PathVariable int id) {
		return service.getEntity(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/hotels")
	public void addHotel(@RequestBody Hotel hotel) {
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
