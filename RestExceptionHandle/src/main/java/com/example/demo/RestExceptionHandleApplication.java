package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.example.GlobalExeHandle"
		,"com.example.StudentController"})
public class RestExceptionHandleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestExceptionHandleApplication.class, args);
	}

}
