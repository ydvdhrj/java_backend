package com.securitypractice.springsecuritydbconnection.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity //this will check credentials	(it is for role based authantication)a
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception {
		return http.
				cors(cors->{})
				.csrf(csrf->csrf.disable())
				.authorizeHttpRequests(auth->auth
						.requestMatchers("/actuator/beans").hasRole("ADMIN")
						.requestMatchers("/actuator/**").permitAll()
						.requestMatchers("/public/**").permitAll()
						.requestMatchers("/admin/**").hasRole("ADMIN")
						.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults()).build();
	}
}
