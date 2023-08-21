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
    private final String[] choices = {BOOLEAN_CHECK,FIBO_INDEX};
    private String selectedChoice;

    @FXML
    private TextField numInput;

    @FXML
    protected void onCheckNumberClick() {
        String trueMessage = "True: the number x is a fibonacci number";
        String falseMessage = "False: the number x is not a fibonacci number";
        String fiboNumberAtIndex = "The fibonacci number at position x is y";
        int number;
        try{
            number = Integer.parseInt(numInput.getText());
            if (selectedChoice == null){
                throw new NullPointerException("Choice not selected");
            } else if (selectedChoice.equals(BOOLEAN_CHECK)){
                boolean booleanResult = FibonacciChecker.isFibonacciNumber(number);
                String message = booleanResult ? trueMessage:falseMessage;
                resultsLabel.setText(message.replace("x",String.valueOf(number)));
            } else {
                long index = FibonacciChecker.findFibonacciNumber(number);
                resultsLabel.setText(fiboNumberAtIndex.replace("x", String.valueOf(number)).replace("y",
                        String.valueOf(index)));
            }
        } catch (NumberFormatException | NullPointerException e){
            System.out.println(e.getMessage());
            resultsLabel.setText("Select an option from the drop down");
        }
        System.out.println(selectedChoice);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.setValue("Make a selection");
        choiceBox.getItems().addAll(choices);
        choiceBox.setOnAction(this::getChoice);
    }

    private void getChoice(ActionEvent event){
        selectedChoice = choiceBox.getValue();
    }
}