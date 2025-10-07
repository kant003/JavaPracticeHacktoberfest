package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI {
    private static String currentInput = "";
    private static String operator = "";
    private static double firstNumber = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");

        JTextField resultField = new JTextField();
        resultField.setBounds(20, 20, 240, 40);
        resultField.setEditable(false);
        resultField.setHorizontalAlignment(JTextField.RIGHT);
        resultField.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(20, 80, 240, 240);
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            buttonPanel.add(button);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String buttonText = button.getText();

                    if (buttonText.matches("\\d")) {
                        currentInput += buttonText;
                        resultField.setText(currentInput);
                    } else if (buttonText.equals("C")) {
                        currentInput = "";
                        operator = "";
                        firstNumber = 0;
                        resultField.setText("");
                    } else if (buttonText.equals("=")) {
                        try {
                            double secondNumber = Double.parseDouble(currentInput);
                            double result = performOperation(firstNumber, secondNumber, operator);
                            resultField.setText(String.valueOf(result));
                            currentInput = "";
                        } catch (Exception ex) {
                            resultField.setText("Error");
                        }
                    } else {
                        if (!currentInput.isEmpty()) {
                            firstNumber = Double.parseDouble(currentInput);
                            operator = buttonText;
                            currentInput = "";
                        }
                    }
                }
            });
        }

        frame.add(resultField);
        frame.add(buttonPanel);

        frame.setSize(300, 400);
        frame.setLocation(400,150);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static double performOperation(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) throw new ArithmeticException("Division by zero");
                return num1 / num2;
            default:
                throw new UnsupportedOperationException("Invalid operator");
        }
    }
}

