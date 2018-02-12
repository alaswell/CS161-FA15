
CS161 P1: Reading a file of words and finding unique ones.

The objective of this assignment is to refresh your knowledge of how to solve programming problems involving loops, arrays, methods, and files. Come to class lecture sessions to learn many of the details you will need to complete this assignment. This will be true for future assignments, also.

You must define the following methods.

    public String[] readWords(String filename)
        Open the file given as a command line argument.
        Read one line at a time.
        Remove all non-alphabetic characters, convert to lower case, and split on white space.

    String line = scanner.nextLine();
    String[] wordsThisLine = line.trim().replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

        Add the resulting words into an array containing all words in the file.
        Return a String array whose length is exactly the number of words in the file.

    public String[] unique(String[] words)
        Return an array that only contains the unique strings in words, and whose length is exactly the number of unique words.

Test your code with your main method. Here is an example. Create a text file named test.txt that contains the lines

Here are some words on
multiple lines. When you read the file you
should find twenty-two (22) words, but only nineteen
unique words.

When you test your code from the command line you should see

> javac P1.java
> java P1 test.txt
From test.txt I read 22 words and found 19 unique ones.

Bigger Test

Now try your code on something big, like, ummm, let's try The Pickwick Papers, by Charles Dickens! Look for the plain text file at The Gutenberg Project. If you save the text file in a file named PickwickPapers.txt, then you should get this output.

> java P1 PickwickPapers.txt
From PickwickPapers.txt I read 310054 words and found 18244 unique ones.

Submission

Submit your P1.java file via the online checkin system.

