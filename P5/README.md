
CS161 P5: Oh No, Fort Collins !!! It's not abstract anymore!

Let's create a disaster in Fort Collins.

For this assignment, you will complete the java code needed to simulate flows of terrible things across Fort Collins. You are provided code that reads a file of elevation data and displays it as a 3D terrain, using the JOGL package that provides Java bindings for the standard graphics framework OpenGL. You will write code that controls the flow of various bad things across the landscape.

To enable your code to link with the OpenGL library, download these two files.

        jogl-all.jar
        gluegen-rt.jar

Also download another two files, depending on which operating system you are using.

        for MS Windows, 64-bit
            jogl-all-natives-windows-amd64.jar
            gluegen-rt-natives-windows-amd64.jar
        for MS Windows, 32-bit. Use these if you see errors about not finding i586.jar
            jogl-all-natives-windowsi586.jar
            gluegen-rt-natives-windows-i586.jar
        for Mac OS
            jogl-all-natives-macosx-universal.jar
            gluegen-rt-natives-macosx-universal.jar
        for Linux
            jogl-all-natives-linux-amd64.jar
            gluegen-rt-natives-linux-amd64.jar

To use these in Eclipse, add them to your project like you did for P3 to use the jfugue.jar package.
Fort Collins Terrain

Now, let's see some graphics! Download these two files.

        Terrain.java (now compiles correctly with FlowInterface.java in current directory)
        fortcollins.elevation

Be sure fortcollins.elevation is in your Eclipse package. You should be able to compile and run Terrain.java using one command-line argument that is the name of the elevation file, fortcollins.elevation.

To compile and run outside of Eclipse, put the four JOGL jar files in your current directory with Terrain.java and fortcollins.elevation. Then these commands should work:

javac -cp .:jogl-all.jar:gluegen-rt.jar Terrain.java
java -cp .:jogl-all.jar:gluegen-rt.jar Terrain fortcollins.elevation

While this is running, hold the left mouse button down to move around and zoom in and out of the scene. Holding the shift key down lets you rotate the scene. The menu at the upper left allows you to quit the application. You will be adding items to this menu.
Let It Flow

Here is the part where you write some code. You will write two classes named Water and Fire, that handle the flow of water and fire, duh, across the terrain. You might guess that the mechanics of implementing these two classes have a lot in common. So, also write a third class named Flow that is extended by Water and Fire. Since we don't know how to actually simulate a general flow without knowing what it is, Flow will have to be an abstract class, because it will contain an abstract update method. This guarantees that

        Water and Fire implement update, and
        our Terrain class can work with objects of type Flow including the ability to call the update method.

The details of what you must define in Flow are specified in FlowInterface.java. Read the comments in this file to understand what the methods must do. The declaration of the Flow class in Flow.java must be

public abstract class Flow implements FlowInterface {

Classes Water and Fire must extend Flow, and so they must implement the update method. You must define the Flow constructor to handle the following Water constructor.

public Water(int nRows, int nColumns, int startR, int startC, double initialAmount) {
    super("Water",0.5,startR,startC,initialAmount, nRows,nColumns, 0.1,0.1,1.0);
    // name, rate_of_flow, starting row and column and initial amount there, total number of rows and columns, and red, green and blue
}

Now for the mechanics. The update method must update the amount, or level, of water or fire at every location in the terrain. Do this be stepping through the two-dimensional array in Flow that holds the amount of water or fire and modify the amount in every 3x3 patch of the array. If that array is named amount, you can do this with

for (int r = 1; r < nRows-1; r++) {
    for (int c = 1; c < nColumns-1; c++) {
        for (int rNear = r-1; rNear < r+2; rNear++) {
            for (int cNear = c-1; cNear < c+2; cNear++) {

                // update amount[rNear][cNear] here

            }
         }
    }
 }

Implement the following algorithms for the flows. The update method receives a two-dimensional array of elevations. For Water, do the following for each 3x3 window centered at [r][c]. Calculate the difference between the elevation plus the amount of water at [r][c] and the elevation plus the amount of water at [rNear][cNear]. If this difference is positive (higher at [r][c]) then move an amount of water from [r][c] to [rNear][cNear] that is equal to the rate_of_flow times this difference, or the rate_of_flow times the actual amount at [r][c], whichever is smaller. "Move" means add it to [rNear][cNear] and subtract if from [r][c]. Also, the first step in the water update method is to add the initialAmount to the initial position, provide in the constructor arguments.

For Fire, the update algorithm is simpler. If there is fire of any amount at [r][c], then spread the fire to [rNear][cNear] if the elevation at [rNear][cNear] is higher or equal to the elevation at [r][c]. Any amount of fire greather than 0 means that position is burning.
Testing

Be sure you test your code. You can test Water and Fire independent of the graphics, by writing main methods in each. Here are some examples, that do not fully test all methods, but that do illustrate update.

// Main method for the Water class
public static void main(String[] args) {

    double[][] elevation = {{10,20,30},{40,50,60},{70,80,90}};

    Water w = new Water(3,3,1,1,10);
    w.debug = true;  // to enable printing of debugging information shown here
    for (int reps = 0; reps < 5; reps++)
        w.update(elevation);
}

// Main method for the Fire class
public static void main(String[] args) {

    double[][] elevation = {{10,20,30},{40,50,60},{70,80,90}};

    Fire f = new Fire(3,3,1,1,1);
    f.debug = true;  // to enable printing of debugging information shown here
    for (int reps = 0; reps < 5; reps++)
        f.update(elevation);
}

And here is example output:

 > javac Water.java
 > java Water
 5.0   2.5   1.3
 0.6   0.6   0.0
 0.0   0.0   0.0

10.3   5.2   2.6
 1.3   0.7   0.0
 0.0   0.0   0.0

15.6   7.8   3.9
 2.0   0.7   0.0
 0.0   0.0   0.0

21.0  10.5   5.2
 2.6   0.7   0.0
 0.0   0.0   0.0

26.3  13.2   6.6
 3.3   0.7   0.0
 0.0   0.0   0.0

 > javac Fire.java
 > java Fire
 0.0   0.0   0.0
 0.0   1.0   1.0
 1.0   1.0   1.0

 0.0   0.0   0.0
 0.0   1.0   1.0
 1.0   1.0   1.0

 0.0   0.0   0.0
 0.0   1.0   1.0
 1.0   1.0   1.0

 0.0   0.0   0.0
 0.0   1.0   1.0
 1.0   1.0   1.0

 0.0   0.0   0.0
 0.0   1.0   1.0
 1.0   1.0   1.0

Here is another example, using a 4 x 4 grid of elevations.

// Water main  :)
 public static void main(String[] args) {

     double[][] elevation = {{10,20,30,40},{40,50,60,70},{70,80,90,100},{100,110,120,130}};

     Water w = new Water(4,4,2,2,10);
     w.debug = true;
     for (int reps = 0; reps < 5; reps++)
         w.update(elevation);
 }

And the result.

 0.0   0.0   0.0   0.0
 0.0   5.0   2.5   1.3
 0.0   0.6   0.6   0.0
 0.0   0.0   0.0   0.0

 2.5   2.5   1.3   0.3
 0.6   5.9   2.9   2.6
 0.0   0.7   0.7   0.0
 0.0   0.0   0.0   0.0

 5.5   5.4   2.7   0.7
 1.3   6.1   2.9   3.9
 0.1   0.7   0.7   0.0
 0.0   0.0   0.0   0.0

 8.5   8.4   4.2   1.0
 2.1   6.1   2.9   5.2
 0.1   0.7   0.7   0.0
 0.0   0.0   0.0   0.0

11.5  11.4   5.7   1.4
 2.8   6.1   2.9   6.6
 0.2   0.7   0.7   0.0
 0.0   0.0   0.0   0.0

By the way, here is how to print a floating point value rounded to one decimal place.

System.out.printf("%5.1f ", 56.28);

Disaster

Now for the full application. With all you have implemented, it doesn't take much. Use this Disaster.java file. It is repeated below:

public class Disaster {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Disaster fortcollins.elevation");
            System.exit(1);
        }
        String filename = args[0];
        Terrain terrain = new Terrain(filename);

        terrain.registerFlow(new Fire(terrain.getNRows(),terrain.getNColumns(),200,400,1));
        terrain.registerFlow(new Water(terrain.getNRows(),terrain.getNColumns(),300,20,10));
    }

Notice that handy method registerFlow that is defined in Terrain.java. Read its implentaion, and all of the methods, in Terrain.java to gain an initial understanding of how to do 3D graphics in Java with JOGL.
Extra Credit

You may earn one to two extra credit points by creating new kinds of flows. Be creative!
Submission

Click on the P5 assignment in Canvas, then the big green "Submit" button. Submit the files

        Flow.java
        Water.java
        Fire.java
        Disaster.java

and any other flows you have created for extra credit.

