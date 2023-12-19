// Name: Oliver Sigwarth                                                     |
// CIDS 235: Programming Paradigms                                           |
// Assignment 2 - Grocery List War                                           |
// Program: Lettuce.java                                                     |
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
import java.util.Random;
public class Lettuce extends Produce {
    private static final int MAX_ABILITIES = 3;
    //----------------------------Constructors--------------------------------
    public Lettuce() {
        // This constructor is used to create a Lettuce object with default
        // attributes. The name is set to "Lettuce" and the health is set to
        // 50. The coloredName attribute is instantiated by calling the
        // fetchColoredName() method in the super class and the color for the
        // coloredName is set to green.
        super("Lettuce", 50);
    }
    public Lettuce(String name, int health) {
        // This constructor is used to create a Lettuce object with custom
        // attributes. The name and health are set to the parameters passed
        // and the coloredName attribute is instantiated by calling the
        // fetchColoredName() method in the super class and the color for the
        // coloredName is set to green.
        super(name, health);
    }
    //=============================-Methods-==================================

    //--------------------------Determine-Damage------------------------------
    @Override
    public int determineDamage(Produce opponent) {
        // This method takes the damage of a random ability and multiplies it
        // with the damage multiplier based on the instance type of the
        // object.
        double multiplier;
        int totalDamage;
        // If the opponent is a Pepper, then the damage multiplier is set to
        // 0.75. If the opponent is a Milk or any other Produce, then the
        // damage multiplier is set to 1.
        if (opponent instanceof Pepper) {
            multiplier = 0.75;
        } else {
            multiplier = 1;
        }
        // A random ability is chosen and the damage is calculated based on
        // the ability chosen and the multiplier.
        int randomAbilityNumber = this.getRandomAbilityNumber();
        switch (randomAbilityNumber) {
            case 1 -> {
                totalDamage = (int) (this.razorLeaf() * multiplier);
            }
            case 2 -> {
                totalDamage = (int) (this.stemStomp() * multiplier);
            }
            case 3 -> {
                totalDamage = (int) (this.eColiAttack() * multiplier);
            }
            default -> {
                totalDamage = 0;
            }
        }
        return totalDamage;
    }
    //------------------------Get-Random-Ability-Number-----------------------
    @Override
    public int getRandomAbilityNumber() {
        // This method returns a random number between 1 and the max number of
        // abilities. Since the nextInt() method is exclusive in its highest
        // number, one is added to the MAX_ABILITIES variable to get the full
        // range of abilities. If the random number is 0, then it is set to 1.
        Random random = new Random();
        int randomAbility = random.nextInt(MAX_ABILITIES + 1);
        if (randomAbility <= 0) {
            randomAbility = 1;
        }
        return randomAbility;
    }
    //======================-Attack-Ability-Methods-==========================

    //----------------------------Razor-Leaf----------------------------------
    public int razorLeaf() {
        // This method is one of the three abilities that the Lettuce class
        // can use. It prints out the name of the ability and returns the base
        // damage of the ability.
        final int BASE_DAMAGE = 20;
        System.out.printf("%s used Razor Leaf!\n", this.getColoredName());
        return BASE_DAMAGE;
    }
    //----------------------------Stem-Stomp----------------------------------
    public int stemStomp() {
        // This method is one of the three abilities that the Lettuce class
        // can use. It prints out the name of the ability and returns the base
        // damage of the ability.
        final int BASE_DAMAGE = 15;
        System.out.printf("%s used Stem Stomp!\n", this.getColoredName());
        return BASE_DAMAGE;
    }
    //---------------------------E-Coli-Attack--------------------------------
    public int eColiAttack() {
        // This method is one of the three abilities that the Lettuce class
        // can use. It prints out the name of the ability and returns the base
        // damage of the ability.
        final int BASE_DAMAGE = 25;
        System.out.printf("%s used E. Coli Attack!\n", this.getColoredName());
        return BASE_DAMAGE;
    }
}
