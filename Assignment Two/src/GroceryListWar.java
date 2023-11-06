// Name: Oliver Sigwarth                                                     |
// Assignment 2 - Grocery List War                                           |
// Program: GroceryListWar.java                                              |
// Description:                                                              |
/*----------------------------------------------------------------------------
 * The goal of this assignment is to practice creating classes and objects.  |
 * You will create a "Crewmember" class and an instance for each Crewmember  |
 * in Among Us and implement methods to interact with those objects.         |
----------------------------------------------------------------------------*/
// Created: 11/6/2023                                                        |
// Last Modified: 11/6/2023                                                  |
//----------------------------------------------------------------------------
import java.util.ArrayList;
public class GroceryListWar {
    ArrayList<Produce> groceryList;
    public GroceryListWar() {
        this.groceryList = new ArrayList<>();
    }
    public static void main(String[] args) {
        GroceryListWar groceryListWarSimulator = new GroceryListWar();
        Apple apple = new Apple();
        Corn corn = new Corn();
        Salad salad = new Salad();
        groceryListWarSimulator.getGroceryList().add(apple);
        groceryListWarSimulator.getGroceryList().add(corn);
        groceryListWarSimulator.getGroceryList().add(salad);
        System.out.println(groceryListWarSimulator.getGroceryList());
    }
    public ArrayList<Produce> getGroceryList() {
        return this.groceryList;
    }
}