package com.example.java8;

public class MethodReference {

	public static void main(String[] args) {
		
		//static method reference
		//FunctionalInterfaceName ref=ClassName::static methodname 
		StuffIntrf str=StuffCls::doStuff;    
		str.doTask();
	
		//Instance reference
		//create object of class
		//FunctionalInterfaceName ref=object name::non static methodname 
		StuffCls ob=new StuffCls();
		StuffIntrf obr=ob::doMoreStuff;
		obr.doTask();
		
		//Constructor reference
		//FunctionalInterfaceName ref=classname::new 
		StuffIntrf cr=StuffCls::new;
		cr.doTask();
		

	}

}
