package com.example.demo;

public class Animal implements Living {
	
	private Human human;
	
	public Animal(Human human)
	{
		this.human=human;
	}

	@Override
	public String getLife() {
		
		return "Animal life achieved through constructor injection";
	}

	public String ConInjection()
	{
		return human.getLife();
	}
}
