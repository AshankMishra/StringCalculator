package com.project.calculate;

public class CalculateNumbers {
	public static int Add(String numbers) {
		if (numbers == null) {
			throw new NullPointerException("String cannot be null");
		}
		if (numbers.isEmpty()) {
			throw new IllegalArgumentException("String cannot be empty");
		}
		int sumOfNumbers = 0;
		return sumOfNumbers;
	}
}
