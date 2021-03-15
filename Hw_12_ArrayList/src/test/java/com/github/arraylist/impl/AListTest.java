package com.github.arraylist.impl;

import com.github.arraylist.IList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class AListTest {

    private static IList iList;

    private final static int[] ten = {1, 2, 45, 32, 15, 128, 424, 567, 222, 904};

    private final static int[] tenHalfReversed = {128, 424, 567, 222, 904, 1, 2, 45, 32, 15};

    private final static int[] tenReversed = {904, 222,567, 424,128, 15,32, 45, 2, 1};

    private final static int[] one = {65};

    private final static int[] two = {5, 9};

    private final static int[] twoReversed = {9, 5};

    private final static int[] zero = {};

    private final static int[] five = {222, 904, 567, 128, 424};

    private final static int[] fiveHalfReversed = {128, 424, 567, 222, 904};

    private final static int[] fiveReversed = {424, 128, 567, 904, 222};

    private final static int num1 = 43;

    @Before
    public void initialize(){
        iList = new AList();
    }


    //===========================================================================
    //==============================  Init tests  ===============================
    //===========================================================================

    @Test
    public void initMany(){

        iList.init(ten);
        Assert.assertArrayEquals(iList.toArray(),ten);

    }

    @Test
    public void initOne(){

        iList.init(one);
        Assert.assertArrayEquals(iList.toArray(),one);

    }

    @Test
    public void initTwo(){

        iList.init(two);
        Assert.assertArrayEquals(iList.toArray(),two);

    }

    @Test
    public void initZero(){

        iList.init(zero);
        Assert.assertArrayEquals(iList.toArray(),zero);

    }

    @Test(expected = IllegalArgumentException.class)
    public void initNull(){

        iList.init(null);

    }

    //===========================================================================
    //============================== Clear tests ================================
    //===========================================================================

    @Test
    public void clearMany(){

        iList.init(ten);
        iList.clear();
        Assert.assertArrayEquals(iList.toArray(),zero);

    }

    @Test
    public void clearOne(){

        iList.init(one);
        iList.clear();
        Assert.assertArrayEquals(iList.toArray(),zero);

    }

    @Test
    public void clearTwo(){

        iList.init(two);
        iList.clear();
        Assert.assertArrayEquals(iList.toArray(),zero);

    }

    @Test
    public void clearZero(){

        iList.init(zero);
        iList.clear();
        Assert.assertArrayEquals(iList.toArray(),zero);

    }

    //===========================================================================
    //============================== Size tests =================================
    //===========================================================================

    @Test
    public void sizeMany(){

        iList.init(ten);
        Assert.assertEquals(iList.size(),10);

    }

    @Test
    public void sizeOne(){

        iList.init(one);
        Assert.assertEquals(iList.size(),1);

    }

    @Test
    public void sizeTwo(){

        iList.init(two);
        Assert.assertEquals(iList.size(),2);

    }

    @Test
    public void sizeZero(){

        iList.init(zero);
        Assert.assertEquals(iList.size(),0);

    }

    //===========================================================================
    //============================== toArray tests ==============================
    //===========================================================================

    @Test
    public void toArrayMany(){

        IList iList = new AList(ten);
        Assert.assertArrayEquals(iList.toArray(),ten);

    }

    @Test
    public void toArrayOne(){

        IList iList = new AList(one);
        Assert.assertArrayEquals(iList.toArray(),one);

    }

    @Test
    public void toArrayTwo(){

        IList iList = new AList(two);
        Assert.assertArrayEquals(iList.toArray(),two);

    }

    @Test
    public void toArrayZero(){

        IList iList = new AList(zero);
        Assert.assertArrayEquals(iList.toArray(),zero);

    }

    //===========================================================================
    //============================== addStart tests =============================
    //===========================================================================

    @Test
    public void addStartMany(){

        iList.init(ten);
        iList.addStart(num1);
        Assert.assertEquals(iList.toArray()[0],num1);

    }

    @Test
    public void addStartOne(){

        iList.init(one);
        iList.addStart(num1);
        Assert.assertEquals(iList.toArray()[0],num1);

    }

    @Test
    public void addStartTwo(){

        iList.init(two);
        iList.addStart(num1);
        Assert.assertEquals(iList.toArray()[0],num1);

    }

    @Test
    public void addStartZero(){

        iList.init(zero);
        iList.addStart(num1);
        Assert.assertEquals(iList.toArray()[0],num1);

    }

    //===========================================================================
    //============================== addEnd tests ===============================
    //===========================================================================

    @Test
    public void addEndMany(){

        iList.init(ten);
        iList.addEnd(num1);
        int[] arr = iList.toArray();
        Assert.assertEquals(arr[arr.length-1],num1);

    }

    @Test
    public void addEndOne(){

        iList.init(one);
        iList.addStart(num1);
        int[] arr = iList.toArray();
        Assert.assertEquals(arr[arr.length-1],num1);

    }

    @Test
    public void addEndTwo(){

        iList.init(two);
        iList.addStart(num1);
        int[] arr = iList.toArray();
        Assert.assertEquals(arr[arr.length-1],num1);

    }

    @Test
    public void addEndZero(){

        iList.init(zero);
        iList.addStart(num1);
        int[] arr = iList.toArray();
        Assert.assertEquals(arr[arr.length-1],num1);

    }

    //===========================================================================
    //============================== addEnd tests ===============================
    //===========================================================================

    @Test
    public void addByPosMany(){

        iList.init(ten);
        iList.addByPos(3,num1);
        Assert.assertEquals(iList.toArray()[3],num1);

    }

    @Test
    public void addByPosOne(){

        iList.init(one);
        iList.addByPos(1,num1);
        int[] arr = iList.toArray();
        Assert.assertEquals(arr[1],num1);

    }

    @Test
    public void addByPosTwo(){

        iList.init(two);
        iList.addByPos(1,num1);
        int[] arr = iList.toArray();
        Assert.assertEquals(arr[1],num1);

    }

    @Test
    public void addByPosZero(){

        iList.init(zero);
        iList.addByPos(0,num1);
        int[] arr = iList.toArray();
        Assert.assertEquals(arr[0],num1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void addByPosException(){

        iList.init(zero);
        iList.addByPos(1,num1);

    }

    //===========================================================================
    //============================ removeStart tests ============================
    //===========================================================================
    
    @Test
    public void removeStartMany(){
        
        iList.init(ten);
        Assert.assertEquals(iList.removeStart(),ten[0]);
        Assert.assertEquals(iList.toArray()[0],ten[1]);
        
    }

    @Test
    public void removeStartOne(){

        iList.init(one);
        Assert.assertEquals(iList.removeStart(),one[0]);
        Assert.assertArrayEquals(iList.toArray(),zero);

    }

    @Test
    public void removeStartTwo(){

        iList.init(two);
        Assert.assertEquals(iList.removeStart(),two[0]);
        Assert.assertEquals(iList.toArray()[0],two[1]);

    }

    @Test(expected = IllegalArgumentException.class)
    public void removeStartZero(){

        iList.init(zero);
        iList.removeStart();

    }

    //===========================================================================
    //============================ removeEnd tests ==============================
    //===========================================================================

    @Test
    public void removeEndMany(){

        iList.init(ten);
        Assert.assertEquals(iList.removeEnd(),ten[9]);
        int[] arr = iList.toArray();
        Assert.assertEquals(arr[arr.length-1],ten[8]);

    }

    @Test
    public void removeEndOne(){

        iList.init(one);
        Assert.assertEquals(iList.removeEnd(),one[0]);
        Assert.assertArrayEquals(iList.toArray(),zero);

    }

    @Test
    public void removeEndTwo(){

        iList.init(two);
        Assert.assertEquals(iList.removeEnd(),two[1]);
        Assert.assertEquals(iList.toArray()[0],two[0]);

    }

    @Test(expected = IllegalArgumentException.class)
    public void removeEndZero(){

        iList.init(zero);
        iList.removeEnd();

    }

    //===========================================================================
    //============================ removeByPos tests ============================
    //===========================================================================

    @Test
    public void removeByPosMany(){

        iList.init(ten);
        Assert.assertEquals(iList.removeByPos(3),ten[3]);
        Assert.assertEquals(iList.toArray()[3],ten[4]);

    }

    @Test
    public void removeByPosOne(){

        iList.init(one);
        Assert.assertEquals(iList.removeByPos(0),one[0]);
        int[] arr = iList.toArray();
        Assert.assertArrayEquals(arr,zero);

    }

    @Test
    public void removeByPosTwo(){

        iList.init(two);
        Assert.assertEquals(iList.removeByPos(1),two[1]);
        int[] arr = iList.toArray();
        Assert.assertEquals(arr[0],two[0]);

    }

    @Test(expected = IllegalArgumentException.class)
    public void removeByPosZero(){

        iList.init(zero);
        iList.removeByPos(0);

    }

    //===========================================================================
    //=============================== max tests =================================
    //===========================================================================

    @Test
    public void maxMany(){

        iList.init(ten);
        Assert.assertEquals(iList.max(),ten[9]);

    }

    @Test
    public void maxOne(){

        iList.init(one);
        Assert.assertEquals(iList.max(),one[0]);

    }

    @Test
    public void maxTwo(){

        iList.init(two);
        Assert.assertEquals(iList.max(),two[1]);

    }

    @Test(expected = IllegalArgumentException.class)
    public void maxZero(){

        iList.init(zero);
        iList.max();

    }

    //===========================================================================
    //=============================== min tests =================================
    //===========================================================================

    @Test
    public void minMany(){

        iList.init(ten);
        Assert.assertEquals(iList.min(),ten[0]);

    }

    @Test
    public void minOne(){

        iList.init(one);
        Assert.assertEquals(iList.min(),one[0]);

    }

    @Test
    public void minTwo(){

        iList.init(two);
        Assert.assertEquals(iList.min(),two[0]);

    }

    @Test(expected = IllegalArgumentException.class)
    public void minZero(){

        iList.init(zero);
        iList.min();

    }

    //===========================================================================
    //============================== maxPos tests ===============================
    //===========================================================================

    @Test
    public void maxPosMany(){

        iList.init(ten);
        Assert.assertEquals(iList.maxPos(),9);

    }

    @Test
    public void maxPosOne(){

        iList.init(one);
        Assert.assertEquals(iList.maxPos(),0);

    }

    @Test
    public void maxPosTwo(){

        iList.init(two);
        Assert.assertEquals(iList.maxPos(),1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void maxPosZero(){

        iList.init(zero);
        iList.maxPos();

    }

    //===========================================================================
    //============================== minPos tests ===============================
    //===========================================================================


    @Test
    public void minPosMany(){

        iList.init(ten);
        Assert.assertEquals(iList.minPos(),9);

    }

    @Test
    public void minPosOne(){

        iList.init(one);
        Assert.assertEquals(iList.minPos(),0);

    }

    @Test
    public void minPosTwo(){

        iList.init(two);
        Assert.assertEquals(iList.minPos(),0);

    }

    @Test(expected = IllegalArgumentException.class)
    public void minPosZero(){

        iList.init(zero);
        iList.minPos();

    }

    //===========================================================================
    //=============================== sort tests ================================
    //===========================================================================

    @Test
    public void sortMany(){

        int[] sortedTen = ten;
        Arrays.sort(sortedTen);
        iList.init(ten);
        Assert.assertArrayEquals(sortedTen,iList.sort());
        Assert.assertArrayEquals(sortedTen,iList.toArray());

    }

    @Test
    public void sortOne(){

        int[] sortedOne = one;
        Arrays.sort(sortedOne);
        iList.init(one);
        Assert.assertArrayEquals(sortedOne,iList.sort());
        Assert.assertArrayEquals(sortedOne,iList.toArray());

    }

    @Test
    public void sortTwo(){

        int[] sortedTwo = two;
        Arrays.sort(sortedTwo);
        iList.init(two);
        Assert.assertArrayEquals(sortedTwo,iList.sort());
        Assert.assertArrayEquals(sortedTwo,iList.toArray());

    }

    @Test
    public void sortZero(){

        int[] sortedZero = zero;
        Arrays.sort(sortedZero);
        iList.init(zero);
        Assert.assertArrayEquals(sortedZero,iList.sort());
        Assert.assertArrayEquals(sortedZero,iList.toArray());

    }

    //===========================================================================
    //================================ get tests ================================
    //===========================================================================

    @Test
    public void getMany(){

        iList.init(ten);
        Assert.assertEquals(ten[0],iList.get(0));
        Assert.assertEquals(ten[4],iList.get(4));

    }

    @Test
    public void getOne(){

        iList.init(one);
        Assert.assertEquals(one[0],iList.get(0));

    }

    @Test(expected = IllegalArgumentException.class)
    public void getOneException(){

        iList.init(one);
        iList.get(12);

    }

    @Test
    public void getTwo(){

        iList.init(two);
        Assert.assertEquals(two[1],iList.get(1));

    }

    @Test(expected = IllegalArgumentException.class)
    public void getZero(){

        iList.init(zero);
        iList.get(0);

    }

    //===========================================================================
    //============================ halfReverse tests ============================
    //===========================================================================

    @Test
    public void halfReverseManyEven(){

        iList.init(ten);
        Assert.assertArrayEquals(tenHalfReversed,iList.halfReverse());

    }

    @Test
    public void halfReverseManyOdd(){

        iList.init(five);
        Assert.assertArrayEquals(fiveHalfReversed,iList.halfReverse());

    }

    @Test
    public void halfReverseOne(){

        iList.init(one);
        Assert.assertArrayEquals(one,iList.halfReverse());

    }

    @Test
    public void halfReverseTwo(){

        iList.init(two);
        Assert.assertArrayEquals(twoReversed,iList.halfReverse());

    }

    @Test
    public void halfReverseZero(){

        iList.init(zero);
        Assert.assertArrayEquals(zero,iList.halfReverse());

    }

    //===========================================================================
    //============================= reverse tests ===============================
    //===========================================================================

    @Test
    public void reverseManyEven(){

        iList.init(ten);
        Assert.assertArrayEquals(tenReversed,iList.reverse());

    }

    @Test
    public void reverseManyOdd(){

        iList.init(five);
        Assert.assertArrayEquals(fiveReversed,iList.reverse());

    }

    @Test
    public void reverseOne(){

        iList.init(one);
        Assert.assertArrayEquals(one,iList.reverse());

    }

    @Test
    public void reverseTwo(){

        iList.init(two);
        Assert.assertArrayEquals(twoReversed,iList.reverse());

    }

    @Test
    public void reverseZero(){

        iList.init(zero);
        Assert.assertArrayEquals(zero,iList.reverse());

    }

    //===========================================================================
    //=============================== Set tests =================================
    //===========================================================================

    @Test
    public void setMany(){

        iList.init(ten);
        iList.set(4,num1);
        Assert.assertEquals(iList.get(4),num1);

    }

    @Test
    public void setOne(){

        iList.init(one);
        iList.set(0,num1);
        Assert.assertEquals(iList.get(0),num1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void setOneException(){

        iList.init(one);
        iList.set(2,num1);

    }

    @Test
    public void setTwo(){

        iList.init(two);
        iList.set(1,num1);
        Assert.assertEquals(iList.get(1),num1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void setZero(){

        iList.init(zero);
        iList.set(0,num1);

    }

}