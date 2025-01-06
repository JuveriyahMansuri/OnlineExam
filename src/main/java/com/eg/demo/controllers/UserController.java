package com.eg.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eg.demo.models.User;
import com.eg.demo.models.User_type;
import com.eg.demo.repositories.UserRepository;
import com.eg.demo.repositories.User_typeRepository;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepositoryObj;

    @Autowired
    private User_typeRepository user_typeRepositoryObj;

    // 1.add a new user
    @PostMapping
    public User addUser(@RequestBody User userObj) {
        // Ensure the user type exists before saving the user
        User_type user_typeObj = user_typeRepositoryObj.findById(userObj.getUser_typeObj().getUser_type_id())
                .orElseThrow(() -> new RuntimeException("User Type not found"));
        userObj.setUser_typeObj(user_typeObj);
        return userRepositoryObj.save(userObj);
    }

    // 2.Get all users
    @GetMapping
    public List<User> getAllUser() {
        return userRepositoryObj.findAll();
    }

    // 3.Get a user by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepositoryObj.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found for ID: " + id));
    }

  //4. update user based on id
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,@RequestBody User userObj) {
    	return userRepositoryObj.findById(id).map(existingUser->{
    		
    		existingUser.setUser_name(userObj.getUser_name());
    		existingUser.setEmail(userObj.getEmail());
    		existingUser.setPassword(userObj.getPassword());
    		existingUser.setActive(userObj.isActive());
    		//update user_type 
    		User_type user_typeObj=user_typeRepositoryObj.findById(userObj.getUser_typeObj().getUser_type_id()).orElseThrow(()->new RuntimeException("user type not found"));
    		existingUser.setUser_typeObj(user_typeObj);
    		return userRepositoryObj.save(existingUser);
    	}).orElseThrow(()->new RuntimeException("user not found"));
    }
    // 5. delete user by id
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
    	userRepositoryObj.deleteById(id);
    }
}

