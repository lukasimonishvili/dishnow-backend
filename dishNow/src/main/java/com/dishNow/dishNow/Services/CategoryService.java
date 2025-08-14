package com.dishNow.dishNow.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public void remove(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Category with id " + id + " not found");
        }
        categoryRepository.deleteById(id);
    }

    public Category getById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category with ID " + id + " not found"));
    }

    public CategoryDTO getByIdDTO(Long id) {
        return convertToGetDTO(getById(id));
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

    public CategoryDTO update(Long id, CategoryAddDTO categoryDTO) {
        Category category = getById(id);
        if (categoryDTO.getNameEN() != null)
            category.setNameEN(categoryDTO.getNameEN());
        if (categoryDTO.getNameES() != null)
            category.setNameES(categoryDTO.getNameES());
        if (categoryDTO.getNameCA() != null)
            category.setNameCA(categoryDTO.getNameCA());
        categoryRepository.save(category); // this performs update
        return convertToGetDTO(category);
    }

}
