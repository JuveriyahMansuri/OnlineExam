package com.eg.demo.models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="user_type")
public class User_type {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long user_type_id;
	
	@Column
	private String user_type;
	
	@OneToMany(mappedBy = "user_typeObj",cascade = CascadeType.ALL) //(current class name)cityObj matches city and college var name
	private List<User> userObj;   // next (referred class name)
	
	
	
	
}
