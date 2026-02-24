package com.basic_of_spring;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
//	dependency injection
	
//	3 types of dependency injection : 
//		1) field injection
//		2) setter injection
//		3) constructor injection (mostly preferred)
//	Autowired does not support on static fields
	
//	@Autowired
	private  Mobile mobile;//null , ref
	
	@Autowired
	private Scanner scan;
	
	@Autowired
	private List<String> items;
	
	@Autowired
	private  HashMap<String,Integer> score; 
	
	public void message() {
		System.out.println("hiiii");
	}

	public Mobile getMobile() {
		return mobile;
	}
	
//	@Autowired
	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

	public Scanner getScan() {
		return scan;
	}

	public void setScan(Scanner scan) {
		this.scan = scan;
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}
	
	public Person(Mobile mobile) {
		this.mobile = mobile;
	}

	public HashMap<String, Integer> getScore() {
		return score;
	}

	public void setScore(HashMap<String, Integer> score) {
		this.score = score;
	}
	
}
