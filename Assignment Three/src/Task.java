// Name: Oliver Sigwarth                                                     |
// CIDS 235: Programming Paradigms                                           |
// Assignment 2 - The Todo List                                              |
// Program: Task.java                                                        |
// Description:                                                              |
/*----------------------------------------------------------------------------
 * Your task is to develop a Todo List application in Java that effectively  |
 * utilizes composition and aggregation. The application should consist of   |
 * classes representing tasks, a todo list, and users.                       |
----------------------------------------------------------------------------*/
// Created: 12/10/2023                                                       |
// Last Modified: 12/15/2023                                                 |
//----------------------------------------------------------------------------
public class Task {
    private String name;
    private String description;
    private String dueDate;
    private boolean isComplete;
    //----------------------------Constructors--------------------------------
    public Task(String name, String description, String dueDate) {
        // Since the tasks object has an aggregation relationship with the
        // TodoList object, we take in values from the parameters and create
        // the object in the constructor with prebuilt values.
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.isComplete = false;
    }
    //==============================-Methods-=================================

    //----------------------------Complete-Task-------------------------------
    public void completeTask() {
        // Sets the isComplete boolean to true to signify that the task is
        // complete.
        this.isComplete = true;
    }
    //-----------------------Colored-Completion-Text--------------------------
    public String completeColored() {
        // Returns a string that is colored green if the task is complete and
        // red if the task is incomplete. The resetCode is used to reset the
        // color back to the default color, the greenCode is used to set the
        // color to green, and the redCode is used to set the color to red. If
        // the task is complete, it returns the status in green, otherwise it
        // returns the status in red.
        String resetCode = "\u001B[0m";
        String greenCode = "\u001B[32m";
        String redCode = "\u001B[31m";
        if (this.isComplete) {
            return greenCode + "Complete" + resetCode;
        } else {
            return redCode + "Incomplete" + resetCode;
        }
    }
    public String completeColored(String name) {
        // Returns a string that is colored green if the task is complete and
        // red if the task is incomplete. The resetCode is used to reset the
        // color back to the default color, the greenCode is used to set the
        // color to green, and the redCode is used to set the color to red. If
        // the task is complete, it returns the status in green wih the given
        // name, otherwise it returns the status in red with the given name.
        String resetCode = "\u001B[0m";
        String greenCode = "\u001B[32m";
        String redCode = "\u001B[31m";
        if (this.isComplete) {
            return greenCode + name + resetCode;
        } else {
            return redCode + name + resetCode;
        }
    }
    //=============================-Overrides-================================

    //------------------------------To-String---------------------------------
    @Override
    public String toString() {
        // This method is an override of the toString method. It returns a
        // string that contains the name, description, due date, and
        // completion status of the task. It uses the completeColored method
        // to color the completion status and the name. This method is used
        // for printing the task in the viewTasks() method in the TodoList
        // class.
        String taskString = "";
        taskString += "[Name: " + this.completeColored(this.name) + "]\n";
        taskString += "[Description: " + this.description + "]\n";
        taskString += "[Due Date: " + this.dueDate + "]\n";
        taskString += "[Complete: " + this.completeColored() + "]";
        return taskString;
    }
    //-------------------------------Getters----------------------------------
    // Getters are allowed for the variables of the class because they are
    // properly encapsulated and are not modified by the user directly.
    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
    public String getDueDate() {
        return this.dueDate;
    }
    public boolean isCompleted() {
        return this.isComplete;
    }
    //-------------------------------Setters----------------------------------
    // Setters are allowed for the isComplete variable of the class because
    // it is the only variable that is modified by the program after its
    // initialization. Other variables are not modified by the program after
    // initialization and are therefore not allowed to be modified by the
    // user.
    public void setCompleted(boolean isComplete) {
        this.isComplete = isComplete;
    }
}
