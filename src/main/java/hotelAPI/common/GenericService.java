//package hotelAPI.common;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Service;
//
//@Service
//public class GenericService<T, Y> {
//
//	@Autowired
//	protected CrudRepository<T, Y> repo;
//	
//	public void add(T entity)
//	{
//		repo.save(entity);
//	}
//	
//	public void delete(T entity)
//	{
//		repo.delete(entity);
//	}
//	
//	public void deleteById(Y id)
//	{
//		repo.deleteById(id);
//	}
//	
//	public Optional<T> getEntity(Y id)
//	{
//		return repo.findById(id);
//	}
//	
//	public List<T> getAll()
//	{
//		ArrayList<T> entities = new ArrayList<>();
//		repo.findAll().forEach(entities::add);
//		return entities;
//	}
//}
