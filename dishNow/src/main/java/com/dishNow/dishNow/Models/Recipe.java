package com.dishNow.dishNow.Models;

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
    private String nameCN;
    private String descriptionEN;
    private String descriptionES;
    private String descriptionCN;
    private Ingredient[] igredients;
    private Category[] categories;
    private int amountLikes;
    private User userCreator;

    public Recipe(String nameEN, String nameES, String nameCN, String descriptionEN, String descriptionES,
            String descriptionCN, Ingredient[] igredients, Category[] categories, int amountLikes, User userCreator) {
        this.nameEN = nameEN;
        this.nameES = nameES;
        this.nameCN = nameCN;
        this.descriptionEN = descriptionEN;
        this.descriptionES = descriptionES;
        this.descriptionCN = descriptionCN;
        this.igredients = igredients;
        this.categories = categories;
        this.amountLikes = amountLikes;
        this.userCreator = userCreator;
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
    public String getNameCN() {
        return nameCN;
    }
    public void setNameCN(String nameCN) {
        this.nameCN = nameCN;
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
    public String getDescriptionCN() {
        return descriptionCN;
    }
    public void setDescriptionCN(String descriptionCN) {
        this.descriptionCN = descriptionCN;
    }
    public Ingredient[] getIgredients() {
        return igredients;
    }
    public void setIgredients(Ingredient[] igredients) {
        this.igredients = igredients;
    }
    public Category[] getCategories() {
        return categories;
    }
    public void setCategories(Category[] categories) {
        this.categories = categories;
    }
    public int getAmountLikes() {
        return amountLikes;
    }
    public void setAmountLikes(int amountLikes) {
        this.amountLikes = amountLikes;
    }
    public User getUserCreator() {
        return userCreator;
    }
    public void setUserCreator(User userCreator) {
        this.userCreator = userCreator;
    }



}
