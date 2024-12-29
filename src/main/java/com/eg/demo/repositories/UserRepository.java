package com.eg.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eg.demo.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
