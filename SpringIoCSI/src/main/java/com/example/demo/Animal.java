package com.example.demo;

public class Animal implements Living {

	private Human humanlife;
	
	private String name;
	
	public void setHumanlife(Human h)
	{
		this.humanlife=h;
	}
	
	public void setName(String n)
	{
		this.name=n;
	}
	@Override
	public String getLife() {
		
		return "Animal life achieved through setter injection (injecting var name) "+name;
	}

	public String SetInjection()
	{
		return humanlife.getLife();
	}
}
