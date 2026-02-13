package com.junit_testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.testing.EvenOrOdd;
import com.testing.Program;

public class ProgramTest {
	
//	@ParameterizedTest
//	@ValueSource(strings= {"tenet","radar","aba"})
	public void isPalindromeTest(String str) {
		Program p=new Program();
		assertTrue(p.isPalindrome(str));
	}
	
//	@ParameterizedTest
//	@ValueSource(ints= {1,15,23,42}) //-> for one parametric test
	public void numberIsPositiveTest(int a) {
		Program p = new Program();
		assertTrue(p.numberIsPositive(a));
	}
	
//	@ParameterizedTest
//	@CsvSource({
//		"1,2,3",
//		"5,5,10",
//		"5,3,7"
//	})  //-> used for more than one parameterized test
	public void addTest(int a,int b, int expectedResult) {
		
		Program p = new Program();
		int actualres = p.add(a, b);
		assertEquals(expectedResult, actualres);
	}
	
	
	@ParameterizedTest   //--> it is used for test with parameter
	@CsvFileSource(resources = "/capgemini.csv",numLinesToSkip = 1)   //-> it is used to read the test from csv file
	public void evenOrOddTest(String input,String expected) {
		
		EvenOrOdd eoo = new EvenOrOdd();
		String actualres = eoo.evenOrOdd(Integer.parseInt(input));
		assertEquals(expected,actualres);
	}
}
