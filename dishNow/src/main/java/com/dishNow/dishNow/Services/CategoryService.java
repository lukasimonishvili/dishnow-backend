package com.dishNow.dishNow.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dishNow.dishNow.Models.Category;
import com.dishNow.dishNow.Models.CategoryDTO;
import com.dishNow.dishNow.Repositories.CategoryRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public void add(CategoryDTO categoryDTO) {
        categoryRepository.save(convertToEntity(categoryDTO));
    }

    public void remove(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new EntityNotFoundException("Category with id " + id + " not found");
        }
        categoryRepository.deleteById(id);
    }

    public Category getById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category with ID " + id + " not found"));
    }

    public CategoryDTO getByIdDTO(Long id) {
        return convertToEntity(getById(id));
    }

    public CategoryDTO convertToEntity(Category category) {
        CategoryDTO dto = new CategoryDTO(
                category.getId(),
                category.getNameEN(),
                category.getNameES(),
                category.getNameCA());
        return dto;
    }

    public Category convertToEntity(CategoryDTO dto) {
        Category category = new Category(
                dto.getNameEN(),
                dto.getNameES(),
                dto.getNameCA());
        return category;
    }

    public void update(Long id, CategoryDTO categoryDTO) {
        Category category = getById(id);
        if (categoryDTO.getNameEN() != null)
            category.setNameEN(categoryDTO.getNameEN());
        if (categoryDTO.getNameES() != null)
            category.setNameES(categoryDTO.getNameES());
        if (categoryDTO.getNameCA() != null)
            category.setNameCA(categoryDTO.getNameCA());
        categoryRepository.save(category); // this performs update
    }

}
