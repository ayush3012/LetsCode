package com.example.SpringSecurityBasic;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/secure/rest")
public class SpringBootSecurityBasicAuthApplication {
	
	@GetMapping
	public String welcome(Principal principal)
	{
		return "Hi "+principal.getName()+" welcome to the world!";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityBasicAuthApplication.class, args);
	}

}
