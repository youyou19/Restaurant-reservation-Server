package reservation_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reservation_server.domain.Admin;
import reservation_server.domain.User;
import reservation_server.exception.GeneralException;
import reservation_server.service.LoginService;
import reservation_server.util.JwtUtil;

import java.util.Optional;
import java.util.Random;


@RestController
@CrossOrigin(origins = {"http://localhost:8080"}, maxAge = 6000)
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String login(@RequestBody User user) {
        String userRole = "";

        if (user.getFirstName() == null || user.getFirstName().length() <= 0) {

            Optional<User> userOpt = loginService.sign(user.getUsername(), user.getPassword());

            if (userOpt.isPresent()) {

                if (userOpt.get() instanceof Admin) {
                    userRole = "Admin";
                } else {
                    userRole = "Customer";
                }
                return jwtUtil.generateToken(userOpt.get(), userRole, true);

            } else {
                return "null";

            }
        } else {
            User facebookUser = new User();
            facebookUser.setUsername(user.getUsername());
            facebookUser.setId(generateID());
            return jwtUtil.generateToken(facebookUser, "Customer", true);
        }
    }

    @PostMapping("/check/{token}")
    public boolean login(@PathVariable String token) {
        jwtUtil.isGranted(token);
        return jwtUtil.isGranted(token);
    }

    public Long generateID() {
        Random r = new Random();
        int low = 456;
        int high = 9898;
        long result = r.nextInt(high - low) + low;
        return result;
    }
}