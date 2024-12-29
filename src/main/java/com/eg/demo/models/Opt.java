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
	private boolean correct;
	
	@ManyToOne
	@JoinColumn(name="question_id")  //city_id is the column name in college  // referred class name
	private Question questionObj;          // referred class name

	public Opt() {}
	public Opt(Long option_id, String option_name, boolean correct, Question questionObj) {
		super();
		this.option_id = option_id;
		this.option_name = option_name;
		this.correct = correct;
		this.questionObj = questionObj;
	}
	
	public Long getOption_id() {
		return option_id;
	}
	public void setOption_id(Long option_id) {
		this.option_id = option_id;
	}
	public String getOption_name() {
		return option_name;
	}
	public void setOption_name(String option_name) {
		this.option_name = option_name;
	}
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	public Question getQuestionObj() {
		return questionObj;
	}
	public void setQuestionObj(Question questionObj) {
		this.questionObj = questionObj;
	}

	
}

