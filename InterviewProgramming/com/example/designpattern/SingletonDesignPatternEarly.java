package com.example.designpattern;

/*design patterns are programming language independent strategies for solving the common object-oriented design problems.
That means, a design pattern represents an idea, not a particular implementation.*/

//Early instantiation 

//Singleton are creational design pattern
class MySingletonClassEarly{
	
	private static MySingletonClassEarly instance=new MySingletonClassEarly(); //step1: declare static object and initialized
	
	private MySingletonClassEarly() {} //step2:private default constructor, so that object will not be created from outside
	
	public static MySingletonClassEarly getInstance()//step3: static method to get the already created instance everytime
	{
		return instance;
	}
}
public class SingletonDesignPatternEarly {

	public static void main(String[] args) {
		
		MySingletonClassEarly obj1=MySingletonClassEarly.getInstance();
		MySingletonClassEarly obj2=MySingletonClassEarly.getInstance();
		MySingletonClassEarly obj3=MySingletonClassEarly.getInstance();
		System.out.println("obj1 "+obj1.hashCode()+" \nobj2 "+obj2.hashCode()+" \nobj3 "+obj3.hashCode());

	}

}
