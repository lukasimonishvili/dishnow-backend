package com.dishNow.dishNow.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dishNow.dishNow.Models.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long>{
}
