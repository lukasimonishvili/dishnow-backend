package com.dishNow.dishNow.Models;

import jakarta.validation.constraints.*;
import java.util.List;

import com.dishNow.dishNow.Enums.RECIPE_ENUMS;

public class RecipeDTO {

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
    private List<@NotNull Long> ingredientsID;

    @NotEmpty(message = "Categories are required")
    private List<@NotNull Long> categoriesID;

    @Min(value = 0, message = "Amount of likes cannot be negative")
    private Integer amountLikes;

    @NotNull(message = "User ID is required")
    private Long userID;

    @NotNull(message = "Status is required")
    private RECIPE_ENUMS.STATUS status;

    private List<@NotBlank String> photos;

    public RecipeDTO(@NotBlank(message = "Name (EN) is required") String nameEN,
            @NotBlank(message = "Name (ES) is required") String nameES,
            @NotBlank(message = "Name (CN) is required") String nameCA,
            @NotBlank(message = "Description (EN) is required") String descriptionEN,
            @NotBlank(message = "Description (ES) is required") String descriptionES,
            @NotBlank(message = "Description (CN) is required") String descriptionCA,
            @NotEmpty(message = "Ingredients are required") List<@NotNull Long> ingredientsID,
            @NotEmpty(message = "Categories are required") List<@NotNull Long> categoriesID,
            @Min(value = 0, message = "Amount of likes cannot be negative") int amountLikes,
            @NotNull(message = "User ID is required") Long userID, RECIPE_ENUMS.STATUS status,
            List<@NotBlank String> photos) {
        this.nameEN = nameEN;
        this.nameES = nameES;
        this.nameCA = nameCA;
        this.descriptionEN = descriptionEN;
        this.descriptionES = descriptionES;
        this.descriptionCA = descriptionCA;
        this.ingredientsID = ingredientsID;
        this.categoriesID = categoriesID;
        this.amountLikes = amountLikes;
        this.userID = userID;
        this.status = status;
        this.photos = photos;
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

    public void setDescriptionCA(String descriptionCN) {
        this.descriptionCA = descriptionCN;
    }

    public List<Long> getingredientsID() {
        return ingredientsID;
    }

    public void setingredientsID(List<Long> ingredientsID) {
        this.ingredientsID = ingredientsID;
    }

    public List<Long> getCategoriesID() {
        return categoriesID;
    }

    public void setCategoriesID(List<Long> categoriesID) {
        this.categoriesID = categoriesID;
    }

    public Integer getAmountLikes() {
        return amountLikes;
    }

    public void setAmountLikes(Integer amountLikes) {
        this.amountLikes = amountLikes;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
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

    // Getters and Setters
}

 