package com.eg.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

//    // Update a student programming record
//    @PutMapping("/{id}")
//    public StudentProgramming updateStudentProgramming(@PathVariable Long id, @RequestBody StudentProgramming studentProgrammingDetails) {
//        return student_programmingRepositoryObj.findById(id).map(existingStudentProgramming -> {
//            // Update relationships if provided
//            if (studentProgrammingDetails.getStudent() != null) {
//                User studentObj = userRepositoryObj.findById(studentProgrammingDetails.getStudent().getUser_id())
//                        .orElseThrow(() -> new RuntimeException("Student not found"));
//                existingStudentProgramming.setStudent(studentObj);
//            }
//
//            if (studentProgrammingDetails.getProgramming() != null) {
//                Programming programmingObj = programmingRepositoryObj.findById(studentProgrammingDetails.getProgramming().getProgramming_id())
//                        .orElseThrow(() -> new RuntimeException("Programming question not found"));
//                existingStudentProgramming.setProgramming(programmingObj);
//            }
//
//            // Update other fields
//            existingStudentProgramming.setUser_output(studentProgrammingDetails.getUser_output());
//            existingStudentProgramming.setCode_submitted(studentProgrammingDetails.getCode_submitted());
//            existingStudentProgramming.setCorrect(studentProgrammingDetails.isCorrect());
//
//            return studentProgrammingRepositoryObj.save(existingStudentProgramming);
//        }).orElseThrow(() -> new RuntimeException("StudentProgramming record not found for ID: " + id));
//    }
//
//    // Delete a student programming record
//    @DeleteMapping("/{id}")
//    public void deleteStudentProgramming(@PathVariable Long id) {
//        student_programmingRepositoryObj.deleteById(id);
//    }

}
