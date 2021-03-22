package com.github.arraylist;

import java.util.Comparator;

public interface IListGenerics<T extends Comparable>{

    void init(T[] init);

    void clear();

    int size();

    T[] toArray();

    void addStart(T val);

    void addEnd(T val);

    void addByPos(int pos, T val);

    T removeStart();

    T removeEnd();

    T removeByPos(int pos);

    T max();

    T min();

    int maxPos();

    int minPos();

    T[] sort();

    T get(int pos);

    T[] halfReverse();

    T[] reverse();

    void set(int pos, T val);

}
