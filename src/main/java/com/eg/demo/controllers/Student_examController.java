package com.eg.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

//	    // Update a student exam record
//	    @PutMapping("/{id}")
//	    public StudentExam updateStudentExam(@PathVariable Long id, @RequestBody StudentExam studentExamDetails) {
//	        return student_examRepositoryObj.findById(id).map(existingStudentExam -> {
//	            // Update relationships if provided
//	            if (studentExamDetails.getStudent() != null) {
//	                User studentObj = userRepositoryObj.findById(studentExamDetails.getStudent().getUser_id())
//	                        .orElseThrow(() -> new RuntimeException("Student not found"));
//	                existingStudentExam.setStudent(studentObj);
//	            }
//
//	            if (studentExamDetails.getExam() != null) {
//	                Exam examObj = examRepositoryObj.findById(studentExamDetails.getExam().getExam_id())
//	                        .orElseThrow(() -> new RuntimeException("Exam not found"));
//	                existingStudentExam.setExam(examObj);
//	            }
//
//	            // Update other fields
//	            existingStudentExam.setStudent_exam_start_datetime(studentExamDetails.getStudent_exam_start_datetime());
//	            existingStudentExam.setPassed(studentExamDetails.isPassed());
//
//	            return studentExamRepositoryObj.save(existingStudentExam);
//	        }).orElseThrow(() -> new RuntimeException("StudentExam record not found for ID: " + id));
//	    }
//
//	    // Delete a student exam record
//	    @DeleteMapping("/{id}")
//	    public void deleteStudentExam(@PathVariable Long id) {
//	        student_examRepositoryObj.deleteById(id);
//	    }
	    
}
