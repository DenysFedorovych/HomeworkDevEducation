package com.github.simple_calculator;

public class Calculate {
    public static boolean validateOperation(String s3) {

        switch (s3) {
            case "+":
            case "-":
            case "*":
            case "/":
                return true;
        }
        return false;

    }

    public static double calculate(String s1, String s2, String s3) {
        double num1 = Double.parseDouble(s1);
        double num2 = Double.parseDouble(s2);
        double result = 0.0;
        switch (s3) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }
        return result;
    }
}
