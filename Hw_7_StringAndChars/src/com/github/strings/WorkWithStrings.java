package com.github.strings;

import java.util.HashSet;

public class WorkWithStrings {
    public static int shortestWord(String input){
        String[] arr = input.split("\\s,\\.;:");
        int a = arr[0].length();
        for(int i = 0; i<arr.length;i++){
            a = Math.min(a,arr[i].length());
        }
        return a;
    }

    public static void replaceLast(String[] arr, int length){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].length()==length){
                arr[i] = arr[i].substring(0,arr[i].length()-3)+"$$$";
            }
        }
    }

    public static String stringWithSpaces(String input) {

        if (input == null) {
            return null;
        }

        if (input.length() == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int counter = 0;

        while (counter < input.length() - 1) {
            result.append(input.charAt(counter));
            if (input.substring(counter, counter + 2).matches("[\\.:,\\?!][^\\s]")) {
                result.append(' ');
            }
            counter++;
        }

        result.append(input.charAt(counter++));
        if (input.substring(input.length() - 1).matches("[\\.:,\\?!]")) {
            result.append(' ');
        }

        return result.toString();
    }

    public static String eachSymbolOnce(String in){
        StringBuilder result = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < in.length(); i++) {
            if(set.add(in.charAt(i))) {result.append(in.charAt(i));}
        }
        return result.toString();
    }

    public static int numberOfWords(String in){
        return in.split("[\\s\\t\\n,\\.\\?\\!]*").length;
    }

    public static String partlyDeletedString(String in, int begin, int length){
        StringBuilder result = new StringBuilder();
        result.append(in.substring(0,begin));
        result.append(in.substring(begin+length));
        return result.toString();
    }

    public static String reverse(String in){
        StringBuilder result = new StringBuilder(in);
        return result.reverse().toString();
    }

    public static String deleteLastWord(String in){
        return in.trim().substring(0,in.lastIndexOf(' '));
    }
    

}
