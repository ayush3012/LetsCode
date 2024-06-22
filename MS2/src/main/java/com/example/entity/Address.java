package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	@Column(name="id")
	public int id;
	
	@Column(name="lane")
	public String lane;
	
	@Column(name="zip")
	public int zip;
	
	@Column(name="state")
	public String state;

	public Address() {}

	public Address(int id, String lane, int zip, String state) {
		super();
		this.id = id;
		this.lane = lane;
		this.zip = zip;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
