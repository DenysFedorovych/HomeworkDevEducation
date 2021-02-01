package com.github.unittests;

import com.github.firsthomework.OneDimensionalArrays;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class OneDimensionalArraysTest {
    int[] a = {0,4,3,10,7};
    int[] a_sorted = {0,3,4,7,10};
    @Test
    public void min() {
        Assert.assertEquals(0, OneDimensionalArrays.min(a));
    }

    @Test(expected = IllegalArgumentException.class)
    public void minException() {
        OneDimensionalArrays.min(null);
    }

    @Test
    public void max() {
        Assert.assertEquals(10,OneDimensionalArrays.max(a));
    }

    @Test(expected = IllegalArgumentException.class)
    public void maxException() {
        OneDimensionalArrays.max(null);
    }

    @Test
    public void minIndex() {
        Assert.assertEquals(0,OneDimensionalArrays.minIndex(a));
    }

    @Test(expected = IllegalArgumentException.class)
    public void minIndexException() {
        OneDimensionalArrays.minIndex(null);
    }

    @Test
    public void maxIndex() {
        Assert.assertEquals(3,OneDimensionalArrays.maxIndex(a));
    }

    @Test(expected = IllegalArgumentException.class)
    public void maxIndexException() {
        OneDimensionalArrays.maxIndex(null);
    }

    @Test
    public void sumOfOddNumbers() {
        Assert.assertEquals(14,OneDimensionalArrays.sumOfOddNumbers(a));
    }

    @Test(expected = IllegalArgumentException.class)
    public void sumOfOddNumbersException() {
        Assert.assertEquals(0,OneDimensionalArrays.sumOfOddNumbers(null));
    }

    @Test
    public void arrayReverse() {
        int[] reverse = {7,10,3,4,0};
        Assert.assertArrayEquals(reverse,OneDimensionalArrays.arrayReverse(a));
    }

    @Test(expected = IllegalArgumentException.class)
    public void arrayReverseException() {
        Assert.assertArrayEquals(null,OneDimensionalArrays.arrayReverse(null));
    }

    @Test
    public void numberOfOddNumbers() {
        Assert.assertEquals(2,OneDimensionalArrays.sumOfOddNumbers(a));
    }

    @Test(expected = IllegalArgumentException.class)
    public void numberOfOddNumbersException() {
        Assert.assertEquals(0,OneDimensionalArrays.sumOfOddNumbers(null));
    }

    @Test
    public void changeParts() {
        int[] exp = {10, 7, 3, 0, 4};
        int[] exp1 = {1, 2, 3, 4};
        int[] raw1 = {3, 4, 1, 2};
        Assert.assertArrayEquals(exp, OneDimensionalArrays.changeParts(a));
        Assert.assertArrayEquals(exp1, OneDimensionalArrays.changeParts(raw1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void changePartsException() {
        OneDimensionalArrays.changeParts(null);
    }

    @Test
    public void sortWithBubble() {
        Assert.assertArrayEquals(a_sorted,OneDimensionalArrays.sortWithBubble(a));
    }

    @Test(expected = IllegalArgumentException.class)
    public void sortWithBubbleException() {
        OneDimensionalArrays.sortWithBubble(null);
    }

    @Test
    public void sortWithSelection() {
        Assert.assertArrayEquals(a_sorted,OneDimensionalArrays.sortWithSelection(a));
    }

    @Test(expected = IllegalArgumentException.class)
    public void sortWithSelectionException() {
        OneDimensionalArrays.sortWithSelection(null);
    }

    @Test
    public void sortWithInsertion() {
        Assert.assertArrayEquals(a_sorted,OneDimensionalArrays.sortWithInsertion(a));

    }

    @Test(expected = IllegalArgumentException.class)
    public void sortWithInsertionException() {
        OneDimensionalArrays.sortWithInsertion(null);
    }

    @Test
    public void quickSort() {
        Assert.assertArrayEquals(a_sorted,OneDimensionalArrays.quickSort(0,a.length-1,a));
    }

    @Test(expected = IllegalArgumentException.class)
    public void quickSortException() {
        OneDimensionalArrays.quickSort(0,0,null);
    }

}