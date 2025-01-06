package com.eg.demo.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eg.demo.models.City;

import com.eg.demo.repositories.CityRepository;



@RestController
@RequestMapping("/api/city")
public class CityController {

	@Autowired
    private CityRepository cityRepositoryObj;
	
	// 1. add a new city (POST)
    @PostMapping
    public City addCity(@RequestBody City cityObj) {
        return cityRepositoryObj.save(cityObj); 
    }
    
    // 2. get all city (GET)
    @GetMapping
    public List<City> getAllCity() {
        return cityRepositoryObj.findAll(); 
    }
    
    // 3. get city by ID (GET)
    @GetMapping("/{id}")
    public City getCityById(@PathVariable Long id) {
        return cityRepositoryObj.findById(id).orElseThrow(() -> new RuntimeException("City not found for ID: " + id)); // Retrieve employee by ID
    }
    
    // 4.Update a city by ID
    @PutMapping("/{id}")
    public City updateCity(@PathVariable Long id, @RequestBody City cityObj) {
        return cityRepositoryObj.findById(id).map(city -> {
        	
            city.setCity(cityObj.getCity());
            
            return cityRepositoryObj.save(city);
        }
        ).orElseThrow(() -> new RuntimeException("City not found for ID: " + id));
    }

    // 5. Delete a city by ID
    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Long id) {
    	
        cityRepositoryObj.deleteById(id);
    }
}
