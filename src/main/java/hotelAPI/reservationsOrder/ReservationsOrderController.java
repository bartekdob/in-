package hotelAPI.reservationsOrder;

import hotelAPI.reservation.Reservation;
import hotelAPI.room.Room;
import hotelAPI.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ReservationsOrderController {

    @Autowired
    ReservationsOrderService service;


    @RequestMapping(method = RequestMethod.POST, value = "/reserve")
    ResponseEntity makeReservation(@RequestBody ReservationOrderViewModel rovm){

        return ResponseEntity.ok(service.tryToReserve(rovm));
    }
}
