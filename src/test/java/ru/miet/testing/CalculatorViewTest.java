package ru.miet.testing;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorViewTest {

    private CalculatorGUI calculatorView = new CalculatorGUI();
    @BeforeEach
    void setUp() {
        calculatorView.getFirstArgumentField().setText("1");
        calculatorView.getSecondArgumentField().setText("2");
        calculatorView.printResult(12);
    }

    @Test
    void getFirstArgumentAsString() {
        String argument = calculatorView.getFirstArgumentAsString();
        assertEquals("1", argument);
    }

    @Test
    void getSecondArgumentAsString() {
        String argument = calculatorView.getSecondArgumentAsString();
        assertEquals("2", argument);
    }
    @Test
    void getResult() {
        calculatorView.printResult(12);
        assertEquals("12.0", calculatorView.getResultField().getText());
    }
    @Test
    void getError() {
        calculatorView.displayError("Invalid argument");
        assertEquals("Invalid argument", calculatorView.getErrorField().getText());
    }


}
