import java.util.ArrayList;

// P3 Assignment
// Author: alaswell
// Date: Sep 18, 2015
// Class: CS161
// Email: alaswell@cs.colostate.edu

public class P3 {

	public static void main(String[] args) {

	     boolean play = false;
	     if (args.length > 0 && args[0].equals("play"))
	         play = true;

	     Orchestra q = new Orchestra();

	     Member jim = new Member("Jim",1);
	     Member mary = new Member("Mary",1);
	     Member thom = new Member("Thom",1);
	     Member steve = new Member("Steve",1);

	     q.addInstrument(new Viola("C D E F E D Cw", jim));
	     q.addInstrument(new Contrabass("E F G A G F Ew", mary));
	     q.addInstrument(new Cello("E F G A G F Ew", thom));
	     q.addInstrument(new Violin("E F G A G F Ew", steve));

	     System.out.println(q.jfugueString());
	     if (play) q.play();

	     System.out.println("Everyone practices.");
	     jim.practice();
	     mary.practice();
	     System.out.println(q.jfugueString());
	     if (play) q.play();

	     System.out.println("Everyone practices again.");
	     jim.practice();
	     mary.practice();
	     System.out.println(q.jfugueString());
	     if (play) q.play();

	     ArrayList<String> violinPlayers = q.whoPlays("violin");
	     System.out.print("Violin players are:");
	     for (String who : violinPlayers) {
	         System.out.print(" " + who);
	     }
	     System.out.println();

	     String what = q.playedBy("jim");
	     if (what != null)
	         System.out.println("Jim plays " + what);
	     else
	         System.out.println("Jim is not playing.");

	 }

}
