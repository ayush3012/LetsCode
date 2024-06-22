package com.example.Entity;

import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class User {
	
	int id;
	String name;
	LocalDate dob;
	public User(int id, String name, LocalDate dob) {
		this.id = id;
		this.name = name;
		this.dob = dob;
	}
	
	public User() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}
	
	

}
