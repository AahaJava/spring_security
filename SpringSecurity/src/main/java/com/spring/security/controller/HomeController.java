package com.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class HomeController {
	
	@GetMapping("/home")
	public String test() {
		
		return "This is a home page";
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "This is a login page";
	}
	
	@GetMapping("/register")
	public String register() {
		
		return "This is a register page";
	}

}
