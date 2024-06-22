package com.mypack.String;

public class strStr {

	public static int implStrStr(String s,String x)
	{
		boolean flag=true;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)==x.charAt(0))
				flag=true;
			for(int j=0;j<x.length();j++)
			{
				if(s.charAt(i+j)!=x.charAt(j))
				{
					flag=false;
					break;
				}
			}
			if(flag)
				return i;
		}
		return -1;
	}
	public static void main(String[] args) {
		
		String s="geeksforgeeks";
		String x="for";
		
		System.out.println(implStrStr(s, x));
	}

}
