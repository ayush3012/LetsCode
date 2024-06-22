package com.example.designpattern;

import java.util.ArrayList;
import java.util.List;
//It is creational design pattern
//In clone->it gives shallow copy of object i.e both reference will point to different object. If we change one
//one object other will also gets changed
//prototype is resolving that only= in this design pattern we override clone method to get a seprate object
//copy.if i perform operation will does not affect other.
class Prototype implements Cloneable{
	List<String> list;
	
	Prototype()
	{
		list=new ArrayList<>();
	}
	Prototype(List<String> l)
	{
		this.list=l;
	}
	public List<String> getType()
	{
		return this.list;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		List<String> temp=new ArrayList<>();
		for(String s:this.getType())
			temp.add(s);
		return new Prototype(temp);
	}
}
public class PrototypeDesignPattern {
	public static void main(String[] args) throws CloneNotSupportedException{

		List<String> al=new ArrayList<>();
		al.add("A");
		al.add("B");
		al.add("C");
		al.add("D");
		al.add("E");
		Prototype proton=new Prototype(al);
		Prototype electron=(Prototype)proton.clone();
		System.out.print("proton :");
		proton.getType().forEach(i->System.out.print(i+" "));
		System.out.print("\nelectron :");
		electron.getType().forEach(i->System.out.print(i+" "));
		
		electron.getType().add("F");
		System.out.println("\n====After adding===");
		System.out.print("proton :");
		proton.getType().forEach(i->System.out.print(i+" "));
		System.out.print("\nelectron :");
		electron.getType().forEach(i->System.out.print(i+" "));
	}

}
