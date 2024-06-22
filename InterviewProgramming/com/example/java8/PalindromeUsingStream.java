package com.example.java8;

import java.util.stream.IntStream;

public class PalindromeUsingStream {
	
	public static boolean CheckPalindrome(String s)
	{
		return IntStream.range(0,s.length()).allMatch(i->s.charAt(i)==s.charAt(s.length()-1-i));
	}

	public static void main(String[] args) {
		
		
		System.out.println(CheckPalindrome("abcba"));
	}

}
