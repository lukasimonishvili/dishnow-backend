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

import com.dishNow.dishNow.Models.UserAddDTO;
import com.dishNow.dishNow.Models.UserDTO;
import com.dishNow.dishNow.Services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@Valid @RequestBody UserAddDTO userDTO) {
        UserDTO dto = userService.add(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto); // 201 Created
    }

    
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeCategory(@PathVariable Long id) {
        userService.remove(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 No Content
    }

    
    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @Valid @RequestBody UserAddDTO userDTO) {
        UserDTO dto = userService.update(id, userDTO);
        return ResponseEntity.ok(dto);
    }
    

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        UserDTO dto = userService.getByIdDTO(id);
        if (dto != null) {
            return ResponseEntity.ok(dto); // Return the category data
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND) // Return 404 if the category is not found
                                .body("User not found");
        }
    }

}
