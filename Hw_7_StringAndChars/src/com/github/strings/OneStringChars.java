package com.github.strings;

public class OneStringChars {
    public static String fromAtoZ(){
        StringBuilder res = new StringBuilder();
        for (char i = 'a'; i <= 'z'; i++) {
            res.append(i);
        }
        return res.toString();
    }

    public static String fromatoz(){
        StringBuilder res = new StringBuilder();
        for (char i = 'z'; i >= 'a'; i--) {
            res.append(i);
        }
        return res.toString();
    }

    public static String otAdoYa(){
        StringBuilder res = new StringBuilder();
        for (char i = 'а'; i <= 'я'; i++) {
            res.append(i);
        }
        return res.toString();
    }

    public static String from0to9(){
        StringBuilder res = new StringBuilder();
        for (char i = '0'; i <= '9'; i++) {
            res.append(i);
        }
        return res.toString();
    }

    public static String printedRangeASCII(){
        StringBuilder res = new StringBuilder();
        for (char i = 32; i <= 126; i++) {
            res.append(i);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(printedRangeASCII());
    }
}
