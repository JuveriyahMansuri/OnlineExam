package com.eg.demo.models;

//import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="user")
public class User {
	
	

	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long user_id;
	
	@Column(name = "user_name")
	private String user_name;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(columnDefinition = "TINYINT(1)",name="isActive")
	private boolean active;
	
//	// one user type has many users
	@ManyToOne
	@JoinColumn(name="user_type_id")  //city_id is the column name in college  // referred class name
	private User_type user_typeObj;          // referred class name
	
	// one user has one student details
//	@OneToOne(mappedBy = "userObj",cascade = CascadeType.ALL) //(current class name)cityObj matches city and college var name
//	private Student_details student_detailsObj;   // next (referred class name)
//
//	// one admin can generate many exams
//	@OneToMany(mappedBy = "userObj",cascade = CascadeType.ALL) //(current class name)cityObj matches city and college var name
//	private List<Exam> examObj;   // next (referred class name)
//	
//	// for student_exam
//	@OneToMany(mappedBy = "userObj",cascade = CascadeType.ALL) //(current class name)cityObj matches city and college var name
//	private List<Student_exam> student_examObj;   // next (referred class name)
//
//	// for student_programming
//		@OneToMany(mappedBy = "userObj",cascade = CascadeType.ALL) //(current class name)cityObj matches city and college var name
//		private List<Student_programming> student_programmingObj;   // next (referred class name)

	public User() {}
	
	public User(Long user_id, String user_name, String email, String password, boolean active, User_type user_typeObj) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.email = email;
		this.password = password;
		this.active = active;
		this.user_typeObj = user_typeObj;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public User_type getUser_typeObj() {
		return user_typeObj;
	}

	public void setUser_typeObj(User_type user_typeObj) {
		this.user_typeObj = user_typeObj;
	}

		
}
