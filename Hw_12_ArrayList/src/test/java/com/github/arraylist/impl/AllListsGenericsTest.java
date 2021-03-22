package com.github.arraylist.impl;

import com.github.arraylist.IListGenerics;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AllListsGenericsTest {

    private static IListGenerics iList;

    private final static String[] four = {"One", "Two", "Three", "Four"};

    private final static String[] fourHalfReversed = {"Three", "Four", "One", "Two"};

    private final static String[] fourReversed = {"Four", "Three", "Two", "One"};

    private final static String[] one = {"One"};

    private final static String[] two = {"One", "Two"};

    private final static String[] twoReversed = {"Two", "One"};

    private final static String[] zero = {};

    private final static String[] five = {"One", "Two", "Three", "Four", "Five"};

    private final static String[] fiveHalfReversed = {"Four", "Five", "Three", "One", "Two"};

    private final static String[] fiveReversed = {"Five", "Four", "Three", "Two", "One"};

    private final static String str1 = "string";

    @Before
    public void initialize() {
        this.iList.clear();
    }

    public AllListsGenericsTest(IListGenerics iList){
        this.iList = iList;
    }

    @Parameterized.Parameters(name = "{index} {0}")
    public static Collection<Object[]> instances(){
        return Arrays.asList(new Object[][]{
                {new AListGenerics<String>()},
                {new LListGenerics<String>()}
        });
    }


    //===========================================================================
    //==============================  Init tests  ===============================
    //===========================================================================

    @Test
    public void initMany() {

        iList.init(four);
        Assert.assertArrayEquals(iList.toArray(), four);

    }

    @Test
    public void initOne() {

        iList.init(one);
        Assert.assertArrayEquals(iList.toArray(), one);

    }

    @Test
    public void initTwo() {

        iList.init(two);
        Assert.assertArrayEquals(iList.toArray(), two);

    }

    @Test
    public void initZero() {

        iList.init(zero);
        Assert.assertArrayEquals(iList.toArray(), zero);

    }

    @Test(expected = IllegalArgumentException.class)
    public void initNull() {

        iList.init(null);

    }

    //===========================================================================
    //============================== Clear tests ================================
    //===========================================================================

    @Test
    public void clearMany() {

        iList.init(four);
        iList.clear();
        Assert.assertArrayEquals(iList.toArray(), zero);

    }

    @Test
    public void clearOne() {

        iList.init(one);
        iList.clear();
        Assert.assertArrayEquals(iList.toArray(), zero);

    }

    @Test
    public void clearTwo() {

        iList.init(two);
        iList.clear();
        Assert.assertArrayEquals(iList.toArray(), zero);

    }

    @Test
    public void clearZero() {

        iList.init(zero);
        iList.clear();
        Assert.assertArrayEquals(iList.toArray(), zero);

    }

    //===========================================================================
    //============================== Size tests =================================
    //===========================================================================

    @Test
    public void sizeMany() {

        iList.init(four);
        Assert.assertEquals(iList.size(), 4);

    }

    @Test
    public void sizeOne() {

        iList.init(one);
        Assert.assertEquals(iList.size(), 1);

    }

    @Test
    public void sizeTwo() {

        iList.init(two);
        Assert.assertEquals(iList.size(), 2);

    }

    @Test
    public void sizeZero() {

        iList.init(zero);
        Assert.assertEquals(iList.size(), 0);

    }

    //===========================================================================
    //============================== toArray tests ==============================
    //===========================================================================

    @Test
    public void toArrayMany() {

        IListGenerics iList = new AListGenerics<String>(four);
        Assert.assertArrayEquals(iList.toArray(), four);

    }

    @Test
    public void toArrayOne() {

        IListGenerics iList = new AListGenerics(one);
        Assert.assertArrayEquals(iList.toArray(), one);

    }

    @Test
    public void toArrayTwo() {

        IListGenerics iList = new AListGenerics(two);
        Assert.assertArrayEquals(iList.toArray(), two);

    }

    @Test
    public void toArrayZero() {

        IListGenerics iList = new AListGenerics(zero);
        Assert.assertArrayEquals(iList.toArray(), zero);

    }

    //===========================================================================
    //============================== addStart tests =============================
    //===========================================================================

    @Test
    public void addStartMany() {

        iList.init(four);
        iList.addStart(str1);
        Assert.assertEquals(iList.toArray()[0], str1);

    }

    @Test
    public void addStartOne() {

        iList.init(one);
        iList.addStart(str1);
        Assert.assertEquals(iList.toArray()[0], str1);

    }

    @Test
    public void addStartTwo() {

        iList.init(two);
        iList.addStart(str1);
        Assert.assertEquals(iList.toArray()[0], str1);

    }

    @Test
    public void addStartZero() {

        iList.init(zero);
        iList.addStart(str1);
        Assert.assertEquals(iList.toArray()[0], str1);

    }

    //===========================================================================
    //============================== addEnd tests ===============================
    //===========================================================================

    @Test
    public void addEndMany() {

        iList.init(four);
        iList.addEnd(str1);
        String str = (String) iList.toArray()[4];
        Assert.assertEquals(str, str1);

    }

    @Test
    public void addEndOne() {

        iList.init(one);
        iList.addEnd(str1);
        String str = (String) iList.toArray()[1];
        Assert.assertEquals(str, str1);

    }

    @Test
    public void addEndTwo() {

        iList.init(two);
        iList.addEnd(str1);
        String str = (String) iList.toArray()[2];
        Assert.assertEquals(str, str1);

    }

    @Test
    public void addEndZero() {

        iList.init(zero);
        iList.addEnd(str1);
        String str = (String) iList.toArray()[0];
        Assert.assertEquals(str, str1);

    }

    //===========================================================================
    //============================== addEnd tests ===============================
    //===========================================================================

    @Test
    public void addByPosMany() {

        iList.init(four);
        iList.addByPos(3, str1);
        Assert.assertEquals(iList.toArray()[3], str1);

    }

    @Test
    public void addByPosOne() {

        iList.init(one);
        iList.addByPos(1, str1);
        String str = (String) iList.toArray()[1];
        Assert.assertEquals(str, str1);

    }

    @Test
    public void addByPosTwo() {

        iList.init(two);
        iList.addByPos(1, str1);
        String str = (String) iList.toArray()[1];
        Assert.assertEquals(str, str1);

    }

    @Test
    public void addByPosZero() {

        iList.init(zero);
        iList.addByPos(0, str1);
        String str = (String) iList.toArray()[0];
        Assert.assertEquals(str, str1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void addByPosException() {

        iList.init(zero);
        iList.addByPos(1, str1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void addByPosException1() {

        iList.init(four);
        iList.addByPos(-1, str1);

    }

    //===========================================================================
    //============================ removeStart tests ============================
    //===========================================================================

    @Test
    public void removeStartMany() {

        iList.init(four);
        Assert.assertEquals(iList.removeStart(), four[0]);
        Assert.assertEquals(iList.toArray()[0], four[1]);

    }

    @Test
    public void removeStartOne() {

        iList.init(one);
        Assert.assertEquals(iList.removeStart(), one[0]);
        Assert.assertArrayEquals(iList.toArray(), zero);

    }

    @Test
    public void removeStartTwo() {

        iList.init(two);
        Assert.assertEquals(iList.removeStart(), two[0]);
        Assert.assertEquals(iList.toArray()[0], two[1]);

    }

    @Test(expected = IllegalArgumentException.class)
    public void removeStartZero() {

        iList.init(zero);
        iList.removeStart();

    }

    //===========================================================================
    //============================ removeEnd tests ==============================
    //===========================================================================

    @Test
    public void removeEndMany() {

        iList.init(four);
        Assert.assertEquals(iList.removeEnd(), four[3]);
        String str = (String) iList.toArray()[2];
        Assert.assertEquals(str, four[2]);

    }

    @Test
    public void removeEndOne() {

        iList.init(one);
        Assert.assertEquals(iList.removeEnd(), one[0]);
        Assert.assertArrayEquals(iList.toArray(), zero);

    }

    @Test
    public void removeEndTwo() {

        iList.init(two);
        Assert.assertEquals(iList.removeEnd(), two[1]);
        Assert.assertEquals(iList.toArray()[0], two[0]);

    }

    @Test(expected = IllegalArgumentException.class)
    public void removeEndZero() {

        iList.init(zero);
        iList.removeEnd();

    }

    //===========================================================================
    //============================ removeByPos tests ============================
    //===========================================================================

    @Test
    public void removeByPosMany() {

        iList.init(four);
        Assert.assertEquals(iList.removeByPos(2), four[2]);
        Assert.assertEquals(iList.toArray()[2], four[3]);

    }

    @Test
    public void removeByPosOne() {

        iList.init(one);
        Assert.assertEquals(iList.removeByPos(0), one[0]);
        Comparable[] arr = iList.toArray();
        Assert.assertEquals(arr.length, 0);

    }

    @Test
    public void removeByPosTwo() {

        iList.init(two);
        Assert.assertEquals(iList.removeByPos(1), two[1]);
        String str = (String) iList.toArray()[0];
        Assert.assertEquals(str, two[0]);

    }

    @Test(expected = IllegalArgumentException.class)
    public void removeByPosZero() {

        iList.init(zero);
        iList.removeByPos(0);

    }

    //===========================================================================
    //=============================== max tests =================================
    //===========================================================================

    @Test
    public void maxMany() {

        iList.init(four);
        Assert.assertEquals(iList.max(), four[1]);

    }

    @Test
    public void maxOne() {

        iList.init(one);
        Assert.assertEquals(iList.max(), one[0]);

    }

    @Test
    public void maxTwo() {

        iList.init(two);
        Assert.assertEquals(iList.max(), two[1]);

    }

    @Test(expected = IllegalArgumentException.class)
    public void maxZero() {

        iList.init(zero);
        iList.max();

    }

    //===========================================================================
    //=============================== min tests =================================
    //===========================================================================

    @Test
    public void minMany() {

        iList.init(four);
        Assert.assertEquals(iList.min(), four[3]);

    }

    @Test
    public void minOne() {

        iList.init(one);
        Assert.assertEquals(iList.min(), one[0]);

    }

    @Test
    public void minTwo() {

        iList.init(two);
        Assert.assertEquals(iList.min(), two[0]);

    }

    @Test(expected = IllegalArgumentException.class)
    public void minZero() {

        iList.init(zero);
        iList.min();

    }

    //===========================================================================
    //============================== maxPos tests ===============================
    //===========================================================================

    @Test
    public void maxPosMany() {

        iList.init(four);
        Assert.assertEquals(iList.maxPos(), 1);

    }

    @Test
    public void maxPosOne() {

        iList.init(one);
        Assert.assertEquals(iList.maxPos(), 0);

    }

    @Test
    public void maxPosTwo() {

        iList.init(two);
        Assert.assertEquals(iList.maxPos(), 1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void maxPosZero() {

        iList.init(zero);
        iList.maxPos();

    }

    //===========================================================================
    //============================== minPos tests ===============================
    //===========================================================================


    @Test
    public void minPosMany() {

        iList.init(four);
        Assert.assertEquals(iList.minPos(), 3);

    }

    @Test
    public void minPosOne() {

        iList.init(one);
        Assert.assertEquals(iList.minPos(), 0);

    }

    @Test
    public void minPosTwo() {

        iList.init(two);
        Assert.assertEquals(iList.minPos(), 0);

    }

    @Test(expected = IllegalArgumentException.class)
    public void minPosZero() {

        iList.init(zero);
        iList.minPos();

    }

    //===========================================================================
    //=============================== sort tests ================================
    //===========================================================================

    @Test
    public void sortMany() {

        String[] sortedfour = new String[four.length];
        for (int i = 0; i < four.length; i++) {
            sortedfour[i] = four[i];
        }
        Arrays.sort(sortedfour);
        iList.init(four);
        Assert.assertArrayEquals(sortedfour, iList.sort());
        Assert.assertArrayEquals(sortedfour, iList.toArray());

    }

    @Test
    public void sortOne() {

        String[] sortedOne = new String[one.length];
        for (int i = 0; i < one.length; i++) {
            sortedOne[i] = one[i];
        }
        Arrays.sort(sortedOne);
        iList.init(one);
        Assert.assertArrayEquals(sortedOne, iList.sort());
        Assert.assertArrayEquals(sortedOne, iList.toArray());

    }

    @Test
    public void sortTwo() {

        String[] sortedTwo = new String[two.length];
        for (int i = 0; i < two.length; i++) {
            sortedTwo[i] = two[i];
        }
        Arrays.sort(sortedTwo);
        iList.init(two);
        Assert.assertArrayEquals(sortedTwo, iList.sort());
        Assert.assertArrayEquals(sortedTwo, iList.toArray());

    }

    @Test
    public void sortZero() {

        String[] sortedZero = zero;
        Arrays.sort(sortedZero);
        iList.init(zero);
        Assert.assertArrayEquals(sortedZero, iList.sort());
        Assert.assertArrayEquals(sortedZero, iList.toArray());

    }

    //===========================================================================
    //================================ get tests ================================
    //===========================================================================

    @Test
    public void getMany() {

        iList.init(four);
        Assert.assertEquals(four[0], iList.get(0));
        Assert.assertEquals(four[3], iList.get(3));

    }

    @Test
    public void getOne() {

        iList.init(one);
        Assert.assertEquals(one[0], iList.get(0));

    }

    @Test(expected = IllegalArgumentException.class)
    public void getOneException() {

        iList.init(one);
        iList.get(12);

    }

    @Test
    public void getTwo() {

        iList.init(two);
        Assert.assertEquals(two[1], iList.get(1));

    }

    @Test(expected = IllegalArgumentException.class)
    public void getZero() {

        iList.init(zero);
        iList.get(0);

    }

    //===========================================================================
    //============================ halfReverse tests ============================
    //===========================================================================

    @Test
    public void halfReverseManyEven() {

        iList.init(four);
        Assert.assertArrayEquals(fourHalfReversed, iList.halfReverse());

    }

    @Test
    public void halfReverseManyOdd() {

        iList.init(five);
        Assert.assertArrayEquals(fiveHalfReversed, iList.halfReverse());

    }

    @Test
    public void halfReverseOne() {

        iList.init(one);
        Assert.assertArrayEquals(one, iList.halfReverse());

    }

    @Test
    public void halfReverseTwo() {

        iList.init(two);
        Assert.assertArrayEquals(twoReversed, iList.halfReverse());

    }

    @Test
    public void halfReverseZero() {

        iList.init(zero);
        Assert.assertArrayEquals(zero, iList.halfReverse());

    }

    //===========================================================================
    //============================= reverse tests ===============================
    //===========================================================================

    @Test
    public void reverseManyEven() {

        iList.init(four);
        Assert.assertArrayEquals(fourReversed, iList.reverse());

    }

    @Test
    public void reverseManyOdd() {

        iList.init(five);
        Assert.assertArrayEquals(fiveReversed, iList.reverse());

    }

    @Test
    public void reverseOne() {

        iList.init(one);
        Assert.assertArrayEquals(one, iList.reverse());

    }

    @Test
    public void reverseTwo() {

        iList.init(two);
        Assert.assertArrayEquals(twoReversed, iList.reverse());

    }

    @Test
    public void reverseZero() {

        iList.init(zero);
        Assert.assertArrayEquals(zero, iList.reverse());

    }

    //===========================================================================
    //=============================== Set tests =================================
    //===========================================================================

    @Test
    public void setMany() {

        iList.init(four);
        iList.set(2, str1);
        Assert.assertEquals(iList.get(2), str1);

    }

    @Test
    public void setOne() {

        iList.init(one);
        iList.set(0, str1);
        Assert.assertEquals(iList.get(0), str1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void setOneException() {

        iList.init(one);
        iList.set(2, str1);

    }

    @Test
    public void setTwo() {

        iList.init(two);
        iList.set(1, str1);
        Assert.assertEquals(iList.get(1), str1);

    }

    @Test(expected = IllegalArgumentException.class)
    public void setZero() {

        iList.init(zero);
        iList.set(0, str1);

    }

}