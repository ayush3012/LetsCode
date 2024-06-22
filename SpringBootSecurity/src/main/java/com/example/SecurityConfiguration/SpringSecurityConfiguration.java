package com.example.SecurityConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.*;


@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		
		//All request should be authenticated
		http.authorizeHttpRequests(auth->auth.anyRequest().authenticated());
		
		//If request is not customized show error page
		http.httpBasic(withDefaults());
		
		//Disable CSRF
		http.csrf().disable();
		
		
		return http.build();
	}
}
