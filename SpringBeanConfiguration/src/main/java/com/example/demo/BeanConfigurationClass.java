package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurationClass {
	
	@Bean
	public ClassA getClassA()
	{
		return new ClassA();
	}
	@Bean
	public ClassB getClassB()
	{
		return new ClassB();
	}

}
