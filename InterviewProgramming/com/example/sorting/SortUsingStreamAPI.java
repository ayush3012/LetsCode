package com.example.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


class Human implements Comparable<Human>{
	
	String name;
	int age;
	public Human(String s,int a)
	{
		this.name=s;
		this.age=a;
	}
	public String toString()
	{
		return "Human "+name+" with age "+age;
	}
	@Override
	public int compareTo(Human o) {
		//return this.name.compareTo(o.name);
		return this.age-o.age;
	}
}
public class SortUsingStreamAPI {

	public static void main(String[] args) {
		
		List<Human> al=new ArrayList<>();
		Human h1=new Human("a",3);
		Human h2=new Human("z",5);
		Human h3=new Human("p",9);
		Human h4=new Human("b",2);
		Human h5=new Human("k",1);
		Human h6=new Human("c",6);
		al.add(h1);
		al.add(h2);
		al.add(h3);
		al.add(h4);
		al.add(h5);
		al.add(h6);
		
		al=al.stream().sorted().collect(Collectors.toList());
		for(Human i:al)
			System.out.println(i+" ");

	}

}
