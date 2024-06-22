package com.example.handleException;

public class StudentNotFoundException extends RuntimeException {
	
	public StudentNotFoundException(String msg)
	{
		super(msg);
	}

}
