
CS161 Lab Week 13: Linked Lists

Write an application that reads a data file of top-selling books for programmers and stores them in a linked list. Then do several queries on this list.
Linked List and Node Implementation

Implement a general linked list class with a parameterized type for the data item. Here is a start of LinkedList.java:

public class LinkedList<T> {

   _____________________ head;
   protected int size;

   public LinkedList() {
      head = null;
      size = 0;
   }

   public void addToFront(T item) {
      .
      .
      .
   }

   public void addToBack(T item) {
      .
      .
      .
   }


   public void remove(int index) {
      .
      .
      .
   }

   public T get(int index) {
      .
      .
      .
   }

   public void clear() {
      .
      .
      .
   }

   public int size() {
      .
      .
      .
   }

   @Override
   public String toString() {
      String result = "";
      if (head == null)
         return result;
      for (Node<T> p = head; p != null; p = p.getNext()) {
         result += p.getItem() + "\n";
      }
     return result.substring(0,result.length()-1); // remove last \n
   }
}

What is the type of head? It must refer to a Node that contains an instance variable to hold a data item of type T and a next value of type Node<T>. Here is the start of Node.java:

public class Node<T> {

   protected _____ item;
   protected ________  next;

   public Node(_____ item, ________ next) {
      setItem(item);
      setNext(next);
   }

   public Node (T item) {
      this(item,null);
   }

   public void setItem(T i) {
      item = i;
   }

   public ______ getItem() {
      return item;
   }

   public void setNext(_________ n) {
      next = n;
   }

   public ___________ getNext() {
      return next;
   }

   @Override
   public String toString() {
      return item.toString();
   }
}

Fill in the missing pieces in these two files, and test them with main method, either in LinkedList.java or in a new file named something like TestLL.java, that looks like this.

public static void main(String[] args) {
   names.addToFront("AAA");
   names.addToFront("BBB");
   names.addToBack("ZZZ");
   names.addToBack("YYY");
   names.addToFront("humm");
   System.out.println(names);

   System.out.println("size = " + names.size());

   System.out.println("get(2) = " + names.get(2));

   names.remove(2);
   System.out.println("after remove(2) size is " + names.size() + " and list is ");
   System.out.println(names);

   names.remove(1);
   System.out.println("after remove(1) size is " + names.size() + " and list is ");
   System.out.println(names);

   names.remove(0);
   System.out.println("after remove(0) size is " + names.size() + " and list is ");
   System.out.println(names);

   names.clear();
   System.out.println("after clear(), size is " + names.size() + " and list is");
   System.out.println(names);
}

A Single Book

To store books in a linked list, you must first define a new class Book to represent one book. Write Book.java so that each book contains the following information:

        rank as an integer
        title as a string
        authors as a string
        publisher as a string
        year as an integer
        price as a double

Define constructors, get and set methods, and a toString method that returns

String.format("%2d. %s, %s, %s, %d, $%.2f",getRank(),getTitle(),getAuthors(),getPublisher(),getYear(),getPrice());

List of Top-Selling Books

Finally, you can write the main application, in a file named TopSellers.java. The only instance variable required is a variable of type LinkedList<Book> to hold the books. You must implement the methods

        public void remove(int index)
        public Book get(int index)
        public void addToBack(Book b)
        public int size()
        public void clear()
        public String toString()

and you will need this method to read books from a text file:

public void readFromFile(String filename) throws IOException {
    Scanner scanner = new Scanner(new File(filename));
    while (scanner.hasNext()) {
         String[] tokens = scanner.nextLine().split(",");
         books.addToBack(new Book(Integer.parseInt(tokens[0].trim()),
                                  tokens[1].trim(),
                                  tokens[2].trim(),
                                  tokens[3].trim(),
                                  Integer.parseInt(tokens[4].trim()),
                                  Double.parseDouble(tokens[5].trim())));
    }
}

which assumes you have defined the constructor for Book to receive arguments in the order that the values appear in the text file shown here.

1, The Go Programming Language, Donovan and Kernighan, Addison-Wesley, 2015, 37.30
2, HTML and CSS, Duckett, Wiley, 2011, 17.19
3, Automate the Boring Stuff with Python, Sweigart, No Starch Press, 2015, 22.86
4, Data Science from Scratch, Grus, O'Reilly, 2015, 28.51
5, Learn Python in One Day and Learn It Well, Chan, Learn Coding Fast, 2014, 2.99
6, Programming Arduino Getting Started with Sketches, Monk, McGraw-Hill, 2011, 8.92
7, Make: Electronics, Platt, Maker Media, 2015, 23.52
8, JavaScript and JQuery, Duckett, Wiley, 2014, 27.94
9, Clean Code, Martin, Prentice Hall, 2008, 37.66
10, The C Programming Language, Kernighan, Prentice Hall, 1988, 52.89
11, Elements of Programming Interviews, Prakash, CreateSpace, 2012, 35.96

The main method in your TopSellers.java must accept one command-line argument being the name of the above text file. Here is the start of this main method:

public static void main(String[] args) throws IOException {
    if (args.length == 0) {
        System.out.println("Usage: java Books <list of books>");
        System.exit(1);
    }
    String filename = args[0];

    TopSellers topSellers = new TopSellers();
    topSellers.readFromFile(filename);
    .
    .
    .

Now, add code to this main method that performs the following tests and prints the results as shown:

 Read 11 topSellers from topbooks.txt
 1. The Go Programming Language, Donovan and Kernighan, Addison-Wesley, 2015, $37.30
 2. HTML and CSS, Duckett, Wiley, 2011, $17.19
 3. Automate the Boring Stuff with Python, Sweigart, No Starch Press, 2015, $22.86
 4. Data Science from Scratch, Grus, O'Reilly, 2015, $28.51
 5. Learn Python in One Day and Learn It Well, Chan, Learn Coding Fast, 2014, $2.99
 6. Programming Arduino Getting Started with Sketches, Monk, McGraw-Hill, 2011, $8.92
 7. Make: Electronics, Platt, Maker Media, 2015, $23.52
 8. JavaScript and JQuery, Duckett, Wiley, 2014, $27.94
 9. Clean Code, Martin, Prentice Hall, 2008, $37.66
10. The C Programming Language, Kernighan, Prentice Hall, 1988, $52.89
11. Elements of Programming Interviews, Prakash, CreateSpace, 2012, $35.96

topSellers.get(5) returns  6. Programming Arduino Getting Started with Sketches, Monk, McGraw-Hill, 2011, $8.92
After removing index 2, list size is 10 and list is
 1. The Go Programming Language, Donovan and Kernighan, Addison-Wesley, 2015, $37.30
 2. HTML and CSS, Duckett, Wiley, 2011, $17.19
 4. Data Science from Scratch, Grus, O'Reilly, 2015, $28.51
 5. Learn Python in One Day and Learn It Well, Chan, Learn Coding Fast, 2014, $2.99
 6. Programming Arduino Getting Started with Sketches, Monk, McGraw-Hill, 2011, $8.92
 7. Make: Electronics, Platt, Maker Media, 2015, $23.52
 8. JavaScript and JQuery, Duckett, Wiley, 2014, $27.94
 9. Clean Code, Martin, Prentice Hall, 2008, $37.66
10. The C Programming Language, Kernighan, Prentice Hall, 1988, $52.89
11. Elements of Programming Interviews, Prakash, CreateSpace, 2012, $35.96

After adding "Last Book Standing" to end of list
 1. The Go Programming Language, Donovan and Kernighan, Addison-Wesley, 2015, $37.30
 2. HTML and CSS, Duckett, Wiley, 2011, $17.19
 4. Data Science from Scratch, Grus, O'Reilly, 2015, $28.51
 5. Learn Python in One Day and Learn It Well, Chan, Learn Coding Fast, 2014, $2.99
 6. Programming Arduino Getting Started with Sketches, Monk, McGraw-Hill, 2011, $8.92
 7. Make: Electronics, Platt, Maker Media, 2015, $23.52
 8. JavaScript and JQuery, Duckett, Wiley, 2014, $27.94
 9. Clean Code, Martin, Prentice Hall, 2008, $37.66
10. The C Programming Language, Kernighan, Prentice Hall, 1988, $52.89
11. Elements of Programming Interviews, Prakash, CreateSpace, 2012, $35.96
99. Last Book Standing, C. Me, Publishing House, 2015, $0.50

After clearing, size is 0 and here is the list


