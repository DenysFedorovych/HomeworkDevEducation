package com.github.workwithstrings;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class WorkWithStringsTest {

    @org.junit.Test
    public void stringWithSpacesTest() {
        String input = "Hi!Hi.Hi?Hi:Hi,Hi. Hi.";
        String actual = WorkWithStrings.stringWithSpaces(input);
        String expected = "Hi! Hi. Hi? Hi: Hi, Hi. Hi. ";
        Assert.assertEquals(expected,actual);
        Assert.assertNull(WorkWithStrings.stringWithSpaces(null));
        Assert.assertEquals("",WorkWithStrings.stringWithSpaces(""));
    }

    @Test
    public void replaceBackslashTest() {
        String input = "hi/hi///hi\\hi///";
        String actual = WorkWithStrings.replaceBackslash(input);
        String expected = "hi\\hi\\\\\\hi\\hi\\\\\\";
        Assert.assertEquals(expected,actual);
        Assert.assertEquals("",WorkWithStrings.replaceBackslash(""));
        Assert.assertNull(WorkWithStrings.replaceBackslash(null));
    }

    @Test
    public void isValidTest() {
        Assert.assertTrue(WorkWithStrings.isValid("MyDocument"));
        Assert.assertTrue(WorkWithStrings.isValid("mydocument123&2"));
        Assert.assertFalse(WorkWithStrings.isValid("MyDocument "));
        Assert.assertFalse(WorkWithStrings.isValid("My?Doc"));
        Assert.assertFalse(WorkWithStrings.isValid("My.doc."));
        Assert.assertFalse(WorkWithStrings.isValid("MyDocum<ent"));
        Assert.assertFalse(WorkWithStrings.isValid(""));
        Assert.assertFalse(WorkWithStrings.isValid(" "));
        Assert.assertFalse(WorkWithStrings.isValid(null));
    }

    @Test
    public void isDiskPathTest(){
        Assert.assertFalse(WorkWithStrings.isValid(""));
        Assert.assertFalse(WorkWithStrings.isValid(" "));
        Assert.assertFalse(WorkWithStrings.isValid(null));
        Assert.assertFalse(WorkWithStrings.isDiskPath("\\Program Files\\Custom Utilities\\StringFinder.exe"));
        Assert.assertTrue(WorkWithStrings.isDiskPath("C:\\Documents\\Newsletters\\Summer2018.pdf"));
        Assert.assertTrue(WorkWithStrings.isDiskPath("D:\\Games"));
    }

}