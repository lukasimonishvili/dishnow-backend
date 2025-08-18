package com.dishNow.dishNow.Models;

import java.time.LocalDate;
import java.util.List;

import com.dishNow.dishNow.Enums.UserEnums;
import com.dishNow.dishNow.Enums.UserEnums.USER_ROLE;

public class UserAddDTO {

    private String name;
    private String lastName;
    private LocalDate birthday;
    private String email;
    private UserEnums.USER_ROLE role = UserEnums.USER_ROLE.USER;
    private boolean verified = false;
    private List<Long> favoriteRecipes;
    private List<Long> recipesCreated;

    public UserAddDTO(String name, String lastName, LocalDate birthday, String email, USER_ROLE role,
            boolean verified, List<Long> favoriteRecipes, List<Long> recipesCreated) {
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.role = role;
        this.verified = verified;
        this.favoriteRecipes = favoriteRecipes;
        this.recipesCreated = recipesCreated;
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
    public List<Long> getFavoriteRecipes() {
        return favoriteRecipes;
    }
    public void setFavoriteRecipes(List<Long> favoriteRecipes) {
        this.favoriteRecipes = favoriteRecipes;
    }
    public List<Long> getRecipesCreated() {
        return recipesCreated;
    }
    public void setRecipesCreated(List<Long> recipesCreated) {
        this.recipesCreated = recipesCreated;
    }



}