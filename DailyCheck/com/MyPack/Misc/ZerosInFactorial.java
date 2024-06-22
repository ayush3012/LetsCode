package com.mypack.Misc;

public class ZerosInFactorial {

	public static void CountZero(int n)
	{
		int count=0;
		for(int i=5;i<=n;i*=5)
		{
			if(n%i==0)
			  count+=n/i;
			
		}
		System.out.println("total zeros "+count);
	}
	public static void main(String[] args) {
		
		CountZero(25);
	}

}
