package com.interview.codes;

import java.util.Scanner;

public class SwapNumbers {
	
	public void SwapWithThird(int a,int b)
	{
		System.out.println("values of a and b before ::a="+a+" , b="+b);
		int t=a;
		a=b;
		b=t;
		System.out.println("values of a and b after ::a="+a+" , b="+b);
	}
	public void SwapWithoutThird(int a,int b)
	{
		System.out.println("values of a and b before ::a="+a+" , b="+b);
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("values of a and b after ::a="+a+" , b="+b);
	}
	public void SwapWithXOR(int a,int b)
	{
		System.out.println("values of a and b before ::a="+a+" , b="+b);
		a=a^b;
		b=a^b;
		a=a^b;
		System.out.println("values of a and b after ::a="+a+" , b="+b);
	}
	
	
	public static void main(String[] args) {
		int a,b;
		System.out.println("enter two numbers");
		SwapNumbers sn=new SwapNumbers();
		Scanner sc=new Scanner(System.in);
		a=sc.nextInt();
		b=sc.nextInt();
		//sn.SwapWithThird(a, b);
		//sn.SwapWithoutThird(a,b);
		sn.SwapWithXOR(a, b);
		sc.close();
		
		System.out.println("=========Another method========");
		int c=10;
		int v=5;
		System.out.println(c+" "+v);
		c=c+v-(v=c);
		System.out.println(c+" "+v);

	}

}
