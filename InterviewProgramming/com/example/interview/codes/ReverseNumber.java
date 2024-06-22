package com.interview.codes;

import java.util.Scanner;

public class ReverseNumber {
	
	public String ReverseNumberUsingString(int n)
	{
		String str=""+n;
		StringBuffer sb=new StringBuffer(str);
		sb=sb.reverse();
		return ""+sb;
	}

	public String ReverseUsingMathLogic(int n)
	{
		String s="";
		while(n>0)
		{
			int a=n%10;
			s=s+a;
			n=n/10;			
		}
		return s;
	}
	public int ReverseUsingAlgo(int n)
	{
		int rev=0;
		while(n>0)
		{
			rev=rev*10+n%10;
			n=n/10;			
		}
		return rev;
	}
	
	public static void main(String[] args) {
		int n=0;
		ReverseNumber rs=new ReverseNumber();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number:");
		n=sc.nextInt();
		System.out.println("number before reversing: "+n);
		//System.out.println("number after reversing: "+rs.ReverseNumberUsingString(n));
		//System.out.println("number after reversing: "+rs.ReverseUsingMathLogic(n));
		System.out.println("number after reversing: "+rs.ReverseUsingAlgo(n));
		sc.close();

	}

}
