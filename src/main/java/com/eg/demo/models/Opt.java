package com.eg.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name="opt")
public class Opt {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long option_id;
	
	@Column
	private String option_name;
	
	@Column(columnDefinition = "TINYINT(1)",name="isCorrect")
	private boolean isCorrect;
	
	@ManyToOne
	@JoinColumn(name="question_id")  //city_id is the column name in college  // referred class name
	private Question questionObj;          // referred class name

	
}

