package com.mypack.Misc;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Anagram {
	
	public static boolean checkAnagram(String s1,String s2)
	{
		if(s1.length()!=s2.length())
			return false;
		char[] ch1=s1.toCharArray();
		char[] ch2=s2.toCharArray();
		
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		
		int i=-1;
		while(i++<ch1.length-1)
			if(ch1[i]!=ch2[i])
				return false;
		
		return true;
	}
	
	public static boolean isAnagram(String s1,String s2)
	{
		Map<Character,Integer> tm1=new TreeMap<>();
		Map<Character,Integer> tm2=new TreeMap<>();
		for(char c:s1.toCharArray())
			tm1.put(c,tm1.containsKey(c)?tm1.get(c)+1:1);
		for(char c:s2.toCharArray())
			tm2.put(c,tm2.containsKey(c)?tm2.get(c)+1:1);
		
		return tm1.entrySet().stream().allMatch(i->tm2.containsKey(i.getKey()) && tm2.get(i.getKey())==i.getValue());
	}
	

	public static void main(String[] args) {
		
		String s1="abcdefbdff";
		String s2="abcdefbdff";
		
		System.out.println(checkAnagram(s1, s2));
		
		System.out.println("==========");
		
		System.out.println(isAnagram(s1, s2));
	}

}
