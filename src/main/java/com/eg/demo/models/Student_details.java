package com.eg.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name="student_details")
public class Student_details {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long student_details_id;

	

	
	@Column
	private Double ssc;
	@Column
	private Double hsc;
	@Column
	private Double cgpa;
	
		
	// one student has one student details
	@OneToOne
	@JoinColumn(name="student_id")  //city_id is the column name in college  // referred class name
	private User userObj;          // referred class name
	
	@ManyToOne
	@JoinColumn(name="college_id")  //city_id is the column name in college  // referred class name
	private College collegeObj;          // referred class name

	public Student_details() {}
	
	public Student_details(Long student_details_id, Double ssc, Double hsc, Double cgpa, User userObj,
			College collegeObj) {
		super();
		this.student_details_id = student_details_id;
		this.ssc = ssc;
		this.hsc = hsc;
		this.cgpa = cgpa;
		this.userObj = userObj;
		this.collegeObj = collegeObj;
	}
	
	public Long getStudent_details_id() {
		return student_details_id;
	}

	public void setStudent_details_id(Long student_details_id) {
		this.student_details_id = student_details_id;
	}

	public Double getSsc() {
		return ssc;
	}

	public void setSsc(Double ssc) {
		this.ssc = ssc;
	}

	public Double getHsc() {
		return hsc;
	}

	public void setHsc(Double hsc) {
		this.hsc = hsc;
	}

	public Double getCgpa() {
		return cgpa;
	}

	public void setCgpa(Double cgpa) {
		this.cgpa = cgpa;
	}

	public User getUserObj() {
		return userObj;
	}

	public void setUserObj(User userObj) {
		this.userObj = userObj;
	}

	public College getCollegeObj() {
		return collegeObj;
	}

	public void setCollegeObj(College collegeObj) {
		this.collegeObj = collegeObj;
	}

	
}
