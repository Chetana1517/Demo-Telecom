
package com.connection.base.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connection.base.entity.Connection;
import com.connection.base.interceptors.ClassNotGetException;
import com.connection.base.repository.ConnectionRepository;

@Service
public class ConnectionService {

	@Autowired
	ConnectionRepository connectionRepository;

	public Connection saveConnection(Connection con) {
		con.setConnection_id(UUID.randomUUID().toString());
		Connection createConnection = connectionRepository.save(con);
		return createConnection;
	}

	public List<Connection> getAllConnection() { // select * from connection
		return connectionRepository.findAll();
	}

	
	public Connection getById(String id) {
		Optional<Connection> con = connectionRepository.findById(id);
		if (con.isPresent()) {
			return con.get();
		}
		return null;
	}

	//Mapping Exception Used  for delete id
	
	public void deleteConnection(String id) {
		Optional<Connection> emp = connectionRepository.findById(id);

		if (emp.isPresent()) {
			connectionRepository.deleteById(id);
		} else {
			throw new ClassNotGetException();
		}
	}

	public Connection updateConnection(String id, Connection newEntity) {
		Connection availableEntity = connectionRepository.findById(id).get();

		if (availableEntity != null) {
			if (newEntity.getConnection_name() != null) {

				availableEntity.setConnection_name(newEntity.getConnection_name());
			}
			if (newEntity.getConnection_plan() != null) {
				availableEntity.setConnection_plan(newEntity.getConnection_plan());
			}
			return connectionRepository.save(availableEntity);
		} else {
			return null;
		}

	}

	public List<Connection> getConnectionByPlan(String plan) {
		return connectionRepository.getConnectionByPlan(plan);

	}

	public List<Connection> listOfConnectionByName(String name) {
		return connectionRepository.listOfConnectionByName(name);

	}
	
	public List<Connection> listOfConnectionByCustomer_Name(String customer_name) {
		return connectionRepository.listOfConnectionByCustomer_Name(customer_name);
	}
   
	public List<Connection> updateConnectionByConnectionName(String plan, String name) {
		return connectionRepository.updateConnectionByConnection_Name(plan, name);
	}


}
