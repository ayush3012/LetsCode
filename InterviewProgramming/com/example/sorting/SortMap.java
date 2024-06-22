package com.example.sorting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SortMap {
	static Map<String,Integer> mp=new HashMap<>();
	private static Map<String,Integer> sortimpl(Map<String,Integer> m)
	{
		List<Entry<String,Integer>> al=new ArrayList<>(m.entrySet());
		Collections.sort(al,new Comparator<Entry<String,Integer>>() {
			public int compare(Entry<String,Integer> o1,Entry<String,Integer> o2)
			{
				//return o1.getKey().compareTo(o2.getKey());//-----sort by keys
				return o1.getValue().compareTo(o2.getValue());//----sort by values
			}
		});
		Map<String,Integer> lhm=new LinkedHashMap<>();
		for(Entry<String,Integer> e:al)
			lhm.put(e.getKey(),e.getValue());
		return lhm;
	}

	public static void main(String[] args) {
		
		mp.put("x", 2);
		mp.put("q", 6);
		mp.put("g", 1);
		mp.put("s", 4);
		mp.put("t", 8);
		mp.put("a", 3);
		mp.entrySet().forEach(o->System.out.println(o));
		mp=sortimpl(mp);
		System.out.println("------------");
		mp.entrySet().forEach(o->System.out.println(o));
		
	}
}
