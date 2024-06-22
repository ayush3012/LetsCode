package com.example.demo;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.i18n.LocaleContextHolder;

@SpringBootApplication
@ComponentScan(basePackages= {"com.example.controller"})
public class SpringBootI18NApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootI18NApplication.class, args);
	}

}
/*1. create messages.properties where application.properties is (name and location must be same)
 * 
 * 
 *2. Autowire MessageSource
 *
 *3. get locale using Locale locale =LocaleContextHolder.getLocale();
 *
 *4. return messageSource.getMessage("good.morning.message", null, "Default message",locale);
 * 
 * 5. create another messages.properties by messages_nl.properties (add like this)
 * 
 * 6.Header: key-Accept-language , value-nl 
 * 
 */