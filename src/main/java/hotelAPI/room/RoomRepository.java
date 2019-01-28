package hotelAPI.room;

import java.awt.print.Pageable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Integer> {
	//Page<Room> findByHotelId(Integer hotelId, Pageable pageable);
	ArrayList<Integer> findByHotel(int hotelId);

	@Query("select r.id from Room r  left join RoomType rt on r.roomTypeId= rt.id left join Reservation rte on r.id = rte.roomId left join Hotel h on r.hotelId = h.id where rt.id = ?1 and h.id = ?2 and (not (?3 between startDate and endDate) and not(?4 between startDate and endDate) or (startDate is null) or (endDate is null))")
	ArrayList<Integer> findFreeRooms(int roomTypeId, int hotelId, Date fromDate, Date toDate);

	ArrayList<Room> findAllByIdIn(ArrayList<Integer> ids);
}
