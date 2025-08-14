package com.dishNow.dishNow.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.dishNow.dishNow.Models.Ingredient;
import com.dishNow.dishNow.Models.IngredientAddDTO;
import com.dishNow.dishNow.Models.IngredientDTO;
import com.dishNow.dishNow.Repositories.IngredientRepository;


@Service
public class IngredrientService {
    @Autowired
    private IngredientRepository ingredienteRepository;

    public IngredientDTO add(IngredientAddDTO ingredientDTO) {
        Ingredient ingre = ingredienteRepository.save(convertToEntity(ingredientDTO));
        return convertToGetDTO(ingre);
    }

    public Ingredient convertToEntity(IngredientAddDTO dto) {
        Ingredient ingredient = new Ingredient(
                dto.getNameEN(),
                dto.getNameES(),
                dto.getNameCA());
        return ingredient;
    }

    public void remove(Long id) {
        if (!ingredienteRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient with id " + id + " not found");
        }
        ingredienteRepository.deleteById(id);
    }

    public Ingredient getById(Long id) {
        return ingredienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient with ID " + id + " not found"));
    }

    public IngredientDTO update(Long id, IngredientDTO ingredientDTO) {
        Ingredient ingredient = getById(id);
        if (ingredientDTO.getNameEN() != null)
            ingredient.setNameEN(ingredientDTO.getNameEN());
        if (ingredientDTO.getNameES() != null)
            ingredient.setNameES(ingredientDTO.getNameES());
        if (ingredientDTO.getNameCA() != null)
            ingredient.setNameCA(ingredientDTO.getNameCA());
        ingredienteRepository.save(ingredient); // this performs update
        return convertToGetDTO(ingredient);
    }

    public IngredientDTO getByIdDTO(Long id) {
        return convertToGetDTO(getById(id));
    }

    public IngredientDTO convertToGetDTO(Ingredient ingredient) {
        IngredientDTO dto = new IngredientDTO(
                ingredient.getId(),
                ingredient.getNameEN(),
                ingredient.getNameES(),
                ingredient.getNameCA());
        return dto;
    }
}
