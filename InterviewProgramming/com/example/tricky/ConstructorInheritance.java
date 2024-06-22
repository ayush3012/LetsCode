package com.example.tricky;
class P{
	public P()
	{
		System.out.println("P");
	}
	
	public void show()
	{
		System.out.println("P::show");
	}
	
}

class C extends P{
	public C()
	{
		System.out.println("C");
	}
	
	public void show()
	{
		System.out.println("C::show");
	}
	
	
}
public class ConstructorInheritance {

	public static void main(String[] args) {
		C c=new C();  //P C    --child object also saves parent's state---first parent constructor called then child's
		c.show();     //C::show --show is overriden in child, so child method is called
		P p=new P();  //P       --parent object doesnt know state of child , only parent's constructor called
		p.show();     //P::show  
		P pc=new C(); //P C     ---in this case first parent then child constructor called
		pc.show();    //C::show  --first method looks in child if not available then looks in parent
		
	}
	
}


