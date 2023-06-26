package com.connection.base.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Connection {
	@Id
	private String uuid;
	private String connection_name;
	
	@Enumerated(EnumType.STRING)
	private Status connection_status;
	
	private String connection_plan;
	
	
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long conncetion_reference_no;
	
	public Connection() {

	}

	public Connection(String uuid, String connection_name, Status connection_status, String connection_plan,
			Long conncetion_reference_no) {
		super();
		this.uuid = uuid;
		this.connection_name = connection_name;
		this.connection_status = connection_status;
		this.connection_plan = connection_plan;
		this.conncetion_reference_no = conncetion_reference_no;
	}

	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getConnection_name() {
		return connection_name;
	}

	public void setConnection_name(String connection_name) {
		this.connection_name = connection_name;
	}

	public Status getConnection_status() {
		return connection_status;
	}

	public void setConnection_status(Status connection_status) {
		this.connection_status = connection_status;
	}

	public String getConnection_plan() {
		return connection_plan;
	}

	public void setConnection_plan(String connection_plan) {
		this.connection_plan = connection_plan;
	}

	public Long getConncetion_reference_no() {
		return conncetion_reference_no;
	}

	public void setConncetion_reference_no(Long conncetion_reference_no) {
		this.conncetion_reference_no = conncetion_reference_no;
	}

	@Override
	public String toString() {
		return "Connection [uuid=" + uuid + ", connection_name=" + connection_name + ", connection_status="
				+ connection_status + ", connection_plan=" + connection_plan + ", conncetion_reference_no="
				+ conncetion_reference_no + "]";
	}
}
