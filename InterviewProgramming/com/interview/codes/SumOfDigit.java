package com.interview.codes;

import java.util.Scanner;

public class SumOfDigit {
	
	public static int Sum(int n)
	{
		int sum=0;
		while(n>0)
		{
		sum+=n%10;
		n=n/10;
		}
		return sum;
	}

	public static void main(String[] args) {
		
		System.out.println("Enter number::");
		int n;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		System.out.println(Sum(n));
		sc.close();

	}

}
