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

}
