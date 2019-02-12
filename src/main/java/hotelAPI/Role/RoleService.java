package hotelAPI.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleService {
    @Autowired
    RoleRepository repo;

    public List<Role> getAllRoles()
    {
        return repo.findAll();
    }

    public Role findByName(String name)
    {
        return repo.findFirstByName(name);
    }
}
