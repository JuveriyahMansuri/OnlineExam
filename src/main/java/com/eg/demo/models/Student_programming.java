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
	private boolean correct;
	
	
	
	@ManyToOne
	@JoinColumn(name="student_id")  //city_id is the column name in college  // referred class name
	private User userObj;          // referred class name
	
	@ManyToOne
	@JoinColumn(name="programming_id")  //city_id is the column name in college  // referred class name
	private Programming programmingObj;          // referred class name

	public Student_programming() {}
	public Student_programming(Long student_programming_id, String code_submitted, String user_output, boolean correct,
			User userObj, Programming programmingObj) {
		super();
		this.student_programming_id = student_programming_id;
		this.code_submitted = code_submitted;
		this.user_output = user_output;
		this.correct = correct;
		this.userObj = userObj;
		this.programmingObj = programmingObj;
	}

	public Long getStudent_programming_id() {
		return student_programming_id;
	}
	public void setStudent_programming_id(Long student_programming_id) {
		this.student_programming_id = student_programming_id;
	}
	public String getCode_submitted() {
		return code_submitted;
	}
	public void setCode_submitted(String code_submitted) {
		this.code_submitted = code_submitted;
	}
	public String getUser_output() {
		return user_output;
	}
	public void setUser_output(String user_output) {
		this.user_output = user_output;
	}
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	public User getUserObj() {
		return userObj;
	}
	public void setUserObj(User userObj) {
		this.userObj = userObj;
	}
	public Programming getProgrammingObj() {
		return programmingObj;
	}
	public void setProgrammingObj(Programming programmingObj) {
		this.programmingObj = programmingObj;
	}

	
}
