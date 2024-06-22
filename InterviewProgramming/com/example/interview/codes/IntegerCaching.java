package com.interview.codes;

public class IntegerCaching {

	public static void main(String[] args) {
		
		Integer i1=100;
		Integer i2=100;
		Integer i3=130;
		Integer i4=130;
		if(i1==i2)
			System.out.println("i1==i2");
		else
			System.out.println("i1!=i2");
		if(i3==i4)
			System.out.println("i3==i4");
		else
			System.out.println("i3!=i4");
		
		//this is because autoboxing ,integer range is -128 to 127
		
		/*
		 * Integer a=new Integer(10); Integer b=new Integer(10); if(a==b)
		 * System.out.println("a==b"); else System.out.println("a!=b");
		 */

	}

}
