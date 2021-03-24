package com.github.trees.impl;

import com.github.trees.ITree;

public class BSTree implements ITree {

    private Node root;

    private static class Node {

        Node left;

        Node right;

        int val;

        public Node(int val) {
            this.val = val;
        }

    }

    public BSTree() {
    }

    public BSTree(int[] init) {

        this.init(init);

    }

    @Override
    public void init(int[] init) {

    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int[] toArray() {
        return new int[0];
    }

    @Override
    public void add(int val) {

    }

    @Override
    public void del(int val) {

    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int nodes() {
        return 0;
    }

    @Override
    public int leaves() {
        return 0;
    }

    @Override
    public void reverse() {
        reverseNode(this.root);
    }

    private void reverseNode(Node p) {

        if (p == null) {
            return;
        }
        Node a = p.right;
        p.right = p.left;
        p.left = a;
        reverseNode(p.left);
        reverseNode(p.right);

    }
}
