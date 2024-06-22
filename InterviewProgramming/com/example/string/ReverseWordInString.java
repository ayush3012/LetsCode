package com.example.string;

import java.util.Scanner;

public class ReverseWordInString {
	
	public static String RevrsWord(String s)
	{
		String[] words=s.split(" ");
		String rev="";
		for(String w:words)
		{
			for(int i=w.length()-1;i>=0;i--)
				rev+=w.charAt(i);
			rev=rev+" ";
		}
		return rev;
	}

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in); 
		System.out.println("enter string::");
		String str=sc.nextLine();
		System.out.println("entered string:: "+str);
		String rev=RevrsWord(str);
		System.out.println("reverse is : "+rev);
		sc.close();

	}

}
