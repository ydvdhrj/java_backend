package com.basic_of_spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com")
public class DemoConfiguration {
	// bean look for the return type not the function name
	@Bean
	public Scanner getScanner() {
		return new Scanner(System.in);
	}
	
	@Bean
	public List<String> getItems(){
		return List.of("Miller","Brevas","Holder");
		
	}
	
	@Bean
	public HashMap<String, Integer> getScore(){
		return new HashMap<String, Integer>();
	}
	
}
