package com.interview.codes;

import com.example.tricky.AccessModifier;

public class AccessModifierOutsidePkg {

	
	public static void main(String[] args) {
		
		AccessModifier am=new AccessModifier();
		//only public are visible ouside the package 
		//System.out.println(am.a);    --a is private
		//System.out.println(am.b);    --b is deault
		//System.out.println(am.c);    --c is protected
		System.out.println(am.d);

	}

}
