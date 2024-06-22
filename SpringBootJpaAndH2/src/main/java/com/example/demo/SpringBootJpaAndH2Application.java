package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
@EntityScan("com.example.entity")
public class SpringBootJpaAndH2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaAndH2Application.class, args);
	}

}
/*
 * 1. create entity with @entity and @id for primary key
 *    like Company class
 * 
 *    
 * 2. add dependency for jpa and h2
 * 
 * 3.add below in application.properties
 * 
 *    spring.h2.console.enabled=true
      spring.datasource.url=jdbc:h2:mem:testdb
 * 
 * first will enable console and second will connect to DB
 * 
 * 
 * 4. hit localhost:8080/h2-console
 * 
 *  provide spring.datasource.url in jdbc url
 * 
 * 5. go to src/main/resources (where application.properties is)
 * 
 * 6. create data.sql
 * 
 * 7. add below in application.properties
 * 
 * spring.jpa.defer-datasource-initialization=true
 * 
 * 
 * 
 */