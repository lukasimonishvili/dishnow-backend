package com.dishNow.dishNow.interfaces;

import java.util.List;

import com.dishNow.dishNow.Enums.RECIPE_ENUMS;
import com.dishNow.dishNow.Models.Recipe;

public interface RecipeRepositoryCustom {
    List<Recipe> findRecipes(Long categoryId, List<Long> ingredientIds, String keyword, RECIPE_ENUMS.STATUS status);
}
