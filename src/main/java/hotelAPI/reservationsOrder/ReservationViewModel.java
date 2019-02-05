package hotelAPI.reservationsOrder;

import hotelAPI.hotel.Hotel;
import hotelAPI.reservation.Reservation;
import hotelAPI.roomType.RoomType;

import java.util.List;

public class ReservationViewModel {
    private ReservationsOrder reservationsOrder;
    private List<Reservation> reservation;

    public ReservationViewModel(ReservationsOrder reservationsOrder, List<Reservation> reservation) {
        this.reservationsOrder = reservationsOrder;
        this.reservation = reservation;
    }

    public ReservationsOrder getReservationsOrder() {
        return reservationsOrder;
    }

    public void setReservationsOrder(ReservationsOrder reservationsOrder) {
        this.reservationsOrder = reservationsOrder;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }
}
