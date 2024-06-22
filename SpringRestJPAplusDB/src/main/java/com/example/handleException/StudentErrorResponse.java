package com.example.handleException;

public class StudentErrorResponse {
	
	private int status;
	private String message;
	
	public StudentErrorResponse(int status,String message)
	{
		this.status=status;
		this.message=message;
	}

	public StudentErrorResponse(){}
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
