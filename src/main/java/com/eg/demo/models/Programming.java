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
		@OneToMany(mappedBy = "programmingObj",cascade = CascadeType.ALL) //(current class name)cityObj matches city and college var name
		private List<Student_programming> student_programmingObj;   // next (referred class name)

}
