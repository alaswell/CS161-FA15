import java.util.ArrayList;

// R11 Assignment
// Author: alaswell
// Date: Nov 4, 2015
// Class: CS161
// Email: alaswell@cs.colostate.edu

public class Project {
	// Instance vars
	protected int linesOfCode = 0;
	protected int linesOfCodeWritten;
	protected int linesOfCodeTested = 0;
	protected int duration = 0; 
	protected ArrayList<Employee> employees = new ArrayList<Employee>();

	public Project(int linesOfCode, int duration) {
		this.setLinesOfCode(linesOfCode);
		this.setDuration(duration);
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getLinesOfCode() {
		return linesOfCode;
	}

	public void setLinesOfCode(int linesOfCode) {
		this.linesOfCode = linesOfCode;
	}

	public void addEmployee(Employee e) {
		employees.add(e);
	}

	public int doProject() {

		int days = 0;
		linesOfCodeWritten = 0;
		linesOfCodeTested = 0;

		do {
			for(int i = 0; i < employees.size(); i++) {
				if(employees.get(i).getClass().equals(Programmer.class)) 
					linesOfCodeWritten += employees.get(i).work();
				else
					linesOfCodeTested += employees.get(i).work();
			}
			days++;
		}
		while(linesOfCodeWritten <= linesOfCode);

		return (days - duration);
	}

	public static void main(String args[]){
		int num = 0;

		Project P11 = new Project(10000, 10);
		P11.addEmployee(new Programmer("Steve", 01, 1000));
		P11.addEmployee(new Programmer("Alex", 02, 700));
		P11.addEmployee(new Tester("Jon", 03, 200));
		P11.addEmployee(new Programmer("Mary", 04, 250));

		num = P11.doProject();

		if(num > 0)
			System.out.println("Project took " + num + " days longer than expected");
		else if(num < 0)
			System.out.println("Prject completed " + num + " days ahead of schedule!!");
		else
			System.out.println("Project completed in exactly the expected amount of time");

	}

}
