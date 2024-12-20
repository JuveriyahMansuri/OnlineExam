package com.eg.demo.models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="city")
public class City {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long city_id;
	
	

	@Column
	private String city;
	
	@OneToMany(mappedBy = "cityObj",cascade = CascadeType.ALL) //(current class name)cityObj matches city and college var name
	private List<College> collegeObj;   // next (referred class name)
	
	
	//constructor
	public City(Long city_id, String city, List<College> collegeObj) {
		super();
		this.city_id = city_id;
		this.city = city;
		this.collegeObj = collegeObj;
	}

	public List<College> getCollegeObj() {
		return collegeObj;
	}

	public void setCollegeObj(List<College> collegeObj) {
		this.collegeObj = collegeObj;
	}

	public Long getCity_id() {
		return city_id;
	}

	public void setCity_id(Long city_id) {
		this.city_id = city_id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
}
