package com.eg.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eg.demo.models.Opt;
import com.eg.demo.models.Question;
import com.eg.demo.repositories.OptRepository;
import com.eg.demo.repositories.QuestionRepository;

@RestController
@RequestMapping("/api/opt")
public class OptController {
	
	@Autowired
	    private OptRepository optRepositoryObj;

	    @Autowired
	    private QuestionRepository questionRepositoryObj;

	    // Create a new option
	    @PostMapping
	    public Opt addOption(@RequestBody Opt optionObj) {
	        // Ensure the question exists
	        Question questionObj = questionRepositoryObj.findById(optionObj.getQuestionObj().getQuestion_id())
	                .orElseThrow(() -> new RuntimeException("Question not found"));

	        // Set the relationship
	        optionObj.setQuestionObj(questionObj);
	        return optRepositoryObj.save(optionObj);
	    }

	    // Get all options
	    @GetMapping
	    public List<Opt> getAllOption() {
	        return optRepositoryObj.findAll();
	    }

	    // Get an option by ID
	    @GetMapping("/{id}")
	    public Opt getOptionById(@PathVariable Long id) {
	        return optRepositoryObj.findById(id)
	                .orElseThrow(() -> new RuntimeException("Option not found for ID: " + id));
	    }

//	    // Update an option by ID
//	    @PutMapping("/{id}")
//	    public Option updateOption(@PathVariable Long id, @RequestBody Option optionDetails) {
//	        return optionRepositoryObj.findById(id).map(existingOption -> {
//	            existingOption.setOption_name(optionDetails.getOption_name());
//	            existingOption.setCorrect(optionDetails.isCorrect());
//
//	            // Update the question association if provided
//	            if (optionDetails.getQuestion() != null) {
//	                Question questionObj = questionRepositoryObj.findById(optionDetails.getQuestion().getQuestion_id())
//	                        .orElseThrow(() -> new RuntimeException("Question not found"));
//	                existingOption.setQuestion(questionObj);
//	            }
//
//	            return optionRepositoryObj.save(existingOption);
//	        }).orElseThrow(() -> new RuntimeException("Option not found for ID: " + id));
//	    }

//	    // Delete an option by ID
//	    @DeleteMapping("/{id}")
//	    public void deleteOption(@PathVariable Long id) {
//	        optionRepositoryObj.deleteById(id);
//	    }

}