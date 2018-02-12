// Alex Laswell
// CS161
// Program 6
// Email: alaswell@cs.colostate.edu

import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class UFOSitings extends UFO {
	private LinkedList<UFO> ufolist = new LinkedList<UFO>();

	public UFOSitings(String filename)
	{
		try 
		{
			Scanner infile = new Scanner(new File(filename));
			while(infile.hasNext())
			{
				String[] tokens = infile.nextLine().split("\t");	
				//System.out.println(tokens.size());	

				ufolist.addFirst(new UFO(tokens[0].trim(), tokens[1].trim(), 
					tokens[2].trim(), tokens[3].trim(), 
					tokens[4].trim(), tokens[5].trim()));

			}
			infile.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			System.exit(0);
		}				
	}

	public void sort()
	{
		ufolist.sort();
	}
	
	public String toString()
	{
		return ufolist.toString();
	}
	
	public static void main(String[] args)
	{
		if(args.length == 0)
		{
			System.out.println("Usage: java UFOSitings <ufositings.file>");
			System.exit(1);
		}
		String filename = args[0];	

		UFOSitings ufos = null;
		ufos = new UFOSitings(filename);

		ufos.sort();
		
		System.out.println("After Sorting:");
		System.out.println(ufos);
	}
}
