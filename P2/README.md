
CS161 P2: Comparing documents by comparing arrays of most common words in each.

Search engines, like Google's, use counts of words in documents to characterize a document's contents. (See Tf-Idf and Cosine Similarity for a nice introduction to related methods, beyond what we are doing in this assignment.) In this assignment you will count the number of times each word appears in a document and identify the n words that appear the most often. You will then compare two documents by counting the number of words that appear in both documents' most-frequent word arrays.
Code Requirements

To accomplish this, you will modify your solution to P1, or the solution provided by the instructor. You are required to add at least the following methods.

    public String[] findMostFrequentWords(String[] words, int nMost)
        Accept the String array of all of the words read from a file.
        Call your unique method to obtain an array of unique words.
        Count the number of times each unique word appears in your words array.
        Create a new String array of nMost elements, or the length of your unique words array, whichever is smaller.
        Fill the new array with the nMost words that occur most often.
        Return this new array.

By calling this method on the array of words for each of two documents, the similarty of the two documents can be estimated by the number of most frequent words that the two documents have in common. Write the following method to calculcate this.

    public int numberInCommon(String[] most1, String[] most2)
        Count and return the number of words that appear in both most1 and most2.

Test your code with your main method that requires four command
    line arguments that are the names of four text files to be compared. Here are four files, a.txt, b.txt, c.txt, d.txt, containing the following text.

This is the a.txt file.  It contains colors, like blue,
red, green, orange, and yellow.

File b.txt is all about watercolor paints, such as indigo blue,
sun yellow, pale green and deep red.

In c.txt you can read about the care and feeding of cats. Yellow cats like dry food and to be
brushed.  Others prefer gravy and do not want to be touched.

File d.txt hos nothing about animals or colors.  It just mentions java, python, scala and
other programming languages.

When you test your code from the command line you should see

> javac P2.java
> java P2 20 ?.txt
a.txt has 15 words.
b.txt has 18 words.
c.txt has 31 words.
d.txt has 18 words.
Number of most-frequent words in common:
15   a.txt           a.txt
7    a.txt           b.txt
4    a.txt           c.txt
4    a.txt           d.txt
18   b.txt           b.txt
3    b.txt           c.txt
3    b.txt           d.txt
20   c.txt           c.txt
2    c.txt           d.txt
18   d.txt           d.txt

This shows that a.txt and b.txt are most similar.
Bigger Test

Now try your code on something big, like, ummm, let's try these

    Omoo-Melville.txt
    Moby-Dick-Melville.txt
    Oliver-Twist-Dickens.txt
    A-Tale-of-Two-Cities-Dickens.txt

> java P2 200 Omoo-Melville.txt Moby-Dick-Melville.txt Oliver-Twist-Dickens.txt A-Tale-of-Two-Cities-Dickens.txt
Omoo-Melville.txt has 104713 words.
Moby-Dick-Melville.txt has 214139 words.
Oliver-Twist-Dickens.txt has 160959 words.
A-Tale-of-Two-Cities-Dickens.txt has 138815 words.
Number of most-frequent words in common:
200  Omoo-Melville.txt               Omoo-Melville.txt
155  Omoo-Melville.txt               Moby-Dick-Melville.txt
136  Omoo-Melville.txt               Oliver-Twist-Dickens.txt
141  Omoo-Melville.txt               A-Tale-of-Two-Cities-Dickens.txt
200  Moby-Dick-Melville.txt          Moby-Dick-Melville.txt
142  Moby-Dick-Melville.txt          Oliver-Twist-Dickens.txt
146  Moby-Dick-Melville.txt          A-Tale-of-Two-Cities-Dickens.txt
200  Oliver-Twist-Dickens.txt                Oliver-Twist-Dickens.txt
157  Oliver-Twist-Dickens.txt                A-Tale-of-Two-Cities-Dickens.txt
200  A-Tale-of-Two-Cities-Dickens.txt                A-Tale-of-Two-Cities-Dickens.txt

These results show that the two books by Dickens are most similar, and the two by Melville are most similar. It also shows that books are most similar to themselves. Duh.
A Gift: The main method

Here is code for the main method you must include in the solution you check-in. Read it over carefully and make sure you fully understand what it is doing.

// Command line arguments are assumed to be:
//    number of most frequently occurring words to keep from each document
//    sequence of file names to be compared.
// Example:
//   java P2 100 Omoo-Melville.txt Moby-Dick-Melville.txt A-Tale-of-Two-Cities-Dickens.txt Oliver-Twist-Dickens.txt

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

Submission

Submit your P2.java file via the online checkin system.

