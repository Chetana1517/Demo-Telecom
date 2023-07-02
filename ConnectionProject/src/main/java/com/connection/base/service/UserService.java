package com.connection.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connection.base.entity.User;
import com.connection.base.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	UserRepository userRepository;
	
	public User saveUser(User use) {
		
		//use.setUser_id.toString());
		User createUser = userRepository.save(use);
		return createUser;
	}
	
	
	
}
