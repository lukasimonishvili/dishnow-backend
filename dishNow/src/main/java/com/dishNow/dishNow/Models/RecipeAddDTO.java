package com.dishNow.dishNow.Models;

import jakarta.validation.constraints.*;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class RecipeAddDTO {

    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Description is required")
    private String description;

    @NotEmpty(message = "Ingredients are required")
    private List<@NotNull Long> ingredients;

    @NotEmpty(message = "Category are required")
    private Long category;

    @NotNull(message = "User ID is required")
    private Long user;

    private List<MultipartFile> photos;
    public RecipeAddDTO() {}
    public RecipeAddDTO(@NotBlank(message = "Name is required") String name,
            @NotBlank(message = "Description is required") String description,
            @NotEmpty(message = "Ingredients are required") List<@NotNull Long> ingredients,
            @NotEmpty(message = "Category are required") Long category,
            @NotNull(message = "User ID is required") Long user, List<MultipartFile> photos) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.category = category;
        this.user = user;
        this.photos = photos;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Long> getIngredients() {
        return ingredients;
    }
    public void setIngredients(List<Long> ingredients) {
        this.ingredients = ingredients;
    }
    public Long getCategory() {
        return category;
    }
    public void setCategory(Long category) {
        this.category = category;
    }
    public Long getUser() {
        return user;
    }
    public void setUser(Long user) {
        this.user = user;
    }
    public List<MultipartFile> getPhotos() {
        return photos;
    }
    public void setPhotos(List<MultipartFile> photos) {
        this.photos = photos;
    }

    

}

 