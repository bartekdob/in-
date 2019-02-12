package hotelAPI.user;


import hotelAPI.Role.Role;
import hotelAPI.Role.RoleService;
import hotelAPI.hotel.Hotel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service(value = "UserService")
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Autowired
    private RoleService roleService;

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


    public Set<UserDTO> findAll() {
        List<User> list = new ArrayList<>();
        repo.findAll().iterator().forEachRemaining(list::add);
        Set<UserDTO> users = list.stream().map(user -> new UserDTO(user)).collect(Collectors.toSet())
;        return users;
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
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        Role role = roleService.findByName("USER");
        user.setRoles(new HashSet<>());
        user.getRoles().add(role);
        return repo.save(user);
    }



}
