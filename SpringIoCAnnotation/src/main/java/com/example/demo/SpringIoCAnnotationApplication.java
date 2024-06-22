package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class SpringIoCAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIoCAnnotationApplication.class, args);
		
		//we need to pass the clas which have componentscan annotation or every class need to pass
		ApplicationContext ctx=new AnnotationConfigApplicationContext(Cat.class,Dog.class,Mouse.class);
	//	ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringIoCAnnotationApplication.class);
		
		Cat cat=ctx.getBean("cat",Cat.class);
		
		cat.CatMethod();
		cat.getObject();
		cat.CatMethodForMouse();
		cat.test();
		cat.testProp();
		
		((AbstractApplicationContext) ctx).close();
	}

}
