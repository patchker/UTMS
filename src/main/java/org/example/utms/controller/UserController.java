package org.example.utms.controller;
import org.example.utms.model.User;
import org.example.utms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.utms.services.UserService;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> loginData) {
        String username = loginData.get("username");
        String password = loginData.get("password");

        if (username == null || password == null) {
            return ResponseEntity.badRequest().body("No login details required");
        }

        if (userService.login(username, password)) {
            return ResponseEntity.ok("You have logged in successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid login details.");
        }
    }
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Map<String, String> registrationData) {
        String username = registrationData.get("username");
        String password = registrationData.get("password");
        String email = registrationData.get("email");

        if (username == null || password == null || email == null) {
            return ResponseEntity.badRequest().body("No required registration details.");
        }
        if(userRepository.findByUsername(username) != null) {
            System.out.println(userRepository.findByUsername(username));
            return ResponseEntity.badRequest().body("A user with this name exists in the database.");

        }
        if(userRepository.findByEmail(email) != null) {
            return ResponseEntity.badRequest().body("A user with this email address exists in the database.");
        }

        try {
            User newUser = userService.registerUser(username, password, email);
            return ResponseEntity.ok("User registered successfully. ID: " + newUser.getId());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error during registration: " + e.getMessage());
        }
    }
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


}