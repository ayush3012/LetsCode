package com.example.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {

	public static void main(String[] args) {
		
		List<List<String>> al=new ArrayList<>();
		List<String> l1=new ArrayList<>();
		l1.add("ayush");
		l1.add("nanhe");
		List<String> l2=new ArrayList<>();
		l2.add("shakti");
		l2.add("tannu");
		List<String> l3=new ArrayList<>();
		l3.add("jishu");
		l3.add("prabhat");
		
		al.add(l1);
		al.add(l2);
		al.add(l3);
		
		System.out.println(al);
		
		List<String> res=al.stream().flatMap(i->i.stream()).collect(Collectors.toList());
		
		System.out.println(res);
	}

}
