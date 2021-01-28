package com.github.functions;

public class TimeOfYear {
    public static void detectTime(int month){
        switch(month){
            case 3 :
            case 4 :
            case 5 :
                System.out.println("Сейчас весна");
                break;
            case 6 :
            case 7 :
            case 8 :
                System.out.println("Сейчас лето");
                break;
            case 9 :
            case 10 :
            case 11 :
                System.out.println("Сейчас осень");
                break;
            case 12 :
            case 2 :
            case 1 :
                System.out.println("Сейчас зима");
                break;

        }
    }

    public static void main(String[] args) {
        System.out.println("Введите номер месяца : ");
        int month = NumberScanner.getInt();
        detectTime(month);
    }
}
