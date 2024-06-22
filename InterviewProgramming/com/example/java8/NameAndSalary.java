package com.example.java8;

import java.util.ArrayList;
import java.util.OptionalDouble;

public class NameAndSalary {

	public static void main(String[] args) {
	Employee e1=new Employee(12,2000,"ayush");
	Employee e2=new Employee(11,3000,"ayushi");
	Employee e3=new Employee(10,1000,"ayushmaan");
	Employee e4=new Employee(14,2002,"ameenakshi");
	Employee e5=new Employee(18,5000,"tina");
	Employee e6=new Employee(17,2040,"divya");
	ArrayList<Employee> al=new ArrayList<>();
	al.add(e1);
	al.add(e2);
	al.add(e3);
	al.add(e4);
	al.add(e5);
	al.add(e6);
	//ArrayList<Employee> al2=new ArrayList<>();
	OptionalDouble a=al.stream().filter(e->e.getName().startsWith("a")).mapToInt(e->e.getSalary()).average();
	System.out.println(a);
}

}
