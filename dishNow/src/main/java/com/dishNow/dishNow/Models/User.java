package com.dishNow.dishNow.Models;

import jakarta.persistence.*;
import java.time.LocalDate;
import com.dishNow.dishNow.Enums.UserEnums;

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
    private Recipe[] favoriteRecipes;

    // Default constructor for JPA
    public User() {}

    public User(String name, String lastName, LocalDate birthday,
        String email, String passwordHash, UserEnums.USER_ROLE role) {
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
        this.verified = false;
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

    public void setFavoriteRecipes(Recipe[] favorites){
        this.favoriteRecipes = favorites;
    }
    public Recipe[] getFavoriteRecipes(){
        return this.favoriteRecipes;
    }
}