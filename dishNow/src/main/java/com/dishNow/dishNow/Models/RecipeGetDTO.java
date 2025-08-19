package com.dishNow.dishNow.Models;

import java.util.List;

import com.dishNow.dishNow.Enums.RECIPE_ENUMS;

public class RecipeGetDTO {
    public Long id;
    public String nameEN;
    public String nameES;
    public String nameCA;
    public String descriptionEN;
    public String descriptionES;
    public String descriptionCA;
    public Category category;
    public List<Ingredient> ingredients;
    public RECIPE_ENUMS.STATUS status;
    public List<String> photos;
    public Long user;
    public int amountLikes;

    public RecipeGetDTO() {}

    public RecipeGetDTO(Recipe recipe) {
        this.id = recipe.getId();
        this.nameEN = recipe.getNameEN();
        this.nameES = recipe.getNameES();
        this.nameCA = recipe.getNameCA();
        this.descriptionEN = recipe.getDescriptionEN();
        this.descriptionES = recipe.getDescriptionES();
        this.descriptionCA = recipe.getDescriptionCA();
        this.category = recipe.getCategory();
        this.ingredients = recipe.getIngredients();
        this.status = recipe.getStatus();
        this.photos = recipe.getPhotos();
        this.user = recipe.getUserCreator().getId();
        this.amountLikes = recipe.getAmountLikes();
    }
}
