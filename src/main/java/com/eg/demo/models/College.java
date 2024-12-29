package com.eg.demo.models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="college")
public class College {



	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long college_id;
	
	

	@Column
	private String college;
	
	@ManyToOne
	@JoinColumn(name="city_id")  //city_id is the column name in college  // referred class name
	private City cityObj;          // referred class name

	//for 1:M clg:student
//	@OneToMany(mappedBy = "collegeObj",cascade = CascadeType.ALL) //(current class name)cityObj matches city and college var name
//	private List<Student_details> student_detailsObj;   // next (referred class name)

	public College() {}
	public College(Long college_id, String college, City cityObj) {
		super();
		this.college_id = college_id;
		this.college = college;
		this.cityObj = cityObj;
	}
	
	public Long getCollege_id() {
		return college_id;
	}
	public void setCollege_id(Long college_id) {
		this.college_id = college_id;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public City getCityObj() {
		return cityObj;
	}
	public void setCityObj(City cityObj) {
		this.cityObj = cityObj;
	}



	}
