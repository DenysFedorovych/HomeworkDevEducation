package com.github.trees.impl;

import com.github.trees.ITree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BSTree implements ITree {

    private Node root;

    private int size;

    private static class Node {

        Node parent;
        Node left;
        Node right;
        int val;

        public Node(int val, Node parent) {
            this.val = val;
            this.parent = parent;
        }

    }

    public BSTree() {
        this.size = 0;
    }

    public BSTree(int[] init) {
        this.init(init);
    }

    @Override
    public void init(int[] init) {
        if(init == null) {throw new IllegalArgumentException("Null argument");}
        for (int each : init) {
            this.add(each);
        }
    }

    @Override
    public void clear() {
        this.root = null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int[] toArray() {
        List<Integer> result = new LinkedList<>();
        toArrayNode(this.root, result);
        Object[] array = result.toArray();
        int[] arr = new int[this.size];
        for(int i = 0; i < array.length; i++){
            arr[i] = (int) array[i];
        }
        return arr;
    }

    private void toArrayNode(Node current, List arr) {
        if (current == null) return;
        toArrayNode(current.left, arr);
        arr.add(current.val);
        toArrayNode(current.right, arr);
    }

    @Override
    public void add(int val) {
        if (this.size == 0) {
            this.root = new Node(val, null);
        } else {
            addNode(this.root, val);
        }
        this.size++;
    }

    private void addNode(Node current, int val) {
        if (current.val > val) {
            if (current.left != null) addNode(current.left, val);
            else {
                current.left = new Node(val, current);
            }
        } else {
            if (current.right != null) addNode(current.right, val);
            else {
                current.right = new Node(val, current);
            }
        }
    }

    @Override
    public void del(int val) {
        if (this.size == 0) {
            throw new IllegalArgumentException("Zero elements in tree");
        }
        Node node = this.getNode(val, this.root);
        drown(node);
    }

    private void drown(Node current) {
        if (current.right != null) {
            swapNeighbours(current, true);
            drown(current.right);
        } else {
            if (current.left != null) {
                swapNeighbours(current, false);
                drown(current.left);
            } else {
                current = null;
            }
        }
    }

    private void swapNeighbours(Node node, boolean right) {
        boolean parent_right = false;
        if (node.parent.right != null && node.parent.right == node) parent_right = true;
        Node newNodeTop;
        Node newNodeBottom;
        if (right) {
            newNodeTop = new Node(node.right.val, node.parent);
            newNodeBottom = new Node(node.val, newNodeTop);
            newNodeTop.right = newNodeBottom;
            newNodeTop.left = node.left;
            newNodeBottom.right = node.right.right;
            newNodeBottom.left = node.right.left;
        } else {
            newNodeTop = new Node(node.left.val, node.parent);
            newNodeBottom = new Node(node.val, newNodeTop);
            newNodeTop.left = newNodeBottom;
            newNodeTop.right = node.right;
            newNodeBottom.right = node.left.right;
            newNodeBottom.left = node.left.left;
        }
        if (parent_right) node.parent.right = newNodeTop;
        else node.parent.left = newNodeTop;
    }

    private Node getNode(int val, Node current) {
        if (current == null) throw new IllegalArgumentException("No such element in tree");
        if (current.val == val) return current;
        if (current.val > val) return getNode(val, current.left);
        return getNode(val, current.right);
    }

    @Override
    public int getWidth() {
        Node current = this.root;
        if (current == null) return 0;
        int width = 1;
        while (current.left != null) {
            current = current.left;
            width++;
        }
        current = this.root;
        while (current.right != null) {
            current = current.right;
            width++;
        }
        return width;
    }

    @Override
    public int getHeight() {
        return getHeight(this.root, 0, 0);
    }

    private int getHeight(Node current, Integer max, int height) {
        if (current == null) return max;
        if (current.right == null && current.left == null) {
            max = Math.max(max, height);
        }
        getHeight(current.right, max, height++);
        getHeight(current.left, max, height++);
        return max;
    }

    @Override
    public int nodes() {
        return this.size - leaves();
    }

    @Override
    public int leaves() {
        return leaves(this.root,0);
    }

    private int leaves(Node current, Integer count) {
        if (current == null) return 0;
        if (current.right == null && current.left == null) {
            count++;
        }
        leaves(current.left, count);
        leaves(current.right, count);
        return count;
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
