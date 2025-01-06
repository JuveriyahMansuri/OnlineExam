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
import com.eg.demo.models.Exam_question;
import com.eg.demo.models.Question;
import com.eg.demo.repositories.ExamRepository;
import com.eg.demo.repositories.Exam_questionRepository;
import com.eg.demo.repositories.QuestionRepository;

@RestController
@RequestMapping("/api/exam_question")
public class Exam_questionController {

	@Autowired
    private Exam_questionRepository exam_questionRepositoryObj;

    @Autowired
    private ExamRepository examRepositoryObj;

    @Autowired
    private QuestionRepository questionRepositoryObj;
    
 // Create a new exam-question relationship
    @PostMapping
    public Exam_question addExam_question(@RequestBody Exam_question examQuestionObj) {
        // Validate and fetch the exam
        Exam examObj = examRepositoryObj.findById(examQuestionObj.getExamObj().getExam_id())
                .orElseThrow(() -> new RuntimeException("Exam not found"));

        // Validate and fetch the question
        Question questionObj = questionRepositoryObj.findById(examQuestionObj.getQuestionObj().getQuestion_id())
                .orElseThrow(() -> new RuntimeException("Question not found"));

        // Set relationships
        examQuestionObj.setExamObj(examObj);
        examQuestionObj.setQuestionObj(questionObj);

        return exam_questionRepositoryObj.save(examQuestionObj);
    }

    // Get all exam-question relationships
    @GetMapping
    public List<Exam_question> getAllExam_question() {
        return exam_questionRepositoryObj.findAll();
    }

    // Get an exam-question relationship by ID
    @GetMapping("/{id}")
    public Exam_question getExam_questionById(@PathVariable Long id) {
        return exam_questionRepositoryObj.findById(id)
                .orElseThrow(() -> new RuntimeException("ExamQuestion not found for ID: " + id));
    }

   // Update an exam-question relationship
    @PutMapping("/{id}")
    public Exam_question updateExam_question(@PathVariable Long id, @RequestBody Exam_question exam_questionObj) {
        return exam_questionRepositoryObj.findById(id).map(existingExam_question -> {
            // Update relationships if provided
            if (exam_questionObj.getExamObj() != null) {
                Exam examObj = examRepositoryObj.findById(exam_questionObj.getExamObj().getExam_id())
                        .orElseThrow(() -> new RuntimeException("Exam not found"));
                existingExam_question.setExamObj(examObj);
            }

            if (exam_questionObj.getQuestionObj() != null) {
                Question questionObj = questionRepositoryObj.findById(exam_questionObj.getQuestionObj().getQuestion_id())
                        .orElseThrow(() -> new RuntimeException("Question not found"));
                existingExam_question.setQuestionObj(questionObj);
            }

            return exam_questionRepositoryObj.save(existingExam_question);
        }).orElseThrow(() -> new RuntimeException("ExamQuestion not found for ID: " + id));
    }

    // Delete an exam-question relationship
    @DeleteMapping("/{id}")
    public void deleteExam_question(@PathVariable Long id) {
        exam_questionRepositoryObj.deleteById(id);
    }
	
}
