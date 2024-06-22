package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.example.entity.Account;

@SpringBootApplication
@EntityScan("com.example.entity")
@EnableJpaRepositories("com.example.repo")
@ComponentScan(basePackages="com.example.controller,com.example.cacheData,com.example.config")
@EnableCaching
public class SpringBootPlusHazelcastApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootPlusHazelcastApplication.class, args);
		
	}
	
	@Bean
	public Map<Integer,Account> cache()
	{
		return new HashMap<>();
	}
}
