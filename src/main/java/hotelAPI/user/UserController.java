package hotelAPI.user;

import hotelAPI.hotel.Hotel;
import hotelAPI.reservation.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Set;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/users", method = RequestMethod.GET)
    public ResponseEntity listUser(){
        return ResponseEntity.ok(userService.findAll());
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getOne(@PathVariable(value = "id") int id){
        return userService.findById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value ="/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable int id)
    {
        HashMap<String, Object> resp = new HashMap<>();
        try
        {
            userService.delete(id);
            resp.put("message", "usunieto uzytkownika");
            return ResponseEntity.ok(resp);
        }
        catch (Exception ex){
            resp.put("message", "uzytkownik ma aktywne rezerwacje lub zarzadza hotelem "+ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
        }
    }


}