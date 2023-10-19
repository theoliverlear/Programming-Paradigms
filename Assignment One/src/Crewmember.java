// Name: Oliver Sigwarth                                                     |
// Assignment 1 - Among Us                                                   |
// Program: Crewmember.java                                                  |
// Description:                                                              |
/*----------------------------------------------------------------------------
 * The goal of this assignment is to practice creating classes and objects.  |
 * You will create a "Crewmember" class and an instance for each Crewmember  |
 * in Among Us and implement methods to interact with those objects.         |
----------------------------------------------------------------------------*/
// Created: 10/12/2023                                                       |
// Last Modified: 10/19/2023                                                 |
//----------------------------------------------------------------------------
import java.util.ArrayList;
public class Crewmember {
    private String name;
    private String color;
    private String task;
    private int age;
    private boolean isAlive;
    // The numCrewmembers variable is set to protected so the Imposter class
    // can mutate the number when a crewmember is killed.
    protected static int numCrewmembers = 0;
    private static ArrayList<Crewmember> crewmembersList = new ArrayList<>();
    //----------------------------Constructors--------------------------------
    public Crewmember() {
        // A default constructor is added for those who may want to play the
        // game without having custom settings. They can be provided a default
        // crewmember with the following settings.
        this("John", "red", "carpenter", 10, true);
    }
    public Crewmember(String name, String color, String task, int age,
                      boolean isAlive) {
        // This constructor is used to create a crewmember with custom
        // it is also used to keep track of the number of crewmembers by
        // incrementing numCrewmembers when a new crewmember is instantiated.
        // This constructor adds the crewmember to the crewmembersList to keep
        // track of them so that the printRemainingCrewmembers() method can
        // iterate through the list and print the remaining crewmembers.
        this.name = name;
        this.color = color;
        this.task = task;
        this.age = age;
        this.isAlive = isAlive;
        numCrewmembers++;
        crewmembersList.add(this);
    }
    //------------------------------Getters-----------------------------------
    // Getters are allowed for all fields because they are all private and
    // cannot be accessed outside of the class. Per the rubric, all fields
    // need to be accessed to demonstrate their functionality and so they are
    // safely accessible through getters.
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
    // Setters are only allowed for the fields that may change during the
    // program. The task may change during the program like in the game. The
    // isAlive variable may change during the program if the crewmember is
    // killed by the imposter. The absence of these methods are meant to
    // demonstrate that the fields should not be changed and is only allowed
    // through the constructor.
    public void setTask(String task) {
        this.task = task;
    }
    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
    //------------------------------Methods-----------------------------------
    public void details() {
        // Prints the details of each crewmember. The details include the
        // name, color, task, and age. The name and color are printed in their
        // respective colors.
        System.out.printf("My name is %s, my color is %s, my task is %s," +
                          " and I am %d years old.\n",
                          this.withColor(this.name),
                          this.withColor(this.color), this.task, this.age);
    }
    //-----------------------------Color-Text---------------------------------
    public String withColor(String phrase) {
        // This method takes a phrase and colors it based on the color of the
        // crewmember. The colors are based on the ANSI escape codes and they
        // are assigned based on a switch of the color of the crewmember.
        String colorLowered = this.color.toLowerCase();
        final String resetCode = "\u001B[0m";
        String colorCode = switch (colorLowered) {
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
    //--------------------Print-Remaining-Crewmembers-------------------------
    public static void printRemainingCrewmembers() {
        // This method prints the remaining crewmembers. It iterates through
        // the crewmembersList and it will only print if the crewmember
        // isAlive.
        System.out.println("The remaining crewmembers are:");
        for (Crewmember crewmember : crewmembersList) {
            if (crewmember.getIsAlive()) {
                System.out.println(crewmember.withColor(
                                   crewmember.getName()));
            }
        }
    }
}
