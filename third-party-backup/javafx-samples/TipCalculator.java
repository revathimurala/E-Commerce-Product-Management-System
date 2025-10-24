package com.example.tip;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Simple Tip Calculator JavaFX app.
 * Run with JavaFX on the module-path.
 */
public class TipCalculator extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tip Calculator");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        Label billLabel = new Label("Bill amount:");
        TextField billField = new TextField();
        billField.setPromptText("e.g. 100.0");

        Label tipLabel = new Label("Tip %:");
        TextField tipField = new TextField();
        tipField.setPromptText("e.g. 15");

        Button calcBtn = new Button("Calculate");
        Label resultLabel = new Label("Tip: ");

        grid.add(billLabel, 0, 0);
        grid.add(billField, 1, 0);
        grid.add(tipLabel, 0, 1);
        grid.add(tipField, 1, 1);
        grid.add(calcBtn, 0, 2);
        grid.add(resultLabel, 1, 2);

        calcBtn.setOnAction(e -> {
            try {
                double bill = Double.parseDouble(billField.getText().trim());
                double tipPercent = Double.parseDouble(tipField.getText().trim());
                double tip = bill * tipPercent / 100.0;
                resultLabel.setText(String.format("Tip: %.2f (Total: %.2f)", tip, bill + tip));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        });

        Scene scene = new Scene(grid, 350, 180);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
