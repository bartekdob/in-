package hotelAPI.user;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;


@Service(value = "UserService")
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    public Integer getUserId(String username){
        User user = repo.findByUsername(username);
        return user.getId();
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }

    private Set  getAuthority(User user) {
        Set authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        repo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public User findOne(String username) {
        return repo.findByUsername(username);
    }

    public User findById(int id) {
        Optional<User> optionalUser = repo.findById(id);
        return optionalUser.isPresent() ? optionalUser.get() : null;
    }

    public User update(User userDto) {
        User user = findById(userDto.getId());
        if(user != null) {
            BeanUtils.copyProperties(userDto, user, "password");
            repo.save(user);
        }
        return userDto;
    }

    public User save(User user) {
/*        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setEmail(user.getEmail());*/
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        return repo.save(user);
    }
}
