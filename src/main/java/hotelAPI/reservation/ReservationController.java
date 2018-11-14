package hotelAPI.reservation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ReservationController {

	@Autowired
	private ReservationService service;
	
	@RequestMapping("/reservaions")
	public List<Reservation> getAll() {
		return service.getAll();
	}
	
	@RequestMapping("/reservations/{id}")
	public Optional<Reservation> get(@PathVariable int id) {
		return service.getEntity(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/reservations")
	public void add(@RequestBody Reservation Reservation) {
		service.add(Reservation);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/reservations/{id}")
	public void addHotel(@RequestBody Reservation Reservation, @PathVariable int id) {
		service.add(Reservation);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/reservations/{id}")
	public void deleteHotel(@RequestBody Reservation Reservation, @PathVariable int id) {
		service.deleteById(id);
	}
	
	
}
