package com.eg.demo.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long category_id;
	@Column
	private String category_name;
	
	@OneToMany(mappedBy = "categoryObj",cascade = CascadeType.ALL) //(current class name)cityObj matches city and college var name
	private List<Question> questionObj;   // next (referred class name)
	
}
