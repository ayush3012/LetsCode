package com.example.designpattern;

abstract class Vehicle{
	public abstract int getWheel() ;
	
}
class Car extends Vehicle{
	int wheel;
	public Car(int wheel)
	{
		this.wheel=wheel;
	}
	public int getWheel()
	{
		return this.wheel;
	}
	@Override
	public String toString()
	{
		return "your car is returned because you asked "+getWheel()+" wheeler";
	}
	
}
class Bike extends Vehicle{
	int wheel;
	public Bike(int wheel)
	{
		this.wheel=wheel;
	}
	public int getWheel()
	{
		return this.wheel;
	}
	@Override
	public String toString()
	{
		return "your bike is returned because you asked "+getWheel()+" wheeler";
	}
}
class FactoryForVehicle{
	public static Vehicle getVehicle(int wheel)
	{
		if(wheel==4)
			return new Car(wheel);
		else if(wheel==2)
			return new Bike(wheel);
		else
			return null;
	}
}
public class FactoryDesignPattern {

	public static void main(String[] args) {
		
		Vehicle ride1=FactoryForVehicle.getVehicle( 4);
		Vehicle ride2=FactoryForVehicle.getVehicle( 2);
		Vehicle ride3=FactoryForVehicle.getVehicle( 3);
		System.out.println(ride1);
		System.out.println(ride2);
		System.out.println(ride3);
		
	}

}
