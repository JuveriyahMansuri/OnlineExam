package com.eg.demo.models;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name="student_exam")
public class Student_exam {
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long student_exam_id;
		@Column(name = "student_exam_start_datetime", columnDefinition = "DATETIME")
		private LocalDateTime student_exam_start_datetime;
		@Column(columnDefinition = "TINYINT(1)",name="hasPassed")
		private boolean hasPassed;
		
		@ManyToOne
		@JoinColumn(name="student_id")  //city_id is the column name in college  // referred class name
		private User userObj;          // referred class name
		
		@ManyToOne
		@JoinColumn(name="exam_id")  //city_id is the column name in college  // referred class name
		private Exam examObj;          // referred class name

}
