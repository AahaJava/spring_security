package com.spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.dao.User;
import com.spring.security.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public List<User> getAllUsers() {

		return userService.getAllUser();
	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable String username) {
		
		return userService.getUser(username);
	}
	
	@PostMapping("/")
	public User createUser(@RequestBody User user) {
		
		return userService.addUser(user);
	}

}
