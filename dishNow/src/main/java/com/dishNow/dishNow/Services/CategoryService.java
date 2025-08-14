package com.dishNow.dishNow.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dishNow.dishNow.Models.Category;
import com.dishNow.dishNow.Models.CategoryAddDTO;
import com.dishNow.dishNow.Models.CategoryDTO;
import com.dishNow.dishNow.Repositories.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDTO add(CategoryAddDTO categoryDTO) {
        Category cat = convertToEntity(categoryDTO);
        categoryRepository.save(cat);
        return convertToGetDTO(cat);
    }

    public Optional<Category> remove(Long id) {
        Optional<Category> op = getById(id);
        if (op.isEmpty()){
            return Optional.empty();
        }
        categoryRepository.deleteById(id);
        return Optional.of(op.get());
    }

    public Optional<Category> getById(Long id) {
        return categoryRepository.findById(id);
    }

    public Optional<CategoryDTO> getByIdDTO(Long id) {
        Optional<Category> categoryOp = getById(id);
        if (categoryOp.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(convertToGetDTO(categoryOp.get()));
    }

    public CategoryDTO convertToGetDTO(Category category) {
        CategoryDTO dto = new CategoryDTO(
                category.getId(),
                category.getNameEN(),
                category.getNameES(),
                category.getNameCA());
        return dto;
    }

    public Category convertToEntity(CategoryAddDTO dto) {
        Category category = new Category(
                dto.getNameEN(),
                dto.getNameES(),
                dto.getNameCA());
        return category;
    }

    public Optional<CategoryDTO> update(Long id, CategoryAddDTO categoryDTO) {

        Optional<Category> categoryOp = getById(id);
        if (categoryOp.isEmpty()){
            return Optional.empty();
        }

        Category category = categoryOp.get();
        if (categoryDTO.getNameEN() != null)
            category.setNameEN(categoryDTO.getNameEN());
        if (categoryDTO.getNameES() != null)
            category.setNameES(categoryDTO.getNameES());
        if (categoryDTO.getNameCA() != null)
            category.setNameCA(categoryDTO.getNameCA());
        categoryRepository.save(category); // this performs update
        return Optional.of(convertToGetDTO(category));
    }

}
