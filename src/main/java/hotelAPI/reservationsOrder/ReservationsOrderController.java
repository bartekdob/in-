package hotelAPI.reservationsOrder;

import hotelAPI.configuration.JwtTokenUtil;
import hotelAPI.reservation.Reservation;
import hotelAPI.room.Room;
import hotelAPI.room.RoomService;
import hotelAPI.user.User;
import hotelAPI.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

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
        }
        else
            resp.put("message", "Brak wymaganej liczby pokoi o tym standardzie na podany termin");
        return ResponseEntity.ok(resp);
    }
}
