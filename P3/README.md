
CS161 P3: Multiple classes, inheritance, ArrayLists, and MUSIC!

Let's have some fun for this assignment, making music with JFugue. Read all about using JFugue by searching the net, or by reading The Complete Guide to JFugue

To install JFugue for use in this assignment, download JFugue 5.0 from the above website or clicking on this link jfugue-5.0.4.jar. To tell Eclipse how to find this jar, go to Project -> Properties, select Java Build Path, select the Libraries tab, and click the Add External JARs… button. Find jfugue-5.0.4.jar and add it to your project.

From the command line, to compile and run P3.java with JFugue, you must use the commands

javac -classpath .:jfugue-5.0.4.jar P3.java
java -classpath .:jfugue-5.0.4.jar P3

Code Requirements

You are going to design a number of classes, meaning multiple Java files, for this assignment. The list of required classes and methods are:

    Orchestra: a group of instruments and methods for dealing with instruments and members of the orchestra and for playing music.
    Member: represents a member of your orchestra
    Instrument: represents an instrument in the orchestra. Four classes extend this one to represent these specific instruments:
        Violin
        Viola
        Cello
        Contrabass

Now the details. Let's start with the Orchestra. This class must contain a collection of instruments as an ArrayList<Instrument> instance variable. Methods that are required are

    public Orchestra(), the no-argument constructor.
    public void addInstrument(Instrument instrument) to add an instrument
    public String toString() that returns a String of instruments
    public String jfugueString() that returns the JFugue string from all instruments that can be played using JFugue
    public ArrayList<String> whoPlays(String instrumentName) returns an ArrayList<String> containing the names of all members that play the instrument given by instrumentName
    public String playedBy(String memberName) returns the name of the instrument played by the member given by memberName

The following method must also be included in Orchestra.

public void play() {
     String jfugueString = jfugueString();
     Player player = new Player();
     player.play(jfugueString);
 }

This method requires Orchestra.java to start with the line

import org.jfugue.player.Player;

The Instrument class must have instance variables to hold a Member, a String of notes, and an int to represent an octave, and it must have at least these methods:

    public Instrument(String notes, int octave, Member member)
    public void setNotes(String s)
    public String getNotes()
    public Member getMember()
    public void setMember(Member m)
    public int getOctave()
    public void setOctave(int o)
    public String toString()

The getNotes() method does not just return the stored notes string. It returns a new String constructed from the stored notes for this instrument, with the following modifications.

The int octave is inserted just after each note. For example, the string "C" for octave 4 becomes "C4", and the string "D#" becomes "D#4". If a note has a duration, like "q" for quarter note, "h" for half note, or "w" for whole note, the string "D#w" becomes "D#4w". It is a little tricky inserting the octave value in the correct position.

Another modification to be made by getNotes() is made to model the errors made by orchestra members. A beginner, at level 1, plays the wrong note 50 percent of the time. An intermediate member, at level 2, plays the wrong note 20 percent of the time. An expert, at level 3, makes no mistakes. You will model this by following this procedure. For each note,

    Draw a random number between 0 and 1.
    If player is a beginner and the random number is greater than 0.5, then replace the note with a random whole note, or a character from "ABCDEFG".
    If player is an intermediate player and the random number is greater than 0.8, then replace the note with a random whole note, or a character from "ABCDEFG".

Each of the classes for the specific instruments, Violin, Viola, Cello and Contrabass, extends the Instrument class. The requirements for these classes is that they implement constructors accepting a String of notes to play and a Member who will play the instrument. Their constructors must explicitly call the super-class constructor with arguments for the notes, the octave, and the member. The octave is an int for the particular instrument:

    octave is 6 for Violin
    octave is 5 for Viola
    octave is 4 for Cello
    octave is 3 for Contrabass

These classes must also implement a String getName() method that returns the name of the instrument, such as "Violin".

The Member class must keep track of the orchestra members name and skill level. Required methods are

    public Member(String name, int level)
    public void setLevel(int level)
    public int getLevel()
    public void setName(String name)
    public String getName()
    public String toString()
    public void practice()

That last method practice() simply increments level. Remember, level can only be 1, 2, or 3.
That JFugue String

The notes from all instruments must be combined into one string to be played. Each instrument is sequentially assigned a voice as they are combined. The first instrument is voice 0, the second one is voice 1, etc. Skip voice 9, because it is reserved for percussion, and we are not using percussion in this assignment. So, other than 9, voice can be 0 through 15.

The instrument name field is used to specify the instrument. If the ArrayList<Instrument> of instruments has a violin added first with notes "C D" and a cello added second with notes "F G", the resulting JFugue String will be "V0 I[Violin] C D V1 I[Cello] F G".
Example

Here is an example of a main method, which could be the sole method in your P3.java file. If one command-line argument is provided, and it is the word "play", then the music is actually played. Be sure to use headphones in the lab or turn the volumn way down. If no command line arguments are given, or you change it to something else, like "noplay", then no sound will be played.

The resulting output is shown after the code.

public static void main(String[] args) {

     boolean play = false;
     if (args.length > 0 && args[0].equals("play"))
         play = true;

     Orchestra duet = new Orchestra();

     Member jim = new Member("Jim",1);
     Member mary = new Member("Mary",1);

     duet.addInstrument(new Violin("C D E F E D Cw", jim));
     duet.addInstrument(new Cello("E F G A G F Ew", mary));

     System.out.println(duet.jfugueString());
     if (play) duet.play();

     System.out.println("Everyone practices.");
     jim.practice();
     mary.practice();
     System.out.println(duet.jfugueString());
     if (play) duet.play();

     System.out.println("Everyone practices again.");
     jim.practice();
     mary.practice();
     System.out.println(duet.jfugueString());
     if (play) duet.play();

     ArrayList<String> violinPlayers = duet.whoPlays("violin");
     System.out.print("Violin players are:");
     for (String who : violinPlayers) {
         System.out.print(" " + who);
     }
     System.out.println();

     String what = duet.playedBy("jim");
     if (what != null)
         System.out.println("Jim plays " + what);
     else
         System.out.println("Jim is not playing.");

 }

Here is the command and the resulting output.

> javac -cp .:jfugue-5.0.4.jar P3.java
> java -cp .:jfugue-5.0.4.jar P3

 V0 I[Violin]  C6 D6 G6 F6 C6 D6 C6w V1 I[Cello]  E4 F4 G4 A4 G4 C4 E4w
Everyone practices.
 V0 I[Violin]  C6 D6 E6 F6 E6 D6 C6w V1 I[Cello]  E4 F4 G4 A4 G4 F4 E4w
Everyone practices again.
 V0 I[Violin]  C6 D6 E6 F6 E6 D6 C6w V1 I[Cello]  E4 F4 G4 A4 G4 F4 E4w
Violin players are: Jim
Jim plays Violin

Submission

Tar your Java files together with a command like

tar cvf P3.tar P3.java Orchestra.java Member.java Instrument.java Violin.java Viola.java Cello.java Contrabass.java

The first arguments to the tar are c for create, v for verbose, and f for file, meaning the next argument is the name of the tar file to be created. You can check the contents of the tar file by doing

tar tf P3.tar

where t is for table of contents, and f is for file again.

Submit P3.tar online checkin system.

