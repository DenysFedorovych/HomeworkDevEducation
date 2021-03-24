package com.github.trees;

public interface ITree {

    void init(int[] init);

    void clear();

    int size();

    int[] toArray();

    void add(int val);

    void del(int val);

    int getWidth();

    int getHeight();

    int nodes();

    int leaves();

    void reverse();
}
