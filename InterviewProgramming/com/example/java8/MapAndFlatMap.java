package com.example.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapAndFlatMap {
	
	static Map<String,List<Integer>> mp=new HashMap<>();
	
	public static void create()
	{
		mp.put("a",Arrays.asList(1,2,3));
		mp.put("b",Arrays.asList(2,3,4));
		mp.put("c",Arrays.asList(3,4,5));
		mp.put("d",Arrays.asList(4,5,6));
		mp.put("e",Arrays.asList(5,6,7));
	}

	public static void mapFunction(Map<String,List<Integer>> m)
	{
		List<Stream<Integer>> mapList1=mp.values().stream().map(Collection::stream).collect(Collectors.toList());
		for(Stream<Integer> i:mapList1)
		{
			List<Integer> li=i.collect(Collectors.toList());
			System.out.println(li);
		}
	}
	
	public static void flatMapFunction(Map<String,List<Integer>> m)
	{
		List<Integer> mapList2=mp.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
		mapList2.forEach(o->System.out.print(o+" "));
	}
	
	
	public static void main(String[] args) {
		
		create();
		mp.forEach((k,v)->System.out.println(k+" "+v));
		
		//.map() returns List<Stream<>>
		mapFunction(mp);
		
		//.flatMap() returns List<>
		flatMapFunction(mp);
	}

}
