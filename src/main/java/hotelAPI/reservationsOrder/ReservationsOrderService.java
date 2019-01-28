package hotelAPI.reservationsOrder;

import hotelAPI.hotel.Hotel;
import hotelAPI.hotel.HotelService;
import hotelAPI.reservation.Reservation;
import hotelAPI.reservation.ReservationRepository;
import hotelAPI.reservation.ReservationService;
import hotelAPI.room.Room;
import hotelAPI.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationsOrderService {

    @Autowired
    ReservationsOrderRepository repo;
    @Autowired
    RoomService roomService;
    @Autowired
    ReservationService reservationService;
    @Autowired
    HotelService hotelService;

    private boolean orderCanBySatisfied = true ;

    public List<ReservationsOrder> findAll(){
        return repo.findAll();
    }

    public List<ReservationsOrder> findAllByHotelId(int hotelId){
        return repo.findAllByHotelId(hotelId);
    }

    public void addReservationOrder(ReservationsOrder ro){
        repo.save(ro);
    }

    public void removeReservationOrder(int id){
        repo.deleteById(id);
    }

    List<Reservation> tryToReserve(ReservationOrderViewModel rovm){
        ArrayList<Room> roomList = new ArrayList<>();
        ArrayList<Reservation> reservationList = new ArrayList<>();
        rovm.getRoomTypeRequest().forEach((roomTypeId, requestedNumber)->{
            if(roomService.findFreeRoomsIds(roomTypeId, rovm.getHotelId(), rovm.getDateFrom(), rovm.getDateTo()).size() < requestedNumber)
                orderCanBySatisfied = false;
        });
        if(orderCanBySatisfied)
        {
            ReservationsOrder ro = repo.save(new ReservationsOrder(rovm.getUserId(),rovm.getHotelId()));
      //      Hotel hotel = hotelService.getEntity(rovm.getHotelId()).get();
            final int roId = ro.getId();
            try{
                rovm.getRoomTypeRequest().forEach((roomTypeId, requestedNumber)-> {
                    roomList.clear();
                    roomList.addAll(roomService.findFreeRooms(roomTypeId, rovm.getHotelId(), rovm.getDateFrom(), rovm.getDateTo()));
                    for(int i=0; i < requestedNumber; i++)
                    {
                        reservationList.add(new Reservation(roomList.get(i), ro, rovm.getDateFrom(), rovm.getDateTo()));
                    }
                });

                reservationList.forEach(reservation -> {
                   // reservation.getRoom().setHotel(hotel);
                    reservation.setOrderId(roId);
                    reservationService.add(reservation);
                });
            }
            catch (Exception err)
            {
                reservationList.forEach(reservation -> reservationService.deleteById(reservation.getId()););
                repo.deleteById(roId);
            }

        }
            return reservationList;
    }
}
