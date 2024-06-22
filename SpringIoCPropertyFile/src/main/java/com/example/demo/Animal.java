package com.example.demo;

public class Animal implements Living {
	
	private Human humanlife; //exact same name from applicationcontext.xml line 22 property name
	
	private String name;
	
	public void setHumanlife(Human humanlife) { // first letter should be caps
		this.humanlife = humanlife;
	}

	public void setName(String name)
	{
		this.name=name;
	}

	@Override
	public String getLife() {
		
		return "Animal life achieved through setter injection"
				+ " (injecting var name ,not hardcoded in xml but through property file) "+name;
	}

	public String setInjection()
	{
		return humanlife.getLife();
	}
}
