public class Species {	

    // Put the instance variable here.
	String name;
	int population;
	double yearlyGrowthRate;
	
    // ....

    // Create a Species constructor that takes in a String for its name, an int for
    // its population, and an int for its growth rate per year as a percent.

	public Species (String nameArg, int popArg, double yearlyGrowthRateArg) {
		// Don't let someone initialize a species
		// with a population above 1500 or below 1
		if(popArg >= 1500)
			population = 1500;
		else if(popArg <= 1)
			population = 1;
		else 
			population = popArg;
		
		// Don't let a growth rate outside of the
		// range of 1 to 20 percent
		if(yearlyGrowthRateArg >= 20)
			yearlyGrowthRate = 20;
		else if(yearlyGrowthRateArg <= 1)
			yearlyGrowthRate = 1;
		else 
			yearlyGrowthRate = yearlyGrowthRateArg;
		
		name = nameArg;
	}
    // ....
    
    // mergeSpecies adds the populations of the two species, changes the name
    // of the species to the concatenation of the two names, and the growth
    // rate to the maximum of the two growth rates.

    public void mergeSpecies(Species other) {
        // This method adds the populations of the two species
    	// changes the name of the species to the concatenation of the two names
    	// and the growth rate to the maximum of the two growth rates
    	
    	this.name = name + other.name;
    	this.population += other.population;
    	
    	if(this.yearlyGrowthRate <= other.yearlyGrowthRate)
    		this.yearlyGrowthRate = other.yearlyGrowthRate;    		
    }

    public String toString(){
    	// Example String to return in the toString() method:
    	//
    	// Name of species: cat
    	// Population: 1200
    	// Growth Rate: 12%
    	String s1 = "Name of species: " + name + "\n";
    	String s2 = "Population: " + population + "\n";
    	String s3 = "Growth Rate: " + yearlyGrowthRate + "\n";
    	String s = s1 + s2 + s3;
    	return s;
    }

    // Increases the population according to the growth rate of the species, i.e.
    // updates the population instance variable by adding to it the growth rate/100 times the current population.

    public void grow() {
        // ....
        this.population += (population * (yearlyGrowthRate/100));
    }

    // Returns the population of the species in x years according to its growth rate.

    public int populationInXYears(int x){
        // ....
    	int tempPop = population;
    	for(int i = 0; i < x; i++)
    		tempPop += (tempPop * (yearlyGrowthRate/100));
    	return tempPop;    	
    }

    public static void main(String[] args) {

        // Put simple code here to test the Species class.  It is always a good idea to include
        // a main method in any class you define.

        Species a = new Species("Frog", 100, 10);
        System.out.println(a);

        a.grow();
        System.out.println(a);

        System.out.println("a.populationInXYears(10) returns " + a.populationInXYears(10));

        Species b = new Species("Rabbit", 10, 23);
        a.mergeSpecies(b);
        System.out.println("a.mergeSpecies(b) is " + a);
        
    }
}
