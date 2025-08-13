package com.dishNow.dishNow.Models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameEN;
    private String nameES;
    private String nameCA;
    
    public Category(){}
    public Category(String nameEN, String nameES, String nameCA) {
        this.nameEN = nameEN;
        this.nameES = nameES;
        this.nameCA = nameCA;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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
}
