// Name: Oliver Sigwarth                                                     |
// Assignment 1 - Among Us                                                   |
// Program: Imposter.java                                                    |
// Description:                                                              |
/*----------------------------------------------------------------------------
 * The goal of this assignment is to practice creating classes and objects.  |
 * You will create a "Crewmember" class and an instance for each Crewmember  |
 * in Among Us and implement methods to interact with those objects.         |
----------------------------------------------------------------------------*/
// Created: 10/12/2023                                                       |
// Last Modified: 10/18/2023                                                 |
//----------------------------------------------------------------------------
public class Imposter extends Crewmember {
    //----------------------------Constructors--------------------------------
    public Imposter() {
        // A default constructor is added for those who may want to play the
        // game without having custom settings. They can be provided a default
        // imposter with the settings defined in the parent class. Since it
        // inherits from the Crewmember class, it uses the super keyword to
        // call the parent constructor.
        super();
    }
    public Imposter(String name, String color, String task, int age,
                    boolean isAlive) {
        // This constructor is used to create an imposter with custom
        // settings. Since it inherits from the Crewmember class, it uses the
        // super keyword to call the parent constructor.
        super(name, color, task, age, isAlive);
    }
    //------------------------------Methods-----------------------------------
    public void kill(Crewmember crewmember) {
        // If the imposter is alive and the crewmember they want to kill is
        // alive, then the imposter can kill the crewmember. The crewmember
        // is killed by setting their isAlive variable to false and the
        // numCrewmembers variable is decremented.
        if (crewmember.getIsAlive() && this.getIsAlive()) {
            System.out.println(crewmember.getName() + " has been killed!");
            crewmember.setIsAlive(false);
            numCrewmembers--;
        }
    }
}
