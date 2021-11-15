/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Alyssa Yee-Kee
 */

package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// main class
public class App extends Application {
    @Override

    // method creates gui
    public void start(Stage stage) throws IOException {
        // create gui
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("hello-view.fxml")); // open fxml file
        Scene scene = new Scene(fxmlLoader.load(), 740, 295); // create new scene to display
        stage.setTitle("To-Do List Maker"); // give title
        stage.setScene(scene); // set scene
        stage.show(); // display
    }

    // main method
    public static void main(String[] args) {
        launch(); // launch gui
    }
}