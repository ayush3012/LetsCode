package com.example.designpattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class ThroughReflection{
	
	private static ThroughReflection instance=new ThroughReflection();
	
	private ThroughReflection() {}
	
	public static ThroughReflection getInstance()
	{
		return instance;
	}
	
}
//because java ensures internally that enum value is instantiated only once. it does not allow lazy initialization
 enum ThroughReflectionEnum{instance} //to prevent singleton from reflection define singleton as ENUM
public class ViolationSingletonThroughReflection {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException
	{
		//through normal implementation
		ThroughReflection ins1=ThroughReflection.getInstance();
		ThroughReflection ins2=null;
		Constructor[] cons=ThroughReflection.class.getDeclaredConstructors();
		for(Constructor c:cons)
		{
			c.setAccessible(true);
		    ins2=(ThroughReflection)c.newInstance();
			break;
		}
		System.out.println("ins1 "+ins1.hashCode()+" \nins2 "+ins2.hashCode());
		
		//through enum
		ThroughReflectionEnum ins3=ThroughReflectionEnum.instance;
		ThroughReflectionEnum ins4=ThroughReflectionEnum.instance;
		System.out.println("ins3 "+ins3.hashCode()+" \nins4 "+ins4.hashCode());
	}

}
