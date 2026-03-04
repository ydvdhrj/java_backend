package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Service
public class EmployeeService {

	EmployeeJpaRepository jpa;

	public EmployeeService(EmployeeJpaRepository jpa) {
		this.jpa = jpa;
	}

	public ModelAndView createEmployee(Employee e) {
		Optional<Employee> optional = jpa.findById(e.getEmail());
		ModelAndView m = new ModelAndView();

		if (optional.isPresent()) {
			m.addObject("msg", e.getName());
			m.setViewName("exist");
			return m;
		} else {
			Employee employee = jpa.save(e);
			m.addObject("msg", e.getName());
			m.setViewName("successfull");
			return m;
		}
	}

	public ModelAndView login(@RequestParam String email, @RequestParam String password) {

		ModelAndView mv = new ModelAndView();
		Employee e = jpa.findByEmailAndPassword(email, password);

//		if (e == null) {
//			mv.setViewName("loginfail");
//			return mv;
//		}

		if (e.getRole().equalsIgnoreCase("admin")) {
			List<Employee> employees = jpa.findAll();
			mv.addObject("msg", employees);
			mv.setViewName("admin");
		} else {
			mv.addObject("msg", e);
			mv.setViewName("userdetails");
		}

		return mv;
	}
}
