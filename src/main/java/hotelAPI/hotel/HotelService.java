package hotelAPI.hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import hotelAPI.DBFile.DBFile;
import hotelAPI.DBFile.DBFileService;
import hotelAPI.room.Room;
import hotelAPI.roomType.RoomType;
import hotelAPI.roomType.RoomTypeService;
import hotelAPI.user.User;
import hotelAPI.user.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManagerFactory;


@CrossOrigin(origins = "http://localhost:4200")
@Service
public class HotelService {
	
	@Autowired
	private HotelRepository repo;

	@Autowired
	private UserService userService;

	@Autowired
	private DBFileService dbFileService;

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	
	public void add(Hotel entity)
	{
		repo.save(entity);
	}

	public void deleteById(int id)
	{
		try{
			repo.deleteHotelById(id);
		}
		catch (Exception ex)
		{

		}
	}
	
	public Optional<Hotel> getEntity(int id)
	{
		return repo.findById(id);
	}
	
	public List<Hotel> getAll()
	{
		ArrayList<Hotel> entities = new ArrayList<>();
		repo.findAll().forEach(entities::add);
		return entities;
	}


	public Set<Hotel> getManagedHotels() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findOne(authentication.getName());
		return user.getManagedHotels();
	}

	public int createHotel(HotelCreateDTO hotelCreateDTO)
	{
		Session session = null;
		Transaction transaction = null;
		Hotel hotel = new Hotel(hotelCreateDTO);
		try {
			session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
			transaction = session.beginTransaction();
			session.save(hotel);
			for(int i = 0; i < hotelCreateDTO.getRoomTypes().size() ; i++)
			{
				RoomType roomType = new RoomType(hotelCreateDTO.getRoomTypes().get(i));
				roomType.setHotel(hotel);
				session.save(roomType);
				for(int j = 0; j < hotelCreateDTO.getRoomTypes().get(i).getQuantity() ; j++)
				{
					session.save(new Room(hotel, roomType));
				}
			}

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			User user = (User) session.get(User.class, userService.getUserId(authentication.getName()));
			user.getManagedHotels().add(hotel);
			session.save(user);
			transaction.commit();
		}
		catch (Exception ex) {
			transaction.rollback();
			hotel.setId(0);
		}
		finally {
			session.close();
		}
		return hotel.getId();
	}

	public boolean saveMainPhoto(MultipartFile file, int hotelId)
	{
		try
		{
			String photoId = dbFileService.storeFile(file, hotelId).getId();
			Hotel hotel = repo.findById(hotelId).get();
			hotel.setMainPhoto(new DBFile());
			hotel.getMainPhoto().setId(photoId);
			repo.save(hotel);
		}
		catch (Exception ex)
		{
			return false;
		}
		return true;
	}

}
