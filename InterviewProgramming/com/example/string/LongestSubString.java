package com.example.string;

import java.util.HashSet;

public class LongestSubString {
	
	public static String LongestString(String str)
	{
		String l="";
		String cl="";
		HashSet<Character> hs=new HashSet<>();
		for(int i=0;i<str.length();i++)
		{
			if(hs.contains(str.charAt(i)))
			{
				cl="";
				hs.clear();
			}
			hs.add(str.charAt(i));
			cl+=str.charAt(i);
			if(cl.length()>l.length())
				l=cl;
		}
		return l;
	}
	public static void main(String[] args) {
		
		String str = "geeksforgeeks";
		System.out.println(LongestString(str));

	}

}
