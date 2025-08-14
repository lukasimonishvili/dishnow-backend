package com.dishNow.dishNow.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dishNow.dishNow.Models.Recipe;
import com.dishNow.dishNow.Models.User;
import com.dishNow.dishNow.Models.UserAddDTO;
import com.dishNow.dishNow.Models.UserDTO;
import com.dishNow.dishNow.Repositories.RecipeRepository;
import com.dishNow.dishNow.Repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RecipeRepository recipeRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with ID " + id + " not found. Service"));
    }

    public UserDTO addByDTO(UserAddDTO userAdd) {
        User user = convertToEntity(userAdd);
        return add(user);
    }

    public UserDTO add(User user) {
        userRepository.save(user);
        return convertToGetDTO(user);
    }

    public void remove(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("Category with id " + id + " not found");
        }
        userRepository.deleteById(id);
    }

    public UserDTO convertToGetDTO(User user) {
        UserDTO dto = new UserDTO(
                user.getId(),
                user.getName(),
                user.getLastName(),
                user.getBirthday(),
                user.getEmail(),
                user.getRole(),
                user.isVerified(),
                getRecipesIDs(user.getFavoriteRecipes()),
                getRecipesIDs(user.getRecipesCreated()));
        return dto;
    }

    public User convertToEntity(UserAddDTO dto) {
        User user = new User(
                dto.getName(),
                dto.getLastName(),
                dto.getBirthday(),
                dto.getEmail(),
                dto.getRole(),
                dto.isVerified(),
                getRecipesByIDs(dto.getFavoriteRecipes()),
                getRecipesByIDs(dto.getRecipesCreated()));
        return user;
    }

    public UserDTO getByIdDTO(Long id) {
        return convertToGetDTO(getUserById(id));
    }

    public UserDTO update(Long id, UserAddDTO dto) {
        // Obtener el usuario existente por su ID
        User user = getUserById(id);

        // Actualizar los atributos solo si los nuevos valores no son null
        if (dto.getName() != null)
            user.setName(dto.getName());
        if (dto.getLastName() != null)
            user.setLastName(dto.getLastName());
        if (dto.getBirthday() != null)
            user.setBirthday(dto.getBirthday());
        if (dto.getEmail() != null)
            user.setEmail(dto.getEmail());
        if (dto.getRole() != null)
            user.setRole(dto.getRole());
        if (dto.getFavoriteRecipes() != null)
            user.setFavoriteRecipes(getRecipesByIDs(dto.getFavoriteRecipes()));
        if (dto.getRecipesCreated() != null)
            user.setRecipesCreated(getRecipesByIDs(dto.getRecipesCreated()));
        if (dto.isVerified() != user.isVerified()) // Solo si el valor cambia
            user.setVerified(dto.isVerified());

        // Convertir el usuario actualizado en DTO
        UserDTO updatedDto = convertToGetDTO(user);

        // Guardar el usuario actualizado en la base de datos
        userRepository.save(user); // Esto realiza la actualización

        return updatedDto;
    }

    public List<Long> getRecipesIDs(List<Recipe> recipes) {
        List<Long> ids = new ArrayList<>();
        for (Recipe recipe : recipes) {
            ids.add(recipe.getId());
        }
        return ids;
    }

    public List<Recipe> getRecipesByIDs(List<Long> ids) {
        List<Recipe> recipes = new ArrayList<>();
        for (Long id : ids) {
            Recipe recipe = getRecipeByID(id);
            recipes.add(recipe);
        }
        return recipes;
    }

    public Recipe getRecipeByID(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Recipe with ID " + id + " not found. Service"));
    }

}
