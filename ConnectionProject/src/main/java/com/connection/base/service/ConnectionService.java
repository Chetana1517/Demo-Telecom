package com.connection.base.service;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connection.base.entity.Connection;
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
	
	
}
