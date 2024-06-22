package com.ayush.test;

public class MainOperation {
	static {
		System.out.println("static block");
		//System.exit(0);

	}
	{
		System.out.println("instance block");
	}
	public void instance()
	{
		System.out.println("object method");
	}
	public static void main(String[] args) 
	{

		System.out.println("main"); MainOperation mo=new MainOperation();
		mo.instance();
	}

}
