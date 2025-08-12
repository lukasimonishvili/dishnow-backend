package com.dishNow.dishNow.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dishNow.dishNow.Models.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
