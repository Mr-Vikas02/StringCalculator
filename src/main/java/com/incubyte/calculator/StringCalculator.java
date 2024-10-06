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
		

        for (String num : numbers) {
            num = num.trim();
            if (!num.isEmpty()) {
                sum += sumOfDigits(num);
            }
        }
        return sum;
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
