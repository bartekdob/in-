package hotelAPI.roomType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoomTypeService {
	
	@Autowired
	private RoomTypeRepository repo;
	
	public void add(RoomType entity)
	{
		repo.save(entity);
	}
	
	public void delete(RoomType entity)
	{
		repo.delete(entity);
	}
	
	public void deleteById(int id)
	{
		repo.deleteById(id);
	}
	
	public Optional<RoomType> getEntity(int id)
	{
		return repo.findById(id);
	}
	
	public List<RoomType> getAll()
	{
		ArrayList<RoomType> entities = new ArrayList<>();
		repo.findAll().forEach(entities::add);
		return entities;
	}
	
	public ArrayList<RoomType> getHotelRoomTypes(int hotelId){
		return repo.findByHotelId(hotelId);
	}

	
}
