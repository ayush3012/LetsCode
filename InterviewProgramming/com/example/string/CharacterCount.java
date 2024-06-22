package com.example.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterCount {

	public static void count(String str)
	{
		Map<Character,Integer> mp=new HashMap<>();
		for(int i=0;i<str.length();i++)
		{
			if(!mp.containsKey(str.charAt(i)))
				mp.put(str.charAt(i),1);
			else
				mp.put(str.charAt(i), mp.get(str.charAt(i))+1);
		}
		for(Map.Entry<Character,Integer> m:mp.entrySet())
			System.out.println(m.getKey() +" is occured "+ m.getValue()+" times");
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in); 
		System.out.println("enter string::");
		String str=sc.nextLine();
		System.out.println("entered string:: "+str);
		count(str);
		sc.close();
	}

}
