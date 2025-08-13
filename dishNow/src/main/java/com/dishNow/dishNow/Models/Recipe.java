package com.dishNow.dishNow.Models;

import java.util.List;

import com.dishNow.dishNow.Enums.RECIPE_ENUMS;
import com.dishNow.dishNow.Enums.RECIPE_ENUMS.STATUS;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameEN;
    private String nameES;
    private String nameCA;
    private String descriptionEN;
    private String descriptionES;
    private String descriptionCA;
    @ElementCollection
    @CollectionTable(name = "recipe_ingredients", joinColumns = @JoinColumn(name = "recipe_id"))
    @Column(name = "ingredient_id")
    private List<Long> ingredientsID;
    @ElementCollection
    @CollectionTable(name = "recipe_categories", joinColumns = @JoinColumn(name = "recipe_id"))
    @Column(name = "category_id")
    private List<Long> categoriesID;
    private Long userID;
    private int amountLikes;
    private RECIPE_ENUMS.STATUS status;
    @ElementCollection
    @CollectionTable(name = "recipe_photos", joinColumns = @JoinColumn(name = "recipe_id"))
    @Column(name = "photo_url")
    private List<String> photos;

    // Default constructor for JPA
    public Recipe() {
    }

    public Recipe(String nameEN, String nameES, String nameCA, String descriptionEN, String descriptionES,
            String descriptionCA, List<Long> ingredientsID, List<Long> categoriesID, int amountLikes, Long userID,
            STATUS status,
            List<String> photos) {
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

    public void setDescriptionCA(String descriptionCA) {
        this.descriptionCA = descriptionCA;
    }

    public List<Long> getIngredientsID() {
        return ingredientsID;
    }

    public void setIngredientsID(List<Long> ingredientsID) {
        this.ingredientsID = ingredientsID;
    }

    public List<Long> getCategoriesID() {
        return categoriesID;
    }

    public void setCategoriesID(List<Long> categoriesID) {
        this.categoriesID = categoriesID;
    }

    public int getAmountLikes() {
        return amountLikes;
    }

    public void setAmountLikes(int amountLikes) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
