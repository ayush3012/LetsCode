package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.example.entity,com.example.pathvarcont")
public class PathVariableDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PathVariableDemoApplication.class, args);
	}

}
