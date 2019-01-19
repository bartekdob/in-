package hotelAPI.roomType;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;


public interface RoomTypeRepository extends CrudRepository<RoomType, Integer> {
    ArrayList<RoomType> findByHotelId(int hotelId);
}
