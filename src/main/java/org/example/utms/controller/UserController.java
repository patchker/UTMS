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

    @Autowired
    private UserRepository userRepository;

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> loginData) {
        String username = loginData.get("username");
        String password = loginData.get("password");

        if (username == null || password == null) {
            return ResponseEntity.badRequest().body("Brak wymaganych danych logowania");
        }

        if (userService.login(username, password)) {
            return ResponseEntity.ok("Zalogowano pomyślnie");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Nieprawidłowe dane logowania");
        }
    }
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Map<String, String> registrationData) {
        String name = registrationData.get("name");
        String password = registrationData.get("password");
        String email = registrationData.get("email");

        if (name == null || password == null || email == null) {
            return ResponseEntity.badRequest().body("Brak wymaganych danych rejestracji");
        }

        try {
            User newUser = userService.registerUser(name, password, email);
            return ResponseEntity.ok("Użytkownik zarejestrowany pomyślnie. ID: " + newUser.getId());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Błąd podczas rejestracji: " + e.getMessage());
        }
    }
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


}