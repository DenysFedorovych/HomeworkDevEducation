package com.github.arraylist;

public interface IList {

    void init(int[] init) throws IllegalArgumentException;

    void clear();

    int size();

    int[] toArray();

    void addStart(int val);

    void addEnd(int val);

    void addByPos(int pos, int val) throws IllegalArgumentException;

    int removeStart() throws IllegalArgumentException;

    int removeEnd();

    int removeByPos(int pos);

    int max();

    int min();

    int maxPos();

    int minPos();

    int[] sort();

    int get(int pos);

    int[] halfReverse();

    int[] reverse();

    void set(int pos, int val);

}