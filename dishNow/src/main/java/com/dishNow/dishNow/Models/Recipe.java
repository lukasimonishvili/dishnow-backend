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
    private int amountLikes;
    private User userCreator;

}
