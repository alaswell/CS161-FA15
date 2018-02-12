
CS161 P4: Finding Your Way Recursively!

Recursion is handy for solving problems involving choosing one of several alternatives at each step. For this assignment, you will use recursion to solve mazes!

Each maze will be specified by a text file containing # marks for barriers, one S for the starting position, and one G for the goal position. As the maze is solved, your code will leave breadcrumbs, indicated by . characters. Here is an example maze.

##########
#        #
#   ###  #
#   #  G #
#   #    #
#        #
#        #
#  #######
#   S    #
##########

After finding a solution path, the result might look like this.

##########
# .......#
# . ### .#
# . #  G.#
# . #  ..#
# .    ..#
# .    ..#
# .#######
# ..S    #
##########

The sequence of moves, with U, R, D, and L indicating Up, Right, Down, and Left moves, and G indicating the Goal is reached, is

LLUUUUUUURRRRRRDDDDDLUUUG

Notice that this is not the shortest path to the goal. The search method we will be implementing is a "depth-first search", and is not likely to find the shortest path.
Code Requirements

For this assignment, you will implement a single class, named Maze. The list of required classes and methods are:

    public void initializeFromFile(String filename): uses a Scanner to read text from the given filename, allocate a two-dimensional char array to hold a map of the maze, fill the map with characters from the file, and remember where the 'S' character is in the maze.
    public String findPathFrom(int row, int col): a recursive method that finds a path from position (row,col) to the goal position, marked by 'G', and returns a String composed of the characters 'U', 'R', 'D', 'L', and the final 'G', indicating the solution path.
    public String findPath(): a method that calls findPathFrom(startRow, startCol) and returns what it returns, and does anything else that is necessary.
    public String toString(): returns a String representation of the map character array.

Your main method must get the filename from the command line, call the above methods to solve the maze, and print the resulting map and the solution path.
Recursive Algorithm

Your findPathFrom(row,col) must implement this recursive algorithm for finding a path to the goal from the position (row,col) given as an argument.

    Base cases:
        If position (row,col) is outside of the maze, return "".
        If the character at position (row,col) in the map is a '#' or '.', return "".
        If the character at position (row,col) in the map is a 'G', return "G". You found the goal!!
    Recursive cases:
        Mark the map at position (row,col) with a '.'
        Try to find a path to the goal from position (row-1,col). If found, add 'U' to the returned path and return it.
        Try to find a path to the goal from position (row,col+1). If found, add 'R' to the returned path and return it.
        Try to find a path to the goal from position (row+1,col). If found, add 'D' to the returned path and return it.
        Try to find a path to the goal from position (row,col-1). If found, add 'L' to the returned path and return it.
        If you reach here, no path to the goal from (row,col) was found. Remove the mark '.' at map position (row,col), by replacing with a blank, and return "".

Examples

To solve the above maze, make a file with the following contents.

10 10
##########
#        #
#   ###  #
#   #  G #
#   #    #
#        #
#        #
#  #######
#   S    #
##########

Say it is saved in a file named maze1. The result of compiling and running your Maze class must be exactly as shown below.

> javac Maze.java
> java Maze maze1
##########
# .......#
# . ### .#
# . #  G.#
# . #  ..#
# .    ..#
# .    ..#
# .#######
# ..S    #
##########
LLUUUUUUURRRRRRDDDDDLUUUG

More examples are provided here in this debugging output of successful runs. These use the above maze file and also mazeSmall and mazeBig.
Submission

Make a jar file containing your Maze.java file and at least one text file, different than the above example, containing a maze that your code can solve. Name your jar file P4.jar. For example, say you have created two maze text files names maze1 and maze2.

jar cvf P4.jar Maze.java maze1 maze2

Submit P4.jar online checkin system.

