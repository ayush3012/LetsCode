package com.example.tricky;

public class CallingOrder {
	static {System.out.println("first static block");}
	static {System.out.println("second static block");} 
	{System.out.println("first init block");}
	{System.out.println("second init block");}
	
	public CallingOrder()
	{
		System.out.println("default constructor");
	}

	public static void main(String[] args) {
		
		CallingOrder co=new CallingOrder();
		CallingOrder co2=new CallingOrder();
	}
	
	static {System.out.println("third static block");} 
	static {System.out.println("four static block");} 
	

}
