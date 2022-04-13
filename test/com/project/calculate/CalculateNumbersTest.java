package com.project.calculate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculateNumbersTest {

	@Test
	void testAdd() {
		fail("Not yet implemented");
	}

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
		IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			String numbers = "";
			CalculateNumbers.Add(numbers);
		});
		Assertions.assertEquals("String cannot be empty", exception.getMessage());
	}
}
