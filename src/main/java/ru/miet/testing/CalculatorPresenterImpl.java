package ru.miet.testing;

import lombok.Data;

@Data
public class CalculatorPresenterImpl implements CalculatorPresenter {

    private double first;
    private double second;
    private double result;

    private Calculator calc = new CalculatorImpl();
    private CalculatorGUI view;

    public CalculatorPresenterImpl(CalculatorGUI gui) {
        view = gui;
    }
    private void checkArguments() {

        try {
            first = Double.parseDouble(view.getFirstArgumentAsString());
        } catch (Exception e) {
            view.displayError("First argument is invalid");
        }
        try {
            second = Double.parseDouble(view.getSecondArgumentAsString());
        } catch (Exception e) {
            view.displayError("Second argument is invalid");
        }
    }

    @Override
    public void onPlusClicked() {
        checkArguments();
        result = calc.sum(first, second);
        view.printResult(result);
    }

    @Override
    public void onMinusClicked() {

        checkArguments();
        result = calc.subtract(first, second);
        view.printResult(result);

    }

    @Override
    public void onDivideClicked() {

        checkArguments();

        try {
            result = calc.divide(first, second);
            view.printResult(result);

        }
        catch (ArithmeticException e) {
            view.displayError("Divide by zero");
            throw e;
        }

    }

    @Override
    public void onMultiplyClicked() {

        checkArguments();

        result = calc.multiply(first, second);
        view.printResult(result);

    }
}
