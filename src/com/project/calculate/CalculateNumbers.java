package com.project.calculate;

import java.util.Arrays;
import java.util.List;

public class CalculateNumbers {
	public static int Add(String numbersString) {
		int sumOfNumbers = 0;
		if (numbersString == null) {
			throw new NullPointerException("String cannot be null");
		}
		if (numbersString.isEmpty()) {
			return 0;
		}
		if (!numbersString.matches(".*\\d.*")) {
			throw new IllegalArgumentException("String contains no number");
		}
		List<String> commaSeparatedListOfNumbers = Arrays.asList(numbersString.split(","));
		
		sumOfNumbers = commaSeparatedListOfNumbers.stream().filter(string -> string.matches(".*\\d.*"))
				.map(s -> Integer.parseInt(s.trim())).mapToInt(Integer::intValue).sum();
		return sumOfNumbers;
	}
}
