package com.connection.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.connection.base.entity.Connection;
import com.connection.base.interceptors.RecordNotFoundException;
import com.connection.base.service.ConnectionService;

@RestController
@RequestMapping("/connection")
public class ConnectionController {

	// GET API to fetch all the connection condition wise

	@Autowired
	ConnectionService connectionService;

	@PostMapping("/save")
	public ResponseEntity<Connection> saveConnection(@RequestBody Connection con) {

		Connection newConnection = connectionService.saveConnection(con);

		return ResponseEntity.created(null).body(newConnection);
	}

	@GetMapping("/getAll")
	public List<Connection> getAllConnection() {
		return connectionService.getAllConnection();
	}

	//Mapping Exception Used  for get id
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Connection> getById(@PathVariable("id") String id) {
		Connection con = connectionService.getById(id);
		if(con==null) {
			throw new RecordNotFoundException();
		}else {
		   return ResponseEntity.ok(con);
		}
	
	}

	@DeleteMapping("/delete/{id}")
	public void deleteConnection(@PathVariable("id") String id) {
		connectionService.deleteConnection(id);
	}

	@PutMapping("/update/{id}")
	public Connection updateConnection(@PathVariable("id") String id, @RequestBody Connection connection) {
		return connectionService.updateConnection(id, connection);
	}

	@GetMapping("/getByPlan/{plan}")
	public List<Connection> getConnectionByPlan(@PathVariable("plan") String plan) {
		return connectionService.getConnectionByPlan(plan);
	}

	@GetMapping("listOfEmpByName/{name}")
	public List<Connection> listOfEmployeeByName(@PathVariable("name") String name) {
		return connectionService.listOfConnectionByName(name);

	}
	
	public List<Connection> listOfConnectionByCustomer_Name(@PathVariable("customer_name") String customer_name) {
		return connectionService.listOfConnectionByCustomer_Name(customer_name);
	}

	@PutMapping("/updateByConnection_Name")
	public void updateConnectionByConnectionName(@RequestParam String plan, @RequestParam String name) {
		connectionService.updateConnectionByConnectionName(plan, name); // 5000,Bench
	}
	
}
