package com.example.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachDemo {

	public static void main(String[] args) {
		List<String> al=new ArrayList<>();
		al.add("Ayush");
		al.add("meenakshi");
		al.add("tina");
		al.add("divya");
		al.add("jyoti");
		al.add("shilpa");
		al.add("Ayushman");
		al.add("Ayushi");
		
		al.stream().forEach(t->System.out.println(t));//forEach takes consumer interface(void accept(T t))
		
		 Map<Integer,String> m=new HashMap<>();
		m.put(1,"a");
		m.put(2,"b");
		m.put(3,"c");
		m.put(4,"d");
		m.forEach((k,v)->System.out.println(k+" : "+v));//in case of map , forEach takes BiConsumer(void accept(T1,T2))
		m.entrySet().stream().forEach(o->System.out.println(o));
		
		
		//filter  --it takes predicate
		al.stream().filter(a->a.charAt(0)=='A').forEach(a->System.out.println(a));
		m.entrySet().stream().filter(k->k.getKey()%2==0).forEach(a->System.out.println(a));
		
		//sort
		al.stream().sorted().forEach(a->System.out.println(a));

	}

}
