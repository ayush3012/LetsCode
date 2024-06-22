package com.example.java8;

 class Employee {
	
	int age;
	int salary;
	String name;
	
	public Employee(int age, int salary, String name) {
		this.age = age;
		this.salary = salary;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode()
	{
		return this.name.length()%10;
	}
	@Override
	public boolean equals(Object obj)
	{
		if(this==obj)
			return true;
		Employee emp=(Employee)obj;
		
		return this.age==emp.age && this.salary==emp.salary && this.name.equals(emp.name);
	}
	@Override
	public String toString() {
		return "Employee [age=" + age + ", salary=" + salary + ", name=" + name + "]";
	}
	

}
