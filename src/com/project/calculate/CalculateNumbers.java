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

		// This converts new line to comma for splitting numbers
		numbersString = numbersString.replaceAll("\\n", ",");

		if (!numbersString.matches(".*\\d.*")) {
			throw new IllegalArgumentException("String contains no number");
		}

		List<String> commaSeparatedListOfNumbers = Arrays.asList(numbersString.split(","));

		sumOfNumbers = commaSeparatedListOfNumbers.stream().filter(string -> string.matches(".*\\d.*"))
				.mapToInt(s -> Integer.valueOf(s.trim())).sum();

		return sumOfNumbers;
	}
}
