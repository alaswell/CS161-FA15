import java.util.Arrays;

public class Water extends Flow {
	boolean debug = false;

	public Water(int nRows, int nColumns, int startR, int startC, double initialAmount) 
	{
		super("Water", 0.5, startR, startC, initialAmount, nRows, nColumns, 0.1, 0.1, 1.0);
		// name, rate_of_flow, starting row and col and initial amount there, total num rows, and RGB
	}

	public void update(double[][] elevation)
	{
	 	amount = getAmount();
		amount[startR][startC] = this.getInitialAmount();

		for (int r = 1; r < nRows-1; r++)
    			for (int c = 1; c < nColumns-1; c++)
        			for (int rNear = r-1; rNear < r+2; rNear++)
			        	for (int cNear = c-1; cNear < c+2; cNear++) 
					{
						// Do stuffs here 
						double amount1 = elevation[r][c] + amount[r][c];
						double amount2 = elevation[rNear][cNear] + amount[rNear][cNear];
						double diff = amount1 - amount2;

						if(diff > 0)
						{
							amount[rNear][cNear] += (this.getRate()*Math.min(amount[r][c], diff));
							amount[r][c] -= (this.getRate()*Math.min(amount[r][c], diff));
						}
 					}
	}
	
	public static void main(String[] args) 
	{
		double[][] elevation = {{10,20,30},{40,50,60},{70,80,90}};

		Water w = new Water(3,3,1,1,10);
		w.debug = true; 
		for (int reps = 0; reps < 5; reps++)
		{
			System.out.println(Arrays.deepToString(w.getAmount()));
			w.update(elevation);
		}
		System.out.println(w.toString());
	}
}
