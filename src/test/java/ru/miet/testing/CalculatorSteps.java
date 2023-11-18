package ru.miet.testing;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import ru.miet.testing.CalculatorPresenterImpl;

public class CalculatorSteps {
    private CalculatorPresenterImpl calculatorPresenter;
    private double result;
    private Exception exception;
    private double arg1;
    private double arg2;

    @Given("I have a calculator presenter")
    public void iHaveACalculatorPresenter() {
        var gui = new CalculatorGUI();
        calculatorPresenter = gui.getCalculatorPresenter();
    }

    @When("I click on plus with arguments {double} and {double}")
    public void iClickOnPlusWithArguments(double arg1, double arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        calculatorPresenter.setFirst(arg1);
        calculatorPresenter.setSecond(arg2);
        calculatorPresenter.onPlusClicked();
        result = calculatorPresenter.getResult();
    }

    @When("I click on minus with arguments {double} and {double}")
    public void iClickOnMinusWithArguments(double arg1, double arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        calculatorPresenter.setFirst(arg1);
        calculatorPresenter.setSecond(arg2);
        calculatorPresenter.onMinusClicked();
        result = calculatorPresenter.getResult();
    }

    @When("I click on multiply with arguments {double} and {double}")
    public void iClickOnMultiplyWithArguments(double arg1, double arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        calculatorPresenter.setFirst(arg1);
        calculatorPresenter.setSecond(arg2);
        calculatorPresenter.onMultiplyClicked();
        result = calculatorPresenter.getResult();
    }

    @When("I click on divide with arguments {double} and {double}")
    public void iClickOnDivideWithArguments(double arg1, double arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        calculatorPresenter.setFirst(arg1);
        calculatorPresenter.setSecond(arg2);
        try {
            calculatorPresenter.onDivideClicked();
            result = calculatorPresenter.getResult();
        } catch (ArithmeticException e) {
            exception = e;
        }
    }

    @Then("the result should be {double}")
    public void theResultShouldBeCalculator(double expected) {
        Assert.assertEquals(expected, result, 0.0001);
    }
    @Then("an error should occur")
    public void anErrorShouldOccur() {
        Assertions.assertNotNull(exception);
    }

    @And("I set the second argument to {double}")
    public void iSetTheSecondArgumentTo(double value) {
        this.arg2 = value;
        calculatorPresenter.setSecond(value);
    }
}
