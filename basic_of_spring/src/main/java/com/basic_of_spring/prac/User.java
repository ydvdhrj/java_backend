package com.basic_of_spring.prac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.basic_of_spring.DemoConfiguration;
@Component
public class User {

	@Autowired
	@Qualifier("creditCart")
	private Payment payment;
	
	public void display() {
		payment.send();
	}
	
	public static void main(String[] args) {
		ApplicationContext ioc = new AnnotationConfigApplicationContext(DemoConfiguration.class);
		
		User u = ioc.getBean(User.class);
		u.display();
		
	}

}
