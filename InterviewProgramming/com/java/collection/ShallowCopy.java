package com.java.collection;

import java.util.ArrayList;
import java.util.List;

//This shallow copy will not work on primitive data type
public class ShallowCopy implements Cloneable{
	
	List<String> al=new ArrayList<>();
	
	public List<String> getI() {
		return this.al;
	}

	public void setI(List<String> al) {
		this.al=al;
	}

	public static void main(String[] args) throws CloneNotSupportedException 
	{
		ShallowCopy p1=new ShallowCopy();
		List<String> al=new ArrayList<>();
		al.add("A");
		al.add("B");
		al.add("C");
		al.add("D");
		p1.setI(al);
		ShallowCopy p2=(ShallowCopy)p1.clone();
		System.out.println(p1.hashCode()+" "+p2.hashCode());
		p1.getI().forEach(i->System.out.print(i+" "));
		System.out.println();
		p2.getI().forEach(i->System.out.print(i+" "));
		p1.getI().add("E");
		System.out.println("\n=====");
		p1.getI().forEach(i->System.out.print(i+" "));
		System.out.println();
		p2.getI().forEach(i->System.out.print(i+" "));
		System.out.println("\n======");
		p2.getI().add("F");
		p1.getI().forEach(i->System.out.print(i+" "));
		System.out.println();
		p2.getI().forEach(i->System.out.print(i+" "));
		
	}
}
