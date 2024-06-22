package com.example.entity;

import org.springframework.stereotype.Component;

@Component
public class Student {
	
	public String fname;
	public String lname;
	public Student() {
	}
	public Student(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}

}
