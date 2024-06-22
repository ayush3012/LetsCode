package com.example.java8;

class A{
	
	public void show()
	{
		System.out.println("in A");
	}
}
class B extends A{
	public void show()
	{
		System.out.println("in B");
	}
}
public class AnonymousClassEg {

	public static void main(String[] args) {
		
		A ob1=new A();
		ob1.show();
		A ob2=new B();
		ob2.show();         //first check in child class then in parents
		B ob3=new B();
		ob3.show();
		//below is anonymous class, class B can be replaced with this
		A ob4=new A() {
			public void show()
			{
				System.out.println("inside anonymous");
			}
		};
		ob4.show();
		/*
		 * 1.object cannot be instantiated from outside of class because it has no name.
		 * 2.It reduces number of class files generation.
		 */

	}

}
