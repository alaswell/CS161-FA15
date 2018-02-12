import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

// P1 Assignment
// Author: alaswell
// Date: Sep 3, 2015
// Class: CS161
// Email: alaswell@cs.colostate.edu

public class P1 {

	// Instance variables
	static String[] allWordsInFile = new String[10];

	public String[] unique(String[] words) {
		int length = words.length;
		int count = 0;
		String[] temp = new String[length];
		
		for(int i = 0; i < length; i++) {
			boolean match = false;
			for(int j = 0; j <= i; j++) {
				if(words[i].equals(temp[j])) {
					match = true;
					break;
				}
			}
			if(!match)
				temp[count++] = words[i];
		}
		temp = trimStringArray(temp);
		return temp;
	}
	
	public String[] readWords(String filename) { 
		Scanner infile;
		int count = 0;

		try {
			infile = new Scanner(new File(filename));


			while(infile.hasNextLine())
			{
				String line = infile.nextLine();
				String[] wordsThisLine = line.trim().replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
				if((count + wordsThisLine.length) >= allWordsInFile.length)
					allWordsInFile = resizeStringArray(allWordsInFile);
				for(int i = 0; i < wordsThisLine.length; i++) {
					allWordsInFile[count++] = wordsThisLine[i];
				}

			}
			infile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		allWordsInFile = trimStringArray(allWordsInFile);
		return allWordsInFile;
	}

	public String[] resizeStringArray(String[] someArray) {
		String[] temp = new String[someArray.length*2];
		for(int i = 0; i < someArray.length; i++)
			temp[i] = someArray[i];
		someArray = temp;		
		return someArray;
	}

	public String[] trimStringArray(String[] someArray) {
		String[] temp;
		int count = 0;

		// Count actual strings
		for(int i = 0; i < someArray.length; i++)
			if(someArray[i] != null)
				count++;

		// Now make a new String[] that length and copy 
		temp = new String[count];
		for(int i = 0; i < count; i++)
			temp[i] = someArray[i];
		return temp;
	}

	public static void main(String[] args) {
		P1 test = new P1();
		System.out.println(test.readWords(args[0]).length);
		String[] t1 = test.unique(allWordsInFile);		
		System.out.println(Arrays.toString(t1));
		System.out.println(t1.length);
	}

}
