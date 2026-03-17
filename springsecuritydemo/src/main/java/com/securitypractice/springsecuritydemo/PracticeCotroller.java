package com.securitypractice.springsecuritydemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PracticeCotroller {

	@GetMapping("/practices")
	public String getDetails() {
		return "Details";
	}
	
	@GetMapping("/admin")
	public String deleteUser() {
		return "Delete";
	}
	
	@GetMapping("/user")
	public String getUser() {
		return "user";
	}
}
