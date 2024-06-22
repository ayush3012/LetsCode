package com.example.response;

import javax.persistence.Column;

import org.springframework.stereotype.Component;

@Component
public class AddressResponse {
	
    public int id;
	
	public String lane;
	
	public int zip;
	
	public String state;

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
