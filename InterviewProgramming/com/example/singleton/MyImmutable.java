package com.example.singleton;

final class MyImmutable //step1-make class final :: can not be make child class-> this is required 
//because if child class created and this contains extra fields i.e it is immutable so whereever
//we are using parent immutable we can use child mutable also and that will leads to problem
{
	//step2-make every field private and final :: can not be accessed from outside the class and can not be changed
	private final String field1;
	private final int field2;
	
	//step3-provide public constructor ::way to create object
	public MyImmutable(String s,int a)
	{
		this.field1=s;
		this.field2=a;
	}
	//step4-provide only Getters not Setters:: can not change object value ,only get the object value
	public String getField1()
	{
		return field1;
	}
	public int getField2()
	{
		return field2;
	}
	
}
public class Immutable {

	public static void main(String[] args) 
	{
		MyImmutable mi=new MyImmutable("s",10);
		System.out.println(mi.getField1()+" "+mi.getField2());
	}

}
