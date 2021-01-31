package com.github.firsthomework;

import java.util.Arrays;
import java.util.Random;

public class OneDimensionalArrays {

    public static int min(int[] a) {
        if (a == null) throw new IllegalArgumentException("Null argument");
        Arrays.sort(a);
        return a[0];
    }

    public static int max(int[] a) {
        if (a == null) throw new IllegalArgumentException("Null argument");
        Arrays.sort(a);
        return a[a.length - 1];
    }

    public static int minIndex(int[] a) {
        if (a == null) throw new IllegalArgumentException("Null argument");
        int min = 1000000000;
        int pointer = 0;
        for (int i = 0; i < a.length; i++) {
            if (min > a[i]) {
                min = a[i];
                pointer = i;
            }
        }
        return pointer;
    }

    public static int maxIndex(int[] a) {
        if (a == null) throw new IllegalArgumentException("Null argument");
        int max = -1000000000;
        int pointer = 0;
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
                pointer = i;
            }
        }
        return pointer;
    }

    public static int sumOfOddNumbers(int[] a) {
        if (a == null) throw new IllegalArgumentException("Null argument");
        int sum = 0;
        for (int i = 1; i < a.length; i += 2) {
            sum += a[i];
        }
        return sum;
    }

    public static int[] arrayReverse(int[] a) {
        if (a == null) throw new IllegalArgumentException("Null argument");
        int k;
        for (int i = 0; i < a.length / 2; i++) {
            k = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = k;
        }
        return a;
    }

    public static int numberOfOddNumbers(int[] a) {
        if (a == null) throw new IllegalArgumentException("Null argument");
        return a.length / 2; // Если за нечетные числа брать числа с нечетными индексами
    }

    public static int[] changeParts(int[] a) {
        if (a == null) throw new IllegalArgumentException("Null argument");
        int k;
        if (a.length % 2 == 1) {
            for (int i = 0; i < a.length / 2; i++) {
                k = a[i];
                a[i] = a[i + a.length / 2 + 1];
                a[i + a.length / 2 + 1] = k;
            }
        } else {
            for (int i = 0; i < a.length / 2; i++) {
                k = a[i];
                a[i] = a[i + a.length / 2];
                a[i + a.length / 2] = k;
            }
        }
        return a;
    }

    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = random.nextInt(200);
        }
        return a;
    }

    public static int[] sortWithBubble(int[] a) {
        if (a == null) throw new IllegalArgumentException("Null argument");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(j, j + 1, a);
                }
            }
        }
        return a;
    }

    public static int[] sortWithSelection(int[] a) {
        if (a == null) throw new IllegalArgumentException("Null argument");
        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            int point = i;
            for (int j = i; j < a.length; j++) {
                if (a[j] < min) {
                    point = j;
                    min = a[j];
                }
            }
            swap(i, point, a);
        }
        return a;
    }

    public static int[] sortWithInsertion(int[] a) {
        if (a == null) throw new IllegalArgumentException("Null argument");
        for (int i = 0; i < a.length; i++) {
            int pointer = i;
            while (pointer != 0 && a[pointer] < a[pointer - 1]) {
                swap(pointer, pointer - 1, a);
                pointer--;
            }
        }
        return a;
    }

    private static void swap(int a, int b, int[] array) {
        int c = array[a];
        array[a] = array[b];
        array[b] = c;
    }

    public static int[] quickSort(int low, int high, int[] a) {
        if (a == null) throw new IllegalArgumentException("Null argument");
        if (a.length == 0) return null;
        if (low < high) {
            int mid = low + (high - low) / 2;
            int l = low;
            int h = high;
            int op = a[mid];
            while (l <= h) {
                while (a[l] < op) {
                    l++;
                }
                while (a[h] > op) {
                    h--;
                }
                if (l <= h) {
                    swap(l, h, a);
                    h--;
                    l++;
                }
            }
            if (low < h) quickSort(low, h, a);
            if (high > l) quickSort(l, high, a);
        }
        return a;
    }

}
