package com.example.tricky;



//Can we reference unreferenced object again: YES, BUT ONLY ONCE
public class Resurrect {

	static Resurrect resurrect=null;
	public static void main(String[] args) 
	{
		Resurrect p1=new Resurrect();
		System.out.println("first instance "+p1.hashCode());
		p1=new Resurrect();
		System.out.println("second instance "+p1.hashCode());
		
		System.gc();
	}
	@Override
	public void finalize()
	{
		resurrect=this;
		System.out.println("resurrected "+resurrect.hashCode());
	}
}
