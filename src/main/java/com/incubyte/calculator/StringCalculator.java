package com.incubyte.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
        while (!(strLine = scanner.nextLine()).isEmpty()) {
            sb.append(strLine).append("\n");
        }

        String finalStr = sb.toString().trim();
        StringCalculator strCalc = new StringCalculator();
        try {
            System.out.println("Result: " + strCalc.Add(finalStr));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

    public int Add(String string) {
        if (string == null || string.isEmpty()) return 0;

        String delimiter = ",|\n";
        String numbersString = string;

        /**
         * this code is used for the string which starts with '//'
         * */
        if (string.startsWith("//")) {

            int delimiterEnd = string.indexOf("\n");

            if (delimiterEnd != -1) {
                String customDelimiter = string.substring(2, delimiterEnd).trim();
                delimiter = Pattern.quote(customDelimiter); // Escape the delimiter for regex
                numbersString = string.substring(delimiterEnd + 1).trim();
            }
        }

        String[] numbers = numbersString.split(delimiter);
        int sum = 0;
        List<Integer> negativeNumbers = new ArrayList<>();

        for (String num : numbers) {
            num = num.trim();
            if (!num.isEmpty()) {
                try {
                    int number = Integer.parseInt(num);
                    if (number < 0) {
                        negativeNumbers.add(number);
                    } else {
                        sum += number;
//                        sumOfDigits(num);
                    }
                } catch (NumberFormatException e) {
                    // Skipping non-numeric values
                    System.out.println("Skipping non-numeric value: " + num);
                }
            }
        }

        if (!negativeNumbers.isEmpty()) {
            String negativeNumbersString = negativeNumbers.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));
            throw new IllegalArgumentException("Negative numbers not allowed: " +negativeNumbersString);
        }
        return sum;
    }

    /**
     * Method used for sum operation.
     */
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
