import java.util.Random;

// R11 Assignment
// Author: alaswell
// Date: Nov 4, 2015
// Class: CS161
// Email: alaswell@cs.colostate.edu

public class Tester extends Employee {
	// Instance vars
	protected int linesOfCodeTestedPerDay = 0;

	public Tester(String name, int idNum, int linesPerDay) {
		super(name, idNum);
		this.setLinesOfCodePerDay(linesPerDay);
	}

	public void setLinesOfCodePerDay(int linesPerDay) {
		this.linesOfCodeTestedPerDay = linesPerDay;
	}

	public int getLinesOfCodePerDay() {
		return linesOfCodeTestedPerDay;
	}

	public int work() {
		int randomNum = 0;
		
		// Need a random number
		Random r = new Random();
		randomNum = r.nextInt((125-75)+75);

		return linesOfCodeTestedPerDay*(randomNum/100);		
	}
}
