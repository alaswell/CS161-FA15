
CS161 P7: Let's Play!

For your final CS161 assignment, you will modify an implementation of Tic-Tac-Toe. Start with the implementation in TicTacToe.java. Download this and compile and run it.

Take some time to read through this code to understand the overall structure. You will see some new java concepts, such as the following. Bring to class your questions about other concepts you see that you do not understand.
Enumerations

Read about enum at stackoverflow page. This is a very useful kind of class that helps the java compiler find errors in your code when you need a variable that should only be assigned one of a small number of values. It also makes your code more readable.
Inner Classes

Nested classes, or inner classes, can simplify the organization of your code that involves multiple classes. Read a short introduction to them at this Programmer Interview page on inner classes.
Anonymous Inner Class

If you will only ever need a single instance of a class, it can be handy to define the new class and create an instance of that class in one step. Since you only need one instance, you really would not need to name that class. Anonymous classes are used for this. Read about them at this Programmer Interview page on anonymous classes.

Anonymous classes are often used when defining event listeners, such as ones needed to respond to events related to a user's mouse and keyboard events when using a graphical user interface (GUI).
Swing and Awt Graphics Packages

A nice introduction to general GUI programming is at this nice lecture notes by Okyay Say. The Java Docs page on 2D Graphics will help you understand the code for drawing shapes for the Tic Tac Toe board.
Your Task

Now, modify this code to automate Player O's turn. Implement the silly strategy of choosing an empty cell at random for placing O's marker. Do this in a new method you define with the following name and arguments:

    public Location robotPlayer()

that returns an instance of a class you must define named Location that has two int instance variables for row and column, a constructor, and get and set methods. The class Location may be defined in TicTacToe.java as an inner class, or in its own file Location.java. This is up to you.

The location returned by robotPlayer() must be a valid row and column for the next move by O.
Extra Credit

If you have time, try implementing these ideas, for one extra credit point each.

    Implement a smarter O strategy. If O has two in a row, column or diagonal, place O marker to win!
    Use a single command-line argument to specify the number of rows and columns (equal) on the board. For example, if the command-line argument is 4, then you will play a 4 x 4 Tic Tac Toe game.

Submission

In Canvas, submit your TicTacToe.java file, and any additional java files you define for your solution.

