package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Mouse implements Animal {
	
	public Mouse()
	{
		System.out.println("Mouse default");
	}

	@Override
	public void Activity() {
		
		System.out.println("Mouse object returned");

	}

}
