package com.dishNow.dishNow.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dishNow.dishNow.Models.User;
import com.dishNow.dishNow.Models.UserLoginDTO;
import com.dishNow.dishNow.Repositories.UserRepository;
import com.dishNow.dishNow.Utils.JwtUtil;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final JwtUtil jwtUtil = new JwtUtil();

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDTO userLogin) {

        Optional<User> userOpt = userRepository.findByEmail(userLogin.getEmail());
        if (userOpt.isEmpty()) {
            return ResponseEntity.status(404).body("User not found");
        }
        User user = userOpt.get();

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if (passwordEncoder.matches(userLogin.getPassword(), user.getPasswordHash())) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid credentials");
        }

        String token = jwtUtil.generateToken(userLogin.getEmail());
        return ResponseEntity.ok(token);
    }

    @GetMapping("/secure")
    public ResponseEntity<String> secureEndpoint(@RequestHeader("Authorization") String token) {
        String username = jwtUtil.validateToken(token.replace("Bearer ", ""));
        return ResponseEntity.ok(username + ", enter on secure end point.");
    }
}
