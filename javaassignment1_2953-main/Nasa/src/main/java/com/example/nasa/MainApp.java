package com.example.nasa;

import com.example.nasa.Controller.SplashController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.Image;


import java.io.IOException;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the FXML file for the splash screen
            FXMLLoader splashLoader = new FXMLLoader(getClass().getResource("splash.fxml"));
            Parent splashRoot = splashLoader.load();
            Scene splashScene = new Scene(splashRoot);

            // Get the controller from the FXMLLoader
            SplashController splashController = splashLoader.getController();

            // Set the scene for the primary stage
            primaryStage.setScene(splashScene);

            // Set the title of the primary stage
            primaryStage.setTitle("Nasa Missions");

            // set the icon of the primary stage
            primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("logo.png")));


            // Make the primary stage visible
            primaryStage.show();

            // Schedule a transition to the main scene after a delay
            Duration delay = Duration.seconds(2); // Adjust the delay as needed (2 seconds in this example)
            KeyFrame keyFrame = new KeyFrame(delay, event -> transitionToMainScene(primaryStage));
            Timeline timeline = new Timeline(keyFrame);
            timeline.play();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void transitionToMainScene(Stage primaryStage) {
        try {
            // Load the FXML file for the main scene
            FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("main_scene.fxml"));
            Parent mainRoot = mainLoader.load();
            Scene mainScene = new Scene(mainRoot);

            // Set the scene for the primary stage
            primaryStage.setScene(mainScene);

            // Set the title of the primary stage
            primaryStage.setTitle("Main Scene");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
