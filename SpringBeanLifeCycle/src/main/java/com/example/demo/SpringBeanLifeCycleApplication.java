package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
public class SpringBeanLifeCycleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBeanLifeCycleApplication.class, args);
		
		ApplicationContext ctx=new AnnotationConfigApplicationContext(BeanDemo.class);
		
		BeanDemo obj=ctx.getBean(BeanDemo.class);
		
		obj.print();
		
		BeanDemo obj2=ctx.getBean(BeanDemo.class);
		
		System.out.println("obj "+obj.hashCode()+" obj2 "+obj2.hashCode());
		
		((AbstractApplicationContext) ctx).close();
	}

}
