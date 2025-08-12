package com.dishNow.dishNow.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dishNow.dishNow.Models.RecipeDTO;
import com.dishNow.dishNow.Services.RecipeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;


    @PostMapping("/add")
    public ResponseEntity<?> addRecipe(@Valid @RequestBody RecipeDTO recipeDTO) {
        recipeService.add(recipeDTO);
        return ResponseEntity.ok("Recipe added successfully");
    }

    
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeRecipe(@PathVariable Long id) {
        recipeService.remove(id);
        return ResponseEntity.ok("Recipe removed successfully");
    }

    
    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateRecipe(@PathVariable Long id, @Valid @RequestBody RecipeDTO recipeDTO) {
        recipeService.update(id, recipeDTO);
        return ResponseEntity.ok("Recipe updated successfully");
    }
    
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getRecipe(@PathVariable Long id) {
        recipeService.getByIdDTO(id);
        return ResponseEntity.ok("Recipe updated successfully");
    }

}
