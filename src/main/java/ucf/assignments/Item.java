/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Alyssa Yee-Kee
 */

package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

import java.io.Serializable;

// class defines objects for a to-do list
public class Item {
    private SimpleStringProperty desc;
    private SimpleStringProperty date;
    private CheckBox status;

    public Item(String desc, String date){
        this.desc = new SimpleStringProperty(desc);
        this.date = new SimpleStringProperty(date);
        this.status = new CheckBox();
    }

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
