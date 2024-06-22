package com.example.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GroupAnagramInList {
	
	private static String sortChar(String str)
	{
		char[] ch=str.toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}

	public static void main(String[] args) {
		
		List<String> al=new ArrayList<>();
		al.add("word");
		al.add("eat");
		al.add("sleep");
		al.add("dorw");
		al.add("ate");
		al.add("lesep");
		al.add("tae");
		al.add("bat");
		
		al.stream().collect(Collectors.groupingBy(i->sortChar(i)))
		.entrySet().stream().map(e->e.getValue()).forEach(i->System.out.print(i+" "));

	}

}
