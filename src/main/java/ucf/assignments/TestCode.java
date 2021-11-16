package ucf.assignments;

import javafx.scene.control.CheckBox;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/*  Class takes functions from GuiController and edits them to have return values that are testable; manipulates GuiController functions
    to keep the same functionality in terms of how the arrays are manipulated so that it can be tested.*/

public class TestCode {

    // method adds a new to do list item to table
    public static ArrayList<Item> addItem(String desc, String date) {
        ArrayList<Item> tdList = new ArrayList<>();

        // make sure description is between 1 and 256 characters
        if(desc.length() >= 1 && desc.length() <= 256){
            Item item = new Item(desc, date); // create new item with given input
            tdList.add(item);
        }
        else { // if not, display error message
            System.out.println("Your description must be between 1 and 256 characters or your date must be in yyyy-mm-dd format!");
        }

        return tdList;
    }

    // method deletes selected item from table/list
    public static ArrayList<Item> deleteItem(Integer index, ArrayList<Item> list) {
        list.remove(index);

        return list;
    }

    // method deletes all items from table/list
    public static ArrayList<Item> clearList(ArrayList<Item> list) {
        list.clear();

        return list;
    }

    // method allows user to edit description and date input
    public static String editItem(String original, String edited) {

        String newThing = "";

        newThing.replaceAll(original, edited);

        return newThing;
    }

    // method displays all to do list items regardless of completion
    public static int displayAll(ArrayList<Item> list) {
        return list.size();
    }

    // method displays to do list items that are complete
    public static int displayComp(ArrayList<Item> list) {
        ArrayList<Item> completeList = new ArrayList<>();
        ArrayList<Item> displayList = new ArrayList<>();

        int count = 0;

        for(Item temp : list){
            if(temp.getStatus().isSelected()){ // if checkBox is selected append to temp arraylist
                completeList.add(temp);
                count++;
            }
        }

        displayList = completeList;

        return count;
    }

    // method displays to do list items that are incomplete
    public static int displayIncomplete(ArrayList<Item> list) {
        ArrayList<Item> incompleteList = new ArrayList<>(); // create temp arraylist for incomplete items
        ArrayList<Item> displayList = new ArrayList<>();

        int count = 0;

        for(Item temp : list){
            if(!temp.getStatus().isSelected()){ // if checkBox is not selected, append to temp arraylist
                incompleteList.add(temp);
                count++;
            }
        }
        displayList = incompleteList;

        return count;
    }

    // method allows user to save their to do list to their hard drive
    public static File saveList(String path, ArrayList<Item> list) throws Exception {
        File file = new File(path);

        try{
            if (file != null) {
                if (file.getName().endsWith(".txt")) { // if the file is a txt file,
                    // write the info in the tdList array to the file
                    BufferedWriter bw = new BufferedWriter(new FileWriter(file));

                    int i = 0;

                    // use comma to separate elements in the file to make loading in the list easier
                    while(i < list.size()){
                        if(list.get(i) != null){
                            bw.write(list.get(i).getDesc()); // write desc
                            bw.write(",");
                            bw.write(list.get(i).getDate()); // write date
                            bw.write(",");
                            bw.write(String.valueOf(list.get(i).getStatus().isSelected())); // write whether or not the checkBox is marked
                            bw.write("\n");
                        }
                        i++;
                    }
                    bw.close();
                } else {
                    System.out.println("Your file must end with .txt!"); // if the file is not .txt, display error
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return file;
    }

    // method allows user to open a to do list they have previously saved
    static void loadList(String path, ArrayList<Item> list) throws IOException {
        File file = new File(path);

        ArrayList<Item> loadList = new ArrayList<>();

        try {
            if(file != null){
                list.clear(); // clear tdList of any previous items

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

                list = loadList;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
