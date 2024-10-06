package com.incubyte.calculator;

import java.util.Scanner;

public class StringCalculator {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		// To build new string with new line
		StringBuilder sb = new StringBuilder();
		System.out.println("Enter string: ");

		String strLine;
		/**
		 * Iteration for each new line
		 * */
		while (!(strLine = scanner.nextLine()).isEmpty()){
			sb.append(strLine).append("\n");
		}

		String finalStr = sb.toString().trim();
		StringCalculator strCalc = new StringCalculator();
		System.out.println("Result: " + strCalc.Add(finalStr));

		scanner.close();
	}

    public int Add(String string) {
        if (string == null || string.isEmpty()) return 0;

        String delimiter = ",";

        /**
         * this code is used for the string which starts with '//'
         * */
        if (delimiter.startsWith("//")) {
            int delimiterEnd = string.indexOf("\n");
            if (delimiterEnd != -1) {
                String customDelimiter = string.substring(2, delimiterEnd).trim();
                if (customDelimiter.startsWith("[") && customDelimiter.endsWith("]")) {
                    customDelimiter = customDelimiter.substring(1, customDelimiter.length() - 1);
                    delimiter = "[ " + customDelimiter + " ]";
                } else {
                    delimiter = customDelimiter;
                }
                string = string.substring(delimiterEnd + 1);
            }
        }

        String[] numbers = string.split("[,\n" + delimiter + "]");
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
