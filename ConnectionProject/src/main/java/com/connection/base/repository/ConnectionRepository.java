package com.connection.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.connection.base.entity.Connection;

@Repository
public interface ConnectionRepository extends JpaRepository<Connection,String>{

}
