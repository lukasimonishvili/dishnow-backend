package com.dishNow.dishNow.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dishNow.dishNow.Models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
