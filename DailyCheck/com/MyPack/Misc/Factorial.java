package com.mypack.Misc;

import java.util.stream.IntStream;

public class Factorial {
	
	public static void FactorialUsingIteration(int n)
	{
		int res=1;
		for(int i=1;i<=n;i++)
			res=res*i;
		System.out.println("Factorial of "+n +" is "+res);
	}

	public static int FactorialUsingRecursion(int n)
	{
		if(n<2)
			return n;
		return n*FactorialUsingRecursion(n-1);
	}
	
	public static int FactorialUsingStream(int n)
	{
		//return IntStream.rangeClosed(1,n).reduce(1,(a,b)->a*b);
		return IntStream.range(1,n+1).reduce(1,(a,b)->a*b);
	}
	public static void main(String[] args) {
		
		FactorialUsingIteration(31); // 31 is max for int , for 32 it will be zero
		
		System.out.println(FactorialUsingRecursion(31));
	}

}
