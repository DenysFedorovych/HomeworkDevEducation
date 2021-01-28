package com.github.functions;

public class TeskaDecector {
    public static void detectNameEquality(String name1, String name2) {
        if (name1.equals(name2)) System.out.println("О, да вы тёзки!");
        else System.out.println("Имена не совпали");
    }

    public static void main(String[] args) {
        System.out.println("Введите имя первого человека : ");
        String name1 = NumberScanner.getName();
        System.out.println("Введите имя второго человека : ");
        String name2 = NumberScanner.getName();
        detectNameEquality(name1, name2);
    }
}
