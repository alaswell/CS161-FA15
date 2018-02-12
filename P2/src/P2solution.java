import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;

public class P2solution {

    public static boolean debug = true;
    
    public String[] readWords(String filename) {
	String words[] = new String[1000];
	int nWords = 0;
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
		if (debug)
		    System.out.println("From file " + filename + " read line \"" + line + "\"");
		String[] wordsThisLine = line.trim().replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");  // multiple spaces!!
		// Only deal with this line if it is not a blank line.
		if (wordsThisLine.length > 1 || (wordsThisLine.length == 1 && ! wordsThisLine[0].equals(""))) {
		    if (debug)
			System.out.println(" Split into these words: " + Arrays.toString(wordsThisLine));
		    int nNewWords = wordsThisLine.length;
		    if (nWords + nNewWords > words.length) {
			words = resizeStringArray(words,words.length*2);
		    }
		    for (String word : wordsThisLine)
			words[nWords++] = word;
		    if (debug)
			System.out.println("Have now read " + nWords + " words.");
		}		
	    }
	    scanner.close();
	
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

	return resizeStringArray(words,nWords);
    }

    public int findWord(String word, String[] words) {
	if (debug)
	    System.out.println("Searching for \"" + word + "\"");
	for (int i = 0; i < words.length; i++) {
	    if (words[i] == null) {
		if (debug)
		    System.out.println(" Did not find it.");
		return -1;
	    }
	    if (words[i].equals(word)) {
		if (debug)
		    System.out.println(" Found it at index " + i);
		return i;
	    }
	}
	return -1;
    }
    
    public String[] resizeStringArray(String[] oldArray, int newSize) {
	if (debug)
	    System.out.println("Resizing array of size " + oldArray.length + " to new length of " + newSize);
	String[] newArray = new String[newSize];
	int numberToCopy = Math.min(newSize,oldArray.length);
	for (int i = 0; i < numberToCopy; i++)
	    newArray[i] = oldArray[i];
	return newArray;
    }

    public String[] unique(String[] words) {
	if (debug)
	    System.out.println("Finding unique words");
	int nUnique = 0;
	String uniqueWords[] = new String[words.length];
	for (int i = 0; i < words.length; i++) {
	    String word = words[i];
	    int uniqueIndex = findWord(word,uniqueWords);
	    if (uniqueIndex < 0) {
		uniqueWords[nUnique] = word;
		nUnique++;
		if (debug)
		    System.out.println(" \"" + word + "\" is new unique word. Now have " + nUnique + " words.");
	    }
	}
	return resizeStringArray(uniqueWords,nUnique);
    }

    public String[] findMostFrequentWords(String[] words, int nMost) {
	// Return top n most frequent.
	if (debug)
	    System.out.println("Finding " + nMost + " most frequent words.");
	String[] uniqueWords = unique(words);
	int nUnique = uniqueWords.length;
	int[] counts = new int[nUnique];
	if (debug)
	    System.out.println(" Counting times each word appears.");
	for (int i = 0; i < nUnique; i++) {
	    String w = uniqueWords[i];
	    for (int j = 0; j < words.length; j++)
		if (w.equals(words[j]))
		    counts[i]++;
	}
	if (nMost > nUnique) {
	    if (debug)
		System.out.println(" nMost (" + nMost + ") is larger than nUnique (" + nUnique + ") so changing nMost to " + nUnique);
	    nMost = nUnique;
	    
	}
	String[] mostFrequent = new String[nMost];

	for (int i = 0; i < nMost; i++) {
	    int maxCount = 0;
	    int maxi = 0;
	    for (int u = 0; u < nUnique; u++) {
		if (counts[u] > maxCount) {
		    maxCount = counts[u];
		    maxi = u;
		}
	    }
	    if (debug)
		System.out.println(" Next most frequent word, with count of " + maxCount + " is \"" + uniqueWords[maxi] + "\" at index " + maxi);
	    mostFrequent[i] = uniqueWords[maxi];
	    counts[maxi] = 0;
	}
	return mostFrequent;
    }
					 
    public int numberInCommon(String[] most1, String[] most2) {
	if (debug)
	    System.out.println("Counting number of most frequent words that two documents have in common.");
	int skip = 0;
	int count = 0;
	for (int i = skip; i < most1.length; i++) {
	    for (int j = skip; j < most2.length; j++) {
		if (most1[i].equals(most2[j])) {
		    count++;
		    if (debug)
			System.out.println(" Found word \"" + most1[i] + "\" at positions " + i + " and " + j + ". Number in common is now " + count);
		}
	    }
	}
	return count;
    }

    // Command line arguments are assumed to be:
    //    number of most frequently occurring words to keep from each document
    //    sequence of file names to be compared.
    // Example:
    //   java P2 100 Omoo-Melville.txt Moby-Dick-Melville.txt A-Tale-of-Two-Cities-Dickens.txt Oliver-Twist-Dickens.txt
    
    public static void main(String[] args) throws IOException {
		
	if (args.length < 2) {
	    System.out.println("Usage: java P2 number-of-most-frequent-words filename1 filename2 ...\n" +
			       " java P2 100 a.txt b.txt c.txt d.txt\n" +
			       " java P2 100 ?.txt\n" +
			       " java P2 100 A-Tale-of-Two-Cities-Dickens.txt Oliver-Twist-Dickens.txt Moby-Dick-Melville.txt Omoo-Melville.txt");
	    System.exit(0);
	}

        P2solution p2 = new P2solution();
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
