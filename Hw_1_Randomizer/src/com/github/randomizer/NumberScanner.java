package com.github.randomizer;

import java.util.Scanner;

public class NumberScanner {
    private static Scanner scanner = new Scanner(System.in);
    private static int min = 0;
    private static int max = 0;

    public static int getMin() {
        System.out.println("Set minimum, more than 1. (Write a minimum possibly generated number)");
        min = scanner.nextInt();
        while (min < 1 || min > 500) {
            System.out.println("Wrong number, try again");
            min = scanner.nextInt();
        }
        return min;
    }

    public static int getMax() {
        System.out.println("Set maximum, less than 500. (Write a maximum possibly generated number)");
        max = scanner.nextInt();
        while (max < 1 || max > 500 || max < min) {
            System.out.println("Wrong number, try again");
            max = scanner.nextInt();
        }
        return max;
    }

    public static String getCommand() {
        return scanner.next();
    }
}
