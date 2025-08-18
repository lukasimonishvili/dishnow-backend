package com.dishNow.dishNow.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dishNow.dishNow.Models.RecipeAddDTO;
import com.dishNow.dishNow.Models.RecipeDTO;
import com.dishNow.dishNow.Models.RecipeGetDTO;
import com.dishNow.dishNow.Services.RecipeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @PostMapping("/add")
    public ResponseEntity<?> addRecipe(@Valid @RequestBody RecipeAddDTO recipeAddDTO, @RequestPart("photos") List<MultipartFile> photos) {
        RecipeGetDTO createdRecipe = recipeService.add(recipeAddDTO, photos);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecipe); // 201 Created
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeRecipe(@PathVariable Long id) {
        recipeService.remove(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 No Content
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateRecipe(@PathVariable Long id, @Valid @RequestBody RecipeDTO recipeDTO) {
        RecipeGetDTO updatedRecipe = recipeService.update(id, recipeDTO);
        return ResponseEntity.ok(updatedRecipe); // 200 OK
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getRecipe(@PathVariable Long id) {
        RecipeGetDTO recipeDTO = recipeService.getByIdDTO(id);
        return ResponseEntity.ok(recipeDTO); // Si la receta existe, devolverla
    }

    @GetMapping("/pending")
    @PreAuthorize("hasAnyRole('ADMIN','MODERATOR')")
    public ResponseEntity<Page<RecipeGetDTO>> getPendingRecipes(Pageable pageable) {
        Page<RecipeGetDTO> pendingRecipes = recipeService.getPendingRecipes(pageable);
        return ResponseEntity.ok(pendingRecipes);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<RecipeGetDTO>> getAllRecipes(Pageable pageable) {
        Page<RecipeGetDTO> recipes = recipeService.getAllRecipes(pageable);
        return ResponseEntity.ok(recipes);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<Page<RecipeGetDTO>> getRecipesByCategory(
        @PathVariable Long categoryId,
        Pageable pageable) {
            Page<RecipeGetDTO> recipes = recipeService.getRecipesByCategory(categoryId, pageable);
            return ResponseEntity.ok(recipes);
        }

    @GetMapping("/by-ingredients")
    public ResponseEntity<Page<RecipeGetDTO>> getRecipesByUserIngredients(
        @RequestParam List<Long> ingredients,
        Pageable pageable) {
            Page<RecipeGetDTO> recipes = recipeService.getRecipesByUserIngredients(ingredients, pageable);
            return ResponseEntity.ok(recipes);
        }
        
}
