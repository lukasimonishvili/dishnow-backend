package com.dishNow.dishNow.Models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ingredient {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameEN;
    private String nameES;
    private String nameCA;

    // Default constructor for JPA
    public Ingredient() {}

    public Ingredient(String nameEN, String nameES, String nameCA) {
        this.nameEN = nameEN;
        this.nameES = nameES;
        this.nameCA = nameCA;
    }
    public Ingredient(String nameEN, String nameES, String nameCA, List<Recipe> recipes) {
        this.nameEN = nameEN;
        this.nameES = nameES;
        this.nameCA = nameCA;
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
    public void setNameCA(String nameCN) {
        this.nameCA = nameCN;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
