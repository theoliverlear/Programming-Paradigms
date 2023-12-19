// Name: Oliver Sigwarth                                                     |
// CIDS 235: Programming Paradigms                                           |
// Assignment 2 - The Todo List                                              |
// Program: Main.java                                                        |
// Description:                                                              |
/*----------------------------------------------------------------------------
 * Your task is to develop a Todo List application in Java that effectively  |
 * utilizes composition and aggregation. The application should consist of   |
 * classes representing tasks, a todo list, and users.                       |
----------------------------------------------------------------------------*/
// Created: 12/10/2023                                                       |
// Last Modified: 12/15/2023                                                 |
//----------------------------------------------------------------------------
public class Main {
    public static void main(String[] args) {
        //-------------------Demonstrate-Static-Code--------------------------
        System.out.println("----------Static Code Demonstration---------");
        // --- Task 1---
        User staticUser = new User();
        String taskName = "Clean Computer";
        String taskDescription = "Clean crumbs out of keyboard";
        String taskDueDate = "Monday";
        staticUser.getTodoList().addTask(taskName,
                                         taskDescription,
                                         taskDueDate);
        // --- Task 2---
        taskName = "Do Homework";
        taskDescription = "Complete CIDS 235 Assignment 3";
        taskDueDate = "Friday (or when Dr. T grades it)";
        staticUser.getTodoList().addTask(taskName,
                                         taskDescription,
                                         taskDueDate);
        staticUser.getTodoList().viewTasks();
        staticUser.getTodoList().completeTask(taskName);
        staticUser.getTodoList().viewTasks();
        //-------------------Demonstrate-Dynamic-Code-------------------------
        System.out.println("---------Dynamic Code Demonstration---------");
        User dynamicUser = new User();
        dynamicUser.userMenu();
    }
}
