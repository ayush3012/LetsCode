package com.interview.codes;

import java.util.ArrayList;
import java.util.List;

public class RSystem
{
	
	public static void method(String str)
	{
		String[] str1=str.split("#");
		for(String s:str1)
		{
			String[] a=s.split(":");
			int val=0;
			String[] k=a[1].replace('+', 'k').split("k");
			for(String p:k)
			{
				val+=Integer.valueOf(p);
			}
			System.out.println(a[0]+" has total amount "+val);
		}
	}
	public static void main(String[] args)
	{
		String str=" Saurabh:24+25+56+26#Rajesh:12+76+12+25#Raman:87+24+25+98";
		method(str);
	}

}