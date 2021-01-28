package com.github.functions;

import java.util.Scanner;

public class NumberScanner {
    private static Scanner scanner = new Scanner(System.in);

    public static double getDouble() {
        return scanner.nextDouble();
    }

    public static int getInt() {
        return scanner.nextInt();
    }

    public static String getName() {
        return scanner.next();
    }
}
