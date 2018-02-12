import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GuinnessBook {

	// Declare an ArrayList for holding Animals.  Name it 'landAnimals'.
	// private ....  

	private ArrayList<Animal> landAnimals;

	public GuinnessBook(String filename) throws FileNotFoundException{

		// Create a new ArrayList for holding Animals
		// landAnimals = ... 

		landAnimals = new ArrayList();

		File animalFile = new File(filename);
		Scanner scan = new Scanner(animalFile);

		while(scan.hasNextLine()){
			// Example lines:
			//  giraffe 32
			//  pronghorn 60
			//  reindeer 32
			String[] animalInfo = scan.nextLine().split(" ");
			String animalName = "";

			for(int i = 0; i < (animalInfo.length-1); i++){
				animalName += animalInfo[i] + " ";
			}
			animalName = animalName.trim();
			Integer topSpeed = Integer.parseInt(animalInfo[animalInfo.length-1]);

			// Insert the animal into the arraylist here, don't change any of the above code
			// landAnimals....	
			landAnimals.add(new Animal(animalName, topSpeed));			
		}
		scan.close();
	}


	// Write a toString method that returns String like
	//   Name: giraffe Top Speed: 32
	//   Name: pronghorn Top Speed: 61

	@Override
	public String toString() {
		String retrunString = "";

		for(int i = 0; i < landAnimals.size(); i++) {
			retrunString += landAnimals.get(i) + "\n";
		}
		// return landAnimals.toString(); also works but gives less control
		return retrunString;
	}

	private void testGuinnessBook() throws FileNotFoundException {

		System.out.println("Is there an animal whose speed is around 70mph?");
		if (landAnimals.contains(new Animal("fast animal",70))) {
			System.out.println(" Yes!  It is " + landAnimals.get(landAnimals.indexOf(new Animal("fast animal", 70))));
		} else {
			System.out.println(" No.");
		}

		System.out.println("Is there an animal whose speed is around 35mph?");
		if (landAnimals.contains(new Animal("slow animal",35))) {
			System.out.println(" Yes!  It is " + landAnimals.get(landAnimals.indexOf(new Animal("slow animal", 35))));
		} else {
			System.out.println(" No.");
		}


		// Print all the animals whose speed is around 50mph.
		// How about a for loop?
		//		for (int i = 0; i < landAnimals.size(); i++){
		//			if(landAnimals.contains(new Animal("fast animal", 50)))
		//				System.out.println(landAnimals.get(i));
		//		}
		for (Animal curAnimal : landAnimals) {
			Animal model = new Animal("model", 50);
			if(model.equals(curAnimal)) {
				System.out.println(curAnimal);
			}
		}

	}

	public static void main(String args[]) throws FileNotFoundException {
		if (args.length == 0) {
			System.out.println("Usage:  java GuinnessBook animals.txt");
			System.exit(0);
		}
		String filename = args[0];
		System.out.println("Reading animals from file " + filename);

		// Uncomment these lines, one at a time to test each part.

		GuinnessBook records = new GuinnessBook(filename);
		System.out.println(records);
		records.testGuinnessBook();
	}

}

