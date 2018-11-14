package hotelAPI.hotel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


public interface HotelRepository extends CrudRepository<Hotel, Integer> {

}

