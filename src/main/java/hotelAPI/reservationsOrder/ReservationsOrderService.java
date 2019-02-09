package hotelAPI.reservationsOrder;

import hotelAPI.DBFile.DBFile;
import hotelAPI.hotel.HotelService;
import hotelAPI.reservation.Reservation;
import hotelAPI.reservation.ReservationService;
import hotelAPI.room.Room;
import hotelAPI.room.RoomService;
import hotelAPI.roomType.RoomTypeService;
import hotelAPI.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    @Autowired
    RoomTypeService roomTypeService;
    @Autowired
    UserService userService;

    private boolean orderCanBeSatisfied = true ;

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

    public List<Reservation> tryToReserve(ReservationOrderViewModel rovm){
        boolean orderCanBeSatisfied = true;
        ArrayList<Room> roomList = new ArrayList<>();
        ArrayList<Reservation> reservationList = new ArrayList<>();
        for (RoomRequest roomRequest: rovm.getRoomRequests()
             ) {
            if(roomService.findFreeRoomsIds(roomRequest.getRoomTypeId(), rovm.getHotelId(), rovm.getDateFrom(), rovm.getDateTo()).size() < roomRequest.getRequestedNumber())
                orderCanBeSatisfied = false;
        }

        if(orderCanBeSatisfied)
        {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            ReservationsOrder ro = repo.save(new ReservationsOrder(userService.getUserId(authentication.getName()),rovm.getHotelId(), rovm.getTotalCost()));
            final int roId = ro.getId();
            try{
                rovm.getRoomRequests().forEach((roomRequest)-> {
                    roomList.clear();
                    roomList.addAll(roomService.findFreeRooms(roomRequest.getRoomTypeId(), rovm.getHotelId(), rovm.getDateFrom(), rovm.getDateTo()));
                    for(int i=0; i < roomRequest.getRequestedNumber(); i++)
                    {
                        reservationList.add(new Reservation(roomList.get(i), ro, rovm.getDateFrom(), rovm.getDateTo()));
                    }
                });

                reservationList.forEach(reservation -> {
                    reservation.setOrderId(roId);
                    reservationService.add(reservation);
                });
            }
            catch (Exception err)
            {
                reservationList.forEach(reservation -> reservationService.deleteById(reservation.getId()));
                repo.deleteById(roId);
            }

        }
/*        orderCanBeSatisfied = true;*/
            return reservationList;
    }

    public List<ReservationViewModel> getUsersReservations(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<ReservationViewModel> reservationViewModelsList = new ArrayList<>();
        List<ReservationsOrder> roList = repo.findAllByUserId(userService.getUserId(authentication.getName()));
        roList.forEach(ro->{
            ro.getHotel().setMainPhoto(new DBFile());
            reservationViewModelsList.add(new ReservationViewModel(ro, reservationService.findByOrderId(ro.getId())));
        });
        return reservationViewModelsList;
    }

}
