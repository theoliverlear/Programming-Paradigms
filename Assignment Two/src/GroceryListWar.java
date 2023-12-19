// Name: Oliver Sigwarth                                                     |
// CIDS 235: Programming Paradigms                                           |
// Assignment 2 - Grocery List War                                           |
// Program: GroceryListWar.java                                              |
// Description:                                                              |
/*----------------------------------------------------------------------------
 * Your task is to create a text-based game called "Grocery List War -       |
 * Battle of the Produce." You will design and implement a base class named  |
 * "Produce" to represent grocery list items, develop distinct subclasses    |
 * for these items, and construct a UML (Unified Modeling Language) diagram  |
 * to visually represent the class structure and relationships.              |
----------------------------------------------------------------------------*/
// Created: 11/6/2023                                                        |
// Last Modified: 11/20/2023                                                 |
//----------------------------------------------------------------------------
import java.util.ArrayList;
import java.util.Random;
public class GroceryListWar {
    private ArrayList<Produce> groceryList;
    private boolean battleInProgress;
    private Produce winner;
    private String battleSeparator = "-".repeat(40);
    //----------------------------Constructors--------------------------------
    public GroceryListWar() {
        // This constructor is used to create a GroceryListWar object with
        // default attributes. The groceryList is instantiated as an empty
        // ArrayList which will hold the embattled Produce objects.
        this.groceryList = new ArrayList<>();
    }
    //-----------------------------Start-War----------------------------------
    public void startWar() {
        // This method starts the war by announcing the beginning of the war
        // then looping through the groceryList and battling each Produce
        // object until there is only one Produce object left. The winner is
        // then announced.
        System.out.println("Let the food for all begin!");
        do {
            // The determineProgress() method is called to determine if the
            // war is still in progress. If there are more than one Produce
            // objects in the groceryList, then the war is still in progress.
            this.determineProgress();
            if (this.battleInProgress) {
                // The getRandomMatchup() method is called to get a random
                // matchup of Produce objects from the groceryList. The
                // battle() method is then called to battle the two Produce
                // objects.
                Produce[] matchup = this.getRandomMatchup();
                this.battle(matchup[0], matchup[1]);
            } else {
                // If there is only one Produce object left in the
                // groceryList, then the war is over and the winner is the
                // first and only Produce object in the groceryList.
                this.winner = this.groceryList.get(0);
                this.announceWinner();
            }
        } while (this.battleInProgress);
    }
    //---------------------------Battle-Method--------------------------------
    public void battle(Produce produceOne, Produce produceTwo) {
        // This method takes two Produce objects and battles them until one
        // Produce object's health is less than or equal to zero. The Produce
        // object with health zero or less is removed from the groceryList and
        // the winner of the battle is announced.

        // The indexes of the Produce objects are stored so that the Produce
        // object with health zero or less can be removed from the
        // groceryList easily.
        int indexOfProduceOne = this.groceryList.indexOf(produceOne);
        int indexOfProduceTwo = this.groceryList.indexOf(produceTwo);
        //--------------------Print-Battle-Matchup----------------------------
        System.out.println("The battle has begun!");
        System.out.println(produceOne.getColoredName() + " vs. " +
                           produceTwo.getColoredName());
        System.out.println(this.battleSeparator);
        //------------------------Battle-Loop---------------------------------
        while (produceOne.getHealth() > 0 && produceTwo.getHealth() > 0) {
            produceOne.attack(produceTwo);
            produceTwo.attack(produceOne);
            System.out.println(this.battleSeparator);
        }
        //-------------------------Handle-Winner------------------------------
        if (produceOne.getHealth() > 0) {
            System.out.println(produceOne.getColoredName() + " has won the" +
                               " battle!");
            this.groceryList.remove(indexOfProduceTwo);
        } else {
            System.out.println(produceTwo.getColoredName() + " has won the" +
                               " battle!");
            this.groceryList.remove(indexOfProduceOne);
        }
        System.out.println("The battle is over!");
    }
    //-------------------------Get-Random-Matchup-----------------------------
    public Produce[] getRandomMatchup() {
        // This method returns a random matchup of Produce objects from the
        // groceryList.
        Produce[] matchup = new Produce[2];
        Random random = new Random();
        int[] randomIndexes = new int[2];
        boolean isUnique = false;
        // A random matchup is chosen by generating two random numbers between
        // zero inclusively and the size of the groceryList exclusively. If
        // the two random numbers are not equal, then the matchup is unique
        // and the Produce objects at those indexes are added to the matchup
        // array.
        while (!isUnique) {
            for (int i = 0; i < randomIndexes.length; i++) {
                randomIndexes[i] = random.nextInt(this.groceryList.size());
            }
            if (randomIndexes[0] != randomIndexes[1]) {
                isUnique = true;
            }
        }
        matchup[0] = this.groceryList.get(randomIndexes[0]);
        matchup[1] = this.groceryList.get(randomIndexes[1]);
        return matchup;
    }
    //-------------------------Determine-Progress-----------------------------
    public void determineProgress() {
        // This method determines if the war is still in progress by checking
        // the size of the groceryList. If the size of the groceryList is
        // greater than one, then the war is still in progress. If the size of
        // the groceryList is one, then the war is over and we have a victor.
        if (this.groceryList.size() > 1) {
            this.battleInProgress = true;
        } else {
            this.battleInProgress = false;
        }
    }
    //--------------------------Announce-Winner-------------------------------
    public void announceWinner() {
        // This method announces the winner of the war.
        System.out.printf("The winner is: %s!\n",
                          this.winner.getColoredName());
    }
    public void addToBattleArena(Produce produce) {
        // This method adds a Produce object to the groceryList for the
        // battle.
        this.groceryList.add(produce);
    }
    //===========================-Main-Method-================================
    public static void main(String[] args) {
        //---------------------Add-Food-Fighters------------------------------
        GroceryListWar groceryListWar = new GroceryListWar();
        Lettuce lauraLettuce = new Lettuce("Laura Lettuce", 50);
        groceryListWar.addToBattleArena(lauraLettuce);
        Pepper paulPepper = new Pepper("Paul Pepper", 35);
        groceryListWar.addToBattleArena(paulPepper);
        Milk maryMilk = new Milk("Mary Milk", 40);
        groceryListWar.addToBattleArena(maryMilk);
        //-------------------------Start-War----------------------------------
        groceryListWar.startWar();
    }
    //------------------------------Getters-----------------------------------
    // A getter is available for the groceryList so that the participants of
    // the war can be viewed. Setters are not available because all of the
    // mutations occur within the class.
    public ArrayList<Produce> getGroceryList() {
        return this.groceryList;
    }
}