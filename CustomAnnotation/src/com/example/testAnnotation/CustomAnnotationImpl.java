package com.example.testAnnotation;

import java.lang.reflect.Method;

import com.example.AnnotationImpl.MyAnnotation;

public class CustomAnnotationImpl {
	
	@MyAnnotation(name="meenakshi" , Dob="30/05/1994")
	public void myMethod1()
	{
		System.out.println("in method 1...");
	}

	@MyAnnotation
	public void myMethod2()
	{
		System.out.println("in method 2...");
	}
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		

		System.out.println("Welcome to Annotation world");
		
		Method m=new CustomAnnotationImpl().getClass().getMethod("myMethod1");
		
		MyAnnotation annotation =m.getAnnotation(MyAnnotation.class);
		
		System.out.println(annotation.name()+"\t"+annotation.Dob());
		
        Method m2=new CustomAnnotationImpl().getClass().getMethod("myMethod2");
		
		MyAnnotation annotation2 =m2.getAnnotation(MyAnnotation.class);
		
		System.out.println(annotation2.name()+"\t"+annotation2.Dob());
	}

}
