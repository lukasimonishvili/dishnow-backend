package com.dishNow.dishNow.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Optional<Ingredient> remove(Long id) {
        Optional<Ingredient> op = getById(id);
        if (op.isEmpty()){
            return Optional.empty();
        }
        ingredienteRepository.deleteById(id);
        return Optional.of(op.get());
    }

    public Optional<Ingredient> getById(Long id) {
        return ingredienteRepository.findById(id);
    }

    public Optional<IngredientDTO> update(Long id, IngredientDTO ingredientDTO) {
        Optional<Ingredient> op = getById(id);
        if (op.isEmpty()){
            return Optional.empty();
        }
        Ingredient ingredient = op.get();
        if (ingredientDTO.getNameEN() != null)
            ingredient.setNameEN(ingredientDTO.getNameEN());
        if (ingredientDTO.getNameES() != null)
            ingredient.setNameES(ingredientDTO.getNameES());
        if (ingredientDTO.getNameCA() != null)
            ingredient.setNameCA(ingredientDTO.getNameCA());
        ingredienteRepository.save(ingredient); // this performs update
        return Optional.of(convertToGetDTO(ingredient));
    }

    public Optional<IngredientDTO> getByIdDTO(Long id) {
        Optional<Ingredient> op = getById(id);
        if (op.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(convertToGetDTO(op.get()));
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
