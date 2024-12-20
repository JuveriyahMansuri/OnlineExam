package com.eg.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name="student_programming")
public class Student_programming {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long student_programming_id;
	
	@Column(columnDefinition = "LONGTEXT", nullable = false)
	private String code_submitted;
	
	@Column
	private String user_output;
	
	@Column(columnDefinition = "TINYINT(1)",name="isCorrect")
	private boolean isCorrect;
	
	@ManyToOne
	@JoinColumn(name="student_id")  //city_id is the column name in college  // referred class name
	private User userObj;          // referred class name
	
	@ManyToOne
	@JoinColumn(name="programming_id")  //city_id is the column name in college  // referred class name
	private Programming programmingObj;          // referred class name

	
	
}
