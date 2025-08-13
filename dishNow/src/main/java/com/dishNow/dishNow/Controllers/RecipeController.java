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

import com.dishNow.dishNow.Models.RecipeDTO;
import com.dishNow.dishNow.Models.RecipeGetDTO;
import com.dishNow.dishNow.Services.RecipeService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @PostMapping("/add")
    public ResponseEntity<?> addRecipe(@Valid @RequestBody RecipeDTO recipeDTO) {
        RecipeGetDTO createdRecipe = recipeService.add(recipeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecipe); // 201 Created
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeRecipe(@PathVariable Long id) {
        recipeService.remove(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 No Content
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateRecipe(@PathVariable Long id, @Valid @RequestBody RecipeDTO recipeDTO) {
        RecipeGetDTO updatedRecipe = recipeService.update(id, recipeDTO);
        return ResponseEntity.ok(updatedRecipe); // 200 OK
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getRecipe(@PathVariable Long id) {
        try {
            RecipeGetDTO recipeDTO = recipeService.getByIdDTO(id);
            return ResponseEntity.ok(recipeDTO);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Recipe not found for ID " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred: " + e.getMessage());
        }
    }

}
