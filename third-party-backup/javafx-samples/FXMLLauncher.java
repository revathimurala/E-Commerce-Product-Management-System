package com.example.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Small launcher that loads lab-records/Exercise-8/JavaFX_NoCode/LabelAndImage.fxml
 * Run with JavaFX on the module-path.
 */
public class FXMLLauncher extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Use a file URL because the FXML is in the workspace outside the classpath root.
        String fxmlPath = "file:lab-records/Exercise-8/JavaFX_NoCode/LabelAndImage.fxml";
        Parent root = FXMLLoader.load(new java.net.URI(fxmlPath).toURL());
        primaryStage.setTitle("FXML Only Demo");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
