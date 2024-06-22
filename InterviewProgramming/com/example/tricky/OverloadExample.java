package com.example.tricky;

public class OverloadExample {
	
	public void m(String s)
	{
		System.out.println("string");
	}
	public void m(Object s)
	{
		System.out.println("object");
	}

	public static void main(String[] args) {
		OverloadExample e=new OverloadExample();
		e.m(null);//call most specific method

	}

}
