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

import com.eg.demo.models.Exam;
import com.eg.demo.models.User;
import com.eg.demo.repositories.ExamRepository;
import com.eg.demo.repositories.UserRepository;

@RestController
@RequestMapping("/api/exam")
public class ExamController {

	@Autowired
    private ExamRepository examRepositoryObj;

    @Autowired
    private UserRepository userRepositoryObj; // Assuming AdminRepository exists

 // Create a new exam
    @PostMapping
    public Exam addExam(@RequestBody Exam examObj) {
        // Ensure the admin exists before saving the exam
        User userObj = userRepositoryObj.findById(examObj.getUserObj().getUser_id())
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        examObj.setUserObj(userObj);
        return examRepositoryObj.save(examObj);
    }
    
 // Get all exams
    @GetMapping
    public List<Exam> getAllExam() {
        return examRepositoryObj.findAll();
    }

    // Get an exam by ID
    @GetMapping("/{id}")
    public Exam getExamById(@PathVariable Long id) {
        return examRepositoryObj.findById(id)
                .orElseThrow(() -> new RuntimeException("Exam not found for ID: " + id));
    }

 // Update an exam by ID
    @PutMapping("/{id}")
    public Exam updateExam(@PathVariable Long id, @RequestBody Exam examObj) {
        return examRepositoryObj.findById(id).map(existingExam -> {
        	
            existingExam.setExam_date(examObj.getExam_date());
            
            existingExam.setExam_duration(examObj.getExam_duration());
            
            existingExam.setPassing_criteria(examObj.getPassing_criteria());
            
            existingExam.setCompleted(examObj.isCompleted());
            
            existingExam.setFinalSubmit(examObj.isFinalSubmit());

            // Update user(admin) association if provided
            User userObj = userRepositoryObj.findById(examObj.getUserObj().getUser_id())
                    .orElseThrow(() -> new RuntimeException("Admin not found"));
            existingExam.setUserObj(userObj);

            return examRepositoryObj.save(existingExam);
        }
        ).orElseThrow(() -> new RuntimeException("Exam not found for ID: " + id));
    }

    // Delete an exam by ID
    @DeleteMapping("/{id}")
    public void deleteExam(@PathVariable Long id) {
        examRepositoryObj.deleteById(id);
    }
}
