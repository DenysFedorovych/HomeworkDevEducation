package com.github.strings;

public class NumberParser {
    public static String toString(long a) {
        StringBuilder res = new StringBuilder();
        boolean isNegative = false;
        if (a == 0) {
            return "0";
        }
        if (a < 0) {
            a = Math.abs(a);
            isNegative = true;
        }
        while (a != 0) {
            res.append(a % 10);
            a /= 10;
        }
        if (isNegative) {
            res.append('-');
        }
        return res.reverse().toString();
    }

    public static String toString(Double a) {
        return a.toString();
    }

    public static long toNumber(String a) {
        long order = 1;
        long result = 0;
        if (a.charAt(0) != '-') {
            for (int i = a.length() - 1; i >= 0; i--) {
                result += toDigit(a.charAt(i)) * order;
                order *= 10;
            }
        } else {
            for (int i = a.length() - 1; i > 0; i--) {
                result += toDigit(a.charAt(i)) * order;
                order *= 10;
            }
            result *= -1;
        }
        return result;
    }

    private static long toDigit(char a) {
        return a - '0';
    }

    public static double toNumberDouble(String a) {
        double result = 0;
        String[] arr = a.split("\\.");
        result += toNumber(arr[0]);
        double b = toNumber(arr[1]);
        b /= Math.pow(10, arr[1].length());
        result += b;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(toNumberDouble("12345.68"));
    }
}
