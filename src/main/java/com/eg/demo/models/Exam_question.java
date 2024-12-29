package com.eg.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name="exam_question")
public class Exam_question {



	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long exam_question_id;
	


	@ManyToOne
	@JoinColumn(name="exam_id")  //city_id is the column name in college  // referred class name
	private Exam examObj;          // referred class name
	
	@ManyToOne
	@JoinColumn(name="question_id")  //city_id is the column name in college  // referred class name
	private Question questionObj;          // referred class name
	
	public Exam_question() {}
	
	public Exam_question(Long exam_question_id, Exam examObj, Question questionObj) {
		super();
		this.exam_question_id = exam_question_id;
		this.examObj = examObj;
		this.questionObj = questionObj;
	}
	
	public Long getExam_question_id() {
		return exam_question_id;
	}

	public void setExam_question_id(Long exam_question_id) {
		this.exam_question_id = exam_question_id;
	}

	public Exam getExamObj() {
		return examObj;
	}

	public void setExamObj(Exam examObj) {
		this.examObj = examObj;
	}

	public Question getQuestionObj() {
		return questionObj;
	}

	public void setQuestionObj(Question questionObj) {
		this.questionObj = questionObj;
	}
	
	}
