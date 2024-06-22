package com.interview.codes;

import com.example.tricky.AccessModifier;

public class AccessModifierOutsidePkgSubClass extends AccessModifier{
	
	public void show()
	{
		//System.out.println(a);   private  
		//System.out.println(b);   default
		System.out.println(c);      //protected is accessible
	    System.out.println(d);      //public is accessible
	}

	public static void main(String[] args) {
		
		AccessModifierOutsidePkgSubClass am=new AccessModifierOutsidePkgSubClass();
		//private and default are not accessible but protected and public are visible outside package by subclass
		//System.out.println(am.a);
		//System.out.println(am.b);
		
		//parent class object can not access protected var, child class object access protected var of parent
		System.out.println(am.c);
		
		System.out.println(am.d);

	}

}
