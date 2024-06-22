package com.example.java8;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstUniqueCharacter {

	public static void firstUnique(String str)
	{
		str.replace(" ","").toLowerCase().chars()
		.mapToObj(i->Character.valueOf((char)i))
		.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
		.entrySet().stream().filter(e->e.getValue()==1).map(e->e.getKey())
		.findFirst().ifPresent(i->System.out.println(i));
	}
	public static void main(String[] args) {
		
		String str="i need to learn java";
		
		firstUnique(str);

	}

}
