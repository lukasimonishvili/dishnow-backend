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

import com.dishNow.dishNow.Models.CategoryDTO;
import com.dishNow.dishNow.Services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        categoryService.add(categoryDTO);
        return ResponseEntity.ok("Ingredient added successfully");
    }

    
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeCategory(@PathVariable Long id) {
        categoryService.remove(id);
        return ResponseEntity.ok("Ingredient removed successfully");
    }

    
    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryDTO categoryDTO) {
        categoryService.update(id, categoryDTO);
        return ResponseEntity.ok("ingredient updated successfully");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> gerCategory(@PathVariable Long id) {
        categoryService.getByIdDTO(id);
        return ResponseEntity.ok("Recipe updated successfully");
    }

}
