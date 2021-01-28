package com.github.functions;

import java.util.Arrays;

public class FiveNumbers {
    private static int[] num = new int[5];

    public static void fill() {
        System.out.println("Введите свои четыре числа в формате Число + Enter");
        for (int i = 0; i < 5; i++) {
            System.out.println("Можете вводить");
            num[i] = NumberScanner.getInt();
        }
    }

    public static void minAndMax() {
        Arrays.sort(num);
        System.out.println("Ваше минимальное число : " + num[0]);
        System.out.println("Ваше максимальное число : " + num[4]);
    }

    public static void main(String[] args) {
        fill();
        minAndMax();
    }
}