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
	
	@OneToMany(mappedBy = "difficulty_levelObj",cascade = CascadeType.ALL) //(current class name)cityObj matches city and college var name
	private List<Question> questionObj;   // next (referred class name)
	
}
