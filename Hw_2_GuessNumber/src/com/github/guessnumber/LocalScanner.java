package com.github.guessnumber;

import java.util.Scanner;

public class LocalScanner {
    public static int min;
    public static int max;
    private static Scanner scanner = new Scanner(System.in);
    public static int getMin(){
        System.out.println("Скажи мне нижнюю границу чисел (больше 1 и меньше 200)");
        min = scanner.nextInt();
        while (min < 1 || min > 200) {
            System.out.println("Число не подходит, давай по новой");
            min = scanner.nextInt();
        }
        return min;
    }

    public static int getMax(){
        System.out.println("Скажи мне верхнюю границу чисел (больше 1, меньше 200 и не меньше нижней границы)");
        max = scanner.nextInt();
        while (max < 1 || max > 200 || max < min) {
            System.out.println("Условия не выполнены, пробуй еще");
            max = scanner.nextInt();
        }
        return max;
    }

    public static int getTries(){
        System.out.println("За сколько попыток угадаешь? (минимум - 1, максимум - 15)");
        int tries = scanner.nextInt();
        while (tries < 1 || tries > 15) {
            System.out.println("Ну ты что, читать не умеешь?");
            tries = scanner.nextInt();
        }
        return tries;
    }

    public static String getString(){
        return scanner.next();
    }
}
