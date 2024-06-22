package com.ayush.test;

public class ClassAndInterface implements DemoInterface{
	
	public void method()
	{
		System.out.println("print");
	}
	
	public static void main(String[] args) throws ClassNotFoundException
	{
		DemoInterface di=new ClassAndInterface();
		di.method();
		System.out.println(DemoInterface.x);
		//DemoInterface.x=8; wrong:-because it is final field
	}

}
