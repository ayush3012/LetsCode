package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher {
	
	@Id
	@Column(name="id")
	public int id;
	
	@Column(name="firstname")
	public String firstname;
	
	@Column(name="lastname")
	public String lastname;
	
	@Column(name="sid")
	public int sid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public Teacher() {}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", sid=" + sid + "]";
	}
	
	
}
