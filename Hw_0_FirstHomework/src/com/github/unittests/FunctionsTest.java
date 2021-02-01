package com.github.unittests;

import com.github.firsthomework.Functions;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FunctionsTest {

    @Test
    public void dayOfWeek() {
        Assert.assertEquals("Понедельник", Functions.dayOfWeek(1));
        Assert.assertEquals("Пятница",Functions.dayOfWeek(5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dayOfWeekException() {
        Functions.dayOfWeek(8);
    }

    @Test
    public void distance() {
        Assert.assertEquals(5.0,Functions.distance(0,3,4,0),0.2);
    }
}