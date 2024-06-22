package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= "com.example.entity,com.example.controller")
public class RestContPojOtoJasonApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestContPojOtoJasonApplication.class, args);
	}

}
