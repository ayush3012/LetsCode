package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.example.entity,com.example.Controller"})
public class SpringBootHateoasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHateoasApplication.class, args);
	}

}

/* HATEOAS: Hypermedia as the engine of application state
 * 
 * used when we want to bind link with object state
 *
 * 1. add HATEOAS dependency
 * 
 * 2.use WebMvcLinkBuilder and EntityModel
 * 
 * 
 * IN this actuator is also implemented:
 * 
 * 1. Add actuator dependency
 * 
 * 2. hit localhost:8080/actuator
 *   
 *   see public endpoints
 *   
 * 3. go to application.properties and add
 *  management.endpoints.beans.enabled=true 
    management.endpoints.web.exposure.include=* 
 * 
 * 4. hit the endpoint whatever you want to monitor
 * 
 * 
 * 
 * In this HAL (Hypermedia application language) is also implemented
 * 
 * 1. just add 
 * 
 *      <dependency>
			<groupId>org.springframework.data</groupId>
			<artifactId>spring-data-rest-hal-explorer</artifactId>
		</dependency>
		
	2. hit http://localhost:8080/ in chrome browser	
 */