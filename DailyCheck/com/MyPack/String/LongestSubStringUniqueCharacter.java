package com.mypack.String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubStringUniqueCharacter {
	
	public static void LongestSubstring(String s)
	{
		Set<Character> hs=new HashSet<>();
		String res="";
		String max="";
		for(int i=0;i<s.length();i++)
		{
			if(hs.contains(s.charAt(i)))
			{
				hs.clear();
				res="";
			}
			hs.add(s.charAt(i));
			res+=s.charAt(i);
			if(max.length()<res.length())
				max=res;
		}
		System.out.println("Longest sunstring without repeating character: "+max);
	}

	public static int LongestSubstringUnique(String s)  // Accepted on leetcode
	{
		Map<Character,Integer> map=new HashMap<>();
		int start=0;
		int len=0;
		int end=-1;
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			if(map.containsKey(c))
			{
				if(map.get(c)>=start)
				 start=map.get(c)+1;
			}
			len=Math.max(len,i-start+1);
			end=i-start;
			map.put(c,i);
		}
		return len;
	}
	public static void main(String[] args) {
		
		String str="geeksforgeeks";
		//String str="dvdf";
		
		LongestSubstring(str);
		
		System.out.println(LongestSubstringUnique(str));
	}

}
