package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
public class SpringBeanConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBeanConfigurationApplication.class, args);
		
		ApplicationContext ctx=new AnnotationConfigApplicationContext(BeanConfigurationClass.class);
		
		ClassA objA=ctx.getBean("getClassA",ClassA.class);
		ClassB objB=ctx.getBean("getClassB",ClassB.class);
		
		objA.printA();
		objB.printB();
		
		((AbstractApplicationContext) ctx).close();
	}

}
