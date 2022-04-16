package com.project.calculate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculateNumbersTest {

	@Test
	void testNullPointerException() {
		NullPointerException thrown = Assertions.assertThrows(NullPointerException.class, () -> {
			String numbers = null;
			CalculateNumbers.Add(numbers);
		});
		Assertions.assertEquals("String cannot be null", thrown.getMessage());
	}

	@Test
	void testEmptyString() {
		String numbers = "";
		Assertions.assertEquals(0, CalculateNumbers.Add(numbers));
	}

	@Test
	void testNoNumericString() {
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			String numbers = "abcde";
			CalculateNumbers.Add(numbers);
		});
		Assertions.assertEquals("String contains no number", exception.getMessage());
	}

	@Test
	void testForSumOfSingleNumber() {
		Assertions.assertEquals(10, CalculateNumbers.Add("10"));
	}

	@Test
	void testForSumOfTwoNumbers() {
		Assertions.assertEquals(12, CalculateNumbers.Add("10,2"));
	}

	// Test to check if characters are ignored when sent as comma separated values
	@Test
	void testForSumOfNumbersWithCharactersInBetween() {
		Assertions.assertEquals(20, CalculateNumbers.Add("10,2,a,g,8"));
	}

	// Test to check sum when numbers contain leading and trailing spaces
	@Test
	void testForSumOfNumbersWithLeadingAndTrailingSpaces() {
		Assertions.assertEquals(28, CalculateNumbers.Add("7, 1,a , f, 8, 12"));
	}

	// Test to check if new line acts as delimiter
	@Test
	void testForSumOfNumbersWithNewLineAsDelimiter() {
		Assertions.assertEquals(6, CalculateNumbers.Add("1\n2,3"));
	}

}
