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
		private boolean passed;
		
	

		
		@ManyToOne
		@JoinColumn(name="student_id")  //city_id is the column name in college  // referred class name
		private User userObj;          // referred class name
		
		@ManyToOne
		@JoinColumn(name="exam_id")  //city_id is the column name in college  // referred class name
		private Exam examObj;          // referred class name

		public Student_exam() {}
		
		public Student_exam(Long student_exam_id, LocalDateTime student_exam_start_datetime, boolean passed, User userObj,
				Exam examObj) {
			super();
			this.student_exam_id = student_exam_id;
			this.student_exam_start_datetime = student_exam_start_datetime;
			this.passed = passed;
			this.userObj = userObj;
			this.examObj = examObj;
		}
		
		public Long getStudent_exam_id() {
			return student_exam_id;
		}

		public void setStudent_exam_id(Long student_exam_id) {
			this.student_exam_id = student_exam_id;
		}

		public LocalDateTime getStudent_exam_start_datetime() {
			return student_exam_start_datetime;
		}

		public void setStudent_exam_start_datetime(LocalDateTime student_exam_start_datetime) {
			this.student_exam_start_datetime = student_exam_start_datetime;
		}

		public boolean isPassed() {
			return passed;
		}

		public void setPassed(boolean passed) {
			this.passed = passed;
		}

		public User getUserObj() {
			return userObj;
		}

		public void setUserObj(User userObj) {
			this.userObj = userObj;
		}

		public Exam getExamObj() {
			return examObj;
		}

		public void setExamObj(Exam examObj) {
			this.examObj = examObj;
		}

}
