import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class R1 {

	// BEGIN PART 1

	/**
	 * Test if x is divisible by 3
	 * @param x integer to test
	 * @return true if x is divisible by 3
	 */
	public boolean isDivisibleBy3(int x)
	{
		if(x%3 == 0)
			return true;
		else 
			return false;
	}

	/**
	 * Test if x is divisible by 5
	 * @param x integer to test
	 * @return true if x is divisible by 5
	 */
	public boolean isDivisibleBy5(int x)
	{
		if(x%5 == 0)
			return true;
		else 
			return false;
	}

	/**
	 * Use helper functions isDivisibleBy3() and isDivisibleBy5() to implement.
	 *
	 * @param x integer to see if it divisible by 3, 5, or both
	 * @return "is divisible by 3" if x is divisible by 3, "is divisible by 5" if divisible by 5,
	 *          or "is divisible by 3 and 5" if divisible by 3 and 5
	 */

	public String testDivisors(int x)
	{		
		if(isDivisibleBy3(x) && isDivisibleBy5(x))
			System.out.print("is divisible by 3 and 5");
		else if(isDivisibleBy5(x))
			System.out.print("is divisible by 5");
		else if(isDivisibleBy3(x))
			System.out.print("is divisible by 3");
		return "";
	}

	/**
	 * Print i and the result of testDivisors for all i such that first <= i <= last
	 *
	 * Example:
	 * 1
	 * 2
	 * 3 "is divisible by 3"
	 * 4
	 * 5 "is divisible by 5"
	 * ...
	 * 15 "is divisible by 3 and 5"
	 *
	 * @param first integer to start the test range, inclusive
	 * @param last integer to end the test range, inclusive
	 */

	public void testRange(int first, int last)
	{
		for(int i = first; i <= last; ++i)
		{
			//print the number
			System.out.print(i + " ");
			testDivisors(i);
			System.out.println();
		}
	}

	// END PART 1


	// BEGIN PART 2

	/**
	 * Extract all positive integers from the intArray.
	 * Returned array is exactly as long as the number of positive integers in values.
	 * @param intArray containing all the numbers
	 * @return array containing all of the positive integers in values.
	 */

	public int[] extractPositives(int[] intArray)
	{
		int length = intArray.length;
		int index = 0;
		int[] temp = new int[length];


		for(int i = 0; i < length; ++i)
		{
			if(intArray[i] >= 0 )
				temp[index++] = intArray[i];
		}

		int[] result = new int[index]; 
		for(int i = 0; i < index; ++i)
		{
			result[i] = temp[i];
		}

		return result;
	}

	// END PART 2


	// BEGIN PART 3

	/**
	 * Read in data from a file, print out the data in the specified format -
	 *    "Name: *name*, Age:*age*" and then print out all of the names in a row.
	 *
	 * @param filename string
	 * @throws FileNotFoundException 
	 */
	public void readAndPrint(String filename)
	{
		Scanner ifile;
		
		try {
			ifile = new Scanner(new File(filename));

			String[] names = new String[10];
			int index = 0;

			while(ifile.hasNext())
			{
				String name = ifile.next();
				int age = ifile.nextInt();
				System.out.printf("Name: %s, Age: %d%n", name, age);
				names[index++] = name;
			}
			ifile.close();
			
			// Print the names - need some array juggling for this
			String[] temp = new String[index];
			for(int i = 0; i < index; ++i)
				temp[i] = names[i];
			names = temp;
			System.out.println(Arrays.toString(names));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


	// END PART 3



	public static void main(String[] args)
	{
		R1 lab = new R1();
		Scanner infile = new Scanner(System.in);
		int first, last;

		System.out.println();

		// Get the ranges 
		System.out.println("Please enter the min value:");
		first = infile.nextInt();

		// Get the ranges 
		System.out.println("Please enter the max value:");
		last = infile.nextInt();

		// Do stuffs
		lab.testRange(first, last);

		// Part 2
		int[] values = {-1, 0, 3, -5, 6 };
		System.out.println(Arrays.toString(lab.extractPositives(values)));

		//Use the same command line arguments as a data source
		lab.readAndPrint(args[0]);

		infile.close();
	}

}