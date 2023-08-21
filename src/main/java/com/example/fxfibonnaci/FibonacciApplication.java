package com.example.fxfibonnaci;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FibonacciApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FibonacciApplication.class.getResource("fibonnaci.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Fibonacci Number Checker!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}