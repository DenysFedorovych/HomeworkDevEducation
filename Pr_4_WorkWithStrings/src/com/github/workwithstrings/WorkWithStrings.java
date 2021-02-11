package com.github.workwithstrings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorkWithStrings {

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

    public static String replaceBackslash(String input) {
        if (input == null) {
            return null;
        }

        if (input.length() == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i)=='/'){
                result.append('\\');
            }
            else{
                result.append(input.charAt(i));
            }
        }

        return result.toString();
    }

    public static boolean isValid(String input) {
        if(input==null||input.isEmpty()){
            return false;
        }
        Pattern pattern = Pattern.compile("[\\/\\\\:\\*\\?\"\\>\\<\\|\\+]|[\\.\\s]$");
        Matcher matcher = pattern.matcher(input);
        return !matcher.find();
    }

    public static boolean isDiskPath(String input) {
        if(input==null||input.isEmpty()){
            return false;
        }
        Pattern pattern = Pattern.compile("^[A-Z]\\:\\\\");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    public static void main(String[] args) {
        System.out.println(isDiskPath("\\Program Files\\Custom Utilities\\StringFinder.exe"));
    }
}
