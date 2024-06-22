package com.interview.codes;

public class CompareObjects  {
	

	public static void main(String[] args) {
		
		Employee e1=new Employee(20,12000,"ayush");
		Employee e2=new Employee(21,13000,"meenakshi");
		Employee e3=new Employee(21,13000,"meenakshi");
		Employee e4=new Employee(21,13000,"ayushkarnaayush");
		
		System.out.println(e1.hashCode());
		/*
		 * System.out.println(e1.equals(e2)); System.out.println(e2.equals(e3));
		 */
		if(e1.hashCode()==e2.hashCode())
			System.out.println(e1.equals(e2));
		if(e2.hashCode()==e3.hashCode())
			System.out.println(e2.equals(e3));
		if(e1.hashCode()==e4.hashCode())
			System.out.println(e1.equals(e4));
	}

}
