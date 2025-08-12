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
    private String nameCN;
    private String descriptionEN;
    private String descriptionES;
    private String descriptionCN;
    private Long[] igredientsID;
    private Long[] categoriesID;
    private int amountLikes;
    private Long userID;
    private RECIPE_ENUMS.STATUS status;
    private String[] phtos;

    public Recipe(String nameEN, String nameES, String nameCN, String descriptionEN, String descriptionES,
            String descriptionCN, Long[] igredientsID, Long[] categoriesID, int amountLikes, Long userID, STATUS status,
            String[] phtos) {
        this.nameEN = nameEN;
        this.nameES = nameES;
        this.nameCN = nameCN;
        this.descriptionEN = descriptionEN;
        this.descriptionES = descriptionES;
        this.descriptionCN = descriptionCN;
        this.igredientsID = igredientsID;
        this.categoriesID = categoriesID;
        this.amountLikes = amountLikes;
        this.userID = userID;
        this.status = status;
        this.phtos = phtos;
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

    public String[] getPhtos() {
        return phtos;
    }

    public void setPhtos(String[] phtos) {
        this.phtos = phtos;
    }

    
    

}
