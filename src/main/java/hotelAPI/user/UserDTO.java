package hotelAPI.user;

import hotelAPI.Role.Role;
import hotelAPI.hotel.HotelViewModel;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;


public class UserDTO {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private Set<Role> roles;
    private Set<HotelViewModel> managedHotels;

    public UserDTO(User user)
    {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.roles = user.getRoles();
        this.managedHotels = user.getManagedHotels().stream().map(hotel -> new HotelViewModel(hotel)).collect(Collectors.toSet());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<HotelViewModel> getManagedHotels() {
        return managedHotels;
    }

    public void setManagedHotels(Set<HotelViewModel> managedHotels) {
        this.managedHotels = managedHotels;
    }
}
