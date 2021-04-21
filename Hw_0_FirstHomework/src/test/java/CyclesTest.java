import com.github.firsthomework.Cycles;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CyclesTest {

    @Test
    public void sumOfEvenNumber() {
        Assert.assertEquals(2450, Cycles.sumOfEvenNumber());
    }

    @Test
    public void isPrime() {
        Assert.assertEquals(false,Cycles.isPrime(25));
        Assert.assertEquals(true,Cycles.isPrime(23));
    }

    @Test
    public void squareRootSimple() {
        Assert.assertEquals(4,Cycles.squareRootSimple(19));
        Assert.assertEquals(3,Cycles.squareRootSimple(10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void squareRootSimpleException() {
        Cycles.squareRootSimple(-10);
    }

    @Test
    public void squareRootBinary() {
        Assert.assertEquals(4,Cycles.squareRootBinary(19));
        Assert.assertEquals(3,Cycles.squareRootBinary(10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void squareRootSimpleExceptionException() {
        Cycles.squareRootBinary(-10);
    }

    @Test
    public void factorial() {
        Assert.assertEquals(120,Cycles.factorial(5));
        Assert.assertEquals(24, Cycles.factorial(4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void factorialException() {
        Cycles.factorial(-1);
    }

    @Test
    public void sumOfNumbers() {
        Assert.assertEquals(12,Cycles.sumOfNumbers(552));
        Assert.assertEquals(0,Cycles.sumOfNumbers(0));
    }

    @Test
    public void reverseNumber() {
        Assert.assertEquals(123,Cycles.reverseNumber(321));
        Assert.assertEquals(12,Cycles.reverseNumber(210));
        Assert.assertEquals(101,Cycles.reverseNumber(101));
    }
}