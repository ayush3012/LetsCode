package com.example.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UniqueAndDuplicateUsingStream {
	
	public static void unique(String s)
	{
		char[] ch=s.toCharArray();
		List<Character> al=new ArrayList<>();
		for(char c:ch)
			al.add(c);
		Set<Character> set=al.stream()
				.filter(i->Collections.frequency(al,i)==1)
				.collect(Collectors.toSet());
		for(char c:set)
			System.out.print(c+" ");
	}
	public static void duplicate(String s)
	{
		char[] ch=s.toCharArray();
		List<Character> al=new ArrayList<>();
		for(char c:ch)
			al.add(c);
		Set<Character> set=al.stream()
				.filter(i->Collections.frequency(al,i)>1)
				.collect(Collectors.toSet());
		for(char c:set)
			System.out.print(c+" ");
	}

	public static void main(String[] args) {
		
		String s="Muzaffarpur";
		
		unique(s);System.out.println();
		duplicate(s);
	}

}
