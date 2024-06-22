package com.java.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class FindDuplicate {
	
	public static void Duplicate(String[] arr)
	{
		Map<String,Integer> mp=new HashMap<>();
		for(int i=0;i<arr.length;i++)
		{
			if(!mp.containsKey(arr[i]))
				mp.put(arr[i],1);
			else
				mp.put(arr[i],mp.get(arr[i])+1);
		}
		for(Map.Entry<String,Integer> m: mp.entrySet())
			System.out.println(m.getKey()+" "+m.getValue());
		for(Map.Entry<String,Integer> m: mp.entrySet())
		{
			if(m.getValue()>1)
				System.out.println(m.getKey()+" is repeated "+m.getValue()+" times");
		}
	}

	public static void main(String[] args) {
		
		String[] str=new String[10];
		Random r=new Random();
		for(int i=0;i<10;i++)
			str[i]=""+(char)(r.nextInt(26)+'a');
		for(int i=0;i<str.length;i++)
			System.out.print(str[i]+" ");
		Duplicate(str);
	}

}
