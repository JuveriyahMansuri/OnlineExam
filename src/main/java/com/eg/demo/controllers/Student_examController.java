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
import com.eg.demo.models.Student_exam;
import com.eg.demo.models.User;
import com.eg.demo.repositories.ExamRepository;
import com.eg.demo.repositories.Student_examRepository;
import com.eg.demo.repositories.UserRepository;

@RestController
@RequestMapping("/api/student_exam")
public class Student_examController {

	 @Autowired
	    private Student_examRepository student_examRepositoryObj;

	    @Autowired
	    private UserRepository userRepositoryObj;

	    @Autowired
	    private ExamRepository examRepositoryObj;

	    // Create a new student exam record
	    @PostMapping
	    public Student_exam addStudentExam(@RequestBody Student_exam student_examObj) {
	        // Validate and fetch the student
	        User studentObj = userRepositoryObj.findById(student_examObj.getUserObj().getUser_id())
	                .orElseThrow(() -> new RuntimeException("Student not found"));

	        // Validate and fetch the exam
	        Exam examObj = examRepositoryObj.findById(student_examObj.getExamObj().getExam_id())
	                .orElseThrow(() -> new RuntimeException("Exam not found"));

	        // Set relationships
	        student_examObj.setUserObj(studentObj);
	        student_examObj.setExamObj(examObj);

	        return student_examRepositoryObj.save(student_examObj);
	    }

	    // Get all student exam records
	    @GetMapping
	    public List<Student_exam> getAllStudentExams() {
	        return student_examRepositoryObj.findAll();
	    }

	    // Get a student exam record by ID
	    @GetMapping("/{id}")
	    public Student_exam getStudentExamById(@PathVariable Long id) {
	        return student_examRepositoryObj.findById(id)
	                .orElseThrow(() -> new RuntimeException("StudentExam record not found for ID: " + id));
	    }

	    // Update a student exam record
	    @PutMapping("/{id}")
	    public Student_exam updateStudentExam(@PathVariable Long id, @RequestBody Student_exam student_examObj) {
	        return student_examRepositoryObj.findById(id).map(existingStudent_exam -> {
	            // Update relationships if provided
	            if (student_examObj.getUserObj() != null) {
	                User userObj = userRepositoryObj.findById(student_examObj.getUserObj().getUser_id())
	                        .orElseThrow(() -> new RuntimeException("Student not found"));
	                existingStudent_exam.setUserObj(userObj);
	            }

	            if (student_examObj.getExamObj() != null) {
	                Exam examObj = examRepositoryObj.findById(student_examObj.getExamObj().getExam_id())
	                        .orElseThrow(() -> new RuntimeException("Exam not found"));
	                existingStudent_exam.setExamObj(examObj);
	            }

	            // Update other fields
	            existingStudent_exam.setStudent_exam_start_datetime(student_examObj.getStudent_exam_start_datetime());
	            existingStudent_exam.setPassed(student_examObj.isPassed());

	            return student_examRepositoryObj.save(existingStudent_exam);
	        }).orElseThrow(() -> new RuntimeException("StudentExam record not found for ID: " + id));
	    }

	    // Delete a student exam record
	    @DeleteMapping("/{id}")
	    public void deleteStudent_exam(@PathVariable Long id) {
	        student_examRepositoryObj.deleteById(id);
	    }
	    
}
