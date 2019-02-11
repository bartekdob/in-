package hotelAPI.hotel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;



@CrossOrigin(origins = "http://localhost:4200")
public interface HotelRepository extends CrudRepository<Hotel, Integer> {

    @Query(value = "update Hotel set mainPhotoId = null where id = ?1 delete ManagerHotel where hotelId = ?1 delete Files where hotelId = ?1 delete Room where hotelId = ?1 delete roomType where hotelId = ?1 delete Hotel where id = ?1 ", nativeQuery = true)
    String deleteHotelById(int id) throws Exception;
}

