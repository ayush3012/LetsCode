package com.example.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AggregateStream {

	public static void main(String[] args) {
		
		List<Employee> al=new ArrayList<>();
		al.add(new Employee(12,800,"ayush"));
		al.add(new Employee(17,1000,"ayush"));
		al.add(new Employee(11,200,"ayush"));
		al.add(new Employee(18,600,"rose"));
		al.add(new Employee(16,800,"meenakshi"));
		al.add(new Employee(14,400,"divya"));
		al.add(new Employee(19,700,"tina"));
		al.add(new Employee(13,100,"rose"));
		
		//group by name as key and average salary as value
		Map<Object,Double> map=al.stream().collect(Collectors.groupingBy(i->i.getName(),Collectors.averagingDouble(i->i.getSalary())));
		map.forEach((k,v)->System.out.println(k+"  "+v));
		System.out.println("-------------------------------------");
		//sort by salary
		al.stream().sorted((x,y)->x.getSalary()-y.getSalary()).forEach(i->System.out.println(i));
		System.out.println("--------------------------------------------");
		
		//group by name as key and count person as value
		Map<Object,Long> m2=al.stream().collect(Collectors.groupingBy(i->i.getName(),Collectors.counting()));
		m2.forEach((k,v)->System.out.println(k+" "+v));

	}

}
