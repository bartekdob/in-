package hotelAPI.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoomService {
	
	@Autowired
	private RoomRepository repo;
	
	public void add(Room entity)
	{	
		repo.save(entity);
	}
	
	public void delete(Room entity)
	{
		repo.delete(entity);
	}
	
	public void deleteById(int id)
	{
		repo.deleteById(id);
	}
	
	public Optional<Room> getEntity(int id)
	{
		return repo.findById(id);
	}
	
	public List<Room> getAll()
	{
		ArrayList<Room> entities = new ArrayList<>();
		repo.findAll().forEach(entities::add);
		return entities;
	}
		
}
