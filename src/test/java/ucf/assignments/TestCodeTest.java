package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TestCodeTest {

    ArrayList<Item> test = new ArrayList<>();

    // test that item was added to arraylist successfully
    @Test
    void addItem() {
        // test that the array size is one more than it was previously
    }

    // test that an item was deleted from arraylist successfully
    @Test
    void deleteItem() {
        // test that arraylist size is one less than it was before
    }

    // test that a list is empty
    @Test
    void clearList() {
        // assertEquals that the arraylist.size() is 0
    }

    // test that a desc and date were edited
    @Test
    void editItem() {
        // check that the old string is not the same as the new one
    }

    // test that all items are displayed
    @Test
    void displayAll() {
        // check the size of the array
    }

    // test that completed items are displayed
    @Test
    void displayComp() {
        // check the items with checkboxes selected
        // use an int variable as a counter as you iterate through the array
        // update count every time a checkbox is selected
        // compare to the expected amount
    }

    // test that incomplete item are displayed
    @Test
    void displayIncomplete() {
        // check the items with checkboxes unselected
        // use an int variable as a counter as you iterate through the array
        // update count every time a checkbox is unselected
        // compare to the expected amount
    }

    // test that a file was successfully created
    @Test
    void saveList() throws Exception {
        File file = TestCode.saveList("C://temp//tempList", test);

        assertEquals(false, file.exists());
    }

    /*// test that file was able to be read
    @Test
    void loadList() throws IOException {
        File file = new File(TestCode.loadList("C://temp//testFile", test));

        assertEquals(false, file.exists());
    }*/
}