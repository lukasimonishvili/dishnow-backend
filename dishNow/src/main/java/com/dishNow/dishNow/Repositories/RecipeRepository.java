package com.dishNow.dishNow.Repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dishNow.dishNow.Enums.RECIPE_ENUMS;
import com.dishNow.dishNow.Models.Category;
import com.dishNow.dishNow.Models.Ingredient;
import com.dishNow.dishNow.Models.Recipe;
import com.dishNow.dishNow.Models.User;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Query("SELECT r.userCreator FROM Recipe r WHERE r.id = :id")
    User findUserCreador(Long id);
    @Query("SELECT r.ingredients FROM Recipe r WHERE r.id = :id")
    List<Ingredient> findIngredients(Long id);
    @Query("SELECT r.categories FROM Recipe r WHERE r.id = :id")
    List<Category> findCategories(Long id);
    Page<Recipe> findByStatus(RECIPE_ENUMS.STATUS status, Pageable pageable);
}

