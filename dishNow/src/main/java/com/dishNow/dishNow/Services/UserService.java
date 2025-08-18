package com.dishNow.dishNow.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dishNow.dishNow.Models.Recipe;
import com.dishNow.dishNow.Models.User;
import com.dishNow.dishNow.Models.UserAddDTO;
import com.dishNow.dishNow.Models.UserDTO;
import com.dishNow.dishNow.Repositories.RecipeRepository;
import com.dishNow.dishNow.Repositories.UserRepository;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RecipeRepository recipeRepository;

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public UserDTO addByDTO(UserAddDTO userAdd) {
        User user = convertToEntity(userAdd);
        return add(user);
    }

    public UserDTO add(User user) {
        userRepository.save(user);
        return convertToGetDTO(user);
    }

    public Optional<User> remove(Long id) {
        Optional<User> userOp = getUserById(id);
        if (userOp.isEmpty()){
            return Optional.empty();
        }
        userRepository.deleteById(id);
        return Optional.of(userOp.get());
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

    public Optional<UserDTO> getByIdDTO(Long id) {
        Optional<User> userOp = getUserById(id);
        if (userOp.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(convertToGetDTO(userOp.get()));
    }

    public Optional<UserDTO> update(Long id, UserAddDTO dto) {
        // Obtener el usuario existente por su ID
        Optional<User> userOp = getUserById(id);
        if (userOp.isEmpty()){
            return Optional.empty();
        }
        User user = userOp.get();
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

        return Optional.of(updatedDto);
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
            Optional<Recipe> op = recipeRepository.findById(id);
            if(op.isEmpty()){continue;}
            recipes.add(op.get());
        }
        return recipes;
    }
}
