// Midterm Assignment
// Author: alaswell
// Date: Sep 30, 2015
// Class: CS161
// Email: alaswell@cs.colostate.edu

public class Lunch extends Recipe {

	public Lunch(String recipeName, String recipeSouce, boolean haveCooked) {
		super(recipeName, recipeSouce, haveCooked);
	}

	@Override
	public String toString() {

		String cooked;

		if(getCooked())
			cooked = "Cooked";
		else
			cooked = "Not-Cooked";

		return "Lunch: "  + recipeName + " " + recipeSource + " "  + cooked;
	}

	public static void main(String[] args) {
		Lunch test = new Lunch("PB-Sandwhich", "Interwebs", true);

		// toString() test
		System.out.println("Testing the toString() method now");
		System.out.println(test.toString());

	}

}
