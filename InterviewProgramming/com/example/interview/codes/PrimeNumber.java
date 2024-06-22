package com.interview.codes;

import java.util.Scanner;
import java.util.stream.IntStream;

public class PrimeNumber {

	public static boolean CheckPrime(int n)
	{
		boolean flag=true;
		if(n==1)
			return false;
		if(n==2)
			return true;
		else
		{
			for(int i=2;i<n/2;i++)
				if(n%i==0)
				{
					flag=false;
					break;
				}
		}
		return flag;
	}

	public static boolean isPrime(int n)
	{
		return n<2?false:IntStream.range(2,n).allMatch(i->n%i!=0);
	}
	public static void main(String[] args) {
		int n;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter number: ");
		n=sc.nextInt();
		System.out.println(CheckPrime(n));
		sc.close();
		
		System.out.println("==========");
		for(int i=0;i<20;i++)
		System.out.println(i+" "+isPrime(i));
	}

}
