import java.util.Random;

// R11 Assignment
// Author: alaswell
// Date: Nov 4, 2015
// Class: CS161
// Email: alaswell@cs.colostate.edu

public class Programmer extends Employee {
	// Instance vars
	protected int linesOfCodePerDay = 0;

	public Programmer(String name, int idNum, int linesPerDay) {
		super(name, idNum);
		this.setLinesOfCodePerDay(linesPerDay);
	}

	public void setLinesOfCodePerDay(int linesPerDay) {
		this.linesOfCodePerDay = linesPerDay;
	}

	public int getLinesOfCodePerDay() {
		return linesOfCodePerDay;
	}

	public int work() {
		int randomNum = 0;
		
		// Need a random number
		Random r = new Random();
		randomNum = r.nextInt((150-50)+50);

		return linesOfCodePerDay*(randomNum/100);		
	}
}
