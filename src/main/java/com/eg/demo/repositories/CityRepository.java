package com.eg.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eg.demo.models.City;

public interface CityRepository extends JpaRepository<City, Long>{

}
