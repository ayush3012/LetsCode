package com.example.entity;

import java.time.LocalDate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Component
public class Employee {
	
	@JsonProperty("Employee_id")
	int id;
	
	String name;
	
	@JsonIgnore
	LocalDate dob;

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

	public Employee() {
	}

	public Employee(int id, String name, LocalDate dob) {
		this.id = id;
		this.name = name;
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}
	
	

}
