package com.eg.demo.models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="difficulty_level")
public class Difficulty_level {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long difficulty_level_id;
	
	@Column
	private String difficulty_level;
	
//	@OneToMany(mappedBy = "difficulty_levelObj",cascade = CascadeType.ALL) //(current class name)cityObj matches city and college var name
//	private List<Question> questionObj;   // next (referred class name)

	public Difficulty_level() {}
	public Difficulty_level(Long difficulty_level_id, String difficulty_level) {
		super();
		this.difficulty_level_id = difficulty_level_id;
		this.difficulty_level = difficulty_level;
	}
	
	public Long getDifficulty_level_id() {
		return difficulty_level_id;
	}
	public void setDifficulty_level_id(Long difficulty_level_id) {
		this.difficulty_level_id = difficulty_level_id;
	}
	public String getDifficulty_level() {
		return difficulty_level;
	}
	public void setDifficulty_level(String difficulty_level) {
		this.difficulty_level = difficulty_level;
	}

	}
