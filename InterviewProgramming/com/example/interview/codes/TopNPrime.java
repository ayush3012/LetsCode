package com.interview.codes;

public class TopNPrime {

	public static void count(int n)
	{
		int count=0;
		int num=2;
		while(count<n)
		{
			if(isPrime(num))
				{
				  System.out.print(num+" ");
				   count++;
				}
			num++;
		}
	}
	
	public static boolean isPrime(int n)
	{
		if(n==0 || n==1) return false;
		if(n==2) return true;
		for(int i=2;i<=n/2;i++)
			if(n%i==0)
				return false;
		return true;
	}
	public static void main(String[] args) {
		
		
		count(10);

	}

}
