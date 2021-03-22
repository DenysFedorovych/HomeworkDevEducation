package com.github.arraylist.impl;

import com.github.arraylist.IListGenerics;

import java.util.Arrays;

public class AListGenerics<T extends Comparable<T>> implements IListGenerics<T> {

    private Comparable[] array;

    private int size;

    private final int INITIAL_CAPACITY = 10;

    public AListGenerics() {

        this.array = new Comparable[this.INITIAL_CAPACITY];
        this.size = 0;

    }

    public AListGenerics(T[] init) {

        this.init(init);

    }

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
            Comparable[] newArray = new Comparable[newCapacity(this.array.length)];
            for (int i = 0; i < this.size; i++) {
                newArray[i] = this.array[i];
            }
            this.array = newArray;
            return;
        }

        if (isEmpty()) {
            Comparable[] newArray = new Comparable[newMinCapacity(this.array.length)];
            for (int i = 0; i < this.size; i++) {
                newArray[i] = this.array[i];
            }
            this.array = newArray;
        }

    }

    @Override
    public void init(T[] init) {

        if(init == null){
            throw new IllegalArgumentException("Null argument");
        }
        this.size = init.length;
        this.array = new Comparable[newCapacity(this.size)];
        for (int i = 0; i < this.size; i++) {
            this.array[i] = init[i];
        }

    }

    @Override
    public void clear() {

        this.array = new Comparable[this.INITIAL_CAPACITY];
        this.size = 0;

    }

    public int size() {
        return this.size;
    }

    @Override
    public T[] toArray() {

        Comparable[] result = new Comparable[this.size];
        for (int i = 0; i < size; i++) {
            result[i] = this.array[i];
        }
        return (T[]) result;

    }

    @Override
    public void addStart(T val) {

        this.changeSize();
        for (int i = 0; i < size; i++) {
            this.array[size - i] = this.array[size - i - 1];
        }
        this.array[0] = val;
        size++;

    }

    @Override
    public void addEnd(T val) {

        changeSize();
        this.array[size] = val;
        size++;

    }

    @Override
    public void addByPos(int pos, T val) {

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

    @Override
    public T removeStart() {

        if (size == 0) {
            throw new IllegalArgumentException("Nothing to delete");
        }
        changeSize();
        T val = (T) this.array[0];
        for (int i = 0; i < size - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        size--;
        return val;

    }

    @Override
    public T removeEnd() {

        if (size == 0) {
            throw new IllegalArgumentException("Nothing to delete");
        }
        changeSize();
        T val = (T) this.array[size - 1];
        this.array[size - 1] = null;
        size--;
        return val;

    }

    @Override
    public T removeByPos(int pos) {

        if (size == 0) {
            throw new IllegalArgumentException("Nothing to delete");
        }
        changeSize();
        T val = (T) this.array[pos];
        for (int i = 0; i < size - pos - 1; i++) {
            this.array[pos + i] = this.array[pos + i + 1];
        }
        size--;
        return val;

    }

    @Override
    public T max() {

        if(this.size == 0){
            throw new IllegalArgumentException("Zero elements in list");
        }
        return (T) this.array[maxPos()];

    }

    @Override
    public T min() {

        if(this.size == 0){
            throw new IllegalArgumentException("Zero elements in list");
        }
        return (T) this.array[minPos()];

    }

    @Override
    public int maxPos() {

        if(this.size == 0){
            throw new IllegalArgumentException("Zero elements");
        }
        T maxVal = (T) this.array[0];
        int maxPos = 0;
        for (int i = 1; i < size; i++) {
            if (maxVal.compareTo((T) this.array[i]) < 0) {
                maxVal = (T) this.array[i];
                maxPos = i;
            }
        }
        return maxPos;

    }

    @Override
    public int minPos() {

        if(this.size == 0){
            throw new IllegalArgumentException("Zero elements");
        }
        T minVal = (T) this.array[0];
        int minPos = 0;
        for (int i = 1; i < size; i++) {
            if (minVal.compareTo((T) this.array[i]) > 0) {
                minVal = (T) this.array[i];
                minPos = i;
            }
        }
        return minPos;

    }

    @Override
    public T[] sort() {

        T[] sorted = this.toArray();
        Arrays.sort(sorted);
        for(int i = 0; i < size; i++){
            this.array[i] = sorted[i];
        }
        return sorted;

    }

    @Override
    public T get(int pos) {

        if(pos > size - 1 || pos < 0){
            throw new IllegalArgumentException("Out of list bounds");
        }
        return (T) this.array[pos];

    }

    @Override
    public T[] halfReverse() {

        T k;
        T[] a = this.toArray();

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
        this.init(a);
        return a;

    }

    @Override
    public T[] reverse() {

        T[] a = (T[]) new Comparable[this.size];
        for (int i = 0; i < this.size; i++) {
            a[i] = (T) this.array[i];
        }
        T k;
        for (int i = 0; i < a.length / 2; i++) {
            k = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = k;
        }
        this.init(a);
        return a;

    }

    @Override
    public void set(int pos, T val) {

        if(pos > size - 1 || pos < 0){
            throw new IllegalArgumentException("Out of list bounds");
        }
        this.array[pos] = val;

    }

}
