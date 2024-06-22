package com.ayush.test4;

import com.ayush.test.A;
import com.ayush.test2.D;
import com.ayush.test3.F;

public class ADFMain extends F{

	public static void main(String[] args) {
		
		/*D objd=new D();
		int var1=objd.a;
		System.out.println(var1);
		F objf=new F();
		int var2=objf.a;
		System.out.println(var2);
		
		A obja=new A();
		int var3=obja.a;*/
		
		System.out.println(new ADFMain().a);
		System.out.println(new ADFMain().d);
		System.out.println(new ADFMain().f);
		
		/*   ==========Concept about protected===
		 * 
		 * A->B->C->D
		 * 
		 * In any of the child class , we can access protected member of any of the parent class regardless of the package
		 * 
		 * Example: In class D , we can access protected member of C,B,A with object of D only but not with object of C,B,A
		 * 
		 * simillarly,
		 * 
		 * In class C , we can access protected member of B,A with object of C only but not with object of B,A
		 *  
		 * 
		 * */
	}

}
