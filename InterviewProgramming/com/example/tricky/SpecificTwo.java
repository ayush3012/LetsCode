package com.example.tricky;

public class SpecificTwo {
	
	public static void MyMethod(Object ob)
	{
		System.out.println("object");
	}
	
	public static void MyMethod(String str)
	{
		System.out.println("string");
	}
	/*
	 * public static void MyMethod(Integer str) { System.out.println("Integer"); }
	 */  //if we uncomment this then there is an ambuigity between string and integer in case of null

	public static void main(String[] args) {
		
		MyMethod("jump to");    //most specific
		Object ob=null;
		MyMethod(ob);           //goes in object type  
		String str=(String)ob;
		MyMethod(str);          //goes in string type because it is typecasted
		MyMethod(null);         //most specific

	}

}
