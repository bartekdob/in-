package hotelAPI.reservationsOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ReservationsOrderController {

    @Autowired
    ReservationsOrderService service;


    @RequestMapping(method = RequestMethod.POST, value = "/reserve")
    ResponseEntity makeReservation(@RequestBody ReservationOrderViewModel rovm){
        HashMap<String, Object> resp = new HashMap<>();
        if(service.tryToReserve(rovm).size() > 0)
        {
            resp.put("message", "Dokonano rezerwacji");
            return ResponseEntity.status(HttpStatus.OK).body(resp);
        }
        else
        {
            resp.put("message", "Brak wymaganej liczby pokoi o tym standardzie na podany termin");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/userReservations")
    ResponseEntity getUsersReservations()
    {
        return ResponseEntity.ok(service.getUsersReservations());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/checkAvailability")
    ResponseEntity checkAvailability(@RequestBody ReservationOrderViewModel rovm){
        HashMap<String, Object> resp = new HashMap<>();
        if(service.checkAvailability(rovm))
        {
            resp.put("message", "Rezerwacja możliwa do spełnienia");
            return ResponseEntity.status(HttpStatus.OK).body(resp);
        }
        else
        {
            resp.put("message", "Brak wymaganych pokoi w tym terminie");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
        }

    }
}
