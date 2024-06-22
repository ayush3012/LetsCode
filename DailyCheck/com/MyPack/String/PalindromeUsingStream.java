package com.mypack.String;

import java.util.stream.IntStream;

public class PalindromeUsingStream {

	public static boolean checkPalindrome(String s)
	{
		return IntStream.range(0,s.length()).allMatch(i->s.charAt(i)==s.charAt(s.length()-1-i));
	}
	
	
	public static boolean PalindromeUsingRecursion(String s,int i)
	{
		if(i>s.length()/2)
			return true;
		return s.charAt(i)==s.charAt(s.length()-1-i) && PalindromeUsingRecursion(s, i+1);
	}
	public static void main(String[] args) {
		
		String s="abba";
		
		System.out.println(checkPalindrome(s));
	}

}
