package com.dishNow.dishNow.Models;

import com.dishNow.dishNow.Enums.RECIPE_ENUMS;
import com.dishNow.dishNow.Enums.RECIPE_ENUMS.STATUS;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
    private Long[] igredientsID;
    private Long[] categoriesID;
    private int amountLikes;
    private Long userID;
    private RECIPE_ENUMS.STATUS status;
    private String[] photos;

    // Default constructor for JPA
    public Recipe() {}
    public Recipe(String nameEN, String nameES, String nameCA, String descriptionEN, String descriptionES,
            String descriptionCA, Long[] igredientsID, Long[] categoriesID, int amountLikes, Long userID, STATUS status,
            String[] photos) {
        this.nameEN = nameEN;
        this.nameES = nameES;
        this.nameCA = nameCA;
        this.descriptionEN = descriptionEN;
        this.descriptionES = descriptionES;
        this.descriptionCA = descriptionCA;
        this.igredientsID = igredientsID;
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

    public Long[] getIgredientsID() {
        return igredientsID;
    }

    public void setIgredientsID(Long[] igredientsID) {
        this.igredientsID = igredientsID;
    }

    public Long[] getCategoriesID() {
        return categoriesID;
    }

    public void setCategoriesID(Long[] categoriesID) {
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

    public String[] getPhotos() {
        return photos;
    }

    public void setPhotos(String[] photos) {
        this.photos = photos;
    }

    
    

}
