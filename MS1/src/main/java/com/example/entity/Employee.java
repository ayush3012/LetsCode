package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@Column(name="id")
	public int id;
	
	@Column(name="firstname")
	public String firstname;
	
	@Column(name="lastname")
	public String lastname;

	public Employee() {}

	public Employee(int id, String firstname, String lastname) {
		this.id=id;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public int getEid() {
		return id;
	}

	public void setEid(int eid) {
		this.id = eid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
}
