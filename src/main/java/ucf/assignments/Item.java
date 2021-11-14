/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Alyssa Yee-Kee
 */

package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;

// class defines objects for a to-do list
public class Item {
    private SimpleStringProperty desc;
    private SimpleStringProperty date;
    private SimpleStringProperty status;

    public Item(String desc, String date, String status){
        this.desc = new SimpleStringProperty(desc);
        this.date = new SimpleStringProperty(date);
        this.status = new SimpleStringProperty(status);
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

    public String getStatus(){
        return status.get();
    }

    public void setStatus(String status){
        this.status = new SimpleStringProperty(status);
    }
}
