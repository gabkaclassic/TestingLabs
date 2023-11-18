package ru.miet.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CalculatorGUITest {
    @Mock
    private JTextField firstArgumentField;
    @Mock
    private JTextField secondArgumentField;
    @Mock
    private JTextField resultField;
    @Mock
    private JTextField errorField;
    @Mock
    private JButton plusButton;
    @Mock
    private JButton minusButton;
    @Mock
    private JButton multiplyButton;
    @Mock
    private JButton divideButton;
    @Mock
    private CalculatorPresenterImpl cpi;
    private CalculatorGUI calculatorGUI = new CalculatorGUI();


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        calculatorGUI.setCalculatorPresenter(cpi);
        calculatorGUI.setFirstArgumentField(firstArgumentField);
        calculatorGUI.setSecondArgumentField(secondArgumentField);
        calculatorGUI.setResultField(resultField);
        calculatorGUI.setErrorField(errorField);
        calculatorGUI.setPlusButton(plusButton);
        calculatorGUI.setMinusButton(minusButton);
        calculatorGUI.setMultiplyButton(multiplyButton);
        calculatorGUI.setDivideButton(divideButton);
    }

    @Test
    void getFirstArgumentAsString() {
        when(firstArgumentField.getText()).thenReturn("7");
        String argument = calculatorGUI.getFirstArgumentAsString();
        assertEquals("7", argument);
    }

    @Test
    void getSecondArgumentAsString() {
        when(secondArgumentField.getText()).thenReturn("8.0");
        String argument = calculatorGUI.getSecondArgumentAsString();
        assertEquals("8.0", argument);
    }
    @Test
    void plusClicked() {
        calculatorGUI.onPlusClicked();
        verify(cpi, times(1)).onPlusClicked();
    }
    @Test
    void minusClicked() {
        calculatorGUI.onMinusClicked();
        verify(cpi, times(1)).onMinusClicked();
    }
    @Test
    void divideClicked() {
        calculatorGUI.onDivideClicked();
        verify(cpi, times(1)).onDivideClicked();
    }
    @Test
    void multClicked() {
        calculatorGUI.onMultiplyClicked();
        verify(cpi, times(1)).onMultiplyClicked();
    }
}
