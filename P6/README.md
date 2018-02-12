
CS161 P6: Look up! Is that a UFO??

The net is full of interesting data sets. The National UFO Reporting Site contains a database of self-reported UFO sitings. Let's write a Java application to read some of the sitings, store them in a linked list, and sort them.
The Data

A small subset of the sitings have been downloaded for you and are available in the file ufos.txt. The first few lines of this file look like

11/5/15 16:10        Denver  CO      Changing        5 minutes       UFO over Denver with two pulsating lights.
11/2/15 19:00        Denver  CO      Chevron 1 minute        Dark chevron/boomerang object.
11/2/15 18:15        Durango CO      Other   4 minutes       Two objects that brighten to 1st magnitude, and dim, to be no longer visible in southeast sky.
11/2/15 11:36        Colorado Springs        CO      Sphere  10 seconds      Saw a white orb fly past the house, silently disappearing.

Each line is one reported UFO siting, and contains the date-time, city, state, shape of UFO, duration of the siting, and a description. Notice the following characteristics of the data in this file.

    The fields are separated by tabs, so to divide into tokens you can use split("\t").
    The file does not start with the number of rows. Since you will be using linked lists, we do not need to allocate the storage before starting to read the file and building the linked list.
    The duration is an integer followed by a string specifying the units of time, which can be seconds, minutes or hours. When storing each siting in your linked list, you must convert the duration amount to seconds, so all durations are stored as seconds.

The Classes

You will write four classes, the main application class UFOSitings, class UFO to represent one UFO siting, and generic LinkedList and Node classes to implement general linked lists. The required methods for LinkedList and Node are specified in the interfaces LinkedList161.java, Node161.java. Read the comments in these interfaces to understand what is required of each method. You may write additional methods that you find useful.

To sort UFO instances, define the compareto method. You are requried to implement this so that sitings are sorted by state, then city, then datetime. This means that when sorted, all sitings from one state will be grouped together. Within that group the sitings are sorted by city. All sitings from the same city (and state) are sorted by datetime. All three of these comparisons are based on simple String comparisons. This will not correctly order all datetime values, but this is good enough.

The UFO, LinkedList and Node classes will be graded by calling their methods and examing the returned values.
Generic LinkedList and Node

Generic types are a bit complicated, so here is some help. The declaration of the Node class in Node.java must be

public class Node<T> implements Node161<T> {

Then, everywhere Node appears in this file, it must be typed as Node<T>. This is true everywhere except for the name of the constructor, which is declared as

public Node(T item, Node<T> next) {

Even trickier is the LinkedList class. You will see in the interface LinkedList161.java that this class must implement a sort method that assumes compareTo is defined for whatever type T becomes when your generic LinkedList is used in an application. Because of this use of compareTo in the LinkedList sort method, you must tell the Java compiler that T is only allowed to be a class for which compareTo is defined. You do this by qualifying the generic type in the delcaration of the Linkedlist class, by using the following as the first line in LinkedList.java:

public class LinkedList<T extends Comparable<T>> implements LinkedList161<T> {

Notice that the class used for T must extend (or implement) the Comparable interface.

So what are you storing in your linked list? UFO sitings, represented as instances of the UFO class. So the declaration of the UFO class must be

public class UFO implements Comparable<UFO> {

The Application

Your UFOSitings.java file must include a main method that includes at least the following statements.

public static void main(String[] args) {
    if (args.length == 0) {
        System.out.println("Usage: java UFOSitings <ufositings.file>");
        System.exit(1);
    }
    String filename = args[0];

    UFOSitings ufos = null;
    try {
        ufos = new UFOSitings(filename);
    } catch (IOException e) {
        System.out.println("Filename " + filename + " not found.");
        System.exit(1);
    }

    ufos.sort();
    System.out.println("After sorting:");
    System.out.println(ufos);
}

Your solution will be graded by calling the constructor, sort and toString methods of the UFOSitings class.

Here are some of the lines of output for this main method.

> javac UFOSitings.java
> java UFOSitings ufos.txt
After sorting:
 10/16/15 13:15, Arvada, CO, Formation, 20 seconds, "8 objects flying completely si ... "
 11/1/15 18:00, Arvada, CO, Sphere, 20 seconds, "Watched 4 orbs of light travel ... "
 11/1/15 18:08, Arvada, CO, Oval, 300 seconds, "Four UFOs flying in diamond pa ... "
 10/10/15 03:00, Aspen, CO, Circle, 3600 seconds, "Friend and I called the police ... "
   .
   .
   .
 9/8/15 22:00, Denver, CO, Light, 600 seconds, "Lights west of Denver."
   .
   .
   .
 9/8/15 10:30, Vernal, UT, Disk, 2700 seconds, "It was a saucer with 4-5 light ... "
 9/12/15 21:45, Cheyenne, WY, Formation, 5 seconds, "A dozen light very close toget ... "
 10/18/15 21:15, Cody, WY, Triangle, 8 seconds, "V-shaped aircraft with undergl ... "
 10/13/15 22:35, Rock Springs, WY, Formation, 10 seconds, "2 sightings of close packed V- ... "

Notice that the complete description is printed only when the length of the description string is less than or equal to 30 characters. If it's length is greater than 30, only print the first 30 characters followed by " ...". This should be done in the UFO toString method.
Submission

In Canvas, submit

    UFOSitings.java
    UFO.java
    LinkedList.java
    Node.java
