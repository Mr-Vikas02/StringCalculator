package com.incubyte.calculator;

import java.util.Scanner;

public class StringCalculator {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter string: ");
		StringCalculator strCalc = new StringCalculator();

		String str = scanner.nextLine();
		System.out.println("Result: " + strCalc.Add(str));

		scanner.close();
	}

	public int Add(String string) {
		if (string == null || string.isEmpty())
			return 0;

		String[] numbers = string.split(",");
		int sum = 0;
		

//		If given string is comma separated string length is greater than 2.

		if (numbers.length > 2) return 0;

		if (numbers.length == 1) {
			String num = numbers[0].trim();
			if (!num.isEmpty()) {
				return sumOfDigits(num);
			}
		} else if (numbers.length == 2) {
			for (String num : numbers) {
				num = num.trim();
				if (!num.isEmpty()) {
					sum += sumOfDigits(num);
				}
			}
			return sum;
		}
		return 0;
	}

	/**
	 * Method used for sum operation.
	 * */
	private int sumOfDigits(String number) {
		int sum = 0;
		for (char ch : number.toCharArray()) {
			if (Character.isDigit(ch)) {
				sum += Character.getNumericValue(ch);
			}
		}
		return sum;
	}

}
