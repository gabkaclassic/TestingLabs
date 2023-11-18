package ru.miet.testing;

public class CalculatorImpl implements Calculator {
    @Override
    public double sum(double a, double b) {
        return a+b;
    }

    @Override
    public double subtract(double a, double b) {
        return a-b;
    }

    @Override
    public double multiply(double a, double b) {
        return a*b;
    }

    @Override
    public double divide(double a, double b) {

        if(b == 0)
            throw new ArithmeticException("Divide by zero");

        return a/b;
    }
}
