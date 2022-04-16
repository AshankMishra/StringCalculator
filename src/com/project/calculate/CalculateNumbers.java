package com.project.calculate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalculateNumbers {
	public static int Add(String numbersString) {
		int sumOfNumbers = 0;
		if (numbersString == null) {
			throw new NullPointerException("String cannot be null");
		}

		if (numbersString.isEmpty()) {
			return 0;
		}

		// This method converts delimiters to comma separated string
		numbersString = convertAllDelimitersIntoCommaSeparatedString(numbersString);

		if (!numbersString.matches(".*\\d.*")) {
			throw new IllegalArgumentException("String contains no number");
		}

		List<String> commaSeparatedListOfNumbers = Arrays.asList(numbersString.split(","));

		// Get a separate List of Negative Integers List to throw an exception if size
		// greater than zero
		List<String> negativeIntegersList = commaSeparatedListOfNumbers.stream()
				.filter(number -> number.matches(".*\\d.*")).map(s -> s.trim())
				.filter(number -> Integer.valueOf(number) < 0).collect(Collectors.toList());

		if (negativeIntegersList.size() > 0) {
			throw new IllegalArgumentException("Negatives not allowed- " + String.join(",", negativeIntegersList));
		} else {
			sumOfNumbers = commaSeparatedListOfNumbers.stream().filter(string -> string.matches(".*\\d.*"))
					.mapToInt(s -> Integer.valueOf(s.trim())).sum();

			return sumOfNumbers;
		}
	}

	private static String convertAllDelimitersIntoCommaSeparatedString(String delimiterSeparatedString) {
		// This converts new line to comma for splitting numbers
		delimiterSeparatedString = delimiterSeparatedString.replaceAll("\\n", ",");

		// Below condition checks if string is long enough to contain dynamically
		// specified delimiter
		if (delimiterSeparatedString.length() > 4 && delimiterSeparatedString.substring(0, 2).equals("//")
				&& delimiterSeparatedString.substring(3, 4).equals(",")) {
			// Get the dynamically entered delimiter
			String dynamicDelimiter = delimiterSeparatedString.substring(2, 3);
			// remove the part of string containing information about delimiter
			delimiterSeparatedString = delimiterSeparatedString.substring(4);
			// replace delimiter to comma separated string
			delimiterSeparatedString = delimiterSeparatedString.replaceAll(dynamicDelimiter, ",");
		}
		return delimiterSeparatedString;
	}
}