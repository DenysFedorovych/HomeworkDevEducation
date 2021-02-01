package com.github.firsthomework;

public class Functions {
    public static String dayOfWeek(int a){
        String[] week = {"Понедельник","Вторник","Среда","Четверг","Пятница","Суббота","Воскресенье"};
        if(a<1||a>7) throw new IllegalArgumentException("В неделе семь дней!");
        return week[a-1];
    }

    public static double distance(double x1, double y1, double x2, double y2){
        double deltaX = x1-x2;
        double deltaY = y1-y2;
        return Math.sqrt(Math.pow(deltaX,2)+Math.pow(deltaY,2));
    }

}
