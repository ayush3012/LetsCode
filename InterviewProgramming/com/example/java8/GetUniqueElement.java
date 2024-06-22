package com.example.java8;

import java.util.*;

public class GetUniqueElement {

	public static void getUnique(int[] arr)
	{
		List<Integer> al=new ArrayList<>();
		for(int i:arr)
			al.add(i);
		al.stream()
		  .filter(i->Collections.frequency(al,i)==1)
		  .forEach(i->System.out.println(i));
	}
	public static void main(String[] args) {
		
		int[] arr= {1,2,3,1,4,5,2,5};
		
        getUnique(arr);
	}

}
