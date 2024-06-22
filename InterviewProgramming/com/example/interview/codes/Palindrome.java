package com.interview.codes;

import java.util.Scanner;

public class Palindrome {
	
	public static boolean checkPalindrome(int n)
	{
		int orig=n;
		int rev=0;
		while(n>0)
		{
			rev=rev*10+n%10;
			n=n/10;
		}
		return rev==orig;
	}

	public static void main(String[] args) {
		
		System.out.println("Enter number to check palindrome::");
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		if(checkPalindrome(a))
			System.out.println("given number is palindrome");
		else
			System.out.println("given number is not palindrome");
		sc.close();

	}

}
