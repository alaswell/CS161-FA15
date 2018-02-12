
CS161 Lab Week 14: Sorting, Execution Timing, and Plotting

In this exercise, you will compare the execution times of four sorting algorithms. All code will be provided, except the implementations of the algorithms.

The code to start with is Sorting.java. You will see four empty methods you must complete:

    selectionSort
    insertionSort
    bubbleSort
    mergeSort

Implement them to sort in ascending order a primitive array of ints. You may find most of the code in the lecture slides at Week 13 slides.

For implementing Merge Sort, you may follow the example code at HowToDoInJava.

You will also need the xchart jar file. This jar file must be added to Eclipse, as we did for other jar files in past assignments.

From the command line, you can compile and run with

javac -cp .:xchart-2.6.0.jar Sorting.java
java  -cp .:xchart-2.6.0.jar Sorting

If you have time, experiment with adding two more line plots showing the values of size*size, and size*log(size). Which of these functions are your sort times most similar to?

