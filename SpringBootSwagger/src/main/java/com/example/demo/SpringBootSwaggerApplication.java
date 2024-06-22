package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.example.Controller"
		,"com.example.Entity","com.example.swaggerImpl"})
public class SpringBootSwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSwaggerApplication.class, args);
	}

}
/*1. Add dependency :
 *   <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger-ui</artifactId>
        <version>2.7.0</version>
    </dependency>
    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger2</artifactId>
        <version>2.7.0</version>
    </dependency>  
 *2.Configure Swagger like: annotate class @EnableSwagger2
 *return docket object
 *
 *3. Add following in application.properties
 *
 *spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER
 * 
 * IMPPPPPPPPPP
 * 
 * server.port=0 : generate dynamic port
 * 
 * 
 * 
 * 
 * 
 * 
 */