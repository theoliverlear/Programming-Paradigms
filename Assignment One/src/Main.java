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
// Last Modified: 10/19/2023                                                 |
//----------------------------------------------------------------------------
public class Main {
            /*-------------------Test-Cases-------------------
            |   |  Name  |  Color |	     Task	   | Age |   |
            |---|--------|--------|----------------|-----|---|
            |   |  Jimmy |	 Cyan |	    Electrical |  34 |   |
            |   |  Steve |	  Red |	        Medbay |  21 |   |
            |   |   Bart |	 Lime |	    Navigation |  25 |   |
            |   |   Mike | Purple |	Communications |  45 |   |
            |   |    Jeb | Yellow |	            O2 |  27 |   |
            |   | Dingus |	Green |	         Admin |  64 |   |
            |   |  Judas |	 Gray |	      Impostor | 100 |   |
            ------------------------------------------------*/
    //===========================-Main-Method-================================
    public static void main(String[] args) {
        // The following variables are the crewmembers laid out in the table
        // from the rubric. I'm using the constructor that takes all of the
        // parameters to instantiate the crewmembers as well as utilizing the
        // static datafields to keep track of the number of crewmembers and
        // the amount of crewmembers that are alive.
        //-----------------------Print-Divider--------------------------------
        String separator = "-".repeat(78);
        System.out.println(separator);
        //----------------------Build-Test-Cases------------------------------
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
        Imposter judas = new Imposter("Judas", "Gray",
                                         "Impostor", 100, true);

        //--------------------Demonstrate-Getters-----------------------------
        System.out.println("Jimmy's name is: " + jimmy.getName());
        System.out.println("Steve's color is: " + steve.getColor());
        System.out.println("Bart's task is: " + bart.getTask());
        System.out.println("Mike's age is: " + mike.getAge());
        System.out.println("Jeb is alive: " + jeb.getIsAlive());
        System.out.println("Dingus' task is: " + dingus.getTask());
        System.out.println("Judas' task is: " + judas.getTask());
        System.out.printf("There are %d crewmembers.\n",
                           Crewmember.getNumCrewmembers());
        //--------------------Demonstrate-Setters-----------------------------
        System.out.println(separator);
        jimmy.setTask("Storage");
        jimmy.details();
        //===================-Demonstrate-Methods-============================
        //------------------------Kill-Method---------------------------------
        System.out.println(separator);
        judas.kill(jimmy);
        System.out.println(jimmy.getName() + " is alive: "
                         + jimmy.getIsAlive());
        System.out.printf("There are %d crewmembers.\n",
                           Crewmember.getNumCrewmembers());
        //-----------------------Details-Method-------------------------------
        System.out.println(separator);
        for (Crewmember crewmember : Crewmember.getCrewmembers()) {
            crewmember.details();
        }
        //----------------Print-Remaining-Crewmembers-------------------------
        System.out.println(separator);
        Crewmember.printRemainingCrewmembers();
    }
}