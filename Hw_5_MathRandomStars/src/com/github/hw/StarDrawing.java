package com.github.hw;

import java.util.Arrays;

public class StarDrawing {
    public static String[][] generateEmptyBoard(){
        String[][] arr = new String[7][7];
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                arr[i][j] = " ";
            }
        }
        return arr;
    }

    public static void boardShow(String[][] arr){
        for(String[] each : arr){
            System.out.println(Arrays.toString(each));
        }
    }

    public static void figureOne(String[][] arr){
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                arr[i][j] = "*";
            }
        }
    }

    public static void figureTwo(String[][] arr){
        for(int i=0;i<7;i++){
            arr[i][0]="*";
            arr[i][6]="*";
            arr[0][i]="*";
            arr[6][i]="*";
        }
    }

    public static void figureThree(String[][] arr){
        for(int i=0;i<7;i++){
            arr[i][0]="*";
            arr[0][i]="*";
            arr[6-i][i]="*";
        }
    }

    public static void figureFour(String[][] arr){
        for(int i=0;i<7;i++){
            arr[i][0]="*";
            arr[6][i]="*";
            arr[i][i]="*";
        }
    }

    public static void figureFive(String[][] arr){
        for(int i=0;i<7;i++){
            arr[i][6]="*";
            arr[6-i][i]="*";
            arr[6][i]="*";
        }
    }

    public static void figureSix(String[][] arr){
        for(int i=0;i<7;i++){
            arr[i][6]="*";
            arr[0][i]="*";
            arr[i][i]="*";
        }
    }

    public static void figureSeven(String[][] arr){
        for(int i=0;i<7;i++){
            arr[i][i]="*";
            arr[6-i][i]="*";
        }
    }

    public static void figureEight(String[][] arr){
        for(int i=0;i<7;i++){
            arr[0][i]="*";
        }
        for(int i=0;i<4;i++){
            arr[i][i]="*";
            arr[i][6-i]="*";
        }
    }

    public static void figureNine(String[][] arr){
        for(int i=0;i<7;i++){
            arr[6][i]="*";
        }
        for(int i=0;i<4;i++){
            arr[6-i][6-i]="*";
            arr[6-i][i]="*";
        }
    }

    public static void main(String[] args) {
        String[][] arr = generateEmptyBoard();
        figureNine(arr);
        boardShow(arr);
    }
}
