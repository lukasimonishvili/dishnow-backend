package com.dishNow.dishNow.Models;

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
    private String nameCN;
    
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


    

}
