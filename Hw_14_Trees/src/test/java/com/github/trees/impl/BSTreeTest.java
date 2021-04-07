package com.github.trees.impl;

import com.github.trees.ITree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.*;

public class BSTreeTest {

    private ITree iTree;

    private final static int[] ten = {1, 2, 45, 32, 15, 128, 424, 567, 222, 904};

    private final static int[] one = {65};

    private final static int[] two = {5, 9};

    private final static int[] zero = {};

    private final static int num1 = 43;

    private final static int[] tenSorted = {1, 2, 15, 32, 45, 128, 222, 424, 567, 904};

    private final static int[] oneSorted = {65};

    private final static int[] twoSorted = {5, 9};

    private final static int[] zeroSorted = {};

    @Before
    public void initialize(){
        this.iTree = new BSTree();
    }

    //===========================================================================
    //==============================  Init tests  ===============================
    //===========================================================================

    @Test
    public void initMany() {

        iTree.init(ten);
        Assert.assertArrayEquals(iTree.toArray(),tenSorted);

    }

    @Test
    public void initOne() {

        iTree.init(one);
        Assert.assertArrayEquals(iTree.toArray(), oneSorted);

    }

    @Test
    public void initTwo() {

        iTree.init(two);
        Assert.assertArrayEquals(iTree.toArray(), twoSorted);

    }

    @Test
    public void initZero() {

        iTree.init(zero);
        Assert.assertArrayEquals(iTree.toArray(), zeroSorted);

    }

    @Test(expected = IllegalArgumentException.class)
    public void initNull() {

        iTree.init(null);

    }

    //===========================================================================
    //==============================  Clear tests  ==============================
    //===========================================================================

    @Test
    public void clearMany() {

        iTree.init(ten);
        iTree.clear();
        Assert.assertArrayEquals(iTree.toArray(), zero);

    }

    @Test
    public void clearOne() {

        iTree.init(one);
        iTree.clear();
        Assert.assertArrayEquals(iTree.toArray(), zero);

    }

    @Test
    public void clearTwo() {

        iTree.init(two);
        iTree.clear();
        Assert.assertArrayEquals(iTree.toArray(), zero);

    }

    @Test
    public void clearZero() {

        iTree.init(zero);
        iTree.clear();
        Assert.assertArrayEquals(iTree.toArray(), zero);

    }

    //===========================================================================
    //============================== Size tests  ================================
    //===========================================================================

    @Test
    public void sizeMany() {

        iTree.init(ten);
        Assert.assertEquals(iTree.size(), 10);

    }

    @Test
    public void sizeOne() {

        iTree.init(one);
        Assert.assertEquals(iTree.size(), 1);

    }

    @Test
    public void sizeTwo() {

        iTree.init(two);
        Assert.assertEquals(iTree.size(), 2);

    }

    @Test
    public void sizeZero() {

        iTree.init(zero);
        Assert.assertEquals(iTree.size(), 0);

    }

    //===========================================================================
    //============================= ToArray tests  ==============================
    //===========================================================================

    @Test
    public void toArrayMany() {
        ITree iTree = new BSTree(ten);
        Assert.assertArrayEquals(iTree.toArray(), tenSorted);
    }

    @Test
    public void toArrayOne() {
        ITree iTree = new BSTree(one);
        Assert.assertArrayEquals(iTree.toArray(), one);
    }

    @Test
    public void toArrayTwo() {
        ITree iTree = new BSTree(two);
        Assert.assertArrayEquals(iTree.toArray(), twoSorted);
    }

    @Test
    public void toArrayZero() {
        ITree iTree = new BSTree(zero);
        Assert.assertArrayEquals(iTree.toArray(), zero);
    }

    //===========================================================================
    //=============================== Add tests  ================================
    //===========================================================================

    @Test
    public void addMany() {
        ITree iTree = new BSTree(ten);
        int[] res = {1, 2, 15, 32, 45, 128, 222, 424, 567, 904, 1000};
        iTree.add(1000);
        Assert.assertArrayEquals(iTree.toArray(), res);
    }

    @Test
    public void addTwo() {
        ITree iTree = new BSTree(two);
        int[] res = {5, 9, 1000};
        iTree.add(1000);
        Assert.assertArrayEquals(iTree.toArray(), res);
    }

    @Test
    public void addOne() {
        ITree iTree = new BSTree(one);
        int[] res = {65, 1000};
        iTree.add(1000);
        Assert.assertArrayEquals(iTree.toArray(), res);
    }

    @Test
    public void addZero() {
        ITree iTree = new BSTree(zero);
        int[] res = {1000};
        iTree.add(1000);
        Assert.assertArrayEquals(iTree.toArray(), res);
    }

    //===========================================================================
    //============================= Delete test  ================================
    //===========================================================================

    @Test
    public void delMany() {
        ITree iTree = new BSTree(ten);
        int[] res = {1, 2, 15, 32, 45, 128, 222, 424, 567};
        iTree.del(904);
        Assert.assertArrayEquals(iTree.toArray(), res);
    }

    //===========================================================================
    //============================= Width tests =================================
    //===========================================================================

    @Test
    public void getWidth() {

    }

    @Test
    public void getHeight() {
    }

    @Test
    public void nodes() {
    }

    @Test
    public void leaves() {
    }

    @Test
    public void reverse() {
    }
}