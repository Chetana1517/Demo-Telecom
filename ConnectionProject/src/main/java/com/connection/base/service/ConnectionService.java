package com.connection.base.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.connection.base.entity.Connection;
import com.connection.base.entity.Plans;
import com.connection.base.interceptors.ClassNotGetException;
import com.connection.base.repository.ConnectionRepository;

@Service
public class ConnectionService {

	@Autowired
	ConnectionRepository connectionRepository;

	public Connection saveConnection(Connection con) {

		con.setConnection_id(UUID.randomUUID().toString());

		Connection createCon = connectionRepository.save(con);
		return createCon;
	}

	public List<Connection> getAllConnection() {
		return connectionRepository.findAll();
	}

	public Connection getById(String id) {
		Optional<Connection> con = connectionRepository.findById(id);
		if (con.isPresent()) {
			return con.get();
		}
		return null;
	}

	public void deleteConnection(String id) {

		Optional<Connection> con = connectionRepository.findById(id);

		if (con.isPresent()) {
			connectionRepository.deleteById(id);// getbyid
		} else {
			throw new ClassNotGetException();
		}

	}

	public Connection updateConnection(String id, Connection newCon) {
		Connection availableEntity = connectionRepository.findById(id).get();// 1 chetana 10000

		if (availableEntity != null) {
			if (newCon.getConnection_name() != null) {
				availableEntity.setConnection_name(newCon.getConnection_name()); // chetana ---> Raj
			}
			if (newCon.getConnection_status() != null) {
				availableEntity.setConnection_status(newCon.getConnection_status()); // 10000 ---->15000
			}
			return connectionRepository.save(availableEntity);
		} else {
			return null;
		}

	}

	public List<Connection> getConnectionListByPlan(String plan) {
		return connectionRepository.listOfConnectionByPlan(plan);

	}

	public List<Connection> listOfConnectionBy_Name(String name) {
		return connectionRepository.listOfConnectionByName(name);
	}

	public List<Connection> listOfConnectionByCustomer_Name(String customer_name) {
		return connectionRepository.listOfConnectionByCustomer_Name(customer_name);
	}

	public List<Connection> updateConnectionByConnectionName(String plan, String name) {
		return connectionRepository.updateConnectionByConnection_Name(plan, name);
	}

}
