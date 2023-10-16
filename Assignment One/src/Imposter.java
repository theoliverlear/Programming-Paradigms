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
public class Imposter extends Crewmember {
    public Imposter() {
        super();
    }
    //----------------------------Constructors--------------------------------
    public Imposter(String name, String color, String task, int age,
                    boolean isAlive) {
        super(name, color, task, age, isAlive);
    }
    //------------------------------Methods-----------------------------------
    public void kill(Crewmember crewmember) {
        if (crewmember.getIsAlive() && this.getIsAlive()) {
            System.out.println(crewmember.getName() + " has been killed!");
            crewmember.setIsAlive(false);
        }
    }
}
