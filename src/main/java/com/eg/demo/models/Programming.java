package com.eg.demo.models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="programming")
public class Programming {



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long programming_id;
	


	@Column
	private String expected_output;
	
	@Column(columnDefinition = "LONGTEXT", nullable = false)
	private String reference_answer;
	
	@ManyToOne
	@JoinColumn(name="question_id")  //city_id is the column name in college  // referred class name
	private Question questionObj;          // referred class name
	
	// for student_exam
//		@OneToMany(mappedBy = "programmingObj",cascade = CascadeType.ALL) //(current class name)cityObj matches city and college var name
//		private List<Student_programming> student_programmingObj;   // next (referred class name)

	public Programming() {}
	public Programming(Long programming_id, String expected_output, String reference_answer, Question questionObj) {
		super();
		this.programming_id = programming_id;
		this.expected_output = expected_output;
		this.reference_answer = reference_answer;
		this.questionObj = questionObj;
	}
	
	public Long getProgramming_id() {
		return programming_id;
	}
	public void setProgramming_id(Long programming_id) {
		this.programming_id = programming_id;
	}
	public String getExpected_output() {
		return expected_output;
	}
	public void setExpected_output(String expected_output) {
		this.expected_output = expected_output;
	}
	public String getReference_answer() {
		return reference_answer;
	}
	public void setReference_answer(String reference_answer) {
		this.reference_answer = reference_answer;
	}
	public Question getQuestionObj() {
		return questionObj;
	}
	public void setQuestionObj(Question questionObj) {
		this.questionObj = questionObj;
	}

}
