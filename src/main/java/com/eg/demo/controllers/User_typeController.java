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

import com.eg.demo.models.User_type;
import com.eg.demo.repositories.User_typeRepository;

@RestController
@RequestMapping("/api/user_type")
public class User_typeController {
	  @Autowired
	    private User_typeRepository user_typeRepositoryObj;

	    // 1.add a new user type
	    @PostMapping
	    public User_type addUser_type(@RequestBody User_type user_typeObj) {
	        return user_typeRepositoryObj.save(user_typeObj);
	    }

	    // 2.Get all user types
	    @GetMapping
	    public List<User_type> getAllUser_type() {
	        return user_typeRepositoryObj.findAll();
	    }

	    // 3.Get user type by ID
	    @GetMapping("/{id}")
	    public User_type getUser_typeById(@PathVariable Long id) {
	        return user_typeRepositoryObj.findById(id)
	                .orElseThrow(() -> new RuntimeException("User_type not found for ID: " + id));
	    }
	    //4. put on basis of user type id
	    @PutMapping("/{id}")
	    public User_type updateUser_type(@PathVariable Long id,@RequestBody User_type user_typeObj) {
	    	return user_typeRepositoryObj.findById(id).map(existingUser_type->{
	    		
	    		existingUser_type.setUser_type(user_typeObj.getUser_type());
	    		return user_typeRepositoryObj.save(existingUser_type);
	    		
	    	}
	    	).orElseThrow(()->new RuntimeException("user not found of id:"+id));
	    }
	    
	    // 5. delete on basis of id
	    @DeleteMapping("/{id}")
	    public void deleteUser_type(@PathVariable Long id) {
	    	user_typeRepositoryObj.deleteById(id);
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    

}
