package com.mypack.String;

public class LargestCommonPrefix {
	
	public static void Prefix(String[] str)
	{
		String s=str[0];
		for(int i=1;i<str.length;i++)
		{
			while(str[i].indexOf(s)!=0)
				s=s.substring(0,s.length()-1);
		}
		System.out.println("Largest prefix "+s);
	}

	public static void main(String[] args) {
		
		String[] input = {"geeksforgeeks", "geeks", "geek", "geezer"};
		
		Prefix(input);

	}

}
