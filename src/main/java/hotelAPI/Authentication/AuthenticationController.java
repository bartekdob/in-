package hotelAPI.Authentication;

import hotelAPI.Role.Role;
import hotelAPI.configuration.JwtTokenUtil;
import hotelAPI.user.LoginUser;
import hotelAPI.user.User;
import hotelAPI.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.AuthenticationException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody LoginUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final User user = userService.findOne(loginUser.getUsername());
        final String token = jwtTokenUtil.doGenerateToken(user);
        AuthToken resp = new AuthToken(token);
        resp.setUsername(loginUser.getUsername());
        for (Role role : user.getRoles()) {
            resp.getRoles().add(role.getName());
        }
        return ResponseEntity.ok(resp);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity register(@Valid @RequestBody User user){
        try{
            userService.save(user);
        }
        catch (Exception ex){
            Map<String, Object> resp = new HashMap<>();
            resp.put("message", "Konto o takiej nazwie lub na ten email juz istnieje");
            resp.put("user", user);
            return ResponseEntity.ok(resp);
        }
        LoginUser lu = new LoginUser();
        lu.setUsername(user.getUsername());
        lu.setPassword(user.getPassword());
        Map<String, Object> resp = new HashMap<>();
        resp.put("message", "Utworzono nowe konto");
        return ResponseEntity.ok(resp);
    }

}