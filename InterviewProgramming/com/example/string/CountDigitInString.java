package com.example.string;

import java.util.Scanner;

public class CountDigitInString {

	public static int CountDigit(String str)
	{
		int count=0;
		for(int i=0;i<str.length();)
		{
			try {
				Integer.parseInt(""+str.charAt(i));
				count++;
				i++;
			}
			catch(NumberFormatException e)
			{
				i++;
			}
		}
		return count;
	}

	public static void main(String[] args) {

		System.out.println("Enter string::");
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		System.out.println("entered string is "+str);
		System.out.println(CountDigit(str));
		sc.close();

	}

}
