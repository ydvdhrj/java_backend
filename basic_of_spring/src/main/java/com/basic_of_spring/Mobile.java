package com.basic_of_spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Mobile {

	@Value("9876543210")
	private long number;

	public long getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
}
