package com.example.demo;

public interface Living {
	
	public String getLife();
	
	public default String SetInjection()
	{
		return "default";
	}

}
