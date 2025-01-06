package com.eg.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eg.demo.models.*;
import com.eg.demo.models.Student_details;
import com.eg.demo.models.User;
import com.eg.demo.repositories.CollegeRepository;
import com.eg.demo.repositories.Student_detailsRepository;
import com.eg.demo.repositories.UserRepository;

@RestController
@RequestMapping("/api/student_details")
public class Student_detailsController {
	 @Autowired
	    private Student_detailsRepository student_detailsRepositoryObj;

	    @Autowired
	    private UserRepository userRepositoryObj;

	    @Autowired
	    private CollegeRepository collegeRepositoryObj;

	    // Create a new student details record and associate it with a user and a college
	    @PostMapping
	    public Student_details addStudent_details(@RequestBody Student_details student_detailsObj) {
	        // Ensure the user exists before saving the student details
	        User userObj = userRepositoryObj.findById(student_detailsObj.getUserObj().getUser_id())
	                .orElseThrow(() -> new RuntimeException("User not found"));

	        // Ensure the college exists before saving the student details
	        College collegeObj = collegeRepositoryObj.findById(student_detailsObj.getCollegeObj().getCollege_id())
	                .orElseThrow(() -> new RuntimeException("College not found"));

	       student_detailsObj.setUserObj(userObj);
	       student_detailsObj.setCollegeObj(collegeObj);
	        
	        return student_detailsRepositoryObj.save(student_detailsObj);
	    }

	    // Get all student details
	    @GetMapping
	    public List<Student_details> getAllStudent_details() {
	        return student_detailsRepositoryObj.findAll();
	    }

	    // Get student details by ID
	    @GetMapping("/{id}")
	    public Student_details getStudent_detailsById(@PathVariable Long id) {
	        return student_detailsRepositoryObj.findById(id)
	                .orElseThrow(() -> new RuntimeException("StudentDetails not found for ID: " + id));
	    }
//
	    // Update student details by ID
	    @PutMapping("/{id}")
	    public Student_details updateStudent_details(@PathVariable Long id, @RequestBody Student_details student_detailsObj) {
	        return student_detailsRepositoryObj.findById(id).map(existingStudent_details -> {
	            existingStudent_details.setCgpa(student_detailsObj.getCgpa());
	            existingStudent_details.setHsc(student_detailsObj.getHsc());
	            existingStudent_details.setSsc(student_detailsObj.getSsc());
	            existingStudent_details.setUserObj(student_detailsObj.getUserObj());
	            existingStudent_details.setCollegeObj(student_detailsObj.getCollegeObj());
	            return student_detailsRepositoryObj.save(existingStudent_details);
	        }).orElseThrow(() -> new RuntimeException("StudentDetails not found for ID: " + id));
	    }

	    // Delete student details by ID
	    @DeleteMapping("/{id}")
	    public void deleteStudentDetails(@PathVariable Long id) {
	        student_detailsRepositoryObj.deleteById(id);
	    }
}
