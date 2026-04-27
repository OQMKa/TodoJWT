package com.todoappjwt.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.todoappjwt.service.CustomUserDetailsService;

@Configuration
@EnableAutoConfiguration
public class SecurityConfig {
	
	private final CustomUserDetailsService userDetailsService;
	
	public SecurityConfig(CustomUserDetailsService userDetailsService) {
		super();
		this.userDetailsService = userDetailsService;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
			.csrf(csrd->csrd.disable())
			.authorizeHttpRequests(auth->auth
					.requestMatchers("/users/**")
					.permitAll()
					.anyRequest()
					.authenticated())
			.userDetailsService(userDetailsService)
			.httpBasic(Customizer.withDefaults());
		return http.build();
	}
}
