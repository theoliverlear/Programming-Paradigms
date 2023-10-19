# Program Write-Up Document

- Oliver Sigwarth
- 10-19-2023
- CIDS 235 - Programming Paradigms
- Assignment 1 - Among Us

**Link to working code: https://replit.com/join/ediygthgdu-theoliverlear**

## Explanation

This document shows the code of the **Among Us** program which simulates the
game Among Us. The program is written in Java and has three distinct classes.
The first class is the Main class, which contains the main method and is
responsible for running the program. The second class is the Crewmate class,
which represents the crewmates in the game. The third class is the Imposter
class, which represents the imposters in the game. 

## IMPORTANT

For descriptions of the code and the justifications for the design, please
refer to the comments in the code. The comments are meant to explain the
functionality of the code and appear in the places where they are most 
pertinent.

## UML Class Diagram

[Insert UML Class Diagram Image Here]

*Figure 1: UML Class Diagram*

The UML diagram shows the structure of each class and their relationships with
each other. It will show the data fields, methods, and constructors of each
class. It will also show the inheritance relationships between the classes.

## The Test Class - Main.java

```java
// Test Class
public class TestProgram {
    public static void main(String[] args) {
        // Test the program functionality here
        // Provide test cases and expected outcomes
    }
}
```

*Listing 1: Test Program Class*

The test class is meant to show the functionality of the program. It is not a
representation of the game itself, but rather it has the functionality for the
game using object-oriented design. You will see many print statements showing
the methods as well as the modular nature of certain data fields.

## Other Classes

### Crewmember.java

```java
// Class 1
public class Class1 {
    // Class 1 code
}
```

*Listing 2: Crewmember*

The Crewmember class is responsible for representing the crewmates in the
game. It has data fields that represent the crewmate's name, color, task, age,
and whether or not they are alive. It also has methods that allow for the
program to safely access its appropriate data fields. The class has methods
which show the details of a Crewmember object, as well as show the remaining
crewmembers.

### Imposter.java

```java
// Class 2
public class Class2 {
    // Class 2 code
}
```

*Listing 3: Imposter*

The Imposter class is responsible for representing the imposters in the game.
It contains all of the same data fields as the Crewmember class since the 
class inherits from the Crewmember class. In addition to the same data fields
and methods, the Imposter class has the unique ability to kill crewmembers, or
set their isAlive status to false.

## Conclusion

This program is a demonstration of the object-oriented design of a game like
Among Us. It shows the relationships between the classes and how they can
interact with each other. It also shows the functionality and modularity of
object-oriented design. This document is meant to share the core information
about the program and its design.

## Citations

*None*