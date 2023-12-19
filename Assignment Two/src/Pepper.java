// Name: Oliver Sigwarth                                                     |
// CIDS 235: Programming Paradigms                                           |
// Assignment 2 - Grocery List War                                           |
// Program: Pepper.java                                                      |
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
public class Pepper extends Produce {
    private static final int MAX_ABILITIES = 3;
    //----------------------------Constructors--------------------------------
    public Pepper() {
        // This constructor is used to create a Pepper with default settings.
        // The name is set to "Pepper" and the health is set to 100. The
        // coloredName attribute is instantiated by calling the
        // fetchColoredName() method in the super class and the color for the
        // coloredName is set to red.
        super("Pepper", 100);
    }
    public Pepper(String name, int health) {
        // This constructor is used to create a Pepper with custom settings.
        // The name and health are set to the parameters passed and the
        // coloredName attribute is instantiated by calling the
        // fetchColoredName() method in the super class and the color for the
        // coloredName is set to red.
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
        // If the opponent is a Lettuce, then the damage multiplier is set to
        // 1.25. If the opponent is a Milk, then the damage multiplier is set
        // to 0.5. If the opponent is a Pepper or any other Produce, then the
        // damage multiplier is set to 1.
        if (opponent instanceof Lettuce) {
            multiplier = 1.0;
        } else if (opponent instanceof Milk) {
            multiplier = 0.5;
        } else {
            multiplier = 1;
        }
        // A random ability is chosen and the damage is calculated based on
        // the ability chosen and the multiplier.
        int randomAbilityNumber = this.getRandomAbilityNumber();
        switch (randomAbilityNumber) {
            case 1 -> {
                totalDamage = (int) (this.spicySpit() * multiplier);
            }
            case 2 -> {
                totalDamage = (int) (this.bulletSeed() * multiplier);
            }
            case 3 -> {
                totalDamage = (int) (this.stemSlice() * multiplier);
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

    //----------------------------Spicy-Spit----------------------------------
    public int spicySpit() {
        // This method is one of the three abilities that the Pepper class
        // can use. It prints out the name of the ability and returns the base
        // damage of the ability.
        final int BASE_DAMAGE = 15;
        System.out.printf("%s used Spicy Spit!\n", this.getColoredName());
        return BASE_DAMAGE;
    }
    //----------------------------Bullet-Seed---------------------------------
    public int bulletSeed() {
        // This method is one of the three abilities that the Pepper class
        // can use. It prints out the name of the ability and returns the base
        // damage of the ability.
        final int BASE_DAMAGE = 10;
        System.out.printf("%s used Bullet Seed!\n", this.getColoredName());
        return BASE_DAMAGE;
    }
    //-----------------------------Stem-Slice---------------------------------
    public int stemSlice() {
        // This method is one of the three abilities that the Pepper class
        // can use. It prints out the name of the ability and returns the base
        // damage of the ability.
        final int BASE_DAMAGE = 5;
        System.out.printf("%s used Stem Slice!\n", this.getColoredName());
        return BASE_DAMAGE;
    }
}
