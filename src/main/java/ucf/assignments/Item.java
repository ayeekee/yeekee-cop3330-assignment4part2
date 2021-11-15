/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Alyssa Yee-Kee
 */

package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

// class defines objects for a to-do list
public class Item {
    private SimpleStringProperty desc; // string variable for item description
    private SimpleStringProperty date; // string variable for the date
    private CheckBox status; // checkBox variable for whether or not the item was completed

    // create to do list item fields and set equal to each other
    public Item(String desc, String date){
        this.desc = new SimpleStringProperty(desc); // set desc to the input desc string
        this.date = new SimpleStringProperty(date); // set date to the input date string
        this.status = new CheckBox();               // create checkBox field
    }

    // create getters and setters for the specific item fields
    public String getDesc(){
        return desc.get();
    }

    public void setDesc(String desc){
        this.desc = new SimpleStringProperty(desc);
    }

    public String getDate(){
        return date.get();
    }

    public void setDate(String date){
        this.date = new SimpleStringProperty(date);
    }

    public CheckBox getStatus(){
        return status;
    }

    public void setStatus(CheckBox status){
        this.status = status;
    }
}
