package com.example.tricky;

public class AccessModifierWithinPkg {

	public static void main(String[] args) {

		AccessModifier am=new AccessModifier();
		//Except private other thre are accessible within package
		//System.out.println(am.a);    --a is private
		System.out.println(am.b);
		System.out.println(am.c);
		System.out.println(am.d);
	}

}
