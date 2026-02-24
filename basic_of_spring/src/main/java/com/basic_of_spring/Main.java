package com.basic_of_spring;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.basic_of_spring.prac.CreditCart;
import com.basic_of_spring.prac.UPI;

public class Main {

	public static void main(String[] args) {
//		ApplicationContext ioc = new ClassPathXmlApplicationContext("config.xml");
//		
//		Person person = ioc.getBean("person", Person.class);
//		System.out.println(person);
//		
//		person.message();
//		
//		Employee employee = ioc.getBean("employee",Employee.class);
//		
//		System.out.println(employee.getId());
//		System.out.println(employee.getName());
//		System.out.println(employee.getSalary());
		
		ApplicationContext ioc = new AnnotationConfigApplicationContext(DemoConfiguration.class);
		Employee emp = ioc.getBean(Employee.class);
//		System.out.println(emp);
//		System.out.println(emp.getId());
//		System.out.println(emp.getName());
//		System.out.println(emp.getSalary());
//		
		Person p = ioc.getBean(Person.class);
		System.out.println(p);
		System.out.println(p.getMobile());
		
		
		Mobile m = ioc.getBean(Mobile.class);
//		System.out.println(m);
		
//		System.out.println(p.getScan());
		System.out.println(p.getItems());
		System.out.println(p.getScore());
		
		List<String> list = ioc.getBean(List.class);
		System.out.println(list);
		
		System.out.println(ioc.getBean(HashMap.class));
		
		System.out.println(ioc.getBean(UPI.class));
		System.out.println(ioc.getBean(CreditCart.class));
	}
}
