package com.github.hw;

public class MathFunctions {

    public static double lengthOfShotDegrees(double alpha, double v) {
        double velocity = MathHelper.velocityToMetres(v);
        double angle = MathHelper.degreesToRadians(alpha);
        return (Math.pow(velocity, 2) * Math.sin(angle * 2.0)) / MathHelper.g_CONST;
    }

    public static double lengthOfShotRadians(double alpha, double v) {
        double velocity = MathHelper.velocityToMetres(v);
        return (Math.pow(velocity, 2) * Math.sin(alpha * 2.0)) / MathHelper.g_CONST;
    }

    public static double carDistance(double v1, double v2, double s0, double t) {
        if (s0 < 0 || t < 0) throw new IllegalArgumentException("Negative distance or time");
        return (v1 + v2) * t + s0;
    }

    public static byte liesIn(double x, double y) {
        double x_abs = Math.abs(x);
        if (x_abs > 2) return 0;
        if (y < MathHelper.linearFunction(1.5, -1, x_abs) || y > MathHelper.linearFunction(1, 0, x_abs)) return 0;
        return 1;
    }

    public static double bigFunction(double x) {
        double s_x = Math.sin(x);
        double c_x = Math.cos(x);
        double e_x = Math.exp(x);
        double e_x1 = Math.exp(x + 1);
        double result1 = 6 * Math.log(Math.sqrt(e_x1 + 2 * (e_x * c_x))) / (Math.log(x - e_x1 * s_x));
        double result2 = Math.abs(c_x / Math.exp(s_x));
        return result1 + result2;
    }


}
