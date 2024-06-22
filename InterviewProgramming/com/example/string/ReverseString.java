package com.example.string;

import java.util.Scanner;

public class ReverseString {
	
	public String ReverseUsingLength(String str)
	{
		String rev="";
		for(int i=str.length()-1;i>=0;i--)
			rev=rev+str.charAt(i);
		return rev;
	}

	public String ReverseUsingStringBuffer(String str)
	{
		StringBuffer sb=new StringBuffer(str);
		sb=sb.reverse();
		return ""+sb;
	}
	
	public String ReverseUsingCharArray(String str)
	{
		char[] arr=str.toCharArray();
		char[] rev=new char[arr.length];
		int j=0;
		for(int i=arr.length-1;i>=0;i--)
			rev[j++]=arr[i];
		return new String(rev);
	}
	public static void main(String[] args) {
		
		String s="";
		ReverseString rs=new ReverseString();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String:");
		s=sc.nextLine();
		System.out.println("String before reversing: "+s);
		//System.out.println("String after reversing: "+rs.ReverseUsingLength(s));
		//System.out.println("String after reversing: "+rs.ReverseUsingStringBuffer(s));
		System.out.println("String after reversing: "+rs.ReverseUsingCharArray(s));
		sc.close();
	}

}
