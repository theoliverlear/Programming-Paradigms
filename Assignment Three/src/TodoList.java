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
// Created: 11/6/2023                                                        |
// Last Modified: 12/14/2023                                                 |
//----------------------------------------------------------------------------
public class TodoList {
    /*
        Aggregation of tasks
     */
    private ArrayList<Task> tasks;
    //----------------------------Constructors--------------------------------
    public TodoList() {
        this.tasks = new ArrayList<>();
    }
    //==============================-Methods-=================================

    //-------------------------------Add-Task---------------------------------
    public void addTask(Task task) {
        this.tasks.add(task);
    }
    //-------------------------------Get-Task---------------------------------
    public Task getTask(String name) {
        for (Task task : this.tasks) {
            if (task.getName().equals(name)) {
                return task;
            }
        }
        return null;
    }
    //------------------------------View-Tasks--------------------------------
    public void viewTasks() {
        for (int i = 1; i <= this.tasks.size(); i++) {
            System.out.println(i + ". " + this.tasks.get(i - 1).getName());
        }
    }
    //-------------------------------Getters----------------------------------

    //-------------------------------Setters----------------------------------
}
