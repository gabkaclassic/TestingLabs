package ru.miet.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;


public class CalculatorPresenterTest {

    private static CalculatorPresenterImpl calculatorPresenter;

    @BeforeAll
    static void setupAll() {
        var gui = new CalculatorGUI();
        calculatorPresenter = gui.getCalculatorPresenter();
    }

    @BeforeEach
    void setup() {

        calculatorPresenter.setFirst(1);
        calculatorPresenter.setSecond(2);
    }

    @Test
    void onPlusClicked() {
        calculatorPresenter.onPlusClicked();
        Assertions.assertEquals(3, calculatorPresenter.getResult());
    }

    @Test
    void onMinusClicked() {

        calculatorPresenter.onMinusClicked();
        Assertions.assertEquals(-1, calculatorPresenter.getResult());
    }

    @Test
    void onDivideClicked() {

        calculatorPresenter.onDivideClicked();
        Assertions.assertEquals(0.5, calculatorPresenter.getResult());
    }


    @Test
    void onMultiplyClicked() {

        calculatorPresenter.onMultiplyClicked();
        Assertions.assertEquals(2, calculatorPresenter.getResult());

    }
}
