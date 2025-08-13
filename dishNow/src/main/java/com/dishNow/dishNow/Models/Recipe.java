package com.dishNow.dishNow.Models;

import java.util.List;

import com.dishNow.dishNow.Enums.RECIPE_ENUMS;
import com.dishNow.dishNow.Enums.RECIPE_ENUMS.STATUS;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

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
    // Relación Muchos a Muchos con Ingredients
    @ManyToMany(cascade = CascadeType.ALL) // Se utiliza CascadeType.ALL para que todas las operaciones se propaguen
    @JoinTable(name = "recipe_ingredients", // Tabla intermedia
            joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private List<Ingredient> ingredients;
    // Relación Muchos a Muchos con Categories
    @ManyToMany(cascade = CascadeType.ALL)  // Propaga todas las operaciones
    @JoinTable(
        name = "recipe_categories",  // Tabla intermedia
        joinColumns = @JoinColumn(name = "recipe_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;
    // Relación Muchos a Uno con User (Creador de la receta)
    @ManyToOne(cascade = CascadeType.ALL)  // El creador puede ser cascado
    @JoinColumn(name = "user_id")  // La columna user_id será la clave foránea
    private User userCreator;

    private int amountLikes;
    private RECIPE_ENUMS.STATUS status;
    private List<String> photos;

    // Default constructor for JPA
    public Recipe() {
    }
    
    public Recipe(String nameEN, String nameES, String nameCA, String descriptionEN, String descriptionES,
            String descriptionCA, List<Ingredient> ingredients, List<Category> categories, User userCreator,
            int amountLikes, STATUS status, List<String> photos) {
        this.nameEN = nameEN;
        this.nameES = nameES;
        this.nameCA = nameCA;
        this.descriptionEN = descriptionEN;
        this.descriptionES = descriptionES;
        this.descriptionCA = descriptionCA;
        this.ingredients = ingredients;
        this.categories = categories;
        this.userCreator = userCreator;
        this.amountLikes = amountLikes;
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

    public int getAmountLikes() {
        return amountLikes;
    }

    public void setAmountLikes(int amountLikes) {
        this.amountLikes = amountLikes;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public User getUserCreator() {
        return userCreator;
    }

    public void setUserCreator(User userCreator) {
        this.userCreator = userCreator;
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
