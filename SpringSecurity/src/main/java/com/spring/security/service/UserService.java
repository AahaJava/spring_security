package com.spring.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.security.dao.User;

@Service
public class UserService {

	List<User> list = new ArrayList<User>();

	public UserService() {

		list.add(new User("aman", "aman123", "aman123@gmail.com"));
		list.add(new User("suman", "suman123", "suman123@gmail.com"));
		list.add(new User("chaman", "chaman123", "chaman123@gmail.com"));
		list.add(new User("raman", "raman123", "raman123@gmail.com"));

	}

	public List<User> getAllUser() {

		return list;
	}

	public User addUser(User user) {

		list.add(user);
		return user;
	}
	
	public User getUser(String username) {
		
		return list.stream().filter(user->user.getUsername().equals(username)).findAny().orElse(null);
	}

}
