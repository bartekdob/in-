package hotelAPI.roomType;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import hotelAPI.reservation.Reservation;

@RestController
public class RoomTypeController {

	@Autowired
	private RoomTypeService service;
	
	@RequestMapping("/roomTypes")
	public List<RoomType> getAllRoomTypes() {
		return service.getAll();
	}
	
	@RequestMapping("/roomTypes/{id}")
	public Optional<RoomType> getRoomType(@PathVariable int id) {
		return service.getEntity(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/roomTypes")
	public void addRoomType(@RequestBody RoomType RoomType) {
		service.add(RoomType);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/roomTypes/{id}")
	public void addRoomType(@RequestBody RoomType RoomType, @PathVariable int id) {
		service.add(RoomType);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/roomTypes/{id}")
	public void deleteRoomType(@RequestBody RoomType RoomType, @PathVariable int id) {
		service.deleteById(id);
	}
	
	
}
