package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Company {
	
	@Id
	@GeneratedValue
	int id;
	
	String name;
	
	int headcount;

	public Company(int id, String name, int headcount) {
		this.id = id;
		this.name = name;
		this.headcount = headcount;
	}

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

	public int getHeadcount() {
		return headcount;
	}

	public void setHeadcount(int headcount) {
		this.headcount = headcount;
	}

	public Company() {
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", headcount=" + headcount + "]";
	}
	
	
	

}
