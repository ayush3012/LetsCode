package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.example.entity,"
		+ "com.example.Controller,com.example.CustomValidation"
		+ "com.example.CustomValidation"})
public class SpringBootCustomValidationImplApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCustomValidationImplApplication.class, args);
	}

}
