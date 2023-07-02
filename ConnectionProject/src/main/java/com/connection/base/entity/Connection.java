package com.connection.base.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Connection {

	@Id
	private String connection_id;

	@Enumerated(EnumType.STRING)
	private Name connection_name;

	@Enumerated(EnumType.STRING)
	private Status connection_status;

	@Enumerated(EnumType.STRING)
	private Plans connection_plan;

	private Long connection_reference_no;
    
	//@JsonIgnore only we can use to remove the null value for particular entity type 
	@OneToOne(cascade=CascadeType.ALL)
	private User user;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_cn")
	private List<Customer> customerList;

	
	public Connection() {
		super();

	}
	public String getConnection_id() {
		return connection_id;
	}

	public void setConnection_id(String connection_id) {
		this.connection_id = connection_id;
	}

	public Name getConnection_name() {
		return connection_name;
	}

	public void setConnection_name(Name connection_name) {
		this.connection_name = connection_name;
	}

	public Status getConnection_status() {
		return connection_status;
	}

	public void setConnection_status(Status connection_status) {
		this.connection_status = connection_status;
	}

	public Plans getConnection_plan() {
		return connection_plan;
	}

	public void setConnection_plan(Plans connection_plan) {
		this.connection_plan = connection_plan;
	}

	public Long getConnection_reference_no() {
		return connection_reference_no;
	}

	public void setConnection_reference_no(Long connection_reference_no) {
		this.connection_reference_no = connection_reference_no;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	public Connection(String connection_id, Name connection_name, Status connection_status, Plans connection_plan,
			Long connection_reference_no, User user) {
		super();
		this.connection_id = connection_id;
		this.connection_name = connection_name;
		this.connection_status = connection_status;
		this.connection_plan = connection_plan;
		this.connection_reference_no = connection_reference_no;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Connection [connection_id=" + connection_id + ", connection_name=" + connection_name
				+ ", connection_status=" + connection_status + ", connection_plan=" + connection_plan
				+ ", connection_reference_no=" + connection_reference_no + "]";
	}

}
