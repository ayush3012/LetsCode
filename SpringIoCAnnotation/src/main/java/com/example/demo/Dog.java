package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal {
	
	public Dog()
	{
		System.out.println("Dog default");
	}
	
	public String DogMethod()
	{
		return "from dog";
	}

	@Override
	public void Activity()
	{
		System.out.println("dog object returned");
	}
}
