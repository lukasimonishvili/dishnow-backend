package com.dishNow.dishNow.Services;

import com.cloudinary.Cloudinary;
import com.dishNow.dishNow.Enums.RECIPE_ENUMS.STATUS;
import com.dishNow.dishNow.Models.Category;
import com.dishNow.dishNow.Models.Ingredient;
import com.dishNow.dishNow.Models.Recipe;
import com.dishNow.dishNow.Models.RecipeAddDTO;
import com.dishNow.dishNow.Models.RecipeGetDTO;
import com.dishNow.dishNow.Models.User;
import com.dishNow.dishNow.Repositories.CategoryRepository;
import com.dishNow.dishNow.Repositories.IngredientRepository;
import com.dishNow.dishNow.Repositories.RecipeRepository;
import com.dishNow.dishNow.Repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CloudinaryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired 
    IngredientRepository ingredientRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RecipeRepository recipeRepository;
    
    private final Cloudinary cloudinary;

    public CloudinaryService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public String uploadFile(MultipartFile file) {
        try{
            HashMap<Object, Object> options = new HashMap<>();
            options.put("folder", "recipes");
            Map uploadedFile = cloudinary.uploader().upload(file.getBytes(), options);
            String publicId = (String) uploadedFile.get("public_id");
            return cloudinary.url().secure(true).generate(publicId);
        }catch (IOException e){
            return "Claudinary" + e.getMessage();
        }
    }

    public RecipeGetDTO addRecipe(RecipeAddDTO dto, List<MultipartFile> photos) throws IOException{
        Category category = categoryRepository.findById(dto.getCategory()).orElse(null);
        List<Ingredient> ingredients = ingredientRepository.findAllById(dto.getIngredients());
        List<String> photoUrls = new ArrayList<>();
        User user = userRepository.findById(dto.getUser()).orElse(null);
        
        try {
            for (MultipartFile file : photos) {
                String url = this.uploadFile(file);
                photoUrls.add(url);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        Recipe newRecipe = new Recipe();
        newRecipe.setNameEN(dto.getName());
        newRecipe.setNameES(dto.getName());
        newRecipe.setNameCA(dto.getName());
        newRecipe.setDescriptionEN(dto.getDescription());
        newRecipe.setDescriptionES(dto.getDescription());
        newRecipe.setDescriptionCA(dto.getDescription());
        newRecipe.setCategory(category);
        newRecipe.setIngredients(ingredients);
        newRecipe.setStatus(STATUS.PENDING);
        newRecipe.setAmountLikes(0);
        newRecipe.setPhotos(photoUrls);
        newRecipe.setUserCreator(user);

        recipeRepository.save(newRecipe);
        return new RecipeGetDTO(newRecipe);
    }
}
