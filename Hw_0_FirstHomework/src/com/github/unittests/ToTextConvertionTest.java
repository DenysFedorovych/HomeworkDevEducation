package com.github.unittests;

import com.github.firsthomework.ToTextConvertion;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ToTextConvertionTest {

    @Test
    public void convertExtended() {
        ToTextConvertion example = new ToTextConvertion();
        Assert.assertEquals("Сто пятьдесят два", example.convertExtended(152));
        Assert.assertEquals("Сто  миллионов", example.convertExtended(100000000));
        Assert.assertEquals("Десять миллиардов",example.convertExtended(10000000000L));
        Assert.assertEquals("Ноль",example.convertExtended(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertExtendedException() {
        ToTextConvertion example = new ToTextConvertion();
        example.convertExtended(-1);
    }
}