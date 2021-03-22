package com.github.arraylist.impl;

import com.github.arraylist.IListGenerics;

import java.util.Arrays;

public class LListGenerics<T extends Comparable<T>> implements IListGenerics<T> {

    private class Node<T> {

        private LListGenerics.Node next;

        private LListGenerics.Node previous;

        private T value;

        public Node(T value) {
            this.value = value;
        }

        public Node(Node<T> node){

            this.setPrevious(node.getPrevious());
            this.setNext(node.getNext());
            this.setValue(node.getValue());

        }

        public void setNext(LListGenerics.Node next) {
            this.next = next;
        }

        public LListGenerics.Node getNext() {
            return this.next;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        private void setValue(T val) {
            this.value = val;
        }

        public Node getPrevious() {
            return previous;
        }

        public T getValue() {
            return this.value;
        }

    }

    private Node first;

    private Node last;

    private int size;

    public LListGenerics() {

        this.first = null;
        this.last = null;
        this.size = 0;

    }

    public LListGenerics(T[] init) {
        this.init(init);
    }


    @Override
    public void init(T[] init) throws IllegalArgumentException {

        if (init == null) {
            throw new IllegalArgumentException("Null argument");
        }
        if (init.length == 0) {
            return;
        }
        this.first = new Node(init[0]);
        this.first.setPrevious(null);
        Node current = this.first;
        for (int i = 1; i < init.length; i++) {
            Node next = new Node(init[i]);
            current.setNext(next);
            next.setPrevious(current);
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
    public T[] toArray() {

        Comparable[] result = new Comparable[this.size];
        Node current = this.first;
        for (int i = 0; i < this.size; i++) {
            result[i] = (Comparable) current.value;
            current = current.getNext();
        }
        return (T[]) result;

    }

    @Override
    public void addStart(T val) {

        Node newFirst = new Node(val);
        if (this.size == 0) {
            this.first = newFirst;
            this.last = newFirst;
        }
        newFirst.setNext(this.first);
        this.first.setPrevious(newFirst);
        this.first = newFirst;
        this.size++;

    }

    @Override
    public void addEnd(T val) {

        Node newFirst = new Node(val);
        if (this.size == 0) {
            this.first = newFirst;
            this.last = newFirst;
        }
        newFirst.setPrevious(this.last);
        this.last.setNext(newFirst);
        this.last = newFirst;
        this.size++;

    }

    @Override
    public void addByPos(int pos, T val) throws IllegalArgumentException {

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
        Node newOne = new Node(val);
        if (this.size == 0) {
            this.first = newOne;
            this.last = newOne;
            return;
        }
        Node current = getNode(pos - 1);
        newOne.setNext(current.getNext());
        newOne.setPrevious(current);
        current.setNext(newOne);
        this.size++;

    }

    @Override
    public T removeStart() throws IllegalArgumentException {

        if (size == 0) {
            throw new IllegalArgumentException("Zero elements in list");
        }
        T result = (T) this.first.getValue();
        if (this.size == 1) {
            this.first = null;
            this.last = null;
        } else {
            this.first = this.first.getNext();
            this.first.setPrevious(null);
        }
        this.size--;
        return result;

    }

    private Node getNode(int pos) {

        if (pos < 0 || pos >= size) {
            throw new IllegalArgumentException("Out of list bounds");
        }
        Node current;
        if (pos < size / 2) {
            current = this.first;
            for (int i = 0; i < pos; i++) {
                current = current.getNext();
            }
        } else {
            current = this.last;
            for(int i = 0; i < size - pos - 1; i++){
                current = current.getPrevious();
            }
        }
        return current;

    }

    @Override
    public T removeEnd() {

        if (size == 0) {
            throw new IllegalArgumentException("Zero elements in list");
        }
        T result = (T) this.last.getValue();
        if (this.size == 1) {
            this.first = null;
            this.last = null;
        } else {
            Node current = this.last.getPrevious();
            current.setNext(null);
            this.last.setPrevious(null);
            this.last = current;
        }
        this.size--;
        return result;

    }

    @Override
    public T removeByPos(int pos) {

        if (size == 0) {
            throw new IllegalArgumentException("Zero elements in list");
        }
        if (pos == 0) {
            return removeStart();
        }
        if(pos == this.size - 1){
            return removeEnd();
        }
        Node current = getNode(pos - 1);
        T result = (T) current.getNext().getValue();
        if (this.size == 1) {
            this.first = null;
            this.last = null;
        } else {
            current.setNext(current.getNext().getNext());
            current.getNext().setPrevious(current);
        }
        this.size--;
        return result;

    }

    @Override
    public T max() {

        if (this.size == 0) {
            throw new IllegalArgumentException("Zero elements in list");
        }
        T result = (T) this.first.getValue();
        Node current = this.first;
        while (current != null) {
            if (result.compareTo((T) current.getValue()) < 0) {
                result = (T) current.getValue();
            }
            current = current.getNext();
        }
        return result;

    }

    @Override
    public T min() {

        if (this.size == 0) {
            throw new IllegalArgumentException("Zero elements in list");
        }
        T result = (T) this.first.getValue();
        Node current = this.first;
        while (current != null) {
            if (result.compareTo((T) current.getValue()) > 0) {
                result = (T) current.getValue();
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
        T result = (T) this.first.getValue();
        int position = 0;
        int index = 0;
        Node current = this.first;
        while (current != null) {
            if (result.compareTo((T) current.getValue()) < 0) {
                result = (T) current.getValue();
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
        T result = (T) this.first.getValue();
        int position = 0;
        int index = 0;
        Node current = this.first;
        while (current != null) {
            if (result.compareTo((T) current.getValue()) > 0) {
                result = (T) current.getValue();
                position = index;
            }
            current = current.getNext();
            index++;
        }
        return position;

    }

    @Override
    public T[] sort() {

        T[] sorted = this.toArray();
        Arrays.sort(sorted);
        this.init(sorted);
        return sorted;

    }

    @Override
    public T get(int pos) {
        return (T) this.getNode(pos).getValue();
    }

    @Override
    public T[] halfReverse() {

        if (this.size == 0 || this.size == 1) {
            return this.toArray();
        }
        Node current = getNode(this.size / 2 - 1);
        if (this.size % 2 == 0) {
            this.last.setNext(this.first);
            this.first.setPrevious(this.last);
            this.first = current.getNext();
            current.getNext().setPrevious(null);
            this.last = current;
            current.setNext(null);
        } else {
            Node current1 = current.getNext();
            Node newFirst = current1.getNext();
            current1.setNext(this.first);
            this.first.setPrevious(current1);
            this.first = newFirst;
            current.setNext(null);
            this.last.setNext(current1);
            current1.setPrevious(this.last);
            this.last = current;
        }
        return this.toArray();

    }

    @Override
    public T[] reverse() {

        T[] a = this.toArray();
        T k;
        for (int i = 0; i < a.length / 2; i++) {
            k = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = k;
        }
        this.init(a);
        return this.toArray();

    }

    @Override
    public void set(int pos, T val) {
        getNode(pos).setValue(val);
    }

}
