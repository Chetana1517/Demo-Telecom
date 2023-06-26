package com.connection.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.connection.base.entity.Connection;
import com.connection.base.service.ConnectionService;

@RestController
@RequestMapping("/connection")
public class ConnectionController {
	
	@Autowired
	ConnectionService connectionService;
	
	//POST API to save the connection object to database.
	@PostMapping("/save")
	public Connection saveConnection(@RequestBody Connection connection) {
		
		return connectionService.saveConnection(connection);
	}
	
	//GET API to get connection object from database
	@GetMapping("/get/{id}")
	public Connection getById(@PathVariable("id") String uuid) {
	  return connectionService.getById(uuid) ; 
	}

}
