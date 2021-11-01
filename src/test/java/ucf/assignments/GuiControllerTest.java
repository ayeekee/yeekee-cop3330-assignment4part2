package ucf.assignments;

class GuiControllerTest {

    @org.junit.jupiter.api.Test
    void addList() {
        // run method
        // check if file was successfully created w/ assert true and make sure it returns true
    }

    @org.junit.jupiter.api.Test
    void delList() {
        // run method
        // check if file was successfully deleted w/ assert true and make sure it returns false
    }

    @org.junit.jupiter.api.Test
    void renameList() {
        // create test file
        // run method
        // check that file name matches input string (string used to rename)
    }

    @org.junit.jupiter.api.Test
    void addToExistList() {
        // check num of elements in list and store in int variable
        // run method
        // check that the num of elements is +1 more than before
    }

    @org.junit.jupiter.api.Test
    void delFromExistList() {
        // check num of elements in list and store in int variable
        // run method
        // check that num of elements is -1 less than before
    }

    @org.junit.jupiter.api.Test
    void editListDesc() {
        // store original desc in a string variable
        // run method to get new desc
        // check that new desc does not equal original desc
    }

    @org.junit.jupiter.api.Test
    void editDate() {
        // store original date in a string
        // run method to get new date
        // check that new date does not equal new date
    }

    @org.junit.jupiter.api.Test
    void markCom() {
        // run method
        // check that status field is equal to 1 for completed
    }

    @org.junit.jupiter.api.Test
    void displayAll() {
        // store size of arraylist in an int variable
        // run method, set equal to a count int variable
        // check that count is the same as size
    }

    @org.junit.jupiter.api.Test
    void displayIncomplete() {
        // create sum int variable
        // for loop to iterate
            // check if incomplete
                // if so, add to sum variable
        // run method, set equal to a count int variable
        // check that count is the same as sum
    }

    @org.junit.jupiter.api.Test
    void displayComplete() {
        // create sum int variable
        // for loop to iterate
            // check if complete
                 // if so, add to sum variable
        // run method, set equal to a count int variable
        // check that count is the same as sum
    }

    @org.junit.jupiter.api.Test
    void saveListItems() {
        // run method
        // check that file was created successfully/exists and is not empty
    }

    @org.junit.jupiter.api.Test
    void saveAllItems() {
        // run method
        // check that file exists and is not empty
    }

    @org.junit.jupiter.api.Test
    void loadList() {
        // run method, set equal to array list object
        // check that arraylist is not empty
    }

    @org.junit.jupiter.api.Test
    void loadManyLists() {
        // run method, set equal to array list object
        // check that arraylist is not empty
    }
}