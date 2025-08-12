package com.dishNow.dishNow.Models;

import jakarta.validation.constraints.*;
import java.util.List;

import com.dishNow.dishNow.Enums.RECIPE_ENUMS;

public class RecipeGetDTO {

    private Long id;
    @NotBlank(message = "Name (EN) is required")
    private String nameEN;

    @NotBlank(message = "Name (ES) is required")
    private String nameES;

    @NotBlank(message = "Name (CN) is required")
    private String nameCA;

    @NotBlank(message = "Description (EN) is required")
    private String descriptionEN;

    @NotBlank(message = "Description (ES) is required")
    private String descriptionES;

    @NotBlank(message = "Description (CN) is required")
    private String descriptionCA;

    @NotEmpty(message = "Ingredients are required")
    private List<@NotNull Ingredient> ingredientsID;

    @NotEmpty(message = "Categories are required")
    private List<@NotNull Category> categoriesID;

    @Min(value = 0, message = "Amount of likes cannot be negative")
    private Integer amountLikes;

    @NotNull(message = "Status is required")
    private RECIPE_ENUMS.STATUS status;

    private List<@NotBlank String> photos;

    public RecipeGetDTO(Long id, @NotBlank(message = "Name (EN) is required") String nameEN,
            @NotBlank(message = "Name (ES) is required") String nameES,
            @NotBlank(message = "Name (CN) is required") String nameCA,
            @NotBlank(message = "Description (EN) is required") String descriptionEN,
            @NotBlank(message = "Description (ES) is required") String descriptionES,
            @NotBlank(message = "Description (CN) is required") String descriptionCA,
            @NotEmpty(message = "Ingredients are required") List<@NotNull Ingredient> ingredientsID,
            @NotEmpty(message = "Categories are required") List<@NotNull Category> categoriesID,
            @Min(value = 0, message = "Amount of likes cannot be negative") Integer amountLikes,
            RECIPE_ENUMS.STATUS status, List<@NotBlank String> photos) {
        this.id = id;
        this.nameEN = nameEN;
        this.nameES = nameES;
        this.nameCA = nameCA;
        this.descriptionEN = descriptionEN;
        this.descriptionES = descriptionES;
        this.descriptionCA = descriptionCA;
        this.ingredientsID = ingredientsID;
        this.categoriesID = categoriesID;
        this.amountLikes = amountLikes;
        this.status = status;
        this.photos = photos;
    }

    public Long getID() {
        return id;
    }

    public void setID(Long id) {
        this.id = id;
    }

    public String getNameEN() {
        return nameEN;
    }

    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
    }

    public String getNameES() {
        return nameES;
    }

    public void setNameES(String nameES) {
        this.nameES = nameES;
    }

    public String getNameCA() {
        return nameCA;
    }

    public void setNameCA(String nameCA) {
        this.nameCA = nameCA;
    }

    public String getDescriptionEN() {
        return descriptionEN;
    }

    public void setDescriptionEN(String descriptionEN) {
        this.descriptionEN = descriptionEN;
    }

    public String getDescriptionES() {
        return descriptionES;
    }

    public void setDescriptionES(String descriptionES) {
        this.descriptionES = descriptionES;
    }

    public String getDescriptionCA() {
        return descriptionCA;
    }

    public void setDescriptionCA(String descriptionCA) {
        this.descriptionCA = descriptionCA;
    }

    public List<Ingredient> getingredientsID() {
        return ingredientsID;
    }

    public void setingredientsID(List<Ingredient> ingredientsID) {
        this.ingredientsID = ingredientsID;
    }

    public List<Category> getCategoriesID() {
        return categoriesID;
    }

    public void setCategoriesID(List<Category> categoriesID) {
        this.categoriesID = categoriesID;
    }

    public Integer getAmountLikes() {
        return amountLikes;
    }

    public void setAmountLikes(Integer amountLikes) {
        this.amountLikes = amountLikes;
    }

    public RECIPE_ENUMS.STATUS getStatus() {
        return status;
    }

    public void setStatus(RECIPE_ENUMS.STATUS status) {
        this.status = status;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }
}
