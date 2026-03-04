package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class EmployeeController {

	private final EmployeeService service;
	private EmployeeJpaRepository jpa;
	
	public EmployeeController(EmployeeService service, EmployeeJpaRepository jpa) {
		super();
		this.service = service;
		this.jpa = jpa;
	}
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	@PostMapping("/create")
	public ModelAndView create(@ModelAttribute Employee e) {
		return service.createEmployee(e);
	}
	
	@GetMapping("/login")
    public String login() {
        return "login";
    }
	
	@PostMapping("/logincheck")
	public ModelAndView getDetails(HttpServletRequest request) {
		return service.login(request.getParameter("email"), request.getParameter("password"));
	}
}
