package ru.miet.testing;


import lombok.Data;

@Data
public class CalculatorViewImpl implements CalculatorView {

    private String first;
    private String second;
    private String result;
    private String error;

    @Override
    public void printResult(double result) {
           this.result = String.valueOf(result);
    }

    @Override
    public void displayError(String message) {
        error = message;
    }

    @Override
    public String getFirstArgumentAsString() {
        return first;
    }

    @Override
    public String getSecondArgumentAsString() {
        return second;
    }
}
