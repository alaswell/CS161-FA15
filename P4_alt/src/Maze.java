import java.io.File;
import java.io.IOException;
import java.util.Scanner;

// P4_alt Assignment
// Author: alaswell
// Date: Oct 14, 2015
// Class: CS161
// Email: alaswell@cs.colostate.edu

public class Maze {
	private int nrows = 0;
	private int ncols = 0;
	private int startRow;
	private int startCol;
	private char[][] map;

	// debug
	private static boolean DEBUG = false;

	public void initializeFromFile(String filename) {
		try {
			Scanner scanner = new Scanner(new File(filename));
			String line;
			int nThings = 0;

			// get the dimensions
			nrows = scanner.nextInt();
			ncols = scanner.nextInt();

			// allocate to char array
			map = new char[nrows][ncols];

			if(DEBUG) {
				System.out.print("nrows = " + nrows + ". ncols = " + ncols + "\n");
				System.out.println("map is: " + map.length);
			}

			// get the rest of the map
			while (scanner.hasNext()) {

				line = scanner.nextLine();

				if(line.equalsIgnoreCase(""))
					continue;

				map[nThings++] = line.toCharArray();
			}

			for(int i = 0; i < map.length; i++)
				for(int j = 0; j < map[i].length; j++) {
					if(map[i][j] == 'S') {
						startRow = i;
						startCol = j;
						if(DEBUG)
							System.out.print("Start Row = " + startRow + " Start Col = " + startCol);
					}
				}	
			scanner.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public String findPathFrom(int row, int col) {

		String path = "";
		
		// BASE CASE(S)
		if(row > nrows || col > ncols)			
			return "";
		
		else if(map[row][col] == '#' || map[row][col] == '.')
			return "";
		
		else if(map[row][col] == 'G')
			return "G";

		// RECURSION
		map[row][col] = '.';

		// Check up
		path = findPathFrom(row-1, col);

		if(path.length() > 0 && path.charAt(path.length() - 1) == 'G')
			return "U" + path; // end up

		// Check right
		path = findPathFrom(row, col+1);

		if(path.length() > 0 && path.charAt(path.length() - 1) == 'G')
			return "R" + path; // end right

		// Check down
		path = findPathFrom(row+1, col);

		if(path.length() > 0 && path.charAt(path.length() - 1) == 'G')
			return "D" + path; // end down

		// Check left
		path = findPathFrom(row, col-1);

		if(path.length() > 0 && path.charAt(path.length() - 1) == 'G')
			return "L" + path; // end left

		map[row][col] = ' ';
		return "";
	}

	// calls findPathFrom(startRow, startCol) and returns what it returns
	// and does anything else that is necessary
	public String findPath() {
		return findPathFrom(startRow, startCol);
	}

	// returns a String representation of the map character array
	public String toString() {
		String finalString = "";		

		// Put the S back
		map[startRow][startCol] = 'S';

		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++)
				finalString += map[i][j];

			finalString += "\n";
		}		
		return finalString;
	}
	
	public static void debug(String[] args) {
		if(args.length > 1 && args[1].equals("-debug")) {
			DEBUG = true;
			System.out.println("-=-=-=-=-=-=-= Debugging enabled =-=-=-=-=-=-=-");
		}
	}


	public static void main(String[] args) {
		
		debug(args);
		
		Maze m = new Maze();

		// get the filename from the command line
		m.initializeFromFile(args[0]);

		// call the appropriate methods
		String s = m.findPath();
		
		// print the resulting map and the solution path
		System.out.println(m.toString() + s);

	}
}