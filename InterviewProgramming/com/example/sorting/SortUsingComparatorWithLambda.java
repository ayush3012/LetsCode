package com.example.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Employee{
	String name;
	int marks;
	public Employee(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String toString()
	{
		return "Employee "+name+" have marks "+marks;
	}
	
}
public class SortUsingComparatorWithLambda {

	public static void main(String[] args) {
		List<Employee> Employees=new ArrayList<>();
		Employee s1=new Employee("ayush",40);
		Employee s2=new Employee("meenakshi",50); 
		Employee s3=new Employee("jyoti",30);
		Employee s4=new Employee("tina",20); 
		Employee s5=new Employee("kareena",60);
		Employees.add(s1);
		Employees.add(s2);
		Employees.add(s3);
		Employees.add(s4);
		Employees.add(s5);
		for(Employee a:Employees)
			System.out.println(a);
		Collections.sort(Employees,(e1,e2)->e1.name.compareTo(e2.name));
		System.out.println("---------comparator-------");
		for(Employee a:Employees)
			System.out.println(a);
	}

}
