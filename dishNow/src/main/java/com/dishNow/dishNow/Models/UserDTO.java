package com.dishNow.dishNow.Models;

import java.time.LocalDate;
import java.util.List;

import com.dishNow.dishNow.Enums.UserEnums.USER_ROLE;

public class UserDTO extends UserAddDTO{
    
    private Long id;
    
    public UserDTO(Long id, String name, String lastName, LocalDate birthday, String email, USER_ROLE role, boolean verified,
            List<Long> favoriteRecipes, List<Long> recipesCreated) {
        super(name, lastName, birthday, email, role, verified, favoriteRecipes, recipesCreated);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
}