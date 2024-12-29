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
	
//	@OneToMany(mappedBy = "user_typeObj",cascade = CascadeType.ALL) //(current class name)cityObj matches city and college var name
//	private List<User> userObj;   // next (referred class name)
	
	public User_type() {}
	
	public User_type(Long user_type_id, String user_type) {
		super();
		this.user_type_id = user_type_id;
		this.user_type = user_type;
	}

	public Long getUser_type_id() {
		return user_type_id;
	}

	public void setUser_type_id(Long user_type_id) {
		this.user_type_id = user_type_id;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}	
}
