package com.example.cors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin("*")
@CrossOrigin("http://localhost:5173/")
public class DemoController {

	@GetMapping("/welcome")
	public String welcome() {
		return "";		
	}
	
	@GetMapping("/api/hello")
	public String getHi() {
		return "dheeraj yadav";
	}
}
