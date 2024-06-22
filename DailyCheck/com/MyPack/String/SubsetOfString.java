package com.mypack.String;

import java.util.ArrayList;
import java.util.List;

public class SubsetOfString {

	static List<String> subset=new ArrayList<>();
	
	public static void findSubset(String str,int ind,String curr)
	{
		if(ind==str.length())
		{
			subset.add(curr);
			return;
		}
		findSubset(str, ind+1, curr);
		findSubset(str, ind+1, curr+str.charAt(ind));
	}
	public static void main(String[] args) {
		
		String str="abc";
		
		findSubset(str, 0, "");
		
		subset.forEach(i->System.out.println(i));

	}

}
