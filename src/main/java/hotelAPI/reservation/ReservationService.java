package hotelAPI.reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReservationService{
	
	@Autowired
	private ReservationRepository repo;
	
	
	public void add(Reservation entity)
	{
		repo.save(entity);
	}
	
	public void delete(Reservation entity)
	{
		repo.delete(entity);
	}
	
	public void deleteById(int id)
	{
		repo.deleteById(id);
	}
	
	public Optional<Reservation> getEntity(int id)
	{
		return repo.findById(id);
	}
	
	public List<Reservation> getAll()
	{
		ArrayList<Reservation> entities = new ArrayList<>();
		repo.findAll().forEach(entities::add);
		return entities;
	}
	
}
