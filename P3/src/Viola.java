// P3 Assignment
// Author: alaswell
// Date: Sep 18, 2015
// Class: CS161
// Email: alaswell@cs.colostate.edu

public class Viola extends Instrument {
	static final int octave = 5;
	static final String name = "Viola";

	public Viola(String string, Member name) {
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
		// TODO Auto-generated method stub

	}

}
