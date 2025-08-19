package com.dishNow.dishNow.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.dishNow.dishNow.Enums.RECIPE_ENUMS;
import com.dishNow.dishNow.Models.Category;
import com.dishNow.dishNow.Models.Ingredient;
import com.dishNow.dishNow.Models.Recipe;
import com.dishNow.dishNow.Models.RecipeAddDTO;
import com.dishNow.dishNow.Models.RecipeDTO;
import com.dishNow.dishNow.Models.RecipeGetDTO;
import com.dishNow.dishNow.Models.User;
import com.dishNow.dishNow.Repositories.RecipeRepository;

@Service
public class RecipeService {
    @Autowired
    private CloudinaryService cloudinaryService;
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private IngredrientService ingredientService;
    @Autowired
    private UserService userService;

    public RecipeGetDTO add(RecipeAddDTO recipeAddDTO, List<MultipartFile> photosFiles) {
        if(photosFiles.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "At least one photo is required");
        }

        List<String> photos = new ArrayList<>();
        for (MultipartFile file : photosFiles) {
            if (file.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Photo file is empty");
            }
            try {
                photos.add(cloudinaryService.uploadFile(file));
            } catch (IOException e) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error uploading photo: " + e.getMessage());
            }
        }

        Recipe recipe = createRecipe(recipeAddDTO, photos);
        recipeRepository.save(recipe);
        return convertToGetDTO(recipe);
    }

    public RecipeGetDTO update(Long id, RecipeDTO recipeDTO) {
        Recipe recipe = getByID(id);

        if (recipeDTO.getNameEN() != null) {
            recipe.setNameEN(recipeDTO.getNameEN());
        }
        if (recipeDTO.getNameES() != null) {
            recipe.setNameES(recipeDTO.getNameES());
        }
        if (recipeDTO.getNameCA() != null) {
            recipe.setNameCA(recipeDTO.getNameCA());
        }

        if (recipeDTO.getDescriptionEN() != null) {
            recipe.setDescriptionEN(recipeDTO.getDescriptionEN());
        }
        if (recipeDTO.getDescriptionES() != null) {
            recipe.setDescriptionES(recipeDTO.getDescriptionES());
        }
        if (recipeDTO.getDescriptionCA() != null) {
            recipe.setDescriptionCA(recipeDTO.getDescriptionCA());
        }

        if (recipeDTO.getIngredientsID() != null) {
            recipe.setIngredients(getIngredients(recipeDTO.getIngredientsID()));
        }

        if (recipeDTO.getCategoryId() != null) {
            Optional<Category> catOp = categoryService.getById(recipeDTO.getCategoryId());
            if (catOp.isPresent()) {
                recipe.setCategory(catOp.get());
            }
        }

        if (recipeDTO.getAmountLikes() != null) {
            recipe.setAmountLikes(recipeDTO.getAmountLikes());
        }

        if (recipeDTO.getUserID() != null) {
            recipe.setUserCreator(recipeRepository.findUserCreador(recipeDTO.getUserID()));
        }

        if (recipeDTO.getStatus() != null) {
            recipe.setStatus(recipeDTO.getStatus());
        }

        if (recipeDTO.getPhotos() != null) {
            recipe.setPhotos(recipeDTO.getPhotos());
        }

        recipeRepository.save(recipe); // this performs update
        return convertToGetDTO(recipe);
    }

    public void remove(Long id) {
        if (!recipeRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe with id " + id + " not found");
        }
        recipeRepository.deleteById(id);
    }

    public Recipe createRecipe(RecipeAddDTO dto, List<String> photos) {
        Optional<Category> catOp = categoryService.getById(dto.getCategory());
        Category cat = null;
        if (catOp.isPresent()) {
            cat = catOp.get();
        }
        Optional<User> userOp = userService.getUserById(dto.getUser());
        User user = null;
        if (userOp.isPresent()) {
            user = userOp.get();
        }

        Recipe recipe = new Recipe(
                dto.getName(),
                dto.getName(),
                dto.getName(),
                dto.getDescription(),
                dto.getDescription(),
                dto.getDescription(),
                getIngredients(dto.getIngredients()),
                cat,
                user,
                0,
                RECIPE_ENUMS.STATUS.PENDING,
                photos);
        return recipe;
    }

    public List<Ingredient> getIngredients(List<Long> ids) {
        List<Ingredient> ingre = new ArrayList<>();
        for (Long id : ids) {
            try {
                Optional<Ingredient> ingredientOp = ingredientService.getById(id);
                Ingredient ingredient = null;
                if (!ingredientOp.isEmpty()) {
                    ingredient = ingredientOp.get();
                }
                if (ingredient != null) {
                    ingre.add(ingredient);
                }
            } catch (Exception e) {
            }
        }
        return ingre;
    }

    public RecipeGetDTO convertToGetDTO(Recipe recipe) {
        return new RecipeGetDTO(recipe);
    }

    public RecipeGetDTO getByIdDTO(Long id) {
        return convertToGetDTO(getByID(id));
    }

    public Recipe getByID(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe with ID " + id + " not found"));
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

    public Page<RecipeGetDTO> getRecipesByUserIngredients(List<Long> ingredientIds, Pageable pageable) {
        // Fetch matching recipes (any overlap)
        Page<Recipe> recipesPage = recipeRepository.findRecipesWithAnyIngredient(ingredientIds, pageable);

        // Sort them: fully match first, then partial
        List<Recipe> sortedRecipes = recipesPage.getContent().stream()
                .sorted((r1, r2) -> {
                    boolean r1FullMatch = ingredientIds.containsAll(
                            r1.getIngredients().stream().map(Ingredient::getId).toList());
                    boolean r2FullMatch = ingredientIds.containsAll(
                            r2.getIngredients().stream().map(Ingredient::getId).toList());

                    if (r1FullMatch && !r2FullMatch)
                        return -1;
                    if (!r1FullMatch && r2FullMatch)
                        return 1;
                    return 0; // keep relative order
                })
                .toList();

        // Map to DTOs
        List<RecipeGetDTO> dtoList = sortedRecipes.stream()
                .map(this::convertToGetDTO)
                .toList();

        // Return as a Page keeping pageable meta
        return new org.springframework.data.domain.PageImpl<>(dtoList, pageable, recipesPage.getTotalElements());
    }
}
