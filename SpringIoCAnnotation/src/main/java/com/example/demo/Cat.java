package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Cat implements Animal {
	
	public Cat()
	{
		System.out.println("cat default");
	}
	
	//constructor injection
	
	Dog dog;
	
	@Autowired
	public Cat(Dog d)
	{
		this.dog=d;
	}
	
	public void CatMethod()
	{
		System.out.println(dog.DogMethod());
	}

	@Override
	public void Activity() {
		
		System.out.println("cat object returned");

	}
	
	//Qualifier used for loose coupling::implementing run time child class in interface reference
	//setter injection::::any method name we can use
	Animal animal;
	
	@Autowired
	@Qualifier("mouse")
	public void setAnimal(Animal animal)
	{
		this.animal=animal;
	}
	
	public void getObject()
	{
		animal.Activity();
	}

	//Field injection
	@Autowired
	Mouse mouse;
	
	public void CatMethodForMouse()
	{
		System.out.println("mouse from cat through field injection");
	}
	
	@Value("ayush")
	String str;
	
	public void test()
	{
		System.out.println("@Value Annotation "+str);
	}
	
	
	//place gap between $ and {  ::: it parses into something else 
	@Value("${app.val:default}")
	private String prop;
	
	public void testProp()
	{
		 System.out.println("@Value annotation through property file "+prop);
	}
}
