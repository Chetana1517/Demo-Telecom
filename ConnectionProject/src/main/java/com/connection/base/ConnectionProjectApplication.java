package com.connection.base;

import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.connection.base.entity.Connection;
import com.connection.base.repository.ConnectionRepository;

@SpringBootApplication
public class ConnectionProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConnectionProjectApplication.class, args);

	}

}
