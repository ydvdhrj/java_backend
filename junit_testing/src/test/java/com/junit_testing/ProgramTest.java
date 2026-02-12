package com.junit_testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.testing.Program;

public class ProgramTest {
	
	@ParameterizedTest
	@ValueSource(strings= {"tenet","radar","aba"})
	public void isPalindromeTest(String str) {
		Program p=new Program();
		assertTrue(p.isPalindrome(str));
	}
	
	@ParameterizedTest
	@ValueSource(ints= {1,15,23,42})
	public void numberIsPositiveTest(int a) {
		Program p = new Program();
		assertTrue(p.numberIsPositive(a));
	}
	
	@ParameterizedTest
	@CsvSource({
		"1,2,3",
		"5,5,10",
		"5,3,7"
	})
	public void addTest(int a,int b, int expectedResult) {
		
		Program p = new Program();
		int actualres = p.add(a, b);
		assertEquals(expectedResult, actualres);
	}
}
