package hotelAPI.hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
	
	@Autowired
	private HotelRepository repo;
	
	public void addHotel(Hotel hotel)
	{
		repo.save(hotel);
		
	}
	
	public Optional<Hotel> getHotel(int id)
	{
		return repo.findById(id);
		
	}
	
	public List<Hotel> viewAll()
	{
		ArrayList<Hotel> hotels = new ArrayList<Hotel>();
		repo.findAll().forEach(hotels::add);
		return hotels;
	}
	
	public void deleteHotel(int id)
	{
		repo.deleteById(id);
	}
	
	public void updateHotel(Hotel hotel)
	{
		repo.save(hotel);
	}
	
	
}
