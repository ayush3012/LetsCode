package com.java.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IteratingMap {

	public static void main(String[] args) {
		
		Map<Integer,String> m=new HashMap<>();
		m.put(1,"a");
		m.put(2,"b");
		m.put(3,"c");
		m.put(4,"d");
		//Method1
		m.forEach((k,v)->System.out.println(k+" : "+v));
		//Method2
		m.entrySet().stream().forEach(o->System.out.println(o));
		//Method3
		for(Map.Entry<Integer,String> s:m.entrySet())
			System.out.println(s.getKey()+" "+s.getValue());
		//Method4
		for(Integer i:m.keySet())
			System.out.print(i+" "+m.get(i)+" ");
		System.out.println();
		for(String s:m.values())
			System.out.print(s+" ");
		System.out.println();
		//Method5
		Iterator<Map.Entry<Integer,String>> itr=m.entrySet().iterator();
		while(itr.hasNext())
		{
			Map.Entry<Integer,String> entry=itr.next();
			System.out.println(entry.getKey()+" "+entry.getValue());
		}

	}

}
