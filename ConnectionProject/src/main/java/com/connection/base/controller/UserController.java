package com.connection.base.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.connection.base.entity.User;
import com.connection.base.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	// GET API to fetch all the user condition wise

	UserService userService;
	@PostMapping("/save")
	
	public ResponseEntity<User> saveUser(@RequestBody User use) {

		User newUser = userService.saveUser(use);

		return ResponseEntity.created(null).body(newUser);
	}

}
