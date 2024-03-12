package tours.tripedia.tripedia.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tours.tripedia.tripedia.model.User;
import tours.tripedia.tripedia.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "http://frontend")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/{pid}")
    public Optional<User> getUserById(@PathVariable("pid") Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        try {
            User savedUser = userService.addUser(user);

            return ResponseEntity.ok("Added User: " + savedUser.toString());
        }
        catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user, HttpServletResponse response) {
        try {
            User loginUser = userService.login(user);

            //create a cookie
            Cookie cookie = new Cookie("userId", Long.toString(loginUser.getUserId()));
            // expires when shut down browser
            cookie.setMaxAge(-1);
            // add cookie to response
            response.addCookie(cookie);

            return ResponseEntity.ok("Login Success: " + loginUser.getUserId());
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        try {
            User savedUser = userService.updateUser(user);

            return ResponseEntity.ok("Update Success: " + savedUser.toString());
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
