package com.example.demo;

public class Human implements Living{

	@Override
	public String getLife() {
		
		return "Human life achieved";
	}
	
	public void method1()
	{
		System.out.println("init method");
	}
	
	public void method2()
	{
		System.out.println("destroy method");
	}

}
