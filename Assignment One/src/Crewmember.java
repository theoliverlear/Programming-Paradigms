// Name: Oliver Sigwarth                                                     |
// Assignment 1 - Among Us                                                   |
// Program: Main.java                                                        |
// Description:                                                              |
/*----------------------------------------------------------------------------
 * The goal of this assignment is to practice creating classes and objects.  |
 * You will create a "Crewmember" class and an instance for each Crewmember  |
 * in Among Us and implement methods to interact with those objects.         |
----------------------------------------------------------------------------*/
// Created: 10/12/2023                                                       |
// Last Modified: 10/16/2023                                                 |
//----------------------------------------------------------------------------

import java.util.ArrayList;

public class Crewmember {
    private String name;
    private String color;
    private String task;
    private int age;
    private boolean isAlive;
    private static int numCrewmembers = 0;
    private static ArrayList<Crewmember> crewmembersList = new ArrayList<>();
    //----------------------------Constructors--------------------------------
    public Crewmember() {
        this("John", "red", "carpenter", 10, true);
    }
    public Crewmember(String name, String color, String task, int age,
                      boolean isAlive) {
        this.name = name;
        this.color = color;
        this.task = task;
        this.age = age;
        this.isAlive = isAlive;
        numCrewmembers++;
        crewmembersList.add(this);
    }
    // For the following class, I am allowing access to all fields through
    // getters. Setters are only allowed for the fields that will change
    // during the gameplay. The two setters that are allowed are for the
    // task and isAlive variables.
    //------------------------------Getters-----------------------------------
    // For the sake of modularity, I'm including getters ands setters for all
    // of the fields, even though I don't use them in this program.
    public String getName() {
        return this.name;
    } // Get
    public String getColor() {
        return this.color;
    } // Get
    public String getTask() {
        return this.task;
    } // Get & Set
    public int getAge() {
        return this.age;
    } // Get
    public boolean getIsAlive() {
        return this.isAlive;
    } // Get & Set
    public static int getNumCrewmembers() {
        return numCrewmembers;
    }
    public static ArrayList<Crewmember> getCrewmembers() {
        return crewmembersList;
}
    //------------------------------Setters-----------------------------------
    public void setName(String name) {
        this.name = name;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setTask(String task) {
        this.task = task;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
    //------------------------------Methods-----------------------------------
    public void details() {
        System.out.printf("My name is %s, my color is %s, my task is %s," +
                          " and I am %d years old.\n",
                          this.name, this.withColor(this.color), this.task,
                          this.age);
    }
    //
    public String withColor(String phrase) {
        String colorLowered = this.color.toLowerCase();
        final String resetCode = "\u001B[0m";
        String colorCode = switch (this.color.toLowerCase()) {
            case "cyan" -> "\u001B[36m";
            case "red" -> "\u001B[31m";
            case "lime" -> "\u001B[32m";
            case "purple" -> "\u001B[35m";
            case "yellow" -> "\u001B[33m";
            case "green" -> "\u001B[32m";
            case "gray" -> "\u001B[37m";
            default -> throw new IllegalStateException("Unexpected value: " +
                                                        colorLowered);
        };
        String coloredPhrase = colorCode + phrase + resetCode;
        return coloredPhrase;
    }
}
