package com.eg.demo.models;


//import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="question")
public class Question {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long question_id;
	

	

	
	@Column
	private String question;
	
	@ManyToOne
	@JoinColumn(name="difficulty_level_id")  //city_id is the column name in college  // referred class name
	private Difficulty_level difficulty_levelObj;          // referred class name
	
	@ManyToOne
	@JoinColumn(name="category_id")  //city_id is the column name in college  // referred class name
	private Category categoryObj;          // referred class name
//	
//	
//	@OneToMany(mappedBy = "questionObj",cascade = CascadeType.ALL) //(current class name)cityObj matches city and college var name
//	private List<Exam_question> exam_questionObj;   // next (referred class name)
	
//	//for 1:M question:options
//	@OneToMany(mappedBy = "questionObj",cascade = CascadeType.ALL) //(current class name)cityObj matches city and college var name
//	private List<Opt> optionObj;   // next (referred class name)
	
//	//for 1:M question:programming
//		@OneToMany(mappedBy = "questionObj",cascade = CascadeType.ALL) //(current class name)cityObj matches city and college var name
//		private List<Programming> programmingObj;   // next (referred class name)
	
	public Question() {}
	
	public Question(Long question_id, String question, Difficulty_level difficulty_levelObj, Category categoryObj) {
		super();
		this.question_id = question_id;
		this.question = question;
		this.difficulty_levelObj = difficulty_levelObj;
		this.categoryObj = categoryObj;
	}
	
	public Long getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(Long question_id) {
		this.question_id = question_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Difficulty_level getDifficulty_levelObj() {
		return difficulty_levelObj;
	}

	public void setDifficulty_levelObj(Difficulty_level difficulty_levelObj) {
		this.difficulty_levelObj = difficulty_levelObj;
	}

	public Category getCategoryObj() {
		return categoryObj;
	}

	public void setCategoryObj(Category categoryObj) {
		this.categoryObj = categoryObj;
	}

	
}
