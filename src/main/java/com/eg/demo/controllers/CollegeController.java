package com.eg.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eg.demo.models.City;
import com.eg.demo.models.College;
import com.eg.demo.repositories.CityRepository;
import com.eg.demo.repositories.CollegeRepository;

import java.util.List;
//import java.util.Map;

@RestController
@RequestMapping("/api/college")
public class CollegeController {

    @Autowired
    private CollegeRepository collegeRepositoryObj;

    @Autowired
    private CityRepository cityRepositoryObj;

    // 1.Create a college and associate it with a city
    @PostMapping
    public College addCollege(@RequestBody College collegeObj) {
        // Ensure the city exists before saving the college
        City cityObj = cityRepositoryObj.findById(collegeObj.getCityObj().getCity_id())
                .orElseThrow(() -> new RuntimeException("City not found"));
        collegeObj.setCityObj(cityObj);
        return collegeRepositoryObj.save(collegeObj);
    }

    //2. Get all colleges
    @GetMapping
    public List<College> getAllCollege() {
        return collegeRepositoryObj.findAll();
    }
    
    // 3.Get a college by ID
    @GetMapping("/{id}")
    public College getCollegeById(@PathVariable Long id) {
        return collegeRepositoryObj.findById(id)
                .orElseThrow(() -> new RuntimeException("College not found for ID: " + id));
    }
    
    //4.update college on basis of id
    @PutMapping("/{id}")
    public College updateCollege(@PathVariable Long id,@RequestBody College collegeObj) {
    	return collegeRepositoryObj.findById(id).map(existingCollege->{
    		
    		existingCollege.setCollege(collegeObj.getCollege());
    		//update city association 
    		City cityObj=cityRepositoryObj.findById(collegeObj.getCityObj().getCity_id()).orElseThrow(()->new RuntimeException("city not found"));
    		existingCollege.setCityObj(cityObj);
    		
    		return collegeRepositoryObj.save(existingCollege);
    		
    	}).orElseThrow(()->new RuntimeException("college not found on id:"+id));
    }
    


    
    //6. delete college on basis of id
    @DeleteMapping("/{id}")
    public void deleteCollege(@PathVariable Long id) {
        collegeRepositoryObj.deleteById(id);
    }
    
    
    
    
    
    
    
}