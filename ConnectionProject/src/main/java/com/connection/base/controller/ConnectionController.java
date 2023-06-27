package com.connection.base.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ConnectionController {
	
	//GET API to get connection
	public void getConnection() {
		System.out.println("This is get method from controller");
		System.out.println("Changes made into controller");
	}
}
