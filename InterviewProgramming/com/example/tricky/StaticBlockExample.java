package com.example.tricky;

public class StaticBlockExample {

	public static void main(String[] args) {
        System.out.println(Main.x);
	}

}

class Main{
	//public static final int x=10;
	public static  int x=10;
	
	static {
		
		System.out.println("static block called when variable is not final");
	}
}
