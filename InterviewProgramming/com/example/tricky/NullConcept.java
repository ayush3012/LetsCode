package com.example.tricky;

public class NullConcept {
	
	public static void sum()
	{
		System.out.println("sum");
	}
	
	public void send()
	{
		System.out.println("send");
	}

	public static void main(String[] args) {
		
		Integer i=10;
		Integer j=null;
		System.out.println(i instanceof Integer);//true
		System.out.println(j instanceof Integer);//false
		
		//concept
		/*
		 * NullConcept obj=null; //obj.send();//NullPointerException ,because it is
		 * object property obj.sum(); //print sum,because it is class property and class
		 * object is created at loading of class into jvm
		 */
		//concept
		String s1=null;
		System.out.println(s1+"123");
		//System.out.println(s1.length());//NullPointerException 

	}

}
