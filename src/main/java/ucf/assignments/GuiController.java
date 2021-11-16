/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Alyssa Yee-Kee
 */

package ucf.assignments;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.ResourceBundle;

// class controls gui for user interaction with buttons
public class GuiController implements Initializable {

    // create objects for gui interaction
    @FXML private DatePicker datePicker; // date selector
    @FXML private TextArea descBox; // text field for user to enter description
    @FXML private TableView<Item> tableOfList; // table to display to do list items
    @FXML private TableColumn<Item, String> descCol; // description column of table
    @FXML private TableColumn<Item, String> dateCol; // date column of table
    @FXML private TableColumn<Item, CheckBox> statusCol; // status column of table

    // create observable arraylist objects
    public ObservableList<Item> tdList = FXCollections.observableArrayList(); // main list
    public ObservableList<Item> loadList = FXCollections.observableArrayList(); // temp list when loading in data from file
    public ArrayList<Item> tempList;

    // create file chooser for user to save and load lists
    public FileChooser fileChooser = new FileChooser();

    // create initialize method to set up gui variables
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fileChooser.setInitialDirectory(new File("C:\\temp")); // base path for users to save and load to do lists
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text doc(*.txt)", "*.txt")); // set file for save to .txt
        fileChooser.setInitialFileName(".txt"); // include .txt in file name

        datePicker.setValue(LocalDate.now()); // default date selector to current date

        // initialize table columns
        descCol.setCellValueFactory(new PropertyValueFactory<Item, String>("desc"));
        dateCol.setCellValueFactory(new PropertyValueFactory<Item, String>("date"));
        statusCol.setCellValueFactory(new PropertyValueFactory<Item, CheckBox>("status"));

        tableOfList.setItems(tdList); // display tdList to table
    }

    // method adds a new to do list item to table
    @FXML
    void addItem(ActionEvent event) {
        String holdDesc = descBox.getText(); // get description from user

        String holdDate = "";
        LocalDate date = datePicker.getValue(); // get date from user
        holdDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")); // convert date to string

        // make sure description is between 1 and 256 characters
        if(holdDesc.length() >= 1 && holdDesc.length() <= 256){
            Item item = new Item(holdDesc, holdDate); // create new item with given input
            tableOfList.getItems().add(item); // display item to table

            descBox.clear(); // clear description box of previous input when done
        }
        else{ // if not, display error message
            AlertDisplay("Description Input Error","Your description must be between 1 and 256 characters!");
        }
    }

    // method deletes selected item from table/list
    @FXML
    void deleteItem(ActionEvent event) {
        tableOfList.getItems().removeAll(tableOfList.getSelectionModel().getSelectedItem());
    }

    // method deletes all items from table/list
    @FXML
    void clearList(ActionEvent event) {
        tableOfList.getItems().clear();
    }

    // method allows user to edit description and date input
    @FXML
    void editItem(ActionEvent event) {
        tableOfList.setEditable(true);

        // allows user to edit description of an item
        descCol.setCellFactory(TextFieldTableCell.forTableColumn());
        descCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Item, String>>(){
            @Override
            public void handle(TableColumn.CellEditEvent<Item, String> event){
                Item item = event.getRowValue(); // get previous desc of the selected row

                if (event.getNewValue().length() >= 1 && event.getNewValue().length() <= 256) {
                    item.setDesc(event.getNewValue()); // update description if between 1-256 words
                } else {
                    AlertDisplay("Description Input Error","Your description must be between 1 and 256 characters!"); // display error if not
                }
            }
        });

        // allows user to edit the due date of an item
        dateCol.setCellFactory(TextFieldTableCell.forTableColumn());
        dateCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Item, String>>(){
            @Override
            public void handle(TableColumn.CellEditEvent<Item, String> event){
                Item item = event.getRowValue(); // get previous date of the selected row

                if(dateValidator(event.getNewValue())){ // if the new date is the in the correct format,
                    item.setDate(event.getNewValue()); // update date
                } else {
                    AlertDisplay("Date Input Error", "Your date must be in the \"yyyy-mm-dd\" format!"); // otherwise, throw error message
                }
            }
        });
    }

    // method displays all to do list items regardless of completion
    @FXML
    void displayAll(ActionEvent event) {
        tableOfList.setItems(tdList);
    }

    // method displays to do list items that are complete
    @FXML
    void displayComp(ActionEvent event) {
        ObservableList<Item> completeList = FXCollections.observableArrayList(); // create temp arraylist for complete items

        for(Item temp : tdList){
            if(temp.getStatus().isSelected()){ // if checkBox is selected append to temp arraylist
                completeList.add(temp);
            }
        }
        tableOfList.setItems(completeList); // display completed items only
    }

    // method displays to do list items that are incomplete
    @FXML
    void displayIncomplete(ActionEvent event) {
        ObservableList<Item> incompleteList = FXCollections.observableArrayList(); // create temp arraylist for incomplete items

        for(Item temp : tdList){
            if(!temp.getStatus().isSelected()){ // if checkBox is not selected, append to temp arraylist
                incompleteList.add(temp);
            }
        }
        tableOfList.setItems(incompleteList); // display incomplete items only
    }

    // method allows user to save their to do list to their hard drive
    @FXML
    void saveList(ActionEvent event) throws Exception {
        File file = fileChooser.showSaveDialog(new Stage()); // display file chooser screen to user

        try{
            if (file != null) {
                if (file.getName().endsWith(".txt")) { // if the file is a txt file,
                    // write the info in the tdList array to the file
                    BufferedWriter bw = new BufferedWriter(new FileWriter(file));

                    int i = 0;

                    // use comma to separate elements in the file to make loading in the list easier
                    while(i < tdList.size()){
                        if(tdList.get(i) != null){
                            bw.write(tdList.get(i).getDesc()); // write desc
                            bw.write(",");
                            bw.write(tdList.get(i).getDate()); // write date
                            bw.write(",");
                            bw.write(String.valueOf(tdList.get(i).getStatus().isSelected())); // write whether or not the checkBox is marked
                            bw.write("\n");
                        }
                        i++;
                    }
                    bw.close();
                } else {
                    AlertDisplay("File Extension Error", "Your file must end with .txt!"); // if the file is not .txt, display error
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // method allows user to open a to do list they have previously saved
    @FXML
    void loadList(ActionEvent event) throws IOException {
        File file = fileChooser.showOpenDialog(new Stage()); // open fileChooser for user to select file to load in

        try {
            if(file != null){
                tdList.clear(); // clear tdList of any previous items

                // read in info from the file
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                String line = br.readLine();

                while(line != null){
                    String[] temp = line.split(","); // use comma as delimiter

                    Item item = new Item(temp[0], temp[1]); // create new item based off the desc and date fields

                    CheckBox stat = new CheckBox(); // create checkbox object to display to table

                    if(temp[2].equals("true")){ // set checkbox to display with a checkmark if true
                        stat.setSelected(true);
                    } else{
                        stat.setSelected(false); // if not, display without checkmark
                    }

                    item.setStatus(stat); // set status based on above

                    loadList.add(item);
                    line = br.readLine();
                }

                tdList = loadList;
                tableOfList.setItems(tdList); // display list
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // method closes gui when user selects the exit option in the menu dropdown
    @FXML
    void exit(ActionEvent event) {
        Platform.exit();
    }

    // method validates date format
    public Boolean dateValidator(String date){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            format.parse(date);
        } catch(DateTimeParseException e) {
            return false;
        }
        return true;
    }

    // method displays error pop up with the given title and message
    public void AlertDisplay(String title, String message){
        // create the window
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);

        // create close button
        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());

        VBox bg = new VBox(10);
        bg.getChildren().addAll(label, closeButton);
        bg.setAlignment(Pos.CENTER);

        // display to user
        Scene scene = new Scene(bg);
        window.setScene(scene);
        window.showAndWait();
    }
}