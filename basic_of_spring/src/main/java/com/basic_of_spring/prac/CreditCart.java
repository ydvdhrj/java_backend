package com.basic_of_spring.prac;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class CreditCart implements Payment{

	@Override
	public void send() {
		// TODO Auto-generated method stub
		System.out.println(" send it through creditcard");
	}

}
