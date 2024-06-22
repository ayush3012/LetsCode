package com.interview.codes;

import java.util.Scanner;

public class Fibonacci {
	static int n1=0;
	static int n2=1;
	static int n3=0;
	public static void FibonacciUsingAddition(int n)
	{
		System.out.print(n1 +" "+n2+" ");
		for(int i=0;i<n-2;i++)
		{
			n3=n1+n2;
			System.out.print(n3+" ");
			n1=n2;
			n2=n3;
		}
	}
	public static void FibonacciUsingRecursion(int n)
	{
		if(n>0)
		{
			n3=n1+n2;
			n1=n2;
			n2=n3;
			System.out.print(n3+" ");
			FibonacciUsingRecursion(n-1);
		}
	}
	public static void main(String[] args) {
		
		System.out.println("enter number untill fibonacci will print");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		//System.out.println("fibonacci without recursion ");
		//FibonacciUsingAddition(n);
		System.out.println("\nfibonacci with recursion ");
		System.out.print(0+" "+1+" ");
		FibonacciUsingRecursion(n-2);
		sc.close();

	}

}
