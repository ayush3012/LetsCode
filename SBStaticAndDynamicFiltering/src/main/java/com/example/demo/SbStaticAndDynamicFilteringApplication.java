package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SpringBootApplication
@ComponentScan(basePackages= {"com.example.entity,com.example.Controller,com.example.DynamicFiltering"})
public class SbStaticAndDynamicFilteringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbStaticAndDynamicFilteringApplication.class, args);
	}

}
/*JACKSON: popular framework for serializing json
 * 
 * @JSONProperty("custom_field"): field name will change with custom_ffield
 * 
 * @JsonIgnore: field will be ignore when sending response
 * 
 * static filtering filters attribute for all api.
 * 
 * @JsonIgnoreProperties: same as @JsonIgnore but @JsonIgnore is method level and 
 *  @JsonIgnoreProperties is class level annotation
 * 
 * 
 * 
 */