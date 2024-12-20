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
	
}
