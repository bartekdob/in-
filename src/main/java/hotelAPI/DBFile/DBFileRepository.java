package hotelAPI.DBFile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String> {
    ArrayList<DBFile> findByFileName(String fileName);
    ArrayList<DBFile> findByHotelId(Integer hotelId);
}
