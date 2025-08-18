package com.dishNow.dishNow.Models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

import com.dishNow.dishNow.Enums.UserEnums;
import com.dishNow.dishNow.Enums.UserEnums.USER_ROLE;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;
    private LocalDate birthday;
    private String email;
    private String passwordHash;
    private UserEnums.USER_ROLE role = UserEnums.USER_ROLE.USER;
    private boolean verified = false;

    @OneToMany(mappedBy = "userCreator", cascade = CascadeType.ALL)
    private List<Recipe> favoriteRecipes;
    @OneToMany(mappedBy = "userCreator", cascade = CascadeType.ALL)
    private List<Recipe> recipesCreated;

    // Default constructor for JPA
    public User() {
    }

    public User(String name2, String lastName2, LocalDate birthday2, String email2, USER_ROLE role2, boolean verified2,
            List<Recipe> favoriteRecipes2, List<Recipe> recipesCreated2, String passwordHash2) {
        this(name2, lastName2, birthday2, email2, role2, verified2, favoriteRecipes2, recipesCreated2);
        this.passwordHash = passwordHash2;
    }

    public User(String name2, String lastName2, LocalDate birthday2, String email2, USER_ROLE role2, boolean verified2,
            List<Recipe> favoriteRecipes2, List<Recipe> recipesCreated2) {
        this.name = name2;
        this.lastName = lastName2;
        this.birthday = birthday2;
        this.email = email2;
        this.role = role2;
        this.verified = verified2;
        this.favoriteRecipes = favoriteRecipes2;
        this.recipesCreated = recipesCreated2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public UserEnums.USER_ROLE getRole() {
        return role;
    }

    public void setRole(UserEnums.USER_ROLE role) {
        this.role = role;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public List<Recipe> getFavoriteRecipes() {
        return favoriteRecipes;
    }

    public void setFavoriteRecipes(List<Recipe> favoriteRecipes) {
        this.favoriteRecipes = favoriteRecipes;
    }

    public List<Recipe> getRecipesCreated() {
        return recipesCreated;
    }

    public void setRecipesCreated(List<Recipe> recipesCreated) {
        this.recipesCreated = recipesCreated;
    }

}