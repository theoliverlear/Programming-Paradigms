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
// Last Modified: 10/12/2023                                                 |
//----------------------------------------------------------------------------
public class Main {
 /*
     Name	 Color	 Task	         Age
     Jimmy	 Cyan	 Electrical      34
     Steve	 Red	 Medbay	         21
     Bart	 Lime	 Navigation      25
     Mike	 Purple	 Communications  45
     Jeb	 Yellow	 O2	             27
     Dingus	 Green	 Admin	         64
  */
    public static void main(String[] args) {
        Crewmember jimmy = new Crewmember("Jimmy", "Cyan",
                                     "Electrical", 34, true);
        Crewmember steve = new Crewmember("Steve", "Red",
                                     "Medbay", 21, true);
        Crewmember bart = new Crewmember("Bart", "Lime",
                                    "Navigation", 25, true);
        Crewmember mike = new Crewmember("Mike", "Purple",
                                    "Communications", 45, true);
        Crewmember jeb = new Crewmember("Jeb", "Yellow",
                                   "O2", 27, true);
        Crewmember dingus = new Crewmember("Dingus", "Green",
                                      "Admin", 64, true);

    }
}