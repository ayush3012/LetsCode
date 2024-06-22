package com.stream.database;

public class Worker {
	
	String name;
	int age;
	int salary;
	char gender;
	public Worker(String name, int age, int salary, char gender) {
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getSalary() {
		return salary;
	}
	public char getGender() {
		return gender;
	}
	@Override
	public String toString() {
		return "Worker [name=" + name + ", age=" + age + ", salary=" + salary + ", gender=" + gender + "]";
	}

}
