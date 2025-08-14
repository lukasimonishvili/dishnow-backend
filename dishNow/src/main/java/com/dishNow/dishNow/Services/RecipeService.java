package com.dishNow.dishNow.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dishNow.dishNow.Enums.RECIPE_ENUMS;
import com.dishNow.dishNow.Models.Category;
import com.dishNow.dishNow.Models.Ingredient;
import com.dishNow.dishNow.Models.Recipe;
import com.dishNow.dishNow.Models.RecipeDTO;
import com.dishNow.dishNow.Models.RecipeGetDTO;
import com.dishNow.dishNow.Models.User;
import com.dishNow.dishNow.Repositories.RecipeRepository;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private IngredrientService ingredientService;
    @Autowired
    private UserService userService;

    public RecipeGetDTO add(RecipeDTO recipeDTO) {
        Recipe recipe = convertToEntity(recipeDTO);
        recipeRepository.save(recipe);
        return convertToGetDTO(recipe);
    }

    public Optional<RecipeGetDTO> update(Long id, RecipeDTO recipeDTO) {
        Optional<Recipe> op = getByID(id);
        if (op.isEmpty()) {
            return Optional.empty();
        }
        Recipe recipe = op.get();

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
            recipe.setIngredients(recipeRepository.findIngredients(id));

        if (recipeDTO.getCategoriesID() != null)
            recipe.setCategories(recipeRepository.findCategories(id));

        if (recipeDTO.getAmountLikes() != null)
            recipe.setAmountLikes(recipeDTO.getAmountLikes());

        if (recipeDTO.getUserID() != null)
            recipe.setUserCreator(recipeRepository.findUserCreador(recipeDTO.getUserID()));

        if (recipeDTO.getStatus() != null)
            recipe.setStatus(recipeDTO.getStatus());

        if (recipeDTO.getPhotos() != null)
            recipe.setPhotos(recipeDTO.getPhotos());

        recipeRepository.save(recipe); // this performs update
        return Optional.of(convertToGetDTO(recipe));
    }

    public Optional<Recipe> remove(Long id) {
        Optional<Recipe> op = getByID(id);
        if (op.isEmpty()){
            return Optional.empty();
        }
        recipeRepository.deleteById(id);
        return Optional.of(op.get());
    }

    public Recipe convertToEntity(RecipeDTO dto) {
        User user = null;
        Optional<User> op = userService.getUserById(dto.getUserID());
        if (!op.isEmpty()){
            user = op.get();
        }
        Recipe recipe = new Recipe(
                dto.getNameEN(),
                dto.getNameES(),
                dto.getNameCA(),
                dto.getDescriptionEN(),
                dto.getDescriptionES(),
                dto.getDescriptionCA(),
                getIngredients(dto.getIngredientsID()),
                getCategories(dto.getCategoriesID()),
                user,
                dto.getAmountLikes(),
                dto.getStatus(),
                dto.getPhotos() != null ? dto.getPhotos() : new ArrayList<>());
        return recipe;
    }

    public List<Ingredient> getIngredients(List<Long> ids) {
        List<Ingredient> ingre = new ArrayList<>();
        for (Long id : ids) {
            Optional<Ingredient> op = ingredientService.getById(id);
            if (op.isEmpty()) {
                continue;
            }
            ingre.add(op.get());
        }
        return ingre;
    }

    public List<Category> getCategories(List<Long> ids) {
        List<Category> cats = new ArrayList<>();
        for (Long id : ids) {
            Optional<Category> op = categoryService.getById(id);
            if (op.isEmpty()) {
                continue;
            }
            cats.add(op.get());
        }
        return cats;
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
                recipeRepository.findIngredients(recipe.getId()),
                recipeRepository.findCategories(recipe.getId()),
                recipe.getAmountLikes(),
                recipe.getStatus(),
                recipe.getPhotos());
    }

    public Optional<RecipeGetDTO> getByIdDTO(Long id) {
        Optional<Recipe> op = getByID(id);
        if (op.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(convertToGetDTO(op.get()));
    }

    public Optional<Recipe> getByID(Long id) {
        return recipeRepository.findById(id);
    }

    public Page<RecipeGetDTO> getPendingRecipes(Pageable pageable) {
        Page<Recipe> recipes = recipeRepository.findByStatus(RECIPE_ENUMS.STATUS.PENDING, pageable);
        return recipes.map(this::convertToGetDTO);
    }

    public Page<RecipeGetDTO> getAllRecipes(Pageable pageable) {
        Page<Recipe> recipes = recipeRepository.findAll(pageable);
        return recipes.map(this::convertToGetDTO);
    }
    
    public Page<RecipeGetDTO> getRecipesByCategory(Long categoryId, Pageable pageable) {
        Page<Recipe> recipes = recipeRepository.findByCategoryId(categoryId, pageable);
        return recipes.map(this::convertToGetDTO);
    }
}
