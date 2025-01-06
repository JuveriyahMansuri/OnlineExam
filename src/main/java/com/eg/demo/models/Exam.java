package com.eg.demo.models;



import java.time.LocalDateTime;
//import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name="exam")
public class Exam {


	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long exam_id;
	
	


//	@Column(columnDefinition = "DATE")
	@Column
	private LocalDateTime exam_date;
	
	@Column
	private Integer exam_duration;
	
	@Column
	private Integer passing_criteria;
	
	@Column(columnDefinition = "TINYINT(1)")
	private boolean completed;
	
	@Column(columnDefinition = "TINYINT(1)")
	@JsonProperty("finalSubmit")
	private boolean finalSubmit;
	
	@ManyToOne
	@JoinColumn(name="admin_id")  //city_id is the column name in college  // referred class name
	private User userObj;          // referred class name
	
//	@OneToMany(mappedBy = "examObj",cascade = CascadeType.ALL) //(current class name)cityObj matches city and college var name
//	private List<Exam_question> exam_questionObj;   // next (referred class name)
//	
//	//for student_exam
//	@OneToMany(mappedBy = "examObj",cascade = CascadeType.ALL) //(current class name)cityObj matches city and college var name
//	private List<Student_exam> student_examObj;   // next (referred class name)

	public Exam() {}
	
	public Exam(Long exam_id, LocalDateTime exam_date, Integer exam_duration, Integer passing_criteria,
			boolean completed, boolean finalSubmit, User userObj) {
		super();
		this.exam_id = exam_id;
		this.exam_date = exam_date;
		this.exam_duration = exam_duration;
		this.passing_criteria = passing_criteria;
		this.completed = completed;
		this.finalSubmit = finalSubmit;
		this.userObj = userObj;
	}
	
	public Long getExam_id() {
		return exam_id;
	}

	public void setExam_id(Long exam_id) {
		this.exam_id = exam_id;
	}

	public LocalDateTime getExam_date() {
		return exam_date;
	}

	public void setExam_date(LocalDateTime exam_date) {
		this.exam_date = exam_date;
	}

	public Integer getExam_duration() {
		return exam_duration;
	}

	public void setExam_duration(Integer exam_duration) {
		this.exam_duration = exam_duration;
	}

	public Integer getPassing_criteria() {
		return passing_criteria;
	}

	public void setPassing_criteria(Integer passing_criteria) {
		this.passing_criteria = passing_criteria;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public boolean isFinalSubmit() {
		return finalSubmit;
	}

	public void setFinalSubmit(boolean finalSubmit) {
		this.finalSubmit = finalSubmit;
	}

	public User getUserObj() {
		return userObj;
	}

	public void setUserObj(User userObj) {
		this.userObj = userObj;
	}


	
}
