import java.util.ArrayList;

// R4 Assignment
// Author: alaswell
// Date: Sep 23, 2015
// Class: CS161
// Email: alaswell@cs.colostate.edu

public class Person {

	protected String name;

	public Person(String name) {
		setName(name);
	}

	public String getName() {
		return name + ", ";
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if(!(obj instanceof Person))
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name;
	}


}
