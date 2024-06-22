package com.example.demo;

public interface Living {
	
	public String getLife();
	
	public default String ConInjection()
	{
		return "Default";
	}

}
