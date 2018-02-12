
CS161 Lab Week 11: Inheritance, polymorphism and Abstract Classes

This lab will cover inheritance ,polymorphism and abstract classes.

A company has the following types of employees: programmers, and testers. This will be represented by the following Java class hierarchy:

       Employee
       /      \
Programmer    Tester

Employee must be an abstract class that represents the notion of an employee. It has an abstract method called work() that the classes Programmer and Tester will provide an implementation for. A Programmer writes code, and the Tester is focused on testing it.

First write the Employee class. It must be abstract, meaning the first line of the class declaration should be

public abstract class Employee {

The Employee class contains functionality common to types of employees in the company. For example, all employees have a name and ID number. Write the constructor and get and set methods.

The Programmer class must be a sub-class of Employee. A given programmer can write a certain number of lines of code per day, captured by an instance variable linesOfCodePerDay. A programmer's work method returns the number of lines of code he/she wrote on a given day, which is a random number between 50% and 150% of linesOfCodePerDay (some days are not as good as others, and some tasks are harder/easier than others). Check out the documentation for nextInt(int bound) at the Java API.

The Tester class is a sub-class of Employee. A given Tester can test a given number of lines of code per day, captured by an instance variable linesOfCodeTestedPerDay. A tester's work method returns the number of lines of code he/she tested that day, which is a random number between 75% and 125% of linesOfCodeTestedPerDay.

Write the class Project that models a software development project. It should have the following attributes:

        linesOfCode: An estimate of the number of lines of code the project will require (that's never known ahead of time, but let's just assume that).
        linesOfCodeWritten: the number of lines of code that have been written by the programmers working on it.
        linesOfCodeTested: the number of lines of code that have been tested so far.
        duration: how many days managers have given for completion of the project.
        employees: an ArrayList that stores the employees that are associated with the project.

The project is complete once all the code is written and tested.

The Project class should have the following methods:

        Constructor: should take in the number of lines of code for the project and required duration.
        addEmployee: adds an employee to the project.
        int doProject(): do the project. Each day, as long as the project is not complete, it should call each employee's work method. It must return the number of days the project took beyond the alotted number of days. Optional: If a project is running behind (or you estimate that it is running behind), put more testers or programmers on the job.

The main method of this class should create a new instance of Project, add a few programmers and testers, run the doProject() method, and report how long it took and whether it was completed on time.

Make sure the constructors for the Programmer and Tester classes use the constructor of the superclass. Also, write toString() methods that use the toString() method of Employee.

