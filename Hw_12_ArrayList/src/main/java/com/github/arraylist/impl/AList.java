package com.github.arraylist.impl;

import com.github.arraylist.IList;

import java.util.Arrays;
import java.util.Collections;

public class AList implements IList {

    private Integer[] array;

    private int size;

    private final int INITIAL_CAPACITY = 10;

    public AList() {

        this.array = new Integer[this.INITIAL_CAPACITY];
        this.size = 0;

    }

    public AList(int[] init) {

        this.init(init);

    }

    //TODO write tests

    private int newCapacity(int capacity) {
        return capacity * 3 / 2 + 1;
    }

    private int newMinCapacity(int capacity) {

        int result = capacity * 2 / 3 + 1;
        if (result < INITIAL_CAPACITY) return INITIAL_CAPACITY;
        return result;

    }

    private boolean isFull() {
        return this.size + 1 == this.array.length;
    }

    private boolean isEmpty() {
        return this.size < this.array.length / 2 + 1;
    }

    private void changeSize() {

        if (isFull()) {
            Integer[] newArray = new Integer[newCapacity(this.array.length)];
            for (int i = 0; i < this.size; i++) {
                newArray[i] = this.array[i];
            }
            this.array = newArray;
            return;
        }

        if (isEmpty()) {
            Integer[] newArray = new Integer[newMinCapacity(this.array.length)];
            for (int i = 0; i < this.size; i++) {
                newArray[i] = this.array[i];
            }
            this.array = newArray;
        }

    }

    public void init(int[] init) {

        this.size = init.length;
        this.array = new Integer[newCapacity(this.size)];
        for (int i = 0; i < this.size; i++) {
            this.array[i] = init[i];
        }

    }

    public void clear() {
        this.array = new Integer[this.INITIAL_CAPACITY];
    }

    public int size() {
        return this.size;
    }

    public int[] toArray() {

        int[] result = new int[this.size];
        for (int i = 0; i < size; i++) {
            result[i] = this.array[i];
        }
        return result;

    }

    public void addStart(int val) {

        this.changeSize();
        for (int i = 0; i < size; i++) {
            this.array[size - i] = this.array[size - i - 1];
        }
        this.array[0] = val;
        size++;

    }

    public void addEnd(int val) {

        changeSize();
        this.array[size] = val;
        size++;

    }

    public void addByPos(int pos, int val) {

        if (pos > size || pos < 0) {
            throw new IllegalArgumentException("Out of list bounds");
        }
        changeSize();
        for (int i = 0; i < size - pos; i++) {
            this.array[size - i] = this.array[size - i - 1];
        }
        this.array[pos] = val;
        size++;

    }

    public int removeStart() {

        if (size == 0) {
            throw new IllegalArgumentException("Nothing to delete");
        }
        changeSize();
        int val = this.array[0];
        for (int i = 0; i < size - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        size--;
        return val;

    }

    //Test-1

    public int removeEnd() {

        if (size == 0) {
            throw new IllegalArgumentException("Nothing to delete");
        }
        changeSize();
        int val = this.array[size - 1];
        this.array[size - 1] = null;
        size--;
        return val;

    }

    public int removeByPos(int pos) {

        if (size == 0) {
            throw new IllegalArgumentException("Nothing to delete");
        }
        changeSize();
        int val = this.array[pos];
        for (int i = 0; i < size - pos - 1; i++) {
            this.array[pos + i] = this.array[pos + i + 1];
        }
        size--;
        return val;

    }

    public int max() {
        return this.array[maxPos()];
    }

    public int min() {
        return this.array[minPos()];
    }

    public int maxPos() {

        int maxVal = this.array[0];
        int maxPos = 0;
        for (int i = 1; i < size; i++) {
            if (maxVal < this.array[i]) {
                maxVal = this.array[i];
                maxPos = i;
            }
        }
        return maxPos;

    }

    public int minPos() {

        int minVal = this.array[0];
        int minPos = 0;
        for (int i = 1; i < size; i++) {
            if (minVal > this.array[i]) {
                minVal = this.array[i];
                minPos = i;
            }
        }
        return minPos;

    }

    public int[] sort() {

        Arrays.sort(this.array);
        return this.toArray();

    }

    public int get(int pos) {

        if(pos > size - 1 || pos < 0){
            throw new IllegalArgumentException("Out of list bounds");
        }
        return this.array[pos];

    }

    public int[] halfReverse() {

            int k;
            int[] a = this.toArray();
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

    public int[] reverse() {

        int[] a = this.toArray();
        int k;
        for (int i = 0; i < a.length / 2; i++) {
            k = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = k;
        }
        return a;

    }

    public void set(int pos, int val) {

        if(pos > size - 1 || pos < 0){
            throw new IllegalArgumentException("Out of list bounds");
        }
        this.array[pos] = val;

    }
}
