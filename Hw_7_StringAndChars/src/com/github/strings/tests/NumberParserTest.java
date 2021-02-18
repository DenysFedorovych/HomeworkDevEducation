package com.github.strings.tests;

import com.github.strings.NumberParser;
import org.junit.Assert;

import static org.junit.Assert.*;

public class NumberParserTest {

    @org.junit.Test
    public void testToString() {
        Assert.assertEquals("123", NumberParser.toString(123));
        Assert.assertEquals("0",NumberParser.toString(0));
        Assert.assertEquals("10000000000000",NumberParser.toString(10000000000000L));
        Assert.assertEquals("-123",NumberParser.toString(-123));
    }

    @org.junit.Test
    public void testToString1() {
        Assert.assertEquals("123.2",NumberParser.toString(123.2));
        Assert.assertEquals("0",NumberParser.toString(0));
        Assert.assertEquals("1.2341234232423515E15",NumberParser.toString(1234123423242351.5));
        Assert.assertEquals("-123.4",NumberParser.toString(-123.4));
    }

    @org.junit.Test
    public void toNumber() {
        Assert.assertEquals(124563,NumberParser.toNumber("124563"));
        Assert.assertEquals(0,NumberParser.toNumber("0"));
        Assert.assertEquals(12002340000L,NumberParser.toNumber("12002340000"));
        Assert.assertEquals(-124563,NumberParser.toNumber("-124563"));
    }

    @org.junit.Test
    public void toNumberDouble() {
        Assert.assertEquals(123.45,NumberParser.toNumberDouble("123.45"),0.001);
        Assert.assertEquals(0.0,NumberParser.toNumberDouble("0.0"),0.001);
        Assert.assertEquals(1200234000000.34,NumberParser.toNumberDouble("1200234000000.34"),0.001);
        Assert.assertEquals(-124563.4,NumberParser.toNumberDouble("-124563.4"),1);
    }
}