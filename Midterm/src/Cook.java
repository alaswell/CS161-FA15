import java.util.ArrayList;

// Midterm Assignment
// Author: alaswell
// Date: Sep 30, 2015
// Class: CS161
// Email: alaswell@cs.colostate.edu

public class Cook {

	protected ArrayList<Recipe> cookbook;

	public Cook() {
		cookbook = new ArrayList<Recipe>();
	}

	public void addRecipe(Recipe recipe) {
		cookbook.add(recipe);
	}
	
	@Override
	public String toString() {
		String s = "";
		
		for(int i = 0; i < cookbook.size(); i++)
			s += cookbook.get(i).toString() + "/n";
		return s;
	}
	
	public static void main(String[] args) {
		
		Cook test = new Cook();
		
		Lunch Salad = new Lunch("Salad", "Martha Stewart Cookbook", false);
		Salad.addIngredient("lettuce");
		Salad.addIngredient("tomatoes");
		test.addRecipe(Salad);
		
		Dinner BaconPotato = new Dinner("Bacon-Potato", "Eatin Cheap Book", true);
		BaconPotato.addIngredient("potatoes");
		BaconPotato.addIngredient("bacon");
		BaconPotato.addIngredient("onions");
		test.addRecipe(BaconPotato);
		
		Breakfast Pancakes = new Breakfast("Pancakes", "Moosewood Cookbook", false);
		Pancakes.addIngredient("flour");
		Pancakes.addIngredient("eggs");
		Pancakes.addIngredient("butter");
		Pancakes.addIngredient("maple syrup");
		test.addRecipe(Pancakes);
		
		Dinner Pizza = new Dinner("Pizza", "Dominoes", false);
		Pizza.addIngredient("telephone");
		Pizza.addIngredient("dollars");
		test.addRecipe(Pizza);
		
		System.out.println(test.cookbook.toString());
		
		// Make a BreakFast recipe using the info in Bacon-Potato
		// getters ONLY
		Breakfast BreakFast = new Breakfast(BaconPotato.getName(), BaconPotato.getSource(), BaconPotato.getCooked());
		
		for(int i = 0; i < BaconPotato.getIngredients().size(); i++) 
			BreakFast.addIngredient(BaconPotato.getIngredients().get(i));
		test.addRecipe(BreakFast);
		
		// 4. Print the recipes again
		System.out.println(test.cookbook.toString());
		
	}

}
