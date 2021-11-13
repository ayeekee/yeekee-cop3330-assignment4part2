/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Alyssa Yee-Kee
 */

package ucf.assignments;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

// class defines objects for a to-do list
class tdItem{
    private SimpleStringProperty desc;
    private LocalDate date;
    private Boolean status;

    public tdItem(LocalDate date, String desc, Boolean status){
        this.desc = new SimpleStringProperty(desc);
        this.date = date;
        this.status = status;
    }

    public String getDesc(){
        return desc.get();
    }

    public void setDesc(String desc){
        this.desc = new SimpleStringProperty(desc);
    }

    public LocalDate getDate(){
        return date;
    }

    public void setDate(LocalDate date){
        this.date = date;
    }

    public Boolean getStatus(){
        return status;
    }

    public void setStatus(Boolean status){
        this.status = status;
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
        Scene scene = new Scene(fxmlLoader.load(), 740, 310); // create new scene to display
        stage.setTitle("To-Do List Maker"); // give title
        stage.setScene(scene); // set scene
        stage.show(); // display
    }

    // main method
    public static void main(String[] args) {
        // create string variable to store to-do list title
        // prompt user for a to-do list title
        // call addList function, pass in string title

        // create arraylist object of type tdItem
        // ArrayList<tdItem> tdList = new ArrayList<>();

        launch(); // launch gui
    }
}