// Midterm Assignment
// Author: alaswell
// Date: Sep 30, 2015
// Class: CS161
// Email: alaswell@cs.colostate.edu

public class Breakfast extends Recipe {

	public Breakfast(String recipeName, String recipeSouce, boolean haveCooked) {
		super(recipeName, recipeSouce, haveCooked);
	}

	@Override
	public String toString() {

		String cooked;

		if(getCooked())
			cooked = "Cooked";
		else
			cooked = "Not-Cooked";

		return "Breakfast: "  + recipeName + " " + recipeSource + " "  + cooked;
	}

	public static void main(String[] args) {
		Breakfast test = new Breakfast("Eggs", "Original", false);

		// toString() test
		System.out.println("Testing the toString() method now");
		System.out.println(test.toString());

	}

}
