package ru.miet.testing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorImplTest {

    private final Calculator calculator = new CalculatorImpl();

    @Test
    public void testSum() {
        double result = calculator.sum(2.0, 3.0);
        assertEquals(5.0, result, 0.0001);
    }

    @Test
    public void testSubtract() {
        double result = calculator.subtract(5.0, 3.0);
        assertEquals(2.0, result, 0.0001);
    }

    @Test
    public void testMultiply() {
        double result = calculator.multiply(2.0, 3.0);
        assertEquals(6.0, result, 0.0001);
    }

    @Test
    public void testDivide() {
        double result = calculator.divide(6.0, 3.0);
        assertEquals(2.0, result, 0.0001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        calculator.divide(6.0, 0.0);
    }
}