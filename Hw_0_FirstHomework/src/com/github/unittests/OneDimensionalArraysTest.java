package com.github.unittests;

import com.github.firsthomework.OneDimensionalArrays;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class OneDimensionalArraysTest {
    int[] a = {0,4,3,10,7};
    int[] a_sorted = {0,3,4,7,10};
    @Test(expected = IllegalArgumentException.class)
    public void min() {
        Assert.assertEquals(0, OneDimensionalArrays.min(a));
        OneDimensionalArrays.min(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void max() {
        Assert.assertEquals(10,OneDimensionalArrays.max(a));
        OneDimensionalArrays.max(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void minIndex() {
        Assert.assertEquals(0,OneDimensionalArrays.minIndex(a));
        OneDimensionalArrays.minIndex(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void maxIndex() {
        Assert.assertEquals(3,OneDimensionalArrays.maxIndex(a));
        OneDimensionalArrays.minIndex(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sumOfOddNumbers() {
        Assert.assertEquals(14,OneDimensionalArrays.sumOfOddNumbers(a));
        Assert.assertEquals(0,OneDimensionalArrays.sumOfOddNumbers(null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void arrayReverse() {
        int[] reverse = {7,10,3,4,0};
        Assert.assertArrayEquals(reverse,OneDimensionalArrays.arrayReverse(a));
        Assert.assertArrayEquals(null,OneDimensionalArrays.arrayReverse(null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void numberOfOddNumbers() {
        Assert.assertEquals(0,OneDimensionalArrays.sumOfOddNumbers(null));
        Assert.assertEquals(2,OneDimensionalArrays.sumOfOddNumbers(a));
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeParts() {
        int[] exp = {10, 7, 3, 0, 4};
        int[] exp1 = {1, 2, 3, 4};
        int[] raw1 = {3, 4, 1, 2};
        Assert.assertArrayEquals(exp, OneDimensionalArrays.changeParts(a));
        Assert.assertArrayEquals(exp1, OneDimensionalArrays.changeParts(raw1));
        OneDimensionalArrays.changeParts(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sortWithBubble() {
        Assert.assertArrayEquals(a_sorted,OneDimensionalArrays.sortWithBubble(a));
        OneDimensionalArrays.sortWithBubble(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sortWithSelection() {
        Assert.assertArrayEquals(a_sorted,OneDimensionalArrays.sortWithSelection(a));
        OneDimensionalArrays.sortWithSelection(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sortWithInsertion() {
        Assert.assertArrayEquals(a_sorted,OneDimensionalArrays.sortWithInsertion(a));
        OneDimensionalArrays.sortWithInsertion(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void quickSort() {
        Assert.assertArrayEquals(a_sorted,OneDimensionalArrays.quickSort(0,a.length-1,a));
        OneDimensionalArrays.quickSort(0,0,null);
    }

}