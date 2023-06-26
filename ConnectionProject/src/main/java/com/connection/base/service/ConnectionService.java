package com.connection.base.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connection.base.entity.Connection;
import com.connection.base.repository.ConnectionRepository;
@Service
public class ConnectionService {
	@Autowired
	ConnectionRepository connectionRepository;
	
	public Connection saveConnection(Connection connection) {
		UUID uuid=UUID.randomUUID();
		connection.setUuid(uuid.toString());
		return connectionRepository.save(connection);
	}
	
	public Connection getById(String uuid) {
		Optional<Connection> con=connectionRepository.findById(uuid);
		if(con.isPresent()) {
			return con.get();
		}
		return null;
	}
}
