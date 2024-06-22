package com.example.tricky;

public class SpecificOne {

	public static void MyMethod(int a,int b,int c)
	{
		System.out.println("a,b,c");
	}

	public static void MyMethod(int...a)
	{
		System.out.println("a...");
	}

	public static void main(String[] args)
	{
		MyMethod(1,2,3);
	}
}