
public class Disaster
{

	public static void main(String[] args) 
	{
		if(args.length == 0)
		{
			System.out.println("Usage: java Disaster forcollins.elevation");
			System.exit(1);
		}
		String filename = args[0];
		Terrain terrain = new Terrain(filename);
		
		terrain.registerFlow(new Fire(terrain.getNRows(),terrain.getNColumns(),200,400,1));	
		terrain.registerFlow(new Water(terrain.getNRows(), terrain.getNColumns(), 300, 20, 10));
		terrain.registerFlow(new Tornado(terrain.getNRows(), terrain.getNColumns(), 200, 240, 10));
		terrain.registerFlow(new Tornado(terrain.getNRows(), terrain.getNColumns(), 300, 240, 10));
	}
}

