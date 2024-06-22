package com.ayush.test;

public class Examples {
	
	{
		System.out.println("instance block called");
	}
	static
	{
		System.out.println("static block called");
	}
	public static void StringCompare()
	{
		String s1=new String("ayush");
		String s2=new String("ayush");
		if(s1==s2)
			System.out.println("reference is equal");
		else
			System.out.println("reference is not equal");
		if(s1.equals(s2))
			System.out.println("content is equal");
		else
			System.out.println("content is not equal");
	}
	public  int varargs(int... a)
	{
		int sum=0;
		for(int i:a)
			sum+=i;
		return sum;
	}
	public static void main(String[] args)
	{
		Examples eg=new Examples();
		StringCompare();
		System.out.println(eg.varargs(1,2,3));
		System.out.println(eg.varargs(1,2,3,4,5,6,7));
	}

}
