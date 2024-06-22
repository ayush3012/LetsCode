package com.mypack.String;

public class ReverseStringRecursion {

	public static String rev(String str)
	{
		if(str.length()==0)
			return str;
		return rev(str.substring(1))+str.charAt(0);
	}
	public static void main(String[] args) {
		
		String str="ayushkarna";
		
		System.out.println(rev(str));
	}

}
