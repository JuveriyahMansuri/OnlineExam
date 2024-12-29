package com.eg.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eg.demo.models.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long>{

}
