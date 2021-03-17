package com.github.arraylist.impl;

import com.github.arraylist.IList;

import java.util.Arrays;

public class LList implements IList {

    private class Node {

        private Node next;

        private Integer value;

        public Node(Integer value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return this.next;
        }

        private void setValue(int val) {
            this.value = val;
        }

        public int getValue() {
            return this.value;
        }

    }

    private Node first;

    private Node last;

    private int size;

    public LList() {

        this.first = null;
        this.last = null;
        this.size = 0;

    }

    public LList(int[] init) {
        this.init(init);
    }


    @Override
    public void init(int[] init) throws IllegalArgumentException {

        if (init == null) {
            throw new IllegalArgumentException("Null argument");
        }
        if (init.length == 0) {
            return;
        }
        this.first = new Node(init[0]);
        Node current = this.first;
        for (int i = 1; i < init.length; i++) {
            Node next = new Node(init[i]);
            current.setNext(next);
            current = next;
        }
        this.last = current;
        this.size = init.length;

    }

    @Override
    public void clear() {

        this.first = null;
        this.last = null;
        this.size = 0;

    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int[] toArray() {

        int[] result = new int[this.size];
        Node current = this.first;
        for (int i = 0; i < this.size; i++) {
            result[i] = current.value;
            current = current.getNext();
        }
        return result;

    }

    @Override
    public void addStart(int val) {

        Node newFirst = new Node(val);
        newFirst.setNext(this.first);
        this.first = newFirst;
        if (this.size == 0) {
            this.last = newFirst;
        }
        this.size++;

    }

    @Override
    public void addEnd(int val) {

        Node newFirst = new Node(val);
        if (this.size == 0) {
            this.first = newFirst;
            this.last = newFirst;
        }
        this.last.setNext(newFirst);
        this.last = newFirst;
        this.size++;

    }

    @Override
    public void addByPos(int pos, int val) throws IllegalArgumentException {

        if (pos > size || pos < 0) {
            throw new IllegalArgumentException("Out of list bounds");
        }
        if (pos == 0) {
            addStart(val);
            return;
        }
        if (pos == this.size) {
            addEnd(val);
            return;
        }
        if (this.size == 0) {
            Node newOne = new Node(val);
            this.first = newOne;
            this.last = newOne;
            return;
        }
        Node current = getNode(pos - 1);
        Node newOne = new Node(val);
        newOne.setNext(current.getNext());
        current.setNext(newOne);
        this.size++;

    }

    @Override
    public int removeStart() throws IllegalArgumentException {

        if (size == 0) {
            throw new IllegalArgumentException("Zero elements in list");
        }
        int result = this.first.getValue();
        if (this.size == 1) {
            this.first = null;
            this.last = null;
        } else {
            this.first = this.first.getNext();
        }
        this.size--;
        return result;

    }

    private Node getNode(int pos) {

        if (pos < 0 || pos >= size) {
            throw new IllegalArgumentException("Out of list bounds");
        }
        Node current = this.first;
        for (int i = 0; i < pos; i++) {
            current = current.getNext();
        }
        return current;

    }

    @Override
    public int removeEnd() {

        if (size == 0) {
            throw new IllegalArgumentException("Zero elements in list");
        }
        int result = this.last.getValue();
        if (this.size == 1) {
            this.first = null;
            this.last = null;
        } else {
            Node current = getNode(this.size - 2);
            current.setNext(null);
        }
        this.size--;
        return result;

    }

    @Override
    public int removeByPos(int pos) {

        if (size == 0) {
            throw new IllegalArgumentException("Zero elements in list");
        }
        if (pos == 0) {
            return removeStart();
        }
        Node current = getNode(pos - 1);
        int result = current.getNext().getValue();
        if (this.size == 1) {
            this.first = null;
            this.last = null;
        } else {
            current.setNext(current.getNext().getNext());
        }
        this.size--;
        return result;

    }

    @Override
    public int max() {

        if (this.size == 0) {
            throw new IllegalArgumentException("Zero elements in list");
        }
        int result = this.first.getValue();
        Node current = this.first;
        while (current != null) {
            if (current.getValue() > result) {
                result = current.getValue();
            }
            current = current.getNext();
        }
        return result;

    }

    @Override
    public int min() {

        if (this.size == 0) {
            throw new IllegalArgumentException("Zero elements in list");
        }
        int result = this.first.getValue();
        Node current = this.first;
        while (current != null) {
            if (current.getValue() < result) {
                result = current.getValue();
            }
            current = current.getNext();
        }
        return result;

    }

    @Override
    public int maxPos() {

        if (this.size == 0) {
            throw new IllegalArgumentException("Zero elements in list");
        }
        int result = this.first.getValue();
        int position = 0;
        int index = 0;
        Node current = this.first;
        while (current != null) {
            if (current.getValue() > result) {
                result = current.getValue();
                position = index;
            }
            current = current.getNext();
            index++;
        }
        return position;

    }

    @Override
    public int minPos() {

        if (this.size == 0) {
            throw new IllegalArgumentException("Zero elements in list");
        }
        int result = this.first.getValue();
        int position = 0;
        int index = 0;
        Node current = this.first;
        while (current != null) {
            if (current.getValue() < result) {
                result = current.getValue();
                position = index;
            }
            current = current.getNext();
            index++;
        }
        return position;

    }

    @Override
    public int[] sort() {

        int[] sorted = this.toArray();
        Arrays.sort(sorted);
        this.init(sorted);
        return sorted;

    }

    @Override
    public int get(int pos) {
        return this.getNode(pos).getValue();
    }

    @Override
    public int[] halfReverse() {

        if (this.size == 0 || this.size == 1) {
            return this.toArray();
        }
        Node current = getNode(this.size / 2 - 1);
        if (this.size % 2 == 0) {
            this.last.setNext(this.first);
            this.first = current.getNext();
            this.last = current;
            current.setNext(null);
            return this.toArray();
        } else {
            Node current1 = current.getNext();
            Node newFirst = current1.getNext();
            current1.setNext(this.first);
            this.first = newFirst;
            current.setNext(null);
            this.last.setNext(current1);
            this.last = current;
        }
        return this.toArray();

    }

    @Override
    public int[] reverse() {

        int[] a = this.toArray();
        int k;
        for (int i = 0; i < a.length / 2; i++) {
            k = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = k;
        }
        this.init(a);
        return a;


    }

    @Override
    public void set(int pos, int val) {
        getNode(pos).setValue(val);
    }

}
