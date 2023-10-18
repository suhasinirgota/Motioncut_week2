/* Task: Temperature Converter
Objective: Build a program in Java that converts temperatures between Celsius and Fahrenheit.
Details: This task will enhance your understanding of basic mathematical operations and user input in Java. Your program should have the following features:
1. It should allow users to input a temperature value and specify whether it's in Celsius or Fahrenheit.
2. Depending on the user's input, your program should convert the temperature to the other unit and display the result.
3. The conversion formulas are as follows:
      - Celsius to Fahrenheit: (Celsius * 9/5) + 32
      - Fahrenheit to Celsius: (Fahrenheit - 32) * 5/9
4. Ensure your program handles input validation (e.g., ensuring the temperature value is valid, and the unit is specified correctly).
5. Provide a user-friendly interface with clear instructions.*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Task1 {
    private JFrame frame;
    private JPanel panel;
    private JTextField inputField;
    private JLabel resultLabel;
    private JComboBox<String> fromUnitComboBox;
    private JComboBox<String> toUnitComboBox;

    public Task1() {
        frame = new JFrame("Temperature Converter");
        panel = new JPanel(new GridLayout(4, 2));
        inputField = new JTextField(10);

        resultLabel = new JLabel("Converted Temperature: ");
        fromUnitComboBox = new JComboBox<>(new String[]{"Celsius", "Fahrenheit"});
        toUnitComboBox = new JComboBox<>(new String[]{"Fahrenheit", "Celsius"});

        Font customFont = new Font("sans-serif", Font.PLAIN, 20);

        resultLabel.setFont(customFont);
        inputField.setFont(customFont);
        fromUnitComboBox.setFont(customFont);
        toUnitComboBox.setFont(customFont);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 300);
        frame.setResizable(true);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Convert From:");
        Font font = new Font("sans-serif", Font.PLAIN, 20);
        label.setFont(font);
        panel.add(label);
        panel.add(fromUnitComboBox);
        JLabel convertToLabel = new JLabel("Convert To:");
        Font convertToFont = new Font("Arial", Font.PLAIN, 20);
        convertToLabel.setFont(convertToFont);
        panel.add(convertToLabel);        
        panel.add(toUnitComboBox);
        JLabel convertedLabel = new JLabel("Converted Temperature is:");
        Font convertedFont = new Font("Arial", Font.PLAIN, 20);
        convertedLabel.setFont(convertedFont);
        panel.add(convertedLabel);        
        panel.add(inputField);
        

        panel.add(new JLabel(""));
        panel.add(resultLabel);

        frame.add(panel);

        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertTemperature();
            }
        });

        frame.setVisible(true);
    }

    private void convertTemperature() {
        try {
            double temperature = Double.parseDouble(inputField.getText());
            String fromUnit = (String) fromUnitComboBox.getSelectedItem();
            String toUnit = (String) toUnitComboBox.getSelectedItem();

            double convertedTemperature;

            if ((fromUnit.equals("Celsius") && toUnit.equals("Fahrenheit")) ||
                (fromUnit.equals("Fahrenheit") && toUnit.equals("Celsius"))) {

                if (fromUnit.equals("Celsius") && (temperature < -100 || temperature > 100)) {
                    resultLabel.setText("Invalid input. Temperature out of range.");
                    return;
                }

                if (fromUnit.equals("Fahrenheit") && (temperature < -148 || temperature > 212)) {
                    resultLabel.setText("Invalid input. Temperature out of range.");
                    return;
                }

                if (toUnit.equals("Celsius") && fromUnit.equals("Fahrenheit")) {
                    convertedTemperature = (temperature - 32) * 5 / 9;
                } else {
                    convertedTemperature = (temperature * 9 / 5) + 32;
                }

                resultLabel.setText("Converted Temperature: " + convertedTemperature + " " + toUnit);
            } else {
                resultLabel.setText("Invalid conversion");
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input. Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Task3();
            }
        });
    }
}


















































