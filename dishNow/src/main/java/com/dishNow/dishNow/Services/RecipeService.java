package com.dishNow.dishNow.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dishNow.dishNow.Models.Category;
import com.dishNow.dishNow.Models.Ingredient;
import com.dishNow.dishNow.Models.Recipe;
import com.dishNow.dishNow.Models.RecipeDTO;
import com.dishNow.dishNow.Models.RecipeGetDTO;
import com.dishNow.dishNow.Repositories.RecipeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private IngredrientService ingredientService;

    public RecipeGetDTO add(RecipeDTO recipeDTO) {
        Recipe recipe = convertToEntity(recipeDTO);
        recipeRepository.save(recipe);
        return convertToGetDTO(recipe);
    }

    public RecipeGetDTO update(Long id, RecipeDTO recipeDTO) {
        Recipe recipe = getByID(id);

        if (recipeDTO.getNameEN() != null)
            recipe.setNameEN(recipeDTO.getNameEN());
        if (recipeDTO.getNameES() != null)
            recipe.setNameES(recipeDTO.getNameES());
        if (recipeDTO.getNameCA() != null)
            recipe.setNameCA(recipeDTO.getNameCA());

        if (recipeDTO.getDescriptionEN() != null)
            recipe.setDescriptionEN(recipeDTO.getDescriptionEN());
        if (recipeDTO.getDescriptionES() != null)
            recipe.setDescriptionES(recipeDTO.getDescriptionES());
        if (recipeDTO.getDescriptionCA() != null)
            recipe.setDescriptionCA(recipeDTO.getDescriptionCA());

        if (recipeDTO.getIngredientsID() != null)
            recipe.setIngredientsID(recipeDTO.getIngredientsID());

        if (recipeDTO.getCategoriesID() != null)
            recipe.setCategoriesID(recipeDTO.getCategoriesID());

        if (recipeDTO.getAmountLikes() != null)
            recipe.setAmountLikes(recipeDTO.getAmountLikes());

        if (recipeDTO.getUserID() != null)
            recipe.setUserID(recipeDTO.getUserID());

        if (recipeDTO.getStatus() != null)
            recipe.setStatus(recipeDTO.getStatus());

        if (recipeDTO.getPhotos() != null)
            recipe.setPhotos(recipeDTO.getPhotos());

        recipeRepository.save(recipe); // this performs update
        return convertToGetDTO(recipe);
    }

    public void remove(Long id) {
        if (!recipeRepository.existsById(id)) {
            throw new EntityNotFoundException("Recipe with id " + id + " not found");
        }
        recipeRepository.deleteById(id);
    }

    public Recipe convertToEntity(RecipeDTO dto) {
        Recipe recipe = new Recipe(
                dto.getNameEN(),
                dto.getNameES(),
                dto.getNameCA(),
                dto.getDescriptionEN(),
                dto.getDescriptionES(),
                dto.getDescriptionCA(),
                dto.getIngredientsID(),
                dto.getCategoriesID(),
                dto.getAmountLikes(),
                dto.getUserID(),
                dto.getStatus(),
                dto.getPhotos() != null ? dto.getPhotos() : new ArrayList<>());
        return recipe;
    }

    public RecipeGetDTO convertToGetDTO(Recipe recipe) {
        return new RecipeGetDTO(
                recipe.getId(),
                recipe.getNameEN(),
                recipe.getNameES(),
                recipe.getNameCA(),
                recipe.getDescriptionEN(),
                recipe.getDescriptionES(),
                recipe.getDescriptionCA(),
                getIngredientList(recipe),
                getCaregoryList(recipe),
                recipe.getAmountLikes(),
                recipe.getStatus(),
                recipe.getPhotos());
    }

    public List<Category> getCaregoryList(Recipe recipe) {
        List<Category> listCategories = new ArrayList<>();
        for (Long id : recipeRepository.findCategoriesByRecipeId(recipe.getId()) ) {
            listCategories.add(categoryService.getById(id));
        }
        return listCategories;
    }

    public List<Ingredient> getIngredientList(Recipe recipe) {
        List<Ingredient> listIngredients = new ArrayList<>();
        for (Long id : recipeRepository.findIngredientsByRecipeId(recipe.getId()) ) {
            listIngredients.add(ingredientService.getById(id));
        }
        return listIngredients;
    }

    public RecipeGetDTO getByIdDTO(Long id) {
        return convertToGetDTO(getByID(id));
    }

    public Recipe getByID(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Recipe with ID " + id + " not found"));
    }
    
}
