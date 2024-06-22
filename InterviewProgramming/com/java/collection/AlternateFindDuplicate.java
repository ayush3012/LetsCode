package com.java.collection;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

public class AlternateFindDuplicate {
	public static void getRepeatedChars(String str)
	{ 
		Map<Character,Integer> counts = new LinkedHashMap<>(str.length()); 
		for (char c : str.toCharArray()) 
		{ 
			counts.put(c, counts.containsKey(c) ? counts.get(c) + 1 : 1); 
		} 
		for (Entry<Character,Integer> entry : counts.entrySet()) 
		{ 
			if (entry.getValue() >1)
			{ 
				System.out.println(entry.getKey() +" is repeated "+entry.getValue()+" times");
			} 
		}
	}
	
public static void main(String[] args) {
		
		String str="";
		Random r=new Random();
		for(int i=0;i<10;i++)
			str+=(char)(r.nextInt(26)+'a');
			System.out.print(str+" \n");
		getRepeatedChars(str);
	}

}
