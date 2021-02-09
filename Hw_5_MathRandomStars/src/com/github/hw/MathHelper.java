package com.github.hw;

public class MathHelper {
    public static double g_CONST = 9.80665;

    public static double velocityToMetres(double v) {
        return v / 3.6;
    }

    public static double degreesToRadians(double degrees) {
        return degrees / 57.3;
    }

    public static double linearFunction(double a, double b, double x) {
        return a * x + b;
    }

}
