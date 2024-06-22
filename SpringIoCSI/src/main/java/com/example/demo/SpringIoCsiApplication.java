package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringIoCsiApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringIoCsiApplication.class, args);
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		
       Living life=ctx.getBean("animallife",Living.class);
		
		System.out.println(life.getLife());
		
		System.out.println(life.setInjection());
	}

}
