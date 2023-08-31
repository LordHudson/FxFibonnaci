package com.example.fxfibonnaci;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FibonacciController implements Initializable {

    @FXML
    private Label resultsLabel;

    @FXML
    private ChoiceBox<String> choiceBox;
    private final String BOOLEAN_CHECK = "Boolean Check", FIBO_INDEX = "Fibonacci Index";
    private final String[] choices = {BOOLEAN_CHECK, FIBO_INDEX};
    private String selectedChoice;

    @FXML
    private TextField numInput;

    @FXML
    protected void onCheckNumberClick() {
        String trueMessage = "True: The number x is a Fibonacci number";
        String falseMessage = "False: The number x is not a Fibonacci number";
        String fiboNumberAtIndex = "The Fibonacci number at position x is y";
        String invalidNumber = "Please enter a positive non-zero integer";
        int number;
        try {
            number = Integer.parseInt(numInput.getText());
            if (selectedChoice.equals(BOOLEAN_CHECK)) {
                boolean booleanResult = FibonacciChecker.isFibonacciNumber(number);
                boolean lessThanOne = number < 1;
                String message = booleanResult ? lessThanOne ? falseMessage : trueMessage : falseMessage;
                resultsLabel.setText(message.replace("x", String.valueOf(number)));
            } else {
                long index = FibonacciChecker.findFibonacciNumber(number);
                if (number < 1) {
                    resultsLabel.setText(invalidNumber);
                } else resultsLabel.setText(fiboNumberAtIndex.replace("x", String.valueOf(number)).replace("y",
                        String.valueOf(index)));
            }
        } catch (NumberFormatException | NullPointerException e) {
            resultsLabel.setText(invalidNumber);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll(choices);
        choiceBox.setOnAction(this::getChoice);

        choiceBox.setValue(BOOLEAN_CHECK);
    }

    private void getChoice(ActionEvent event) {
        selectedChoice = choiceBox.getValue();
    }
}