package hotelAPI.reservationsOrder;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationsOrderRepository extends JpaRepository<ReservationsOrder, Integer> {
    List<ReservationsOrder> findAllByHotelId(int hotelId);
    List<ReservationsOrder> findAllByUserId(int userId);
}
