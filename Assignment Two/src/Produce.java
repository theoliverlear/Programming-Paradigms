// Name: Oliver Sigwarth                                                     |
// CIDS 235: Programming Paradigms                                           |
// Assignment 2 - Grocery List War                                           |
// Program: Produce.java                                                     |
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
public abstract class Produce {
    private String name;
    private int health;
    private String coloredName;
    //----------------------------Constructors--------------------------------
    public Produce(String name, int health) {
        // This constructor is used to create a Produce object with custom
        // attributes. The name and health are set to the parameters passed
        // and the coloredName attribute is instantiated by calling the
        // fetchColoredName() method.
        this.name = name;
        this.health = health;
        this.fetchColoredName();
    }
    //=============================-Methods-==================================

    //-------------------------------Attack-----------------------------------
    public void attack(Produce opponent) {
        // This method is meant for attacking another Produce object. It calls
        // the determineDamage() method to determine the amount of damage that
        // a random ability will deal to the opponent. Then it calls the
        // takeDamage() method on the opponent to deal the damage.
        int damage = this.determineDamage(opponent);
        opponent.takeDamage(damage);
    }
    //----------------------------Take-Damage---------------------------------
    public void takeDamage(int damage) {
        // This method deals damage to a produce object of which it is called
        // upon and prints the status of the produce object after the damage
        // has been dealt. If the damage dealt is greater than the health of
        // the produce object, then the health is set to 0.
        System.out.printf("%s took %d damage!\n", this.coloredName, damage);
        if ((this.health - damage) > 0){
            this.health -= damage;
        } else {
            this.health = 0;
        }
        System.out.println(this);
    }
    //--------------------------Determine-Damage------------------------------
    public abstract int determineDamage(Produce opponent);
    // This method is meant for determining the damage that a Produce object
    // will deal to another Produce object. It is abstract because each
    // Produce item has its own unique abilities and damage multipliers.
    //------------------------Get-Random-Ability-Number-----------------------
    public abstract int getRandomAbilityNumber();
    // This method is meant for determining which ability a Produce object
    // will use. It is abstract because each Produce item has its own amount
    // of unique abilities to choose from.
    //----------------------------Fetch-Colored-Name--------------------------
    public void fetchColoredName() {
        // This method instantiates the coloredName field based on the
        // instance type of the object. It is used to print the name of the
        // produce object in color. First, we define the codes needed for each
        // type of produce. Then we check the type of the object and set the
        // coloredName field to the appropriate color based on its instance.
        String resetCode = "\u001B[0m";
        String greenCode = "\u001B[32m";
        String redCode = "\u001B[31m";
        String pinkCode = "\u001B[35m";
        if (this instanceof Pepper) {
            this.coloredName = redCode + this.name + resetCode;
        } else if (this instanceof Lettuce) {
            this.coloredName = greenCode + this.name + resetCode;
        } else if (this instanceof Milk) {
            this.coloredName = pinkCode + this.name + resetCode;
        }
    }
    //-----------------------------To-String----------------------------------
    @Override
    public String toString() {
        // This method provides a string representation of a Produce object
        // for various purposes -- but mainly printing. It gives the name and
        // health of the Produce object.
        return String.format("%s has %d health remaining.",
                             this.coloredName, this.health);
    }
    //------------------------------Getters-----------------------------------
    // Getters are allowed for all fields because they should be accessible
    // for their contents but only through the getters.
    public String getName() {
        return this.name;
    }
    public int getHealth() {
        return this.health;
    }
    public String getColoredName() {
        return this.coloredName;
    }
    //------------------------------Setters-----------------------------------
    // Setters are only allowed for the health field because it is the only
    // field that may change during the program. The other fields would be set
    // through the constructor and should not be changed.
    public void setHealth(int health) {
        this.health = health;
    }
}
