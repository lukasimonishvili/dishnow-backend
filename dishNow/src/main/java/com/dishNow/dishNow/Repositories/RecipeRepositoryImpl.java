package com.dishNow.dishNow.Repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dishNow.dishNow.Enums.RECIPE_ENUMS;
import com.dishNow.dishNow.Models.Recipe;
import com.dishNow.dishNow.interfaces.RecipeRepositoryCustom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class RecipeRepositoryImpl implements RecipeRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Recipe> findRecipes(Long categoryId, List<Long> ingredientIds, String keyword, RECIPE_ENUMS.STATUS status) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Recipe> query = cb.createQuery(Recipe.class);
        Root<Recipe> recipe = query.from(Recipe.class);

        List<Predicate> predicates = new ArrayList<>();

        // Always enforce APPROVED
        predicates.add(cb.equal(recipe.get("status"), status));

        if (categoryId != null) {
            predicates.add(cb.equal(recipe.get("category").get("id"), categoryId));
        }

        if (ingredientIds != null && !ingredientIds.isEmpty()) {
            Join<Object, Object> ingredients = recipe.join("ingredients");
            predicates.add(ingredients.get("id").in(ingredientIds));
        }

        if (keyword != null && !keyword.isBlank()) {
            Predicate nameENMatch = cb.like(cb.lower(recipe.get("nameEN")), "%" + keyword.toLowerCase() + "%");
            Predicate nameESMatch = cb.like(cb.lower(recipe.get("nameES")), "%" + keyword.toLowerCase() + "%");
            Predicate nameCAMatch = cb.like(cb.lower(recipe.get("nameCA")), "%" + keyword.toLowerCase() + "%");
            predicates.add(cb.or(nameENMatch, nameESMatch, nameCAMatch));
        }

        query.select(recipe).where(predicates.toArray(new Predicate[0])).distinct(true);

        return entityManager.createQuery(query).getResultList();
    }
}