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

import com.eg.demo.models.Programming;
import com.eg.demo.models.Question;
import com.eg.demo.repositories.ProgrammingRepository;
import com.eg.demo.repositories.QuestionRepository;

@RestController
@RequestMapping("/api/programming")
public class ProgrammingController {

	@Autowired
    private ProgrammingRepository programmingRepositoryObj;

    @Autowired
    private QuestionRepository questionRepositoryObj;

    // Create a new programming record
    @PostMapping
    public Programming addProgramming(@RequestBody Programming programmingObj) {
        // Validate and fetch the question
        Question questionObj = questionRepositoryObj.findById(programmingObj.getQuestionObj().getQuestion_id())
                .orElseThrow(() -> new RuntimeException("Question not found"));

        // Set the question relationship
        programmingObj.setQuestionObj(questionObj);

        return programmingRepositoryObj.save(programmingObj);
    }

    // Get all programming records
    @GetMapping
    public List<Programming> getAllProgramming() {
        return programmingRepositoryObj.findAll();
    }

    // Get a programming record by ID
    @GetMapping("/{id}")
    public Programming getProgrammingById(@PathVariable Long id) {
        return programmingRepositoryObj.findById(id)
                .orElseThrow(() -> new RuntimeException("Programming record not found for ID: " + id));
    }

    // Update a programming record
    @PutMapping("/{id}")
    public Programming updateProgramming(@PathVariable Long id, @RequestBody Programming programmingObj) {
        return programmingRepositoryObj.findById(id).map(existingProgramming -> {
            // Update relationships if provided
            if (programmingObj.getQuestionObj() != null) {
                Question questionObj = questionRepositoryObj.findById(programmingObj.getQuestionObj().getQuestion_id())
                        .orElseThrow(() -> new RuntimeException("Question not found"));
                existingProgramming.setQuestionObj(questionObj);
            }
            
            // Update other fields
            existingProgramming.setExpected_output(programmingObj.getExpected_output());
            existingProgramming.setReference_answer(programmingObj.getReference_answer());

            return programmingRepositoryObj.save(existingProgramming);
        }).orElseThrow(() -> new RuntimeException("Programming record not found for ID: " + id));
    }

    // Delete a programming record
    @DeleteMapping("/{id}")
    public void deleteProgramming(@PathVariable Long id) {
        programmingRepositoryObj.deleteById(id);
    }
	
}
