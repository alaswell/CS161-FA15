
CS161 Lab Week 4: Classes and ArrayList
Introduction

This lab will explore the ArrayList data structure as well as the following aspects of object-oriented programming in Java:

    Constructing objects
    Access modifiers (private, public) and accessing/modifying instance variables
    Method usage
    Client objects
    toString()
    equals(Object other)

The ArrayList structure in java is a way to create an array that can grow or shrink in size during the execution of a program. As we have seen, a primitive array has a fixed size: once we declare it to be a particular size, that size cannot be changed. In our first two assignments, we have learned how to grow and shrink primitive arrays. The ArrayList class uses a primitive array to store objects and includes code much like you have written to grow and shrink the array.

To set up an ArrayList, you first have to import the package from the java.util library.

import java.util.ArrayList;

You can then create a new ArrayList for storing any object.

ArrayList things = new ArrayList();

As discussed in lecture, you can create an ArrayList for holding specific types of objects, like Pet objects.

ArrayList<Pet> things = new ArrayList<Pet>();

The Java API has a list of all the methods provided by an ArrayList. See: Java ArrayList API.
What You Must Do

Download the following files.

    animals.txt
    Animal.java
    GuinnessBook.java

Complete the implementation of Animal.java, by adding the following methods.

    A constructor that takes in a String for the name and an int for the topSpeed. Use the setters to set the instance variables.
    Getters and setters for name and topSpeed. setTopSpeed must bound the topSpeed value to be between 0 and 70, inclusively.
    a toString method that returns a String with that animal's information. For example, Name: elephant, Top Speed: 25
    an equals(Object other) method that returns True if two animals have the same speed within 2mph, and False otherwise. Recall that equals takes in an instance of Object rather than Animal, in order to override the default implementation of equals).

When implementing constructors, getters/setters, toString or equals methods you can use Eclipse to help you write those methods. Under the "Source" tab of Eclipse there are options for generating stubs for those methods.

In GuinnessBook.java complete these steps.

    Write the constructor. You just need to add code that adds the animals to the landAnimals ArrayList.
    Uncomment the line in main to test the constructor, then test it.
    Write the toString method. This will implicitly use the Animal's toString``method.  It should return a ``String representation all of the elements in the ArrayList. For example,

Name: giraffe, Top Speed: 32
Name: pronghorn, Top Speed: 61
Name: reindeer, Top Speed: 32

    Uncomment the line in main to test toString, then test it.
    Complete the testGuinnessBook method.
    Uncomment the line in main to test testGuinnessBook, then test it.


