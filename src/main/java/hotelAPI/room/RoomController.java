package hotelAPI.room;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hotelAPI.reservation.Reservation;
import hotelAPI.room.Room;

@RestController
public class RoomController {

	@Autowired
	private RoomService service;
	
	@RequestMapping("/rooms")
	public List<Room> getAllRooms() {
		return service.getAll();
	}
	
	@RequestMapping("/rooms/{id}")
	public Optional<Room> getRoom(@PathVariable int id) {
		return service.getEntity(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/rooms")
	public void addRoom(@RequestBody Room room) {
		service.add(room);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/rooms/{id}")
	public void addRoom(@RequestBody Room room, @PathVariable int id) {
		service.add(room);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/rooms/{id}")
	public void deleteRoom(@PathVariable int id) {
		service.deleteById(id);
	}
	
}
