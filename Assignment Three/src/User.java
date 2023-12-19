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
// Created: 12/10/2023                                                       |
// Last Modified: 12/15/2023                                                 |
//----------------------------------------------------------------------------
import java.util.InputMismatchException;
import java.util.Scanner;
public class User {
    private TodoList todoList;
    //----------------------------Constructors--------------------------------
    public User() {
        // Since the todoList object has a composition relationship with the
        // User object, we initialize it here and create it in the
        // constructor.
        this.todoList = new TodoList();
    }
    //==============================-Methods-=================================

    //------------------------------User-Menu---------------------------------
    public void userMenu() {
        // This is the main menu for the user. It is a while loop that
        // continues until the user selects the exit option. It uses a switch
        // statement to determine which option the user selected. If the user
        // enters an invalid integer, it will prompt them to enter a valid
        // integer. Once a valid integer is entered, it will execute the
        // corresponding case defined later in the program.
        System.out.println("Welcome to the Todo List Application!");
        outer: while (true) {
            System.out.println("""
                          Please select an option:
                            1. View Tasks
                            2. Create Task
                            3. Complete Task
                            4. Remove Task
                            5. Exit""");
            int input = this.getValidIntInput();
            switch (input) {
                case 1 -> {
                    this.getTodoList().viewTasks();
                }
                case 2 -> {
                    this.createTask();
                }
                case 3 -> {
                    this.completeTask();
                }
                case 4 -> {
                    this.removeTask();
                }
                case 5 -> {
                    System.out.println("Thank you for using the Todo List" +
                                       " Application!");
                    break outer;
                }
            }
        }
    }
    //--------------------------Get-Valid-Int-Input---------------------------
    public int getValidIntInput() {
        // This method is used to get a valid integer input from the user. It
        // uses a do-while loop to continue until a valid integer is entered.
        // If the user enters an invalid integer, it will prompt them to enter
        // a valid integer. Invalid inputs are caught with an exception and
        // the user is prompted instead of the program crashing.
        Scanner userInput = new Scanner(System.in);
        int input = 0;
        boolean validInput = false;
        do {
            try {
                input = userInput.nextInt();
                if (input < 1 || input > 5) {
                    System.out.println("Please enter an integer between 1 " +
                                       "and 5.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter a valid integer.");
                userInput.nextLine();
            }
        } while (!validInput);
        return input;
    }
    //--------------------------Get-Valid-String-Input------------------------
    public String getValidStringInput() {
        // Similar to the getValidIntInput() method, this method is used to
        // get a valid string input from the user. It uses a do-while loop to
        // continue until a valid string is entered. If the user enters an
        // invalid string, it will prompt them to enter a valid string.
        // Invalid inputs are caught with an exception and the user is
        // prompted instead of the program crashing.
        Scanner userInput = new Scanner(System.in);
        String input = "";
        boolean validInput = false;
        do {
            try {
                input = userInput.nextLine();
                if (input.isEmpty()) {
                    System.out.println("Please enter a valid string.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter a valid string.");
                userInput.nextLine();
            }
        } while (!validInput);
        return input;
    }
    //------------------------------Create-Task-------------------------------
    public void createTask() {
        // This method is used to create a Task. It prompts the user for the
        // information needed to form a task and then adds it to the todoList
        // object. It calls the appropriate methods to get the valid input
        // from the user to ensure the task is created correctly.
        //-------------------------Get-Task-Name------------------------------
        System.out.println("Please enter the name of the task:");
        String name = this.getValidStringInput();
        //-----------------------Get-Task-Description-------------------------
        System.out.println("Please enter the description of the task:");
        String description = this.getValidStringInput();
        //-------------------------Get-Task-Date------------------------------
        System.out.println("Please enter the due date of the task:");
        String dueDate = this.getValidStringInput();
        //---------------------------Add-Task---------------------------------
        this.getTodoList().addTask(name, description, dueDate);
    }
    //------------------------------Complete-Task------------------------------
    public void completeTask() {
        // This method is used to complete a task. It prompts the user for the
        // name of the task they would like to complete. It first checks if
        // for the amount of tasks in the todoList object and if the amount
        // that are completed are the same. If it is, then all tasks are
        // completed and the user is alerted instead of being prompted for a
        // task to complete.
        int listSize = this.todoList.getTasks().size();
        // This variable is counted by filtering the tasks in the todoList
        // object by if they are completed. The tasks completed are then
        // inserted into an array and the length of the array is returned as
        // the value of the variable.
        int completedTasks = this.todoList.getTasks().stream()
                             .filter(Task::isCompleted).toArray().length;
        // If the list size is not equal to the amount of completed tasks,
        // then there are tasks that are not completed. The list of tasks are
        // looped through and if a task is not completed, it is printed out as
        // an option for the user to complete.
        if (listSize != completedTasks) {
            System.out.println("Please enter the name of the task you would" +
                    " like to complete.\nOptions:");
            for (Task task : this.getTodoList().getTasks()) {
                if (!task.isCompleted()) {
                    String space = "   ";
                    System.out.println(space + task.getName());
                }
            }
            // The user is prompted for a task to complete. If the task is not
            // in the todoList object, then the user is prompted again until
            // they enter a valid task.
            String name = this.getValidStringInput();
            while (!this.getTodoList().containsTask(name)) {
                System.out.println("Please enter a valid task name:");
                name = this.getValidStringInput();
            }
            // Once a valid task is entered, the task is completed by calling
            // the completeTask() method.
            this.getTodoList().completeTask(name);
        } else {
            System.out.println("All tasks are already completed.");
        }
    }
    //------------------------------Remove-Task-------------------------------
    public void removeTask() {
        // This method is used to remove a task. It prompts the user for the
        // name of the task they would like to remove. If the task is not in
        // the todoList object, then the user is prompted again until they
        // enter a valid task. Once a valid task is entered, the task is
        // removed.
        //----------------------Prompt-Task-Removal---------------------------
        System.out.println("Please enter the name of the task you would" +
                           " like to remove:");
        for (Task task : this.getTodoList().getTasks()) {
            System.out.println(task.getName());
        }
        String name = this.getValidStringInput();
        //----------------------Validate-Task-Name----------------------------
        while (!this.getTodoList().containsTask(name)) {
            System.out.println("Please enter a valid task name:");
            name = this.getValidStringInput();
        }
        //--------------------------Remove-Task-------------------------------
        this.getTodoList().removeTask(name);
    }
    //-------------------------------Getters----------------------------------
    // Getters are allowed for the variables of the class because they are
    // properly encapsulated and are not modified by the user directly.
    // Setters are not allowed because they are not needed for the user to
    // interact with the variable.
    public TodoList getTodoList() {
        return this.todoList;
    }
}