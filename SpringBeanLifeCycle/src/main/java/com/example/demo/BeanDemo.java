package com.example.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@PreDestroy method isn't callable for prototype beans 
//(as they do not have a clearly defined lifecycle like singletons or request scoped beans)
@Component
//@Scope("prototype")
@Scope("singleton")
public class BeanDemo {
	
	@PostConstruct
	public void afterBeanFormation()
	{
		System.out.println("afterBeanFormation method invoked just after creation of bean");
	}
	
	public BeanDemo()
	{
		System.out.println("BeanDemo object created");
	}
	
	@PreDestroy
	public void beforeBeanDestroy()
	{
		System.out.println("beforeBeanDestroy method invoked just after destroy of bean");
	}
	

	public void print()
	{
		System.out.println("instance method invoked");
	}
}
