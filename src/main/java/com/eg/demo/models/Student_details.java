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

}
