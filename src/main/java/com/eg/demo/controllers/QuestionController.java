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
import com.eg.demo.models.Difficulty_level;
import com.eg.demo.models.Question;
import com.eg.demo.repositories.CategoryRepository;
import com.eg.demo.repositories.Difficulty_levelRepository;
import com.eg.demo.repositories.QuestionRepository;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

	@Autowired
    private QuestionRepository questionRepositoryObj;

    @Autowired
    private CategoryRepository categoryRepositoryObj;

    @Autowired
    private Difficulty_levelRepository difficultyLevelRepositoryObj;
    
 // add a new question
    @PostMapping
    public Question addQuestion(@RequestBody Question questionObj) {
        // Ensure the category exists
        Category categoryObj = categoryRepositoryObj.findById(questionObj.getCategoryObj().getCategory_id())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Ensure the difficulty level exists
        Difficulty_level difficultyLevelObj = difficultyLevelRepositoryObj
                .findById(questionObj.getDifficulty_levelObj().getDifficulty_level_id())
                .orElseThrow(() -> new RuntimeException("Difficulty Level not found"));

        // Set relationships
        questionObj.setCategoryObj(categoryObj);
        questionObj.setDifficulty_levelObj(difficultyLevelObj);

        return questionRepositoryObj.save(questionObj);
    }

    // Get all questions
    @GetMapping
    public List<Question> getAllQuestion() {
        return questionRepositoryObj.findAll();
    }

    // Get a question by ID
    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable Long id) {
        return questionRepositoryObj.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found for ID: " + id));
    }

//    // Update a question by ID
//    @PutMapping("/{id}")
//    public Question updateQuestion(@PathVariable Long id, @RequestBody Question questionDetails) {
//        return questionRepositoryObj.findById(id).map(existingQuestion -> {
//            existingQuestion.setQuestion(questionDetails.getQuestion());
//
//            // Update category if provided
//            if (questionDetails.getCategory() != null) {
//                Category categoryObj = categoryRepositoryObj
//                        .findById(questionDetails.getCategory().getCategory_id())
//                        .orElseThrow(() -> new RuntimeException("Category not found"));
//                existingQuestion.setCategory(categoryObj);
//            }
//
//            // Update difficulty level if provided
//            if (questionDetails.getDifficultyLevel() != null) {
//                DifficultyLevel difficultyLevelObj = difficultyLevelRepositoryObj
//                        .findById(questionDetails.getDifficultyLevel().getDifficulty_level_id())
//                        .orElseThrow(() -> new RuntimeException("Difficulty Level not found"));
//                existingQuestion.setDifficultyLevel(difficultyLevelObj);
//            }
//
//            return questionRepositoryObj.save(existingQuestion);
//        }).orElseThrow(() -> new RuntimeException("Question not found for ID: " + id));
//    }

//    // Delete a question by ID
//    @DeleteMapping("/{id}")
//    public void deleteQuestion(@PathVariable Long id) {
//        questionRepositoryObj.deleteById(id);
//    }
	
}
