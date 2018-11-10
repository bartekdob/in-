package hotelAPI.hotel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {

	@Autowired
	private HotelService service;
	
	@RequestMapping("/hotels")
	public List<Hotel> getAllHotels() {
		return service.viewAll();
	}
	
	@RequestMapping("/hotels/{id}")
	public Optional<Hotel> getHotel(@PathVariable int id) {
		return service.getHotel(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/hotels")
	public void addHotel(@RequestBody Hotel Hotel) {
		service.addHotel(Hotel);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/hotels/{id}")
	public void addHotel(@RequestBody Hotel Hotel, @PathVariable int id) {
		service.updateHotel(Hotel);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/Hotels/{id}")
	public void deleteHotel(@RequestBody Hotel Hotel, @PathVariable int id) {
		service.deleteHotel(id);
	}
	
	
}
