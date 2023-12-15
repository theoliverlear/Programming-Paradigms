// Name: Oliver Sigwarth                                                     |
// CIDS 235: Programming Paradigms                                           |
// Assignment 2 - The Todo List                                              |
// Program: User.java                                                        |
// Description:                                                              |
/*----------------------------------------------------------------------------
 * Your task is to develop a Todo List application in Java that effectively  |
 * utilizes composition and aggregation. The application should consist of   |
 * classes representing tasks, a todo list, and users.                       |
----------------------------------------------------------------------------*/
// Created: 11/6/2023                                                        |
// Last Modified: 12/14/2023                                                 |
//----------------------------------------------------------------------------
public class User {
    private TodoList todoList;
    //----------------------------Constructors--------------------------------
    public User() {
        this.todoList = new TodoList();
    }
    //==============================-Methods-=================================

    //------------------------------User-Menu---------------------------------
    public void userMenu() {
        System.out.println("Welcome to the Todo List Application!");
        System.out.println("""
                          Please select an option:
                            1. View Tasks
                            2. Create Task
                            3. Complete Task
                            4. Exit
                            """);
    }
    //--------------------------Get-Valid-Int-Input---------------------------
    public int getValidIntInput() {
        Scanner userInput = new Scanner(System.in);
        int input = 0;
        boolean validInput = false;
        do {
            try {
                input = userInput.nextInt();
                validInput = true;
            } catch (InputMismatchException ex) {
                System.out.println("Please enter a valid integer.");
                userInput.nextLine();
            }
        } while (!validInput);
        return input;
    }
    //--------------------------Get-Valid-String-Input------------------------
    public String getValidStringInput() {
        Scanner userInput = new Scanner(System.in);
        String input = "";
        boolean validInput = false;
        do {
            try {
                input = userInput.nextLine();
                validInput = true;
            } catch (InputMismatchException ex) {
                System.out.println("Please enter a valid string.");
                userInput.nextLine();
            }
        } while (!validInput);
        return input;
    }
    //------------------------------Create-Task-------------------------------
    public void createTask(String name, String description, String dueDate) {
        Task task = new Task(name, description, dueDate);
        this.todoList.addTask(task);
    }
    //----------------------------Complete-Task-------------------------------
    public void completeTask(String name) {
        Task task = this.todoList.getTask(name);
        task.completeTask();
    }
    //-------------------------------Getters----------------------------------
    public TodoList getTodoList() {
        return this.todoList;
    }
    //-------------------------------Setters----------------------------------
    public void setTodoList(TodoList todoList) {
        this.todoList = todoList;
    }
}
