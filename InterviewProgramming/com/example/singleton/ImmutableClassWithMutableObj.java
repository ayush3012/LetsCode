package com.example.singleton;

final class Employee{
	private final String name;
	private final int age;
	private final Address address;
	
	public Employee(String name,int age,Address ad)
	{
		this.name=name;
		this.age=age;
		this.address=ad;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Address getAddress() {
		Address ad=new Address();
		ad.setCity(address.getCity());
		ad.setState(address.getState());
		return ad;
	}
	
}

 class Address{
	public  String state;
	public  String city;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Address(String state,String city)
	{
		this.state=state;
		this.city=city;
	}
	public Address(){}
	@Override
	public String toString() {
		return "Address [state=" + state + ", city=" + city + "]";
	}
	
}
public class ImmutableClassWithMutableObj {

	public static void main(String[] args) {
		Address ad=new Address("bihar","muz");
		Employee e=new Employee("Ayush",25,ad);
		System.out.println(e.getName()+" "+e.getAge()+" "+e.getAddress());
		e.getAddress().setCity("patna");                                    //trying to update city
		System.out.println(e.getName()+" "+e.getAge()+" "+e.getAddress());
		ad.setState("london");
		System.out.println(e.getName()+" "+e.getAge()+" "+e.getAddress());
	}

}
