package com.eg.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eg.demo.models.Category;
import com.eg.demo.repositories.CategoryRepository;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
    private CategoryRepository categoryRepositoryObj;

    // Create a new category
    @PostMapping
    public Category addCategory(@RequestBody Category categoryObj) {
        return categoryRepositoryObj.save(categoryObj);
    }

    // Get all categories
    @GetMapping
    public List<Category> getAllCategory() {
        return categoryRepositoryObj.findAll();
    }

    // Get a category by ID
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryRepositoryObj.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found for ID: " + id));
    }

//    // Update a category by ID
//    @PutMapping("/{id}")
//    public Category updateCategory(@PathVariable int id, @RequestBody Category categoryDetails) {
//        return categoryRepositoryObj.findById(id).map(category -> {
//            category.setCategoryName(categoryDetails.getCategoryName());
//            return categoryRepositoryObj.save(category);
//        }).orElseThrow(() -> new RuntimeException("Category not found for ID: " + id));
//    }

//    // Delete a category by ID
//    @DeleteMapping("/{id}")
//    public void deleteCategory(@PathVariable int id) {
//        categoryRepositoryObj.deleteById(id);
//    }

	
}
