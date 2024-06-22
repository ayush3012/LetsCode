package com.interview.codes;

import java.util.Scanner;

public class LargestOfThree {
	
	public static int Largest(int a,int b,int c)
	{
		int l=(a>b?a:b);
		return l>c?l:c;
	}

	public static void main(String[] args) {
		
		int a,b,c;
		System.out.println("enter 3 number:");
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a :");
		a=sc.nextInt();
		System.out.println("enter b :");
		b=sc.nextInt();
		System.out.println("enter c :");
		c=sc.nextInt();
		System.out.println("values entered are a="+a+" b="+b+" c="+c);
		System.out.println("Largest among three is: "+Largest(a,b,c));
		sc.close();

	}

}
