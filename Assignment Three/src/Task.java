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
// Created: 11/6/2023                                                        |
// Last Modified: 12/14/2023                                                 |
//----------------------------------------------------------------------------
public class Task {
    private String name;
    private String description;
    // TODO: Change to Date type
    private String dueDate; // Uses weekday or MM/DD/YYYY format
    private boolean isComplete;
    //----------------------------Constructors--------------------------------
    public Task(String name, String description, String dueDate) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.isComplete = false;
    }
    //==============================-Methods-=================================

    //----------------------------Complete-Task-------------------------------
    public void completeTask() {
        this.isComplete = true;
    }
    //=============================-Overrides-================================
    @Override
    public String toString() {
        String taskString = "";
        taskString += "Name: " + this.name + "\n";
        taskString += "Description: " + this.description + "\n";
        taskString += "Due Date: " + this.dueDate + "\n";
        taskString += "Complete: " + this.isComplete + "\n";
        return taskString;
    }
    //-------------------------------Getters----------------------------------
    public String getName() {
        return this.name;
    }
    //-------------------------------Setters----------------------------------
    public void setName(String name) {
        this.name = name;
    }
}
