// Recursion Assignment
// Author: alaswell
// Date: Oct 7, 2015
// Class: CS161
// Email: alaswell@cs.colostate.edu

public class Recursion {

	// Define methods here

	public static void main(String[] args) {

		Recursion rec = new Recursion();

		System.out.println("sequence1(5) = " + rec.sequence1(5) + ". It should be 16.");
		System.out.println("sequence1(7) = " + rec.sequence1(7) + ". It should be 64.");

		System.out.println("sequence2(4) = " + rec.sequence2(4) + ". It should be 6.");
		System.out.println("sequence2(7) = " + rec.sequence2(7) + ". It should be 37.");

		System.out.println("\"car\" is a palindrome?: " + rec.palindrome("car"));
		System.out.println("\"racecar\" is a palindrome?: " + rec.palindrome("racecar"));
		System.out.println("\"hannah\" is a palindrome?: " + rec.palindrome("hannah"));
		System.out.println("\"banana\" is a palindrome?: " + rec.palindrome("banana") + "\n");

		System.out.println(rec.concatStars(5));
	}

	public String starString(int n) {
		String stars = "";

		if(n == 0)
			return "";
		else
			stars += "*" + starString(n-1);
		
		return stars;
	}
	
	public String concatStars(int n) {
		if(n == 0)
			return "";
		else
			return (starString(n) + "\n" + concatStars(n-1));
			
	}

	public boolean palindrome(String word) {
		if(word.length() == 1 || word.length() == 0)
			return true;

		else if(word.charAt(0) == word.charAt(word.length()-1))
			return palindrome(word.substring(1, word.length()-1));
		
		return false;
	}

	// Pre-Condition: n >= 1
	// Pre-Condition: The sequence is 1 2 4 8 16 32 64 128 ...
	// Post Condition: returns the nth number in a sequence
	// where each element is twice its predecessor
	// starts with 1
	public int sequence1(int n) {

		if(n == 1)
			return 1;
		else
			return 2 * sequence1(n-1);    	
	}

	// Pre-Condition: n >= 1
	// Pre-Condition: The sequence is 1 2 3 6 11 20 37 ...
	// Post Condition: This method returns the nth number in a
	// sequence where each element is the sum of the previous 3,
	// and starts with 1,2,3.
	public int sequence2(int n) {

		if(n < 3)
			return n;
		else {
			return sequence2(n-1) + sequence2(n-2) + sequence2(n-3);
		}	
	}



}