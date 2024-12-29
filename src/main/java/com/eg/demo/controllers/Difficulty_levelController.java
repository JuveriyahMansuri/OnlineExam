package com.eg.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.eg.demo.models.Difficulty_level;
import com.eg.demo.repositories.Difficulty_levelRepository;

@RestController
@RequestMapping("/api/difficulty_level")
public class Difficulty_levelController {

	@Autowired
    private Difficulty_levelRepository difficulty_levelRepositoryObj;

    // Create a new difficulty level
    @PostMapping
    public Difficulty_level addDifficulty_level(@RequestBody Difficulty_level difficulty_levelObj) {
        return difficulty_levelRepositoryObj.save(difficulty_levelObj);
    }

    // Get all difficulty levels
    @GetMapping
    public List<Difficulty_level> getAllDifficulty_level() {
        return difficulty_levelRepositoryObj.findAll();
    }

    // Get a difficulty level by ID
    @GetMapping("/{id}")
    public Difficulty_level getDifficultyLevelById(@PathVariable Long id) {
        return difficulty_levelRepositoryObj.findById(id)
                .orElseThrow(() -> new RuntimeException("Difficulty Level not found for ID: " + id));
    }

    // 4.Update a city by ID
    @PutMapping("/{id}")
    public Difficulty_level updateDifficulty_level(@PathVariable Long id, @RequestBody Difficulty_level difficulty_levelObj) {
        return difficulty_levelRepositoryObj.findById(id).map(difficulty_level -> {
        	
            difficulty_level.setDifficulty_level(difficulty_levelObj.getDifficulty_level());
            
            return difficulty_levelRepositoryObj.save(difficulty_level);
        }
        ).orElseThrow(() -> new RuntimeException("Difficulty level not found for ID: " + id));
    }


    // Delete a difficulty level by ID
    @DeleteMapping("/{id}")
    public void deleteDifficulty_level(@PathVariable Long id) {
        difficulty_levelRepositoryObj.deleteById(id);
    }
	
}
