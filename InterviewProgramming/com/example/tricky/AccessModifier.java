package com.example.tricky;

public class AccessModifier {
	
	//increasing order of access modifier
	private   int a=10;
	          int b=20;
	protected int c=30;
	public    int d=40;

	public static void main(String[] args) {
	
		AccessModifier am=new AccessModifier();
		//All four are accessible inside class
		System.out.println(am.a);
		System.out.println(am.b);
		System.out.println(am.c);
		System.out.println(am.d);

	}

}
