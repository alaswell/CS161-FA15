// R4 Assignment
// Author: alaswell
// Date: Sep 23, 2015
// Class: CS161
// Email: alaswell@cs.colostate.edu

public class Student extends Person {

	protected Double gpa;
	
	public Student(Double gpa, String name) {
		super(name);
		this.setGpa(gpa);
	}
	
	public Double getGpa() {
		return gpa;
	}

	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	}
