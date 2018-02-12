import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// R4 Assignment
// Author: alaswell
// Date: Sep 23, 2015
// Class: CS161
// Email: alaswell@cs.colostate.edu

public class Lab5 {
	public ArrayList<Person> people = new ArrayList<Person>();

	public void readFromFile(String filename) {
		File file = new File(filename);
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] tokens = line.trim().split(",");
				String name = tokens[0];
				String role = tokens[1];
				String level = tokens[2];
				String gpa = tokens[3];
				String salary = tokens[4];

				if( role.length() > 0)
					if(role.equals("student"))
						if(level.equals("graduate"))
							people.add(new Graduate((new Double(gpa)), name));
						else
							people.add(new Undergraduate((new Double(gpa)), name));
					else if(role.equals("staff"))
						people.add(new Staff(name, (new Double(salary))));
					else
						people.add(new Faculty(name, (new Double(salary))));
			}
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public static void main(String[] args) {

		Lab5 lab = new Lab5();

		lab.readFromFile("people.txt");
		
		for (int i = 0; i < lab.people.size(); i++) {
			System.out.println(lab.people.get(i).toString());
		}
		
		System.out.print("Here is Bob Brown: ");
		for (int i = 0; i < lab.people.size(); i++) {
			if(lab.people.get(i).equals(new Person("Bob Brown")))
				System.out.println(lab.people.get(i).toString());
		}

	}

}
