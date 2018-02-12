import java.util.ArrayList;

// Midterm Assignment
// Author: alaswell
// Date: Sep 30, 2015
// Class: CS161
// Email: alaswell@cs.colostate.edu

public class Recipe {

	protected String recipeName;
	protected String recipeSource;
	protected boolean haveCooked;
	protected ArrayList<String> ingredients;


	public Recipe (String recipeName, String recipeSouce, boolean haveCooked) {
		this.setName(recipeName);
		this.setSource(recipeSouce);
		this.setCooked(haveCooked);

		ingredients = new ArrayList<String>();
	}

	public String getName() {
		return recipeName;
	}

	public void setName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getSource() {
		return recipeSource;
	}

	public void setSource(String recipeSource) {
		this.recipeSource = recipeSource;
	}

	public boolean getCooked() {
		return haveCooked;
	}

	public void setCooked(boolean haveCooked) {
		this.haveCooked = haveCooked;
	}

	public ArrayList<String> getIngredients() {
		return ingredients;
	}

	public void addIngredient(String ingredients) {
		this.ingredients.add(ingredients);
	}	

	@Override
	public String toString() {

		String cooked;

		if(getCooked())
			cooked = "Cooked";
		else
			cooked = "Not-Cooked";

		return "Recipe: "  + recipeName + " " + recipeSource + " "  + cooked;
	}

	public static void main(String[] args) {
		Recipe test = new Recipe("Spaghetti", "Cookbook", true);

		// get/set name test(s)
		System.out.println("The recipe name is: " + test.getName());
		System.out.println("Setting recipe now");
		test.setName("Not Spaghetti");
		System.out.println("NOW, the recipe name is: " + test.getName());
		System.out.println();

		// get/set Source test(s)
		System.out.println("The source name is: " + test.getSource());
		System.out.println("Setting source now");
		test.setSource("Interwebs");
		System.out.println("NOW, the source name is: " + test.getSource());
		System.out.println();

		// get/set Cooked test(s)
		System.out.println("Cooked returns: " + test.getCooked());
		System.out.println("Setting cooked now");
		test.setCooked(false);
		System.out.println("NOW, cooked returns: " + test.getCooked());
		System.out.println();

		// get/add ingredients test(s)
		System.out.println("Ingredients: " + test.getIngredients());
	
		test.addIngredient("Meat");
		test.addIngredient("Noodles");
		test.addIngredient("Sauce");
		System.out.println("Ingredients: " + test.getIngredients());
		System.out.println();
		
		// toString() test
		System.out.println("Testing the toString() method now");
		System.out.println(test.toString());
	}

}
