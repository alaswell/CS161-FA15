import java.util.Arrays;

public class Tornado extends Flow {
	boolean debug = false;

	public Tornado(int nRows, int nColumns, int startR, int startC, double initialAmount) 
	{
		super("Tornado", 0.5, startR, startC, initialAmount, nRows, nColumns, 1.0, 1.0, 0.0);
		// name, rate_of_flow, starting row and col and initial amount there, total num rows, and RGB
	}

	public void update(double[][] elevation)
	{
	 	amount = getAmount();
		amount[startR][startC] = 1;

		for (int r = 1; r < nRows-1; r++)
    			for (int c = 1; c < nColumns-1; c++)
        			for (int rNear = r-1; rNear < r+2; rNear++)
			        	for (int cNear = c-1; cNear < c+2; cNear++) 
					{
						// Do stuffs here 
						if(amount[r][c] > 0)
							if(elevation[rNear][cNear] < elevation[r][c]) 
								amount[rNear][cNear] = 1;
 					}
	}
	
	public static void main(String[] args) 
	{
		double[][] elevation = {{10,20,30},{40,50,60},{70,80,90}};

		Tornado t = new Tornado(3,3,1,1,1);
		t.debug = true; 
		for (int reps = 0; reps < 5; reps++)
		{
			System.out.println(Arrays.deepToString(t.getAmount()));
			t.update(elevation);
		}	
	}
}

