
CS161 Lab Week 12: Interfaces for Team Programming

An interface can be used to facilitate team programming. In this recitation, you will work with one or two other people in the room. One of you will be the application programmer, the other one or two will be implementors. Pick your partners.

Imagine the application programmer is writing a Java application that allows the user to control a music player. Your boss has determined how the application and implementations will interace by definining in interface. You can download it at MusicPlayerInterface.java. It is repeated here.

public interface MusicPlayerInterface {
    public void turnOn();
    public void turnOff();
    public boolean isOn();

    public void add(String song);
    public int indexOf(String song);
    public void play(int songIndex);
    public int isPlaying();
}

Implementation Programmer A

Write a new class named MusicPlayerA that implements MusicPlayerInterface. In addition, you will need a constructor.

Use a primitive array of String elements to hold the songs.
Implementation Programmer B

Write a new class named MusicPlayerB that implements MusicPlayerInterface. In addition, you will need a constructor.

Use an ArrayList<String> to hold the songs.
Application Programmer

Write a main method that performs the following steps.

    Initialize an instance variable for the music player to null.

private MusicPlayerInterface musicplayer = null;

    Write the statements that perform these actions.
        Turn on the player.
        Print result of isOn()
        Add at least three songs to the player.
        Print result of using indexOf(song) to search for one of your songs.
        Play a song.
        Print result of isPlaying().
        Play a different song.
        Print result of isPlaying().

You can debug the compilation of your code, before you get java files from your team mates. When you do get their code, add the following steps.
Team Time

Implementation programmers, e-mail your java file to the Application Programmer. The Application programmer can now add the following steps:

    Set musicplayer to an instance of one of the music player classes. If you have two music player implementations, ask the user which one they want to use.

import java.util.Scanner;

Scanner consoleInput = new Scanner(System.in);
System.out.print("Music Player A or B? ");
String answer = consoleInput.next();
if (answer.equalsIgnoreCase("A")) {
   .
   .
   .

    Test run your program, and show the instructor your running code.


