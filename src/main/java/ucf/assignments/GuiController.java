/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Alyssa Yee-Kee
 */

package ucf.assignments;

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
import javafx.stage.Window;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.ResourceBundle;

// class controls gui for user interaction with buttons
public class GuiController implements Initializable {

    @FXML private Button addItemButton;
    @FXML private MenuItem deleteOption;
    @FXML private MenuItem clearOption;
    @FXML private MenuItem editOption;
    @FXML private MenuItem displayCompOption;
    @FXML private MenuItem displayIncompOption;
    @FXML private MenuItem displayAll;

    @FXML private DatePicker datePicker;
    @FXML private TextArea descBox;

    @FXML private TableView<Item> tableOfList;
    @FXML private TableColumn<Item, String> descCol;
    @FXML private TableColumn<Item, String> dateCol;
    @FXML private TableColumn<Item, CheckBox> statusCol;

    public ObservableList<Item> tdList = FXCollections.observableArrayList();

    FileChooser fileChooser = new FileChooser();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fileChooser.setInitialDirectory(new File("C:\\temp"));

        datePicker.setValue(LocalDate.now());

        descCol.setCellValueFactory(new PropertyValueFactory<Item, String>("desc"));
        dateCol.setCellValueFactory(new PropertyValueFactory<Item, String>("date"));
        statusCol.setCellValueFactory(new PropertyValueFactory<Item, CheckBox>("status"));

        tableOfList.setItems(tdList);
    }

    @FXML
    void addItem(ActionEvent event) {
        String holdDesc = "";
        holdDesc = descBox.getText();

        String holdDate = "";
        LocalDate date = datePicker.getValue();
        holdDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        if(holdDesc.length() >= 1 && holdDesc.length() <= 256){
            Item item = new Item(holdDesc, holdDate);
            tableOfList.getItems().add(item);

            descBox.clear();
        }
        else{
            descAlertDisplay();
        }
    }

    @FXML
    void deleteItem(ActionEvent event) {
        tableOfList.getItems().removeAll(tableOfList.getSelectionModel().getSelectedItem());
    }

    @FXML
    void clearList(ActionEvent event) {
        tableOfList.getItems().clear();
    }

    @FXML
    void editItem(ActionEvent event) {
        tableOfList.setEditable(true);

        descCol.setCellFactory(TextFieldTableCell.forTableColumn());
        descCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Item, String>>(){
            @Override
            public void handle(TableColumn.CellEditEvent<Item, String> event){
                Item item = event.getRowValue();

                if (event.getNewValue().length() >= 1 && event.getNewValue().length() <= 256) {
                    item.setDesc(event.getNewValue());
                } else {
                    descAlertDisplay();
                }
            }
        });

        dateCol.setCellFactory(TextFieldTableCell.forTableColumn());
        dateCol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Item, String>>(){
            @Override
            public void handle(TableColumn.CellEditEvent<Item, String> event){
                Item item = event.getRowValue();

                if(dateValidator(event.getNewValue())){
                    item.setDate(event.getNewValue());
                } else {
                    dateAlertDisplay();
                }
            }
        });
    }

    @FXML
    void displayAll(ActionEvent event) {
        tableOfList.setItems(tdList);
    }

    @FXML
    void displayComp(ActionEvent event) {
        ObservableList<Item> completeList = FXCollections.observableArrayList();

        for(Item temp : tdList){
            if(temp.getStatus().isSelected()){
                completeList.add(temp);
            }
        }

        tableOfList.setItems(completeList);
    }

    @FXML
    void displayIncomplete(ActionEvent event) {
        ObservableList<Item> incompleteList = FXCollections.observableArrayList();

        for(Item temp : tdList){
            if(!temp.getStatus().isSelected()){
                incompleteList.add(temp);
            }
        }

        tableOfList.setItems(incompleteList);
    }

    @FXML
    void saveList(ActionEvent event) {
        VBox menu;

        Window stage = menu.getScene().getWindow();

    }

    public Boolean dateValidator(String date){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            format.parse(date);
        } catch(DateTimeParseException e) {
            return false;
        }
        return true;

    }

    public void dateAlertDisplay(){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Date Input Error");
        window.setMinWidth(300);

        Label label = new Label();
        label.setText("Your date must be in the \"yyyy-mm-dd\" format!");
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());

        VBox bg = new VBox(10);
        bg.getChildren().addAll(label, closeButton);
        bg.setAlignment(Pos.CENTER);

        Scene scene = new Scene(bg);
        window.setScene(scene);
        window.showAndWait();
    }

    public void descAlertDisplay(){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Description Input Error");
        window.setMinWidth(300);

        Label label = new Label();
        label.setText("Your description must be between 1 and 256 characters!");
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());

        VBox bg = new VBox(10);
        bg.getChildren().addAll(label, closeButton);
        bg.setAlignment(Pos.CENTER);

        Scene scene = new Scene(bg);
        window.setScene(scene);
        window.showAndWait();
    }

    // ---------------------------------------------------------------------------- //

    // method creates a new folder as a to-do list from the user-input list title
    public static boolean addList(String title){
        // create new file object from basePath and title strings
        // create txt file using .createNewFile()
            // if file was created successfully, return true
            // else, return false
        return true; // return if files was created successfully
    }

    // method writes given itemDesc to the existing file specified
    public static ArrayList<Item> addItem(File file, ArrayList<Item> tdList){
        // open file specified
        // create new item object from user input
        // add newItem to tdList
        return tdList; // return arraylist w item added
    }

    // method deletes given string from file given (call on both date and itemDesc strings)
    public static ArrayList<Item> delItem(File file, ArrayList<Item> tdList){
        // open file specified
        // when user interacts with delete button on a specific item from the arraylist, delete it using .remove()
        return tdList; // return arraylist w item deleted
    }

    // method replaces old user input for item description field in item/arraylist with a new description
    public static String editListDesc(Item item, ArrayList<Item> tdlist){
        String newDesc = null;
        // select item to edit from tdList arraylist
        // make string variable for old string, set equal to itemDesc object of the specified item
        // make new string variable for new item desc
        // get user input for new string
        // replace new string with old string in tdItem
        return newDesc; // return newDesc string
    }

    // method replaces old user input for date in arraylist/item with the new date they want to select
    public static String editDate(Item item, ArrayList<Item> tdlist){
        String newDate = null;
        // select item to edit from tdList arraylist
        // make string variable for old string, set equal to date object of the specified item
        // make new string variable for new due date
        // get user input for new string
        // replace new string with old string in tdItem
        return newDate; // return newDate string
    }

    // method keeps track of which items have been completed in the arraylist
    public static ArrayList<Item> markCom(Item item, ArrayList<Item> tdList){
        // select item from tdList arraylist
        // if the user clicks the checkmark in the "mark as complete" complete button,
        // set status field from tdItem item to true
        return tdList; // return arraylist
    }

    // method shows user all items in an arraylist (their to do list)
    public static int displayAll(File file, ArrayList<Item> tdList){
        // print file name using .getName() of the file
        // create a count variable to keep track of how many times the loop runs
        // use for loop to iterate through arraylist
            // print out arraylist elements in a nice format
             // count++
        return 0; // return count variable
    }

    // method shows items that are marked incomplete in tdList
    public static int displayIncomplete(File file, ArrayList<Item> tdList){
        // print file name using .getName()
        // create a count variable to keep track of how many times the loop runs
        // use for loop to iterate through the arraylist
            // if marked false in the status field of tditem from the tdList,
                // print it
                // update count variable
        return 0; // return count variable
    }

    // method displays items that are marked as complete in tdList
    public static int displayComplete(File file, ArrayList<Item> tdList){
        // print file name using .getName()
        // create a count variable to keep track of how many times the loop runs
        // use for loop to iterate through the arraylist
        // if marked true in the status field of tditem from the tdList,
        // print it
        // update count variable
        return 0; // return count variable
    }

    // method writes data from tdList arraylist into specified file and stores in path specified
    public static File saveListItems(File file, ArrayList<Item> tdList){
        // when usernames file (title of to-do list), open it to write to it
        // print name of file using .getName()
        // use for loop to write all content from tdList array into the file
        // the description, due date, and status
        // ask user where to store this file in their own computer
        // save/set file equal to hard drive path
        return file; // return the file to be saved
    }

    // method opens file (to do list) user specifies and stores info in arraylist
    public static ArrayList<Item> loadList(){
        ArrayList<Item> arrList = null;
        // ask user which list they'd like to load
        // use a file chooser
        // open file user selects
        // create tditem object and read in appropriate data
        // use loop and arraylist to store all the tditems made
        // display items to user
        return arrList; // return ArrayList<tdItem>
    }
}