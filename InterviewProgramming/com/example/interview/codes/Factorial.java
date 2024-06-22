package com.interview.codes;

import java.util.Scanner;

public class Factorial {
	
	public static int FactorialWithoutRecursion(int n)
	{
		int fact=1;
		for(int i=1;i<=n;i++)
			fact=fact*i;
		return fact;
	}
	public static int FactorialWithRecursion(int n)
	{
		if(n==1)
			return n;
		else
			return FactorialWithRecursion(n-1)*n;
	}

	public static void main(String[] args) {
		
		int n=0;
		System.out.println("Enter n ");
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		//System.out.println("factorial of "+n+" is "+FactorialWithoutRecursion(n));
		System.out.println("factorial of "+n+" is "+FactorialWithRecursion(n));
		sc.close();

	}

}
