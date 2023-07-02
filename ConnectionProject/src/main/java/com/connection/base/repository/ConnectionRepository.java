package com.connection.base.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.connection.base.entity.Connection;
import com.connection.base.entity.Plans;

@Repository
public interface ConnectionRepository extends JpaRepository<Connection, String> {

	// select * from connection where connection_name LIKE 'A%';

	@Query(value = "select * from Connection where connection_plan=:p", nativeQuery = true)
	List<Connection> listOfConnectionByPlan(@Param("p") String plan);
	
	@Query(value = "select * from Connection where connection_name=:n", nativeQuery = true)
	List<Connection> listOfConnectionByName(@Param("n") String name); 

	@Query(value = "select * from connection c inner join customer u on c.connection_id = u.fk_cn where u.customer_name=:customer_name", nativeQuery = true)
	List<Connection> listOfConnectionByCustomer_Name(@Param("customer_name") String customer_name);

	@Modifying
	@Query(value = "update Connection c set c.connection_plan=:plan where c.connection_name=:name", nativeQuery = true)
	List<Connection> updateConnectionByConnection_Name(@Param("plan") String plan, @Param("name") String name);

}
