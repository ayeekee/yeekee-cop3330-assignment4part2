/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Alyssa Yee-Kee
 */

package ucf.assignments;

import javafx.beans.Observable;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import javax.security.auth.callback.Callback;
import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.ResourceBundle;

// class controls gui for user interaction with buttons
public class GuiController implements Initializable {

    @FXML private Button addItemButton;

    @FXML private DatePicker datePicker;
    @FXML private TextArea descBox;

    @FXML private TableView<tdItem> tableOfList;
    @FXML private TableColumn<tdItem, String> descCol;
    @FXML private TableColumn<tdItem, LocalDate> dateCol;
    @FXML private TableColumn<tdItem, Boolean> statusCol;

    @FXML
    void addItem(ActionEvent event) {
        tdItem item = new tdItem(datePicker.getValue(), descBox.getText(), false);
        tableOfList.getItems().add(item);
    }

    public ObservableList<tdItem> getList(){
        ObservableList<tdItem> tdList = FXCollections.observableArrayList();

        return tdList;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        datePicker.setValue(LocalDate.now());

        descCol.setCellValueFactory(new PropertyValueFactory<tdItem, String>("desc"));
        dateCol.setCellValueFactory(new PropertyValueFactory<tdItem, LocalDate>("date"));
        statusCol.setCellValueFactory(new PropertyValueFactory<tdItem, Boolean>("status"));

        tableOfList.setItems(getList());

        tableOfList.setEditable(true);
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
    public static ArrayList<tdItem> addItem(File file, ArrayList<tdItem> tdList){
        // open file specified
        // create new item object from user input
        // add newItem to tdList
        return tdList; // return arraylist w item added
    }

    // method deletes given string from file given (call on both date and itemDesc strings)
    public static ArrayList<tdItem> delItem(File file, ArrayList<tdItem> tdList){
        // open file specified
        // when user interacts with delete button on a specific item from the arraylist, delete it using .remove()
        return tdList; // return arraylist w item deleted
    }

    // method replaces old user input for item description field in item/arraylist with a new description
    public static String editListDesc(tdItem item, ArrayList<tdItem> tdlist){
        String newDesc = null;
        // select item to edit from tdList arraylist
        // make string variable for old string, set equal to itemDesc object of the specified item
        // make new string variable for new item desc
        // get user input for new string
        // replace new string with old string in tdItem
        return newDesc; // return newDesc string
    }

    // method replaces old user input for date in arraylist/item with the new date they want to select
    public static String editDate(tdItem item, ArrayList<tdItem> tdlist){
        String newDate = null;
        // select item to edit from tdList arraylist
        // make string variable for old string, set equal to date object of the specified item
        // make new string variable for new due date
        // get user input for new string
        // replace new string with old string in tdItem
        return newDate; // return newDate string
    }

    // method keeps track of which items have been completed in the arraylist
    public static ArrayList<tdItem> markCom(tdItem item, ArrayList<tdItem> tdList){
        // select item from tdList arraylist
        // if the user clicks the checkmark in the "mark as complete" complete button,
        // set status field from tdItem item to true
        return tdList; // return arraylist
    }

    // method shows user all items in an arraylist (their to do list)
    public static int displayAll(File file, ArrayList<tdItem> tdList){
        // print file name using .getName() of the file
        // create a count variable to keep track of how many times the loop runs
        // use for loop to iterate through arraylist
            // print out arraylist elements in a nice format
             // count++
        return 0; // return count variable
    }

    // method shows items that are marked incomplete in tdList
    public static int displayIncomplete(File file, ArrayList<tdItem> tdList){
        // print file name using .getName()
        // create a count variable to keep track of how many times the loop runs
        // use for loop to iterate through the arraylist
            // if marked false in the status field of tditem from the tdList,
                // print it
                // update count variable
        return 0; // return count variable
    }

    // method displays items that are marked as complete in tdList
    public static int displayComplete(File file, ArrayList<tdItem> tdList){
        // print file name using .getName()
        // create a count variable to keep track of how many times the loop runs
        // use for loop to iterate through the arraylist
        // if marked true in the status field of tditem from the tdList,
        // print it
        // update count variable
        return 0; // return count variable
    }

    // method writes data from tdList arraylist into specified file and stores in path specified
    public static File saveListItems(File file, ArrayList<tdItem> tdList){
        // when usernames file (title of to-do list), open it to write to it
        // print name of file using .getName()
        // use for loop to write all content from tdList array into the file
        // the description, due date, and status
        // ask user where to store this file in their own computer
        // save/set file equal to hard drive path
        return file; // return the file to be saved
    }

    // method opens file (to do list) user specifies and stores info in arraylist
    public static ArrayList<tdItem> loadList(){
        ArrayList<tdItem> arrList = null;
        // ask user which list they'd like to load
        // use a file chooser
        // open file user selects
        // create tditem object and read in appropriate data
        // use loop and arraylist to store all the tditems made
        // display items to user
        return arrList; // return ArrayList<tdItem>
    }
}