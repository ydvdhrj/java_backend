package com.testing;

public class Program {
	
	public boolean isPalindrome(String str) {
		
		StringBuilder s=new StringBuilder(str);
		
		return (s.reverse().toString().equals(str))?true:false;		
		
	}
	
	
	public boolean numberIsPositive(int a) {
		
		return a>0?true:false;
	}
	
	public int add(int a, int b) {
		return a+b;
	}
	
}
