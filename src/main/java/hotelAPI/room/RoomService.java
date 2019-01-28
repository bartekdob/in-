package hotelAPI.room;

import java.util.ArrayList;
import java.sql.Date;
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

	public List<Room> getByIdBetween(ArrayList<Integer> ids)
	{
		return repo.findAllByIdIn(ids);
	}

	public List<Room> findFreeRooms(int roomTypeId, int hotelId, Date dateFrom, Date dateTo){
		/*RoomService roomService = null;
		ArrayList<Room> roomList = new ArrayList<>();
		repo.findFreeRooms(roomTypeId, hotelId, dateFrom, dateTo).forEach(ob ->{
			roomList.add(new Room())
		});*/
		ArrayList<Integer> ids = repo.findFreeRooms(roomTypeId,hotelId,dateFrom,dateTo);
		ArrayList<Room> rooms = repo.findAllByIdIn(ids);
		return rooms;
	}
	public List<Integer> findFreeRoomsIds(int roomTypeId, int hotelId, Date dateFrom, Date dateTo) {
		List<Integer> resp = repo.findFreeRooms(roomTypeId, hotelId, dateFrom, dateTo);
		return resp;
	}
}
