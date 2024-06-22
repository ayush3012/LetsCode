package com.example.java8;


interface MyInterface{     //functional interface::Single abstract method
	
	public int MyMethod(int a,int b);
}
public class LambdaExpression {

	public static void main(String[] args) {
		MyInterface mi=(a,b)->a*b;   //->lambda exp
		
		System.out.println(mi.MyMethod(2, 3));
		

	}

}
