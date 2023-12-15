package com.example.nasa.Controller;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SplashController {

    // Injected FXML element
    @FXML
    private Button changeToPage;

    // Handle button click to transition to the next page
    @FXML
    public void nextPage() {
        // Show a loading dialog to indicate that the transition is in progress
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please wait...", ButtonType.CLOSE);
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStyleClass().add("wait-dialog"); // Assuming you have a CSS class for styling the dialog
        alert.show();

        // Create a background task for simulating a delay
        Task<Void> task = new Task<>() {
            @Override
            protected Void call() throws Exception {
                // Simulate a delay (e.g., fetching data, loading resources, etc.)
                Thread.sleep(2000);
                return null;
            }
        };

        // Set up an event handler for when the background task is succeeded
        task.setOnSucceeded(event -> {
            // Close the loading dialog
            alert.close();
            try {
                // Load the FXML file for the next page
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/nasa/nasa_missions.fxml"));
                Parent nextSceneRoot = loader.load();

                // Create a new scene with the loaded parent
                Scene nextScene = new Scene(nextSceneRoot);

                // Get the primary stage and set the new scene
                Stage primaryStage = (Stage) changeToPage.getScene().getWindow();
                primaryStage.setScene(nextScene);
                primaryStage.setTitle("NASA Missions");  // Set the title for the next scene
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Start the background task in a new thread
        new Thread(task).start();
    }
}
