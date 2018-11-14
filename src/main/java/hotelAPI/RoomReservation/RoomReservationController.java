package hotelAPI.RoomReservation;

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
public class RoomReservationController {

	@Autowired
	private RoomReservationService service;
	
	@RequestMapping("/roomReservations")
	public List<RoomReservation> getAlls() {
		return service.getAll();
	}
	
	@RequestMapping("/roomReservations/{id}")
	public Optional<RoomReservation> getReservation(@PathVariable int id) {
		return service.getEntity(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/roomReservations")
	public void addReservation(@RequestBody RoomReservation RoomReservation) {
		service.add(RoomReservation);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/roomReservations/{id}")
	public void addReservation(@RequestBody RoomReservation RoomReservation, @PathVariable int id) {
		service.add(RoomReservation);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/RoomReservations/{id}")
	public void deleteReservation(@RequestBody RoomReservation RoomReservation, @PathVariable int id) {
		service.deleteById(id);
	}
	
	
}
