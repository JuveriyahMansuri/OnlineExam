package com.eg.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eg.demo.models.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{

}
