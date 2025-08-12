package com.dishNow.dishNow.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dishNow.dishNow.Models.Ingredient;
import com.dishNow.dishNow.Models.IngredientDTO;
import com.dishNow.dishNow.Repositories.IngredientRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class IngredrientService {
    @Autowired
    private IngredientRepository ingredienteRepository;

    public void add(IngredientDTO ingredientDTO) {
        ingredienteRepository.save(convertToEntity(ingredientDTO));
    }

    public Ingredient convertToEntity(IngredientDTO dto) {
        Ingredient ingredient = new Ingredient(
                dto.getNameEN(),
                dto.getNameES(),
                dto.getNameCA());
        return ingredient;
    }

    public void remove(Long id) {
        if (!ingredienteRepository.existsById(id)) {
            throw new EntityNotFoundException("Ingredient with id " + id + " not found");
        }
        ingredienteRepository.deleteById(id);
    }

    public Ingredient getById(Long id) {
        return ingredienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ingedient with ID " + id + " not found"));
    }

    public void update(Long id, IngredientDTO ingredientDTO) {
        Ingredient ingredient = getById(id);
        if (ingredientDTO.getNameEN() != null)
            ingredient.setNameEN(ingredientDTO.getNameEN());
        if (ingredientDTO.getNameES() != null)
            ingredient.setNameES(ingredientDTO.getNameES());
        if (ingredientDTO.getNameCA() != null)
            ingredient.setNameCA(ingredientDTO.getNameCA());
        ingredienteRepository.save(ingredient); // this performs update
    }
}
