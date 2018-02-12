// P2 Assignment
// Author: alaswell
// Date: Sep 10, 2015
// Class: CS161
// Email: alaswell@cs.colostate.edu

import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class P2 {

	public String[] findMostFrequentWords(String[] words, int nMost) {

		String[] uniqueWords = new String[words.length];
		String[] nMostFrequentWords; 
		int[] numTimesAppearing;
		int count;

		uniqueWords = unique(words);
		numTimesAppearing = new int[uniqueWords.length]; // mirrors uniqueWords index

		// Get the number of times each unique word appears
		for(int i = 0; i < uniqueWords.length; i++) {
			count = 0;
			for(int j = 0; j < words.length; j++) {
				if(uniqueWords[i].equals(words[j]))
					count++;
			}
			numTimesAppearing[i] = count;
		}

		if(nMost < uniqueWords.length)
			nMostFrequentWords = new String[nMost];
		else
			nMostFrequentWords = new String[uniqueWords.length];

		for(int i = 0; i < nMostFrequentWords.length; i++) {
			int maxValue = 0;
			int index = 0;
			for(int j = 0; j < numTimesAppearing.length; j++) {
				if(numTimesAppearing[j] > maxValue) {
					maxValue = numTimesAppearing[j];
					index = j;
				}
			}
			nMostFrequentWords[i] = uniqueWords[index];
			numTimesAppearing[index] = 0;
		}
		return nMostFrequentWords;
	}

	public int numberInCommon(String[] most1, String[] most2) {
		int count = 0;

		for(int i = 0; i < most1.length; i++) 
			for(int j = 0; j < most2.length; j++) {
				if(most1[i].equals(most2[j])) {
					count++;
				}
			}
		return count;
	}

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

	// Command line arguments are assumed to be:
	//  number of most frequently occurring words to keep from each document
	//  sequence of file names to be compared.
	// Example:
	// java P2 100 Omoo-Melville.txt Moby-Dick-Melville.txt A-Tale-of-Two-Cities-Dickens.txt Oliver-Twist-Dickens.txt

	public static void main(String[] args) throws IOException {

		P2 p2 = new P2();
		// Get number of most frequent words to keep from first command line argument.
		int nMostFreqToKeep = Integer.parseInt(args[0]);

		// Copy all filenames given as second, third, etc. command line
		// arguments into String array filenames.
		String[] filenames = new String[args.length-1];
		for (int i = 0; i < args.length-1; i++)
			filenames[i] = args[i+1];

		// Define array of String arrays to hold the most frequent words
		// from each file.
		String[][] mostFrequentWords =  new String[filenames.length][];

		// Find the top most frequent words in each file and save in the
		// mostFrequentWords array of String arrays.
		for (int i = 0; i < filenames.length; i++) {
			String[] words = p2.readWords(filenames[i]);
			mostFrequentWords[i] = p2.findMostFrequentWords(words,nMostFreqToKeep);
			System.out.println(filenames[i] + " has " + words.length + " words.");
		}

		// Compare all pairs of files by counting number of top most frequent
		// words they have in common.
		System.out.println("Number of most-frequent words in common:");
		for (int i = 0; i < filenames.length; i++) {
			for (int j = i; j < filenames.length; j++) {
				System.out.println(p2.numberInCommon(mostFrequentWords[i],mostFrequentWords[j]) + "\t" + filenames[i] + "\t\t" +  filenames[j]);
			}
		}
	}
}