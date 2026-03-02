package com.capgemini.springmvcboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DemoController {
	
	@Autowired
	UserJpaRepository jpa;

	@GetMapping("/hello")
	public String getHi() {
		return "welcome";
	}
	
	@GetMapping("/register")
	public String createAccount() {
		return "register";
	}
	
	@PostMapping("/create-account")
	public String register(@ModelAttribute Users users) {
		
		jpa.save(users);
		
		
		
		return "success";
	}
}
