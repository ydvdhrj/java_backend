package com.prac;

public class Calculator {
	public static int add(int a,int b) {
		return a+b;
	}
	
	public static String reverseString(String data) {
		String rev="";
		for(int i=data.length()-1;i>=0;i--) {
			rev=rev+data.charAt(i);
		}
		return rev;
	}
	
	public static int factorial(int n) {
		int res=1;
		for(int i=1;i<=n;i++) {
			res*=i;
		}
		return res;
	}
	
	public static boolean palindrome(String s) {
		int i=0,j=s.length()-1;
		while(i++<j--) {
			if(s.charAt(i)!=s.charAt(j)) {
				return false;
			}
			
			
		}
		return true;
	}
	
	public static int div(int a,int b) {
		return a/b;
	}
}
