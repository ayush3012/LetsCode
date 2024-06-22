package com.example.designpattern;


class ThroughCloning implements Cloneable{
	
	private static ThroughCloning instance=new ThroughCloning();
	
	private ThroughCloning(){}
	
	public static ThroughCloning getInstance()
	{
		return instance;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException{
		//return super.clone();  if we uncomment this line we will get different object on cloning
		//throw new CloneNotSupportedException(); //To prevent this we should throw this exception
		 return instance;  // or if we don't want to throw exception and get the object we can return instance also
	}
}
public class ViolationSingletonThroughClone{
	
	public static void main(String[] args) throws CloneNotSupportedException
	{
		ThroughCloning obj1=ThroughCloning.getInstance();
		ThroughCloning obj2=ThroughCloning.getInstance();
		ThroughCloning obj3=(ThroughCloning)obj2.clone();
		
		System.out.println("obj1 "+obj1.hashCode()+" \nobj2 "+obj2.hashCode()+" \nobj3 "+obj3.hashCode());
	}
}