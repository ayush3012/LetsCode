package com.java.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastNFailSafe {
	
	static List<Integer> al=new ArrayList<>();
	static List<Integer> cowl=new CopyOnWriteArrayList<>();
	
	public static void createList() {
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		al.add(5);
	}
	public static void createCoWList() {
		cowl.add(10);
		cowl.add(20);
		cowl.add(30);
		cowl.add(40);
		cowl.add(50);
	}
	

	public static void main(String[] args) {
		
		createList();
		Iterator<Integer> itr=al.iterator();
		while(itr.hasNext())
		{
			Integer a=itr.next();
			if(a==4)
				itr.remove();       //--iterator is fail safe,
			//--it does not have add operation ,because it can violate collection properties like treeset
			System.out.print(a+" ");
			//al.add(6);-----concurrent modification exception
			//al.remove(2);-----concurrent modification exception
			al.set(2,9);//update 9 at index 2,because there is no structural change or mod count
		}
		System.out.println();
		al.forEach(i->System.out.print(i+" "));
		createCoWList();
		System.out.println();
		for(int i:cowl)
		{
			System.out.print(i+" ");
			if(i==50)
			cowl.add(77);//it iterates over original copy of arraylist and 
			              //updation takes on cloned list which has updated value because it is immutable
		}
		System.out.println();
		cowl.forEach(a->System.out.print(a+" "));
	}

}
