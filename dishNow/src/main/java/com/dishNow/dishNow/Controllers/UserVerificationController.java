package com.dishNow.dishNow.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dishNow.dishNow.Models.User;
import com.dishNow.dishNow.Repositories.UserRepository;

@RestController
@RequestMapping("/api")
public class UserVerificationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping ("/verify/{id}")
    public ResponseEntity<String> verifyUser(@PathVariable Long id) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isEmpty()){
            return ResponseEntity.status(404).body("User not found");
        }

        User user = userOpt.get();

        if (user.isVerified()) {
            return ResponseEntity.ok("User is already verified");
        }

        user.setVerified(true);
        userRepository.save(user);

        
        return ResponseEntity.ok("Your account is verified");
    }
}