package com.github.functions;

public class Discriminant {
    public static double discriminant(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    public static void main(String[] args) {
        System.out.println("Представьте ваше квадратное уравнение в виде ax^2+bx+c.");
        System.out.println("Введите старший (первый) коэффициент : ");
        double a = NumberScanner.getDouble();
        System.out.println("Введите второй коэффициент : ");
        double b = NumberScanner.getDouble();
        System.out.println("Введите третий коэффициент : ");
        double c = NumberScanner.getDouble();
        System.out.println("Вот искомый дискриминант : ");
        System.out.println(discriminant(a, b, c));
    }
}
