package com.github.unittests;

import com.github.firsthomework.ConditionalStatements;
import org.junit.Assert;
import org.junit.Test;

public class ConditionalStatementsTest {

    @Test
    public void sumOrMulti() {
        Assert.assertEquals(12, ConditionalStatements.sumOrMulti(4,3));
        Assert.assertEquals(7, ConditionalStatements.sumOrMulti(3,4));
        Assert.assertEquals(100, ConditionalStatements.sumOrMulti(10,10));
    }

    @Test
    public void pointAnalytics() {
        Assert.assertEquals(1,ConditionalStatements.pointAnalytics(1,1));
        Assert.assertEquals(2,ConditionalStatements.pointAnalytics(-11,1));
        Assert.assertEquals(3,ConditionalStatements.pointAnalytics(-2,-31));
        Assert.assertEquals(4,ConditionalStatements.pointAnalytics(1,-5));
        Assert.assertEquals(0,ConditionalStatements.pointAnalytics(1,0));
    }

    @Test
    public void sumOfPositive() {
        Assert.assertEquals(7,ConditionalStatements.sumOfPositive(2,4,1));
        Assert.assertEquals(5,ConditionalStatements.sumOfPositive(-2,4,1));
        Assert.assertEquals(2,ConditionalStatements.sumOfPositive(2,-4,-1));
        Assert.assertEquals(0,ConditionalStatements.sumOfPositive(-2,-4,-1));
    }

    @Test
    public void resultOfEquation() {
        Assert.assertEquals(11,ConditionalStatements.resultOfEquation(2,4,1));
        Assert.assertEquals(8,ConditionalStatements.resultOfEquation(0,4,1));
        Assert.assertEquals(9,ConditionalStatements.resultOfEquation(2,3,1));
    }

    @Test
    public void studentGrade(){
        Assert.assertEquals('A',ConditionalStatements.studentGrade(95));
        Assert.assertEquals('B',ConditionalStatements.studentGrade(80));
        Assert.assertEquals('C',ConditionalStatements.studentGrade(70));
        Assert.assertEquals('D',ConditionalStatements.studentGrade(55));
        Assert.assertEquals('E',ConditionalStatements.studentGrade(35));
        Assert.assertEquals('F',ConditionalStatements.studentGrade(15));
    }

    @Test(expected = IllegalArgumentException.class)
    public void studentGradeExeption() throws IllegalArgumentException{
        ConditionalStatements.studentGrade(105);
    }
}