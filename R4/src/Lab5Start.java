import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

// Assumes data file named people.txt is available with lines like
//  Jim Johnson,student,graduate,3.8,0
//  Pam Petunia,faculty,,,94000
//  Bob Brown,staff,,,120000
//  Deb Dickinson,student,undergraduate,3.5,0

public class Lab5Start {

    // Parallel ArrayLists, meaning entry i in each one refers to the same person.
    private ArrayList<String> names;
    private ArrayList<String> roles;
    private ArrayList<String> levels;
    private ArrayList<Double> gpas;
    private ArrayList<Double> salaries;
    // If we are only accessing these from methods, including the main, private is okay.

    public Lab5Start() {
	names = new ArrayList<String>();
	roles = new ArrayList<String>();
	levels = new ArrayList<String>();
	gpas = new ArrayList<Double>();
	salaries = new ArrayList<Double>();
    }
    
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
		names.add(name);
		roles.add(role);
		levels.add(level);
		if (gpa.length() > 0)
		    gpas.add(new Double(gpa));
		else
		    gpas.add(0.0);
		if (salary.length() > 0)
		    salaries.add(new Double(salary));
		else
		    salaries.add(0.0);
	    }
	    scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    //======================================================================

    public static void main(String[] args) {

	Lab5Start lab = new Lab5Start();

	lab.readFromFile("people.txt");
	
	for (int i = 0; i < lab.names.size(); i++) {

	    if (lab.roles.get(i).equals("faculty") ||
		lab.roles.get(i).equals("staff")) {

		System.out.println(lab.names.get(i) + ", " +
				   lab.roles.get(i) + ", " +
				   lab.salaries.get(i));

	    } else {
		System.out.println(lab.names.get(i) + ", " +
				   lab.levels.get(i) + ", " +
				   lab.gpas.get(i));
	    }
	}

	System.out.print("Here is Bob Brown: ");
	int bobi = lab.names.indexOf("Bob Brown");

	if (lab.roles.get(bobi).equals("faculty") ||
		lab.roles.get(bobi).equals("staff")) {

		System.out.println(lab.names.get(bobi) + ", " +
				   lab.roles.get(bobi) + ", " +
				   lab.salaries.get(bobi));

	    } else {
		System.out.println(lab.names.get(bobi) + ", " +
				   lab.levels.get(bobi) + ", " +
				   lab.gpas.get(bobi));
	    }

    }

}
