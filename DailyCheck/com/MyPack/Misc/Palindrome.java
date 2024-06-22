package com.mypack.Misc;

import java.util.stream.IntStream;

public class Palindrome {

	public static boolean checkPalindromeForNumber(int n)
	{
		int temp=n;
		int num=0;
		while(temp>0)
		{
			num=num*10+temp%10;
			temp=temp/10;
		}
		return n==num;
	}
	
	public static boolean checkPalindromeForString(String str)
	{
		
		String s="";
		for(int i=str.length()-1;i>=0;i--)
			s+=str.charAt(i);
		return s.equals(str);   //method 1
		//return str.equals(new StringBuffer(str).reverse().toString());  //method 2
		
	}
	public static boolean CheckPalindromeUsingRecursion(String s,int i)
	{
		if(i>s.length()/2)
			return true;
		return s.charAt(i)==s.charAt(s.length()-1-i) && CheckPalindromeUsingRecursion(s, i+1);
	}
	public static boolean CheckPalindromeUsingStream(String s)
	{
		return IntStream.range(0,s.length()).allMatch(i->s.charAt(i)==s.charAt(s.length()-1-i));
	}
	public static void main(String[] args) {
		
		int a=121;
		
		System.out.println(checkPalindromeForNumber(a));
		
		System.out.println();
		
		String str="abcdcba";
		
		System.out.println(checkPalindromeForString(str));
		
		System.out.println();
		
		System.out.println(CheckPalindromeUsingRecursion(str, 0));
		
		System.out.println();
		
		System.out.println(CheckPalindromeUsingStream(str));
	}

}
