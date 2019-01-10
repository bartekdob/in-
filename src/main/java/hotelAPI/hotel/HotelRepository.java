package hotelAPI.hotel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "http://localhost:4200")
public interface HotelRepository extends CrudRepository<Hotel, Integer> {

}

