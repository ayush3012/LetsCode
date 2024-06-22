package com.example.designpattern;

//Lazy instantiation : Instance will be created when required
class MySingletonClassLazy {
	
	private static MySingletonClassLazy instance; //step1: declare static object 
	
	private MySingletonClassLazy() {} //step2:private default constructor, so that object will not be created from outside
	
	public static MySingletonClassLazy getInstance()//step3: static method to get the already created instance everytime
	{
		if(instance==null) {
			synchronized(MySingletonClassLazy.class)
			{
					instance=new MySingletonClassLazy();
			}
		}
		return instance;
	}
}
public class SingletonDesignPatternLazy implements Cloneable{

	public static void main(String[] args)  {
		
		MySingletonClassLazy obj1=MySingletonClassLazy.getInstance();
		MySingletonClassLazy obj2=MySingletonClassLazy.getInstance();
		MySingletonClassLazy obj3=MySingletonClassLazy.getInstance();
		System.out.println("objL1 "+obj1.hashCode()+" \nobjL2 "+obj2.hashCode()+" \nobjL3 "+obj3.hashCode());
				
	}

}
