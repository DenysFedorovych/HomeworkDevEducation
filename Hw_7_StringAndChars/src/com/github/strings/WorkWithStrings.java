package com.github.strings;

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

}
