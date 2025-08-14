package com.dishNow.dishNow.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dishNow.dishNow.Models.Ingredient;
import com.dishNow.dishNow.Models.IngredientAddDTO;
import com.dishNow.dishNow.Models.IngredientDTO;
import com.dishNow.dishNow.Services.IngredrientService;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientController {

    @Autowired
    private IngredrientService ingredientService;

    @PostMapping("/add")
    public ResponseEntity<?> addIngredient(@Valid @RequestBody IngredientAddDTO ingredientDTO) {
        IngredientDTO dto = ingredientService.add(ingredientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto); // 201 Created
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeIngredient(@PathVariable Long id) {
        Optional<Ingredient> op = ingredientService.remove(id);
        if (op.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND) // Return 404 if the category is not found
                    .body("Ingredient not found");
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 No Content
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateIngredient(@PathVariable Long id, @Valid @RequestBody IngredientDTO ingredientDTO) {
        Optional<IngredientDTO> op = ingredientService.update(id, ingredientDTO);
        if(op.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND) // Return 404 if the category is not found
                                    .body("Ingredient not found");
        }
        return ResponseEntity.ok(op.get()); // 200 OK
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getIngredient(@PathVariable Long id) {
        Optional<IngredientDTO> op = ingredientService.getByIdDTO(id);
        if(op.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND) // Return 404 if the category is not found
                                    .body("Ingredient not found");
        }
        return ResponseEntity.ok(op.get()); // 200 OK
    }

}
