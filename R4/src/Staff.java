// R4 Assignment
// Author: alaswell
// Date: Sep 23, 2015
// Class: CS161
// Email: alaswell@cs.colostate.edu

public class Staff extends Person {
	// Instance vars
	protected Double salary;

	public Staff(String name, Double salary) {
		super(name);
		this.setSalary(salary);		
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return name + ", Staff, " + salary;
	}

	public static void main(String[] args) {
		// Stub
	}

}