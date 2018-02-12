public interface FlowInterface {

    // Set instance variable for name
    public void setName(String n);

    public String getName();

    // Set flow rate to be used in update
    public void setRate(double r);

    public double getRate();

    // Set location and amount of initial flow value.
    public void setInitialAmount(int startR, int startC, double amount);

    public double getInitialAmount();

    // Set instance variable amount[][] to all zeros
    public void init();

    // Set instance variable(s) for color.
    public void setColor(double r, double g, double b);

    // Get color by filling in provided three-element array.
    public void getColor(float[] returnedColor);

    // Set size of instance variable for two-dimensional amount array.
    // Also set instance variables for number of rows and columns.
    public void setSize(int r, int c);

    // Return reference to two-dimensional array of flow amounts.
    public double[][] getAmount();
    
    // Return string with name of flow, rate, and number of rows and columns.  NO PRINTING HERE.
    public String toString();


    // Abstract method that must be implemented in classes that extend Flow
    public abstract void update(double [][] elevation);

}
