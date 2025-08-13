package com.dishNow.dishNow.Models;

public class Category {
    private int id;
    private String nameEN;
    private String nameES;
    private String nameCA;

    public Category(int id, String nameEN, String nameES, String nameCA) {
        this.id = id;
        this.nameEN = nameEN;
        this.nameES = nameES;
        this.nameCA = nameCA;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNameEN() {
        return nameEN;
    }

    public String getNameES() {
        return nameES;
    }

    public String getNameCA() {
        return nameCA;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
    }

    public void setNameES(String nameES) {
        this.nameES = nameES;
    }

    public void setNameCA(String nameCA) {
        this.nameCA = nameCA;
    }
}
