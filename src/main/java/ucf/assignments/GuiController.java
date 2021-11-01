/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Alyssa Yee-Kee
 */

package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.File;
import java.util.ArrayList;

// class controls gui for user interaction with buttons
public class GuiController {

    @FXML

    // method creates a new folder as a to-do list from the user-input list title
    public static boolean addList(String title){
        // create new file object from basePath and title strings
        // create txt file using .createNewFile()
            // if file was created successfully, return true
            // else, return false
        return true; // return if files was created successfully
    }

    // method deletes directory of specified list
    public static boolean delList(File file){
        // use file.delete() to delete file
        // if it was deleted successfully, return true
        // else, return false
        return false; // return whether the file was deleted via boolean
    }

    // method renames a directory using the String
    public static File renameList(File file, String renameTo){
        // create new file object from default path and renameTo string
        // use .renameTo() to rename the file
        return File Object newFile; // return the newFile
    }

    // method writes given itemDesc to the existing file specified
    public static ArrayList<tdItem> addToExistList(File file, ArrayList<tdItem> tdList){
        // open file specified
        // create new item object from user input
        // add newItem to tdList
        return tdList; // return arraylist w item added
    }

    // method deletes given string from file given (call on both date and itemDesc strings)
    public static ArrayList<tdItem> delFromExistList(File file, ArrayList<tdItem> tdList){
        // open file specified
        // when user interacts with delete button on a specific item from the arraylist, delete it using .remove()
        return tdList; // return arraylist w item deleted
    }

    // method replaces old user input for item description field in item/arraylist with a new description
    public static String editListDesc(tdItem item, ArrayList<tdItem> tdlist){
        // select item to edit from tdList arraylist
        // make string variable for old string, set equal to itemDesc object of the specified item
        // make new string variable for new item desc
        // get user input for new string
        // replace new string with old string in tdItem
        return String Object newDesc; // return newDesc string
    }

    // method replaces old user input for date in arraylist/item with the new date they want to select
    public static String editDate(tdItem item, ArrayList<tdItem> tdlist){
        // select item to edit from tdList arraylist
        // make string variable for old string, set equal to date object of the specified item
        // make new string variable for new due date
        // get user input for new string
        // replace new string with old string in tdItem
        return String Object newDate; // return newDate string
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

    // method writes data from arraylist of tditem arraylists to a file stored in a path the user specifies
    public static File saveAllItems(ArrayList<ArrayList<tdItem>> allLists){
        // create a new file object
        // set file equal to a path in hard drive
        // open file to write to
        // print title of first list
        // use for loop to write all the info in allLists
        // check when arraylist<tdItem> ends and print title of next list to be displayed
        return File Object file; // return the file to be saved
    }

    // method opens file (to do list) user specifies and stores info in arraylist
    public static ArrayList<tdItem> loadList(){
        // ask user which list they'd like to load
        // use a file chooser
        // open file user selects
        // create tditem object and read in appropriate data
        // use loop and arraylist to store all the tditems made
        // display items to user
        return ArrayList Object arrList; // return ArrayList<tdItem>
    }

    // method opens multiple to do lists the user asks to view
    public static ArrayList<ArrayList<tdItem>> loadManyLists(){
        // ask user which list they'd like to load
        // use a file chooser
        // create int variable count to keep track of how many lists they want to open
        // create ArrayList<ArrayList<tdItem>> object to store all arraylists of <tdItem> created
        // use for loop using count variable
        // create arraylist <tdItem>
        // set equal to loadList() function
        // add arraylist <tdItem> to ArrayList<ArrayList<tdItem>>(i)
        return ArrayList Object ALofLists; // return ArrayList<ArrayList<tdItem>>
    }
}