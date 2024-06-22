package com.example.java8;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SortMapUsingStream {

	static Map<String,Integer> hm=new HashMap<>();
	static{
		hm.put("ayush",5);
		hm.put("karna",0);
		hm.put("saurabh",9);
		hm.put("tannu",2);
		hm.put("jishu",1);
		hm.put("munna",7);
		hm.put("bunty",3);
	}
	public static void main(String[] args) {
		
		hm.entrySet().stream().sorted((e1,e2)->e1.getValue()-e2.getValue())
		.forEach(e->System.out.println(e));
		
		System.out.println("=====storing in map========");
		LinkedHashMap<String,Integer> lhm=hm.entrySet().stream()
				.sorted((e1,e2)->e1.getValue()-e2.getValue())
		.collect(Collectors.toMap(Entry::getKey,Entry::getValue,(k,v)->k,LinkedHashMap::new));

		System.out.println(lhm);
	}

}
