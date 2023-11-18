package ru.miet.testing;

import lombok.Data;

import javax.swing.*;
import java.awt.*;

public class CalculatorGUI extends JFrame implements CalculatorView {
    private JTextField firstArgumentField;
    private JTextField secondArgumentField;
    private JTextField resultField;
    private JTextField errorField;
    private JButton plusButton;
    private JButton minusButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton answerButton;

    private CalculatorPresenterImpl calculatorPresenter;

    public CalculatorGUI() {
        calculatorPresenter = new CalculatorPresenterImpl(this);
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2));

        JLabel firstArgumentLabel = new JLabel("First Argument:");
        panel.add(firstArgumentLabel);

        firstArgumentField = new JTextField();
        panel.add(firstArgumentField);

        JLabel secondArgumentLabel = new JLabel("Second Argument:");
        panel.add(secondArgumentLabel);

        secondArgumentField = new JTextField();
        panel.add(secondArgumentField);

        JLabel resultLabel = new JLabel("Result:");
        panel.add(resultLabel);

        resultField = new JTextField();
        resultField.setEditable(false);
        panel.add(resultField);
        errorField = new JTextField();
        errorField.setEditable(false);
        panel.add(errorField);

        plusButton = new JButton("+");
        panel.add(plusButton);
        plusButton.addActionListener(e -> onPlusClicked());

        minusButton = new JButton("-");
        minusButton.addActionListener(e -> onMinusClicked());
        panel.add(minusButton);

        multiplyButton = new JButton("*");
        multiplyButton.addActionListener(e -> onMultiplyClicked());
        panel.add(multiplyButton);

        divideButton = new JButton("/");
        divideButton.addActionListener(e -> onDivideClicked());
        panel.add(divideButton);



        add(panel);

        setVisible(true);
    }

    public JTextField getFirstArgumentField() {
        return firstArgumentField;
    }

    public JTextField getSecondArgumentField() {
        return secondArgumentField;
    }

    public JTextField getResultField() {
        return resultField;
    }

    public JButton getPlusButton() {
        return plusButton;
    }

    public JButton getMinusButton() {
        return minusButton;
    }

    public JButton getMultiplyButton() {
        return multiplyButton;
    }

    public JButton getDivideButton() {
        return divideButton;
    }

    public void onPlusClicked() {
        calculatorPresenter.onPlusClicked();
        printResult(calculatorPresenter.getResult());
    }

    public CalculatorPresenterImpl getCalculatorPresenter() {
        return calculatorPresenter;
    }

    public void setCalculatorPresenter(CalculatorPresenterImpl calculatorPresenter) {
        this.calculatorPresenter = calculatorPresenter;
    }

    public void onMinusClicked() {

        calculatorPresenter.onMinusClicked();
        printResult(calculatorPresenter.getResult());
    }

    public void setFirstArgumentField(JTextField firstArgumentField) {
        this.firstArgumentField = firstArgumentField;
    }

    public void setSecondArgumentField(JTextField secondArgumentField) {
        this.secondArgumentField = secondArgumentField;
    }

    public void setResultField(JTextField resultField) {
        this.resultField = resultField;
    }

    public JTextField getErrorField() {
        return errorField;
    }

    public void setErrorField(JTextField errorField) {
        this.errorField = errorField;
    }

    public void setPlusButton(JButton plusButton) {
        this.plusButton = plusButton;
    }

    public void setMinusButton(JButton minusButton) {
        this.minusButton = minusButton;
    }

    public void setMultiplyButton(JButton multiplyButton) {
        this.multiplyButton = multiplyButton;
    }

    public void setDivideButton(JButton divideButton) {
        this.divideButton = divideButton;
    }

    public JButton getAnswerButton() {
        return answerButton;
    }

    public void setAnswerButton(JButton answerButton) {
        this.answerButton = answerButton;
    }

    public void onDivideClicked() {
        try {

            calculatorPresenter.onDivideClicked();
            printResult(calculatorPresenter.getResult());
        } catch (Exception e) {
            displayError("Divide by zero");
        }
    }

    public void onMultiplyClicked() {

        calculatorPresenter.onMultiplyClicked();
        printResult(calculatorPresenter.getResult());

    }

    @Override
    public void printResult(double result) {
        resultField.setText(String.valueOf(result));
    }

    @Override
    public void displayError(String message) {
        errorField.setText(message);
    }

    @Override
    public String getFirstArgumentAsString() {
        return firstArgumentField.getText();
    }

    @Override
    public String getSecondArgumentAsString() {
        return secondArgumentField.getText();
    }
}
