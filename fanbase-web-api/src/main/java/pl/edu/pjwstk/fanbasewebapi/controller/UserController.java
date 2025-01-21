package pl.edu.pjwstk.fanbasewebapi.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.fanbasewebapi.modelDTO.UserDTO;
import pl.edu.pjwstk.fanbasewebapi.service.UserService;

@RestController
@RequestMapping("/user/")
@RequiredArgsConstructor
public class UserController{
    private final UserService userService;

    @PostMapping("register")
    public ResponseEntity<String> register(@Valid @RequestBody UserDTO userDTO){
        try {
            var user = userService.save(userDTO);
            if(user == null) {
                return ResponseEntity.badRequest().body("This login is taken");
            }
            return ResponseEntity.accepted().body("User registered successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Failed to register user");
        }
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO, HttpSession session){
        UserDTO user = userService.login(userDTO.getLogin(), userDTO.getPassword());
        if(user != null){
            session.setAttribute("user", user);
            return ResponseEntity.accepted().body(user.toString());
        }
        return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("logout")
    public ResponseEntity<String> logout(HttpSession session){
        if (session.getAttribute("user") != null){
            session.invalidate();
            return ResponseEntity.accepted().body("Logged out successfully");

        } else {
            return ResponseEntity.badRequest().body("You are not logged in");
        }
    }
}
