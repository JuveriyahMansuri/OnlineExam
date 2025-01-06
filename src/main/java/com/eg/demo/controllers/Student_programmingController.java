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
import com.eg.demo.models.Student_programming;
import com.eg.demo.models.User;
import com.eg.demo.repositories.ProgrammingRepository;
import com.eg.demo.repositories.Student_programmingRepository;
import com.eg.demo.repositories.UserRepository;

@RestController
@RequestMapping("/api/student_programming")
public class Student_programmingController {
	@Autowired
    private Student_programmingRepository student_programmingRepositoryObj;

    @Autowired
    private UserRepository userRepositoryObj;

    @Autowired
    private ProgrammingRepository programmingRepositoryObj;

    // Create a new student programming record
    @PostMapping
    public Student_programming addStudentProgramming(@RequestBody Student_programming student_programmingObj) {
        // Validate and fetch the student (user)
        User studentObj = userRepositoryObj.findById(student_programmingObj.getUserObj().getUser_id())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // Validate and fetch the programming question
        Programming programmingObj = programmingRepositoryObj.findById(student_programmingObj.getProgrammingObj().getProgramming_id())
                .orElseThrow(() -> new RuntimeException("Programming question not found"));

        // Set relationships
        student_programmingObj.setUserObj(studentObj);
        student_programmingObj.setProgrammingObj(programmingObj);

        return student_programmingRepositoryObj.save(student_programmingObj);
    }

    // Get all student programming records
    @GetMapping
    public List<Student_programming> getAllStudentProgramming() {
        return student_programmingRepositoryObj.findAll();
    }

    // Get a student programming record by ID
    @GetMapping("/{id}")
    public Student_programming getStudentProgrammingById(@PathVariable Long id) {
        return student_programmingRepositoryObj.findById(id)
                .orElseThrow(() -> new RuntimeException("StudentProgramming record not found for ID: " + id));
    }

    // Update a student programming record
    @PutMapping("/{id}")
    public Student_programming updateStudent_programming(@PathVariable Long id, @RequestBody Student_programming student_programmingObj) {
        return student_programmingRepositoryObj.findById(id).map(existingStudent_programming -> {
            // Update relationships if provided
            if (student_programmingObj.getUserObj() != null) {
                User userObj = userRepositoryObj.findById(student_programmingObj.getUserObj().getUser_id())
                        .orElseThrow(() -> new RuntimeException("Student not found"));
                existingStudent_programming.setUserObj(userObj);
            }

            if (student_programmingObj.getProgrammingObj() != null) {
                Programming programmingObj = programmingRepositoryObj.findById(student_programmingObj.getProgrammingObj().getProgramming_id())
                        .orElseThrow(() -> new RuntimeException("Programming question not found"));
                existingStudent_programming.setProgrammingObj(programmingObj);
            }

            // Update other fields
            existingStudent_programming.setUser_output(student_programmingObj.getUser_output());
            existingStudent_programming.setCode_submitted(student_programmingObj.getCode_submitted());
            existingStudent_programming.setCorrect(student_programmingObj.isCorrect());

            return student_programmingRepositoryObj.save(existingStudent_programming);
        }).orElseThrow(() -> new RuntimeException("StudentProgramming record not found for ID: " + id));
    }

    // Delete a student programming record
    @DeleteMapping("/{id}")
    public void deleteStudent_programming(@PathVariable Long id) {
        student_programmingRepositoryObj.deleteById(id);
    }

}
