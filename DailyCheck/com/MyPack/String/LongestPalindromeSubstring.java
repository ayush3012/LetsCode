package com.mypack.String;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LongestPalindromeSubstring {
	
	public static String LongestPalindrome(String s)    // method 1
	{
		
		int max=0;
		String res="";
		Map<Character,List<Integer>> tm=new TreeMap<>();
		for(int j=0;j<s.length();j++)
		{
			char c=s.charAt(j);
			List<Integer> al=new ArrayList<>();
			if(tm.containsKey(c))
				al.addAll(tm.get(c));
			al.add(j);
			for(int i:al)
			{
				if(isPalindrome(s.substring(i,j+1)))
				{
					if(max<j-i+1)
					{
						max=j-i+1;
						res=s.substring(i,j+1);
					}
				}
			}
			tm.put(c,al);
		}
		return res;
	}

	public static boolean isPalindrome(String s)
	{
		return s.equals(new StringBuffer(s).reverse().toString());
	}
	
	public static String LongestPalindrome_leetcode(String str)     // method 2
	{
		int s=0, e=0;
		for(int i=0;i<str.length();i++)
		{
			int odd=pal(str,i,i);
			int even=pal(str,i,i+1);
			int len=Math.max(odd,even);
			if(len>e-s)
			{
				s=i-(len-1)/2;
				e=i+len/2;
			}
		}
		return str.substring(s,e+1);
	}
	public static int pal(String str,int s,int e)
	{
		while(s>=0 && e<str.length() && str.charAt(s)==str.charAt(e))
		{
			s--;
			e++;
		}
		return e-s-1;
	}
	public static String Palindrome_recursion_leetcode(String s)         // method 3
	{
		if(s.equals(new StringBuffer(s).reverse().toString()))
			return s;
		String left=Palindrome_recursion_leetcode(s.substring(1));
		String right=Palindrome_recursion_leetcode(s.substring(0,s.length()-1));
		return left.length()>right.length()?left:right;
	}
	public static void main(String[] args) {
		
		System.out.println(LongestPalindrome("ababa"));
		
		System.out.println(LongestPalindrome_leetcode("abab"));
		
		System.out.println(Palindrome_recursion_leetcode("abab"));
	}

}
