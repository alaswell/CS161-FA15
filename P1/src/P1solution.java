// P1 Assignment
// Author: Chuck Anderson
// Date: Sep 10, 2015
// Class: CS161
// Email: alaswell@cs.colostate.edu

import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;

public class P1solution {

    public String[] readWords(String filename) {
	String words[] = new String[1000];
	int nWords = 0;
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
		String[] wordsThisLine = line.trim().replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");  // multiple spaces!!
		// Only deal with this line if it is not a blank line.
		// THIS TEST WAS NOT REQUIRED FOR P1.
		if (wordsThisLine.length > 1 || (wordsThisLine.length == 1 && ! wordsThisLine[0].equals(""))) {
		    int nNewWords = wordsThisLine.length;
		    if (nWords + nNewWords > words.length) {
			//System.out.println("resizing words");
			words = resizeStringArray(words,words.length*2);
		    }
		    for (String word : wordsThisLine)
			words[nWords++] = word;
		}		
	    }
	    scanner.close();
	
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

	return resizeStringArray(words,nWords);
    }

    // Return index in array words where word first appears.
    // Return -1 if it is not found.
    public int findWord(String word, String[] words) {
	for (int i = 0; i < words.length; i++) {
	    if (words[i] == null)
		return -1;
	    if (words[i].equals(word))
		return i;
	}
	return -1;
    }
    
    // Return String array of size newSize that contains all of the elements of oldArray.
    public String[] resizeStringArray(String[] oldArray, int newSize) {
	String[] newArray = new String[newSize];
	int numberToCopy = Math.min(newSize,oldArray.length);
	for (int i = 0; i < numberToCopy; i++)
	    newArray[i] = oldArray[i];
	return newArray;
    }

    // Return String array of all of the words that appear in the array words. In the
    // returned array all words appear only once.
    public String[] unique(String[] words) {
	int nUnique = 0;
	String uniqueWords[] = new String[words.length];
	for (int i = 0; i < words.length; i++) {
	    String word = words[i];
	    int uniqueIndex = findWord(word,uniqueWords);
	    if (uniqueIndex < 0) {
		uniqueWords[nUnique] = word;
		nUnique++;
	    }
	}
	return resizeStringArray(uniqueWords,nUnique);
    }

    //----------------------------------------------------------------------
    // main: A filename must be supplied as a command line argument.
    //----------------------------------------------------------------------
    
    public static void main(String[] args) throws IOException {
		
        P1solution p1 = new P1solution();

	String filename = args[0];
        String[] words = p1.readWords(filename);
	System.out.println("From " + filename + " read " + words.length + " words.");
	System.out.println("  and " + p1.unique(words).length + " unique ones.");

    }
}