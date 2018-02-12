// P3 Assignment
// Author: alaswell
// Date: Sep 18, 2015
// Class: CS161
// Email: alaswell@cs.colostate.edu

public class Member {
	
	// Instance vars
	private String name;
	private int level;
	
	public Member(String name, int level) {
		this.setName(name);
		this.setLevel(level);		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		if(level > 0 && level <= 3)
			this.level = level;
		else
			System.out.println("Level can only be 1, 2, or 3!");
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public void practice() {
		if(this.level < 3) {
			this.setLevel(this.level++);
			System.out.println("Inside level, level = " + level);
		}
		else
			System.out.println("Already at max level!");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
