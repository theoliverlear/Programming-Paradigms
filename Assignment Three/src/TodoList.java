// Name: Oliver Sigwarth                                                     |
// CIDS 235: Programming Paradigms                                           |
// Assignment 2 - The Todo List                                              |
// Program: TodoList.java                                                    |
// Description:                                                              |
/*----------------------------------------------------------------------------
 * Your task is to develop a Todo List application in Java that effectively  |
 * utilizes composition and aggregation. The application should consist of   |
 * classes representing tasks, a todo list, and users.                       |
----------------------------------------------------------------------------*/
// Created: 12/10/2023                                                       |
// Last Modified: 12/15/2023                                                 |
//----------------------------------------------------------------------------
import java.util.ArrayList;
public class TodoList {
    private ArrayList<Task> tasks;
    //----------------------------Constructors--------------------------------
    public TodoList() {
        // Since the tasks object has a composition relationship with the
        // TodoList object, we initialize it here and create it in the
        // constructor.
        this.tasks = new ArrayList<>();
    }
    //==============================-Methods-=================================

    //-------------------------------Add-Task---------------------------------
    public void addTask(Task task) {
        // Adds a task to the tasks ArrayList already prebuilt.
        this.tasks.add(task);
    }
    public void addTask(String name, String description, String dueDate) {
        // Adds a task to the tasks ArrayList built from the parameters.
        Task task = new Task(name, description, dueDate);
        this.addTask(task);
    }
    //-------------------------------Get-Task---------------------------------
    public Task getTask(String name) {
        // Loops through the tasks in the ArrayList and returns the task
        // if it matches the name.
        for (Task task : this.tasks) {
            if (task.getName().equals(name)) {
                return task;
            }
        }
        return null;
    }
    //------------------------------View-Tasks--------------------------------
    public void viewTasks() {
        // Prints out all tasks in the tasks ArrayList it uses the indexing
        // of 1 to print the task number and get the task from the ArrayList
        // using the index one less. If there are no tasks, it alerts the
        // user.
        System.out.println("Viewing tasks...");
        for (int i = 1; i <= this.tasks.size(); i++) {
            String space = "   ";
            System.out.println(space + i + "...\n" + this.tasks.get(i - 1));
        }
        if (this.tasks.isEmpty()) {
            System.out.println("No tasks to view.");
        }
    }
    //----------------------------Complete-Task-------------------------------
    public void completeTask(String name) {
        // Completes a task in the tasks ArrayList if it matches the name.
        System.out.println("Completing task: " + name);
        this.getTask(name).completeTask();
    }
    //----------------------------Contains-Task-------------------------------
    public boolean containsTask(String name) {
        // Loops through the tasks in the ArrayList and returns true if
        // it matches the name. If the name matches, the list contains the
        // task. Otherwise, it does not and returns false.
        for (Task task : this.getTasks()) {
            if (task.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    //----------------------------Remove-Task---------------------------------
    public void removeTask(String name) {
        // Removes a task from the tasks ArrayList if it matches the name.
        // Once the task is removed, it alerts the user of the specific task
        // that was removed.
        System.out.println("Removing task \"" + name + "\"...");
        this.tasks.remove(this.getTask(name));
    }
    //-------------------------------Getters----------------------------------
    // Getters are allowed for the variables of the class because they are
    // properly encapsulated and are not modified by the user directly.
    // Setters are not allowed because they are not needed for the user to
    // interact with the variable.
    public ArrayList<Task> getTasks() {
        return this.tasks;
    }
}
