public class Animal {
	
    private String name;
    private int topSpeed; // mph.  Only allow values from 0 to 70.

    // Consructor that takes a String for the name and an int for the topSpeed
    //  The constructor must call setName and setTopSpeed methods.
    public Animal(String name, int topSpeed) {
		setName(name);
		setTopSpeed(topSpeed);
	}

    // Write an equals(Object other) method that returns True if two Animals
    // top speeds are within 2 mph of each other.

    // Write a toString method that returns Strings like
    // Name: elephant, Top Speed: 25

    //======================================================================
    //  Always include a main to test this code.
    //======================================================================

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(int topSpeed) {
		this.topSpeed = Math.max(0, Math.min(70, topSpeed));
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		result = prime * result + topSpeed;
//		return result;
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;

		if (Math.abs(topSpeed - other.getTopSpeed()) <= 2)
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", Top Speed: " + topSpeed;
	}

	public static void main(String[] args) {

	Animal giraffe = new Animal("giraffe", 90);
	
	System.out.println(giraffe);
	giraffe.setName("giraffe2");
	giraffe.setTopSpeed(9);
	System.out.println(giraffe);
	
	Animal b = new Animal("giraffe", 70);
	
	System.out.println(b);
	System.out.println(giraffe);
	System.out.println(giraffe.equals(b));
	System.out.println(giraffe.equals(giraffe));

    }

	
}

