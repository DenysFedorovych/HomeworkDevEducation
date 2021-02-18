package com.github.strings;

public class NumberParser {
    public static String toString(int a){
        StringBuilder res = new StringBuilder();
        while(a!=0){
            res.append(a%10);
            a/=10;
        }
        return res.reverse().toString();
    }

    public static String toString(double a){
        StringBuilder res = new StringBuilder();
        int b = (int) a;
        res.append(toString(b));
        res.append('.');
        a-=b;
        while(a%10!=0) {a*=10;}
        a/=10;
        res.append(toString((int) a));
        return res.toString();
    }

    public static int toNumber(String a){
        int order = 1;
        int result = 0;
        for (int i = a.length()-1; i >=0; i--) {
            result+= toDigit(a.charAt(i))*order;
            order*=10;
        }
        return result;
    }

    private static int toDigit(char a){
        return a - '0';
    }

    public static double toNumberDouble(String a){
        double result = 0;
        String[] arr = a.split("\\.");
        result +=toNumber(arr[0]);
        double b = toNumber(arr[1]);
        b/= Math.pow(10,arr[1].length());
        result+=b;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(toNumberDouble("12345.68"));
    }
}
