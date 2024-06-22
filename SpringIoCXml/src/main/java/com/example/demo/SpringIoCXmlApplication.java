package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringIoCXmlApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringIoCXmlApplication.class, args);
		
				ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
				
				//here we are giving interface reference , we only have to change runtime in cfg file NOT pojo
				Living life=ctx.getBean("life",Living.class);
				System.out.println(life.getLife());
				
				//we will make two object to check it is prototype or not:::::SCOPE OF BEAN
				Living ani1=ctx.getBean("animalobj",Living.class);
				Living ani2=ctx.getBean("animalobj",Living.class);
				System.out.println("checking animal bean which is prototype " +ani1.equals(ani2));
				
				Living t1=ctx.getBean("life",Living.class);
				Living t2=ctx.getBean("life",Living.class);
				System.out.println("checking techie bean which is singleton " +t1.equals(t2));
				
				
				//init-method(while registering into ioc) and destroy-method(before shutting down the application)
				Living hman=ctx.getBean("humanobj",Living.class);
				ctx.close();
	}

}
