package com.github.functions;

import java.util.Arrays;

public class FourNumbers {
    private static int[] num = new int[4];

    public static void fill() {
        System.out.println("Введите свои четыре числа в формате Число + Enter");
        for (int i = 0; i < 4; i++) {
            System.out.println("Можете вводить");
            num[i] = NumberScanner.getInt();
        }
    }

    public static void minAndMax() {
        Arrays.sort(num);
        System.out.println("Ваше минимальное число : " + num[0]);
        int i = 3;
        while (i > 0 && num[i] == num[i - 1]) i--;
        System.out.println("Количество наибольший цифр : " + (4 - i));
    }

    public static void main(String[] args) {
        fill();
        minAndMax();
    }
}
