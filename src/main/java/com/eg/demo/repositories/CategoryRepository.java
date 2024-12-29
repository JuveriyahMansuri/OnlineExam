package com.eg.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eg.demo.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
