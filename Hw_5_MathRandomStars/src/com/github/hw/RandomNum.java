package com.github.hw;

import java.util.Random;

public class RandomNum {
    private static Random random = new Random();

    public static double randomDouble(double a, double b) {
        if (a > b) throw new IllegalArgumentException("Left border must be less than right border");
        return random.nextDouble() * (b - a + 1) + a;
    }

    public static int randomInt(int a, int b) {
        if (a > b) throw new IllegalArgumentException("Left border must be less than right border");
        return random.nextInt(b - a + 1) + a;
    }

    public static int randomInt() {
        return random.nextInt(1001) - 500;
    }
}
