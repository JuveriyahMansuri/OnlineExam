package com.eg.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eg.demo.models.College;

public interface CollegeRepository extends JpaRepository<College, Long>{

}
