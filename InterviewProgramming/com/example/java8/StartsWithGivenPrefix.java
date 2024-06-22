package com.example.java8;

import java.util.stream.IntStream;

public class StartsWithGivenPrefix {

	public static void FilterStringWithPrefix(String[] str,String s)
	{
		IntStream.range(0,str.length)
		         .filter(i->str[i].startsWith(s))
		         .mapToObj(i->str[i])
		         .forEach(i->System.out.println(i));
	}
	public static void main(String[] args) {
		
		String[] str= {"geeksforgeeks", "geeks", "geek", "geezer"};

		String s="geek";
		
		FilterStringWithPrefix(str, s);
	}

}
