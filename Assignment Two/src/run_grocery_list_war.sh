#!/bin/bash
#enter chmod +x run_grocery_list_war.sh to make executable

javac GroceryListWar.java
if [ $? -eq 0 ]
then
  echo "Welcome to Grocery List War!"
  java GroceryListWar
else
  echo "Failed to load program."
fi