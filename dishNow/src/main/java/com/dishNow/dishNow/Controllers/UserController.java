package com.dishNow.dishNow.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.dishNow.dishNow.Enums.UserEnums.USER_ROLE;
import com.dishNow.dishNow.Models.User;
import com.dishNow.dishNow.Models.UserAddDTO;
import com.dishNow.dishNow.Models.UserDTO;
import com.dishNow.dishNow.Models.UserRegisterDTO;
import com.dishNow.dishNow.Services.UserService;

import static com.dishNow.dishNow.Utils.Validations.*;

import java.util.ArrayList;
import java.util.Optional;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserRegisterDTO registerDTO) {
        if (!isValidEmail(registerDTO.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid email");
        }
        if (!isValidPassword(registerDTO.getPassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid password");
        }
        if (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("The passwords do not match");
        }
        Optional<User> existingUser = userService.getUserByEmail(registerDTO.getEmail());
        if (existingUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Email is already registered");
        }

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        User user = new User(
                registerDTO.getName(),
                registerDTO.getLastName(),
                registerDTO.getBirthday(),
                registerDTO.getEmail(),
                USER_ROLE.USER,
                false,
                new ArrayList<>(),
                new ArrayList<>(),
                passwordEncoder.encode(registerDTO.getPassword()));
        UserDTO dto = userService.add(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto); // 201 Created
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@Valid @RequestBody UserAddDTO userAddDTO) {
        UserDTO dto = userService.addByDTO(userAddDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto); // 201 Created
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeUser(@PathVariable Long id) {
        Optional<User> op = userService.remove(id);
        if (op.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND) // Return 404 if the category is not found
                    .body("User not found");
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 No Content
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @Valid @RequestBody UserAddDTO userDTO) {
        Optional<UserDTO> dto = userService.update(id, userDTO);
        if (dto.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND) // Return 404 if the category is not found
                    .body("User not found");
        }
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        Optional<UserDTO> dto = userService.getByIdDTO(id);
        if (dto.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND) // Return 404 if the category is not found
                    .body("User not found");
        }
        return ResponseEntity.ok(dto); // Return the category data
    }

}
