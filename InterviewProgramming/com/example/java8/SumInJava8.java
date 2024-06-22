package com.example.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SumInJava8 {

	public static void main(String[] args)
	{
		List<Integer> al11=Arrays.asList(1,2,3);
		Integer i=al11.stream().reduce(0,(a,b)->a+b);
		System.out.println(i);
	}

}
