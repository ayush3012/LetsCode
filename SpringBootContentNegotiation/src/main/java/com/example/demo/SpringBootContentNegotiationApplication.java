package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.example.entity,com.example.Controller"})
public class SpringBootContentNegotiationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootContentNegotiationApplication.class, args);
	}

}

/*1. Add dependency
 * 
 * <dependency>
           <groupId>com.fasterxml.jackson.dataformat</groupId>
           <artifactId>jackson-dataformat-xml</artifactId>
   </dependency>
 *
 * 
 * goto Headers tab: key: Accept , value: Application/xml
 * 
 * 
 * 
 * 
 */