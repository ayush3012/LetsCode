package com.example.java8;

import java.util.HashMap;
import java.util.stream.IntStream;

public class FrequencyOfEveryCharacter {

	public static void Frequency(String str)
	{
	   	//Frequency of particular character	
	   //System.out.println(IntStream.range(0,str.length()).filter(i->str.charAt(i)=='a').count());
		
		HashMap<Character,Integer> hm=new HashMap<>();
		IntStream.range(0,str.length()).forEach(i->hm.put(str.charAt(i),hm.containsKey(str.charAt(i))?hm.get(str.charAt(i))+1:1));
		
		hm.forEach((k,v)->System.out.println(k+" "+v));
	}
	public static void main(String[] args) {
		
		String str="mynameisayusha";
		
		Frequency(str);

	}

}
