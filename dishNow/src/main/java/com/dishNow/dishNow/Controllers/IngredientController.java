package com.dishNow.dishNow.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        ingredientService.remove(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 No Content
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateIngredient(@PathVariable Long id, @Valid @RequestBody IngredientDTO ingredientDTO) {
        IngredientDTO dto = ingredientService.update(id, ingredientDTO);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getIngredient(@PathVariable Long id) {
        IngredientDTO ingredientDTO = ingredientService.getByIdDTO(id);
        if (ingredientDTO != null) {
            return ResponseEntity.ok(ingredientDTO); // Return the ingredient data
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND) // Return 404 if not found
                    .body("Ingredient not found");
        }
    }

}
