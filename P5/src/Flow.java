// Alex Laswell
// CS161 P5
// Chuck Anderson
// 11/11/2015

public abstract class Flow implements FlowInterface {

	// Instance vars
	protected String name;
	protected Double rateOfFlow, initialAmount, red, green, blue;
	protected int startR, startC, nRows, nColumns;
	protected double[][] amount;
	
	// Constructor(s)
	
	public Flow (String name, double rateOfFlow, int startR, int startC, double initialAmount, 
			int nRows, int nColumns, double red, double green, double blue) 
	{
		this.setName(name);
		this.setRate(rateOfFlow);
		this.setInitialAmount(startR, startC, initialAmount);

		this.init();		
		this.setColor(red, green, blue);
		this.setSize(nRows, nColumns);		
	}

	// Set instance variable for the name
	public void setName(String n)
	{
		this.name = n;
	}

	public String getName()
	{
		return name;
	}

	// Set flow rate to be used in update
	public void setRate(double r)
	{
		this.rateOfFlow = r;
	}

	public double getRate()
	{	
		return rateOfFlow;
	}

	// Set location and amount of initial flow value
	public void setInitialAmount(int startR, int startC, double amount) 
	{
		this.startR = startR;
		this.startC = startC;	
		this.initialAmount = amount;
	}

	public double getInitialAmount()
	{
		return initialAmount;		
	}

	// Set instance variable amount[][] to all zeros
	public void init()
	{
		amount = new double[nRows][nColumns];
		for(int i = 0; i < nRows; i++)
			for(int j = 0; j < nColumns; j++)
				amount[i][j] = 0;
	}

	// Set instance variable(s) for color
	public void setColor(double r, double g, double b)
	{
		this.red = r;
		this.green = g;
		this.blue = b;
	}

	public void getColor(float[] returnedColor)
	{
		returnedColor[0] = red.floatValue();
		returnedColor[1] = green.floatValue();
		returnedColor[2] = blue.floatValue();
	}

	// Set size of instance variable for 2D Array of flow amounts
	// Also set instance variables for number of rows and colums
	public void setSize(int r, int c)
	{
		this.amount = new double[r][c];
		this.nRows = r;
		this.nColumns = c;
	}

	// Return reference to 2D Array of flow amounts
	public double[][] getAmount()
	{
		return amount;
	}

	// Return string with name of flow, rate, and number of rows and columns
	public String toString()
	{	
		return "Name: " +  this.getName() + " Rate: " + this.getRate() + " Num Rows: " +  nRows + " Num Columns: " + nColumns;
	}
	

	// Copy over and integer[][] to a double[][]
	// Pre-condition: source array must be square
	public static double[][] copyFromIntArray(int[][] source) 
	{
		int r = source.length;
		int c = source[0].length;

		double[][] returnArray = new double[r][c];
    		for(int i = 0; i < r; i++)
			for(int j = 0; j < c; j++)
				returnArray[i][j] = source[i][j];
		return returnArray;
	}	

	public static void main(String[] args) 
	{
		// Stub main
	}

	// Abstract method that must be implemented in classes that extend Flow
	public abstract void update(double[][] elevation);
}
