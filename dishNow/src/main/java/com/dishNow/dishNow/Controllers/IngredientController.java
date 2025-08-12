package com.dishNow.dishNow.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dishNow.dishNow.Models.IngredientDTO;
import com.dishNow.dishNow.Services.IngredrientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientController {

    @Autowired
    private IngredrientService ingredientService;


    @PostMapping("/add")
    public ResponseEntity<?> addRecipe(@Valid @RequestBody IngredientDTO ingredientDTO) {
        ingredientService.add(ingredientDTO);
        return ResponseEntity.ok("Ingredient added successfully");
    }

    
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeRecipe(@PathVariable Long id) {
        ingredientService.remove(id);
        return ResponseEntity.ok("Ingredient removed successfully");
    }

    
    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateRecipe(@PathVariable Long id, @Valid @RequestBody IngredientDTO ingredientDTO) {
        ingredientService.update(id, ingredientDTO);
        return ResponseEntity.ok("ingredient updated successfully");
    }

}
