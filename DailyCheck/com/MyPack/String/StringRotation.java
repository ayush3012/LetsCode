package com.mypack.String;

public class StringRotation {
	
	public static boolean CheckRotation(String s1,String s2)
	{
		s1+=s1;
		if(s1.contains(s2))
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		
		String s1="abcd";
		String s2="bcda";
		
		System.out.println(CheckRotation(s1, s2));
	}

}
