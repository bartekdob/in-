package hotelAPI.room;

import java.awt.print.Pageable;
import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Integer> {
	//Page<Room> findByHotelId(Integer hotelId, Pageable pageable);
	ArrayList<Room> findByHotel(int hotelId);
}
