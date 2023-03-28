package com.example.numeralconvertergui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class NumeralConverterGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a GridPane to hold our controls
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        // Add labels and text fields for input and output
        Label inputLabel = new Label("Input number:");
        gridPane.add(inputLabel, 0, 0);

        TextField inputField = new TextField();
        gridPane.add(inputField, 1, 0);

        Label fromLabel = new Label("From:");
        gridPane.add(fromLabel, 0, 1);

        ComboBox<String> fromComboBox = new ComboBox<>();
        fromComboBox.getItems().addAll("Binary", "Octal", "Decimal", "Hexadecimal");
        fromComboBox.setValue("Binary");
        gridPane.add(fromComboBox, 1, 1);

        Label toLabel = new Label("To:");
        gridPane.add(toLabel, 0, 2);

        ComboBox<String> toComboBox = new ComboBox<>();
        toComboBox.getItems().addAll("Binary", "Octal", "Decimal", "Hexadecimal");
        toComboBox.setValue("Octal");
        gridPane.add(toComboBox, 1, 2);

        Label outputLabel = new Label("Output number:");
        gridPane.add(outputLabel, 0, 3);

        TextField outputField = new TextField();
        outputField.setEditable(false);
        gridPane.add(outputField, 1, 3);

        // Add a button to perform the conversion
        Button convertButton = new Button("Convert");
        convertButton.setOnAction(event -> {
            // Get the input number and numeral systems
            String inputNum = inputField.getText();
            String fromNumeralSystem = fromComboBox.getValue();
            String toNumeralSystem = toComboBox.getValue();

            // Call your conversion function here to get the output number
            String outputNum = Convert.doconvert(inputNum, fromNumeralSystem, toNumeralSystem);

            // Set the output field to the output number
            outputField.setText(outputNum);
        });
        gridPane.add(convertButton, 1, 4);

        // Create a scene and set it on the stage
        Scene scene = new Scene(gridPane, 400, 250);
        primaryStage.setTitle("Numeral Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

