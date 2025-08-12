package com.dishNow.dishNow.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dishNow.dishNow.Models.Recipe;
import com.dishNow.dishNow.Models.RecipeDTO;
import com.dishNow.dishNow.Repositories.RecipeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public void add(RecipeDTO recipeDTO) {
        Recipe recipe = convertToEntity(recipeDTO);
        recipeRepository.save(recipe);
    }

    public void update(Long id, RecipeDTO recipeDTO) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Recipe with ID " + id + " not found"));

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

        if (recipeDTO.getIgredientsID() != null)
            recipe.setIgredientsID(recipeDTO.getIgredientsID().toArray(new Long[0]));

        if (recipeDTO.getCategoriesID() != null)
            recipe.setCategoriesID(recipeDTO.getCategoriesID().toArray(new Long[0]));

        if (recipeDTO.getAmountLikes() != null)
            recipe.setAmountLikes(recipeDTO.getAmountLikes());

        if (recipeDTO.getUserID() != null)
            recipe.setUserID(recipeDTO.getUserID());

        if (recipeDTO.getStatus() != null)
            recipe.setStatus(recipeDTO.getStatus());

        if (recipeDTO.getPhotos() != null)
            recipe.setPhotos(recipeDTO.getPhotos().toArray(new String[0]));

        recipeRepository.save(recipe); // this performs update
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
                dto.getIgredientsID().toArray(new Long[0]),
                dto.getCategoriesID().toArray(new Long[0]),
                dto.getAmountLikes(),
                dto.getUserID(),
                dto.getStatus(),
                dto.getPhotos() != null ? dto.getPhotos().toArray(new String[0]) : null);
        return recipe;
    }

}
