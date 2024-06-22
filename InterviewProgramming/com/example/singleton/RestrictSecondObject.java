package com.example.singleton;

import java.util.HashSet;
import java.util.Set;


class A
{
	private static final Set instances=new HashSet<>();

	A()
	{
		synchronized(instances)
		{
			if(instances.contains(getClass()))
				throw new RuntimeException("Duplicate object "+getClass().getSimpleName());
			instances.add(getClass());
		}
	}
}

public class RestrictSecondObject {

	A a1=new A();
	RestrictSecondObject p1=new RestrictSecondObject();
	A a2=new A();
	RestrictSecondObject p2=new RestrictSecondObject();
}
