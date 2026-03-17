package com.securitypractice.springsecuritydemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception{
		//single ton builder design pattern
		return http.authorizeHttpRequests(auth->auth
				.requestMatchers("/practices").permitAll()
				.requestMatchers("/user").hasRole("ADMIN")
				.requestMatchers("/admin").hasRole("ADMIN"))
				.httpBasic(Customizer.withDefaults())
			
				.build();
	}
	
	@Bean
	public UserDetailsService getUserDetails() {
		
		UserDetails user = User.withUsername("admin")
		.password("{noop}1234")
		.roles("ADMIN")
		.build();
		
		return new InMemoryUserDetailsManager(user);
	}
}