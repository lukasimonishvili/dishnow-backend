package com.dishNow.dishNow.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dishNow.dishNow.Models.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Query("SELECT r.ingredientsID FROM Recipe r WHERE r.id = :id")
    List<Long> findIngredientsByRecipeId(Long id);
    @Query("SELECT r.categoriesID FROM Recipe r WHERE r.id = :id")
    List<Long> findCategoriesByRecipeId(Long id);
}
