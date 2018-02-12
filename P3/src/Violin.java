// P3 Assignment
// Author: alaswell
// Date: Sep 18, 2015
// Class: CS161
// Email: alaswell@cs.colostate.edu

public class Violin extends Instrument {
	static final int octave = 6;
	static final String name = "Violin";

	public Violin(String string, Member name) {
		super(string, octave, name);
	}
	
	String getName() {
		return this.getName();
	}
	
	@Override
	public String toString() {
		return name;
	}

	
	public static void main(String[] args) {
		// stub

	}

}
