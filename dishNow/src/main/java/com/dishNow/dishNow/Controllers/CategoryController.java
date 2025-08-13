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

import com.dishNow.dishNow.Models.CategoryAddDTO;
import com.dishNow.dishNow.Models.CategoryDTO;
import com.dishNow.dishNow.Services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@Valid @RequestBody CategoryAddDTO categoryDTO) {
        CategoryDTO dto = categoryService.add(categoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto); // 201 Created
    }

    
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeCategory(@PathVariable Long id) {
        categoryService.remove(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 No Content
    }

    
    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryAddDTO categoryDTO) {
        CategoryDTO dto = categoryService.update(id, categoryDTO);
        return ResponseEntity.ok(dto);
    }
    

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getCategory(@PathVariable Long id) {
        CategoryDTO categoryDTO = categoryService.getByIdDTO(id);
        if (categoryDTO != null) {
            return ResponseEntity.ok(categoryDTO); // Return the category data
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND) // Return 404 if the category is not found
                                .body("Category not found");
        }
    }

}
