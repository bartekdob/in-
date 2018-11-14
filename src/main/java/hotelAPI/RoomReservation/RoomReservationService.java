package hotelAPI.RoomReservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RoomReservationService{
		
	
	@Autowired
	private RoomReservationRepository repo;
	
	
	
	public void add(RoomReservation entity)
	{
		repo.save(entity);
	}
	
	public void delete(RoomReservation entity)
	{
		repo.delete(entity);
	}
	
	public void deleteById(int id)
	{
		repo.deleteById(id);
	}
	
	public Optional<RoomReservation> getEntity(int id)
	{
		return repo.findById(id);
	}
	
	public List<RoomReservation> getAll()
	{
		ArrayList<RoomReservation> entities = new ArrayList<>();
		repo.findAll().forEach(entities::add);
		return entities;
	}
	
}
