package com.connection.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	@PostMapping("/save")
	public ResponseEntity<Connection> saveConnection(@RequestBody Connection con) {
		Connection newConnection = connectionService.saveConnection(con);
		return ResponseEntity.created(null).body(newConnection);
	}
}
