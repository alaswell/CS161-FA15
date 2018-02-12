 CS 161 Lab 1
Overview
This lab will familiarize students with the environment they will be using this semester:

    Logging into CS Lab machines
    Basic text editing
    Submitting a programming assignment using Checkin
    Basic Eclipse usage

We will also cover basic Java programming from CS 160:

    Reading from standard input (console)
    Reading from Files
    Creating and using functions
    for and while loops
    if-statements
    array manipulation

UNIX Learning some of the basic UNIX commands for working in a UNIX/Linux environment can help you greatly. If you want to learn a lot about programming in the UNIX/Linux environment, you can take the course CS155 (1 credit). We will introduce you to some of the essential and most useful commands this semester. Type the following commands at a terminal window. The TA will explain what each of them as you go along.

    ls
    ls -l
    mkdir cs161Lab
    ls
    cd cs161Lab
    pwd
    cd ..
    pwd

Lab Assignment
Please complete this portion of the lab individually. Notify the instructor when you have finished to receive credit. The assignment must be completed in lab.

You will need the following file:
Lab1.java

Please implement the stub methods in Lab1.java.

Part 1 - Checking divisors
The divisors test is a common programming interview question due to its coverage of several basic concepts. Traditionally, for some i such that n ≤ i ≤ m, the candidate must:

    print "is divisible by 3" if i is divisible by 3
    print "is divisible by 5" if i is divisible by 5
    print "is divisible by both 3 and 5" if i is divisible by 3 and 5

For this part of the lab assignment, you must implement the following methods:

public boolean isDivisibleBy3(int x): returns true if x is divisible by 3

public boolean isDivisibleBy5(int x): returns true if x is divisible by 5

public String testDivisors(int x) returns the Strings "is divisible by 3", "is divisible by 5", or "is divisible by 3 and 5" as appropriate.

public void testRange(int first, int last): runs the testDivisors test for all integers in the range [first, last]. You should prompt the user to input first and last.

Example:

Input: first = 1, last = 15
Output:
1
2
3 "is divisible by 3"
4
5 "is divisible by 5"
6
...
15 "is divisible by 3 and 5"
Part 2 - Extracting Positive Integers from an Array
Implement public int[] extractPositives(int[] values)

Given an array of integers, create and return a new array that contains only the positive elements. The returned array should be exactly the right size. In other words, if values contains 10 elements, but only 5 elements are positive, the returned array should be of length 5.

You should use command line arguments as the data source for this task. Read the file in the main method, create an array, and call extractPositives with that array. Create your own file for testing. For the purposes of this exercise, consider 0 to be positive. You may use Arrays.toString to print an array. Asjk about this.

Example:

Input: -1 0 3 -5 6
Output: [0, 3, 6]
Part 3 - Read input from a file
Create a data file called people.txt that contains a person's last name, a space, and their age. Data file listed below:

Darby 92
Coolie 18
Jorge 25
Jansen 40
Geow 22

Read in the data file as a command line argument and store it into an array. Print out each line as follows:"Person: name, Age: #" For example, the first line would read "Person: Darby, Age: 92". Then print out all of the last names separated with a comma. For example, the output would be:
"Darby, Coolie, Jorge, Jansen, Geow"
Grading
This lab is worth a total of 2 points broken down as:
Demo/Attendance: 1 point
Effort: 1 point 
