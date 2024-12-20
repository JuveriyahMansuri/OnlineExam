package com.eg.demo.models;



import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="exam")
public class Exam {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long exam_id;
	
	@Column(columnDefinition = "DATE")
	private LocalDateTime exam_date;
	
	@Column
	private Integer exam_duration;
	
	@Column
	private Integer passing_criteria;
	
	@Column(columnDefinition = "TINYINT(1)")
	private boolean isCompleted;
	
	@Column(columnDefinition = "TINYINT(1)")
	private boolean finalSubmit;
	
	@ManyToOne
	@JoinColumn(name="admin_id")  //city_id is the column name in college  // referred class name
	private User userObj;          // referred class name
	
	@OneToMany(mappedBy = "examObj",cascade = CascadeType.ALL) //(current class name)cityObj matches city and college var name
	private List<Exam_question> exam_questionObj;   // next (referred class name)
	
	//for student_exam
	@OneToMany(mappedBy = "examObj",cascade = CascadeType.ALL) //(current class name)cityObj matches city and college var name
	private List<Student_exam> student_examObj;   // next (referred class name)


}
