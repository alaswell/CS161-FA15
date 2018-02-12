// R11 Assignment
// Author: alaswell
// Date: Nov 4, 2015
// Class: CS161
// Email: alaswell@cs.colostate.edu

public abstract class Employee {	
	// Instance vars
	protected String name;
	protected int idNum;
	
	public Employee (String name, int idNum) {
		this.setName(name);
		this.setIdNum(idNum);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getIdNum() {
		return idNum;
	}

	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}

	public abstract int work();
	
}
