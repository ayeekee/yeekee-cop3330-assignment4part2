/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Alyssa Yee-Kee
 */

package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

// class defines objects for a to-do list
class tdItem{
    // string variable for the item description
    // string variable for the date

    // create to-do list fields and set equal to each other
    tdItem(String itemDesc, String date, Boolean mark){
        // set itemDesc to each other
        // set date to each other
        // set status to false automatically
    }
}

// main class
public class App extends Application {
    @Override

    // create variable that stores base path which to-do files will be stored in

    // method creates gui
    public void start(Stage stage) throws IOException {
        // create gui
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("hello-view.fxml")); // open fxml file
        Scene scene = new Scene(fxmlLoader.load(), 320, 240); // create new scene to display
        stage.setTitle("To-Do List Maker"); // give title
        stage.setScene(scene); // set scene
        stage.show(); // display
    }

    // main method
    public static void main(String[] args) {
        // create string variable to store to-do list title
        // prompt user for a to-do list title
        // call addList function, pass in string title

        // create object variable list for tdList class
        // create arraylist object of type tdItem

        launch(); // launch gui
    }
}