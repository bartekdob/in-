package hotelAPI.hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "http://localhost:4200")
@Service
public class HotelService {
	
	@Autowired
	private HotelRepository repo;
	
	
	public void add(Hotel entity)
	{
		repo.save(entity);
	}
	
	public void delete(Hotel entity)
	{
		repo.delete(entity);
	}
	
	public void deleteById(int id)
	{
		repo.deleteById(id);
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

}
