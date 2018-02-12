import java.io.File;
import java.io.IOException;
import java.util.Scanner;

// P4 Assignment
// Author: alaswell
// Date: Oct 14, 2015
// Class: CS161
// Email: alaswell@cs.colostate.edu

public class Maze {
	private int nrows = 0;
	private int ncols = 0;
	private static int startRow;
	private static int startCol;
	private char[][] map;
	private static String path = "";

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
				System.out.print("nrows = " + nrows + ". ncols = " + ncols + "\n"); //debug stmt
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
					}
				}	
			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public String findPathFrom(int row, int col) {
		// BASE CASE(S)
		if(row > nrows || col > ncols)
			return "";
		else if(map[row][col] == '#' || map[row][col] == '.')
			return "";
		else if(map[row][col] == 'G') {
			path += "G";
			return "G";
		}

		// RECURSIVE
		map[row][col] = '.';

		if(!(findPathFrom(row-1,col) == ""))
			path = "U" + path;
		else if(!(findPathFrom(row,col+1) == ""))
			path = "R" + path;
		else if(!(findPathFrom(row+1,col) == ""))
			path = "D" + path;
		else if(!(findPathFrom(row,col-1)== ""))
			path = "L" + path;
		else {
			map[row][col] = ' ';
			return "";
		}
		map[startRow][startCol] = 'S';
		return path;
	}

	// calls findPathFrom(startRow, startCol) and returns what it returns
	// and does anything else that is necessary
	public String findPath() {
		return findPathFrom(startRow, startCol);
	}

	// returns a String representation of the map character array
	public String toString() {
		String finalString = "";

		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				finalString += map[i][j];
			}
			finalString += "\n";
		}
		finalString += path;
		return finalString;
	}


	public static void main(String[] args) {
//		if(args[1].equals("-debug")) {
//			DEBUG = true;
//			System.out.println("-=-=-=-=-=-=-= Debugging enabled =-=-=-=-=-=-=-");
//		}

		Maze m = new Maze();
		
		m.initializeFromFile(args[0]);
		
		// call the appropriate methods
		m.findPath();
		
		// print the resulting map and the solution path
		System.out.println(m.toString());

	}
}