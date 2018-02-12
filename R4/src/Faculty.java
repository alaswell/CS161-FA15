// R4 Assignment
// Author: alaswell
// Date: Sep 23, 2015
// Class: CS161
// Email: alaswell@cs.colostate.edu

public class Faculty extends Person {

	protected Double salary;
	
	public Faculty(String name, Double salary) {
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
		return name + ", Faculty, " + salary;
	}

	public static void main(String[] args) {
		// Stub
	}

}
