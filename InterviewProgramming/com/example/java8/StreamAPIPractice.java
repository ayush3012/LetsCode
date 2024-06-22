package com.example.java8;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class StreamAPIPractice {

	public static void main(String[] args) {
		
		List<Integer> al=Arrays.asList(1,2,3,4,5,6);
		Integer k=al.stream().reduce(0,(a,b)->a+b);
		System.out.println(k);
		List<Integer> al2=al.stream().map(a->a*a).collect(Collectors.toList());
		for(Integer a:al2)
			System.out.print(a+" ");
		System.out.println();
		List<String> al3=Arrays.asList("ayush","ayushi","meenakshi");
		List<String> al33=al3.stream().filter(v->v.startsWith("m")).collect(Collectors.toList());
		for(String s:al33)
			System.out.println(s);
		OptionalDouble al44=al.stream().filter(i->i%2==0).mapToInt(i->(int)i).average();
		System.out.println(al44);
		int al45=al.stream().filter(i->i%2==0).mapToInt(i->(int)i).sum();
		System.out.println(al45);

	}

}
