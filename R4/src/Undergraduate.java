// R4 Assignment
// Author: alaswell
// Date: Sep 23, 2015
// Class: CS161
// Email: alaswell@cs.colostate.edu

public class Undergraduate extends Student {

	public Undergraduate(Double gpa, String name) {
		super(gpa, name);

	}

	@Override
	public String toString() {
		return name + ", Undergraduate, " + gpa;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
