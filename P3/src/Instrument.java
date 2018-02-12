import java.util.Random;

// P3 Assignment
// Author: alaswell
// Date: Sep 18, 2015
// Class: CS161
// Email: alaswell@cs.colostate.edu

public class Instrument {

	protected Member member; 
	protected String notes = "";
	protected int octave = 0;

	public Instrument(String notes, int octave, Member member) {
		this.setNotes(notes);
		this.setMember(member);
		this.setOctave(octave);
	}


	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}


	public String getNotes() {
		String[] newNotes = notes.split("\\s+");
		String[] randNotes = {"A", "B", "C", "D", "E", "F", "G"};

		// replace strings based on skill
		for(int i = 0; i < newNotes.length; i++){
			double rand0 = Math.random(); 
			Random rand1 = new Random();
			int index = rand1.nextInt(6);

			switch (this.getMember().getLevel()) {

			case 1:
			{
				if(rand0 > .5)
					newNotes[i] = randNotes[index];
				break;
			}

			case 2:
			{
				if(rand0 > .8)
					newNotes[i] = randNotes[index];
				break;
			}

			default:
				break;				
			}

			// add in octave
			char z = newNotes[i].charAt(newNotes[i].length() - 1);
			int length = newNotes[i].length();

			if(Character.isLowerCase(z)) {
				if(length == 3) {
					String temp1 = newNotes[i].substring(0, 2); // subString 0-1
					String temp2 = newNotes[i].substring(2); // subString 2 on
					newNotes[i] = temp1 + Integer.toString(octave) + temp2;
				}
				else if(length == 2) {
					// if there are only 2 
					String temp1 = Character.toString(newNotes[i].charAt(0)); // subString 0
					String temp2 = newNotes[i].substring(1); // subString 1 on
					newNotes[i] = temp1 + Integer.toString(octave) + temp2;
				}
			}
			else
				newNotes[i] = newNotes[i] + Integer.toString(octave);
			// need another space
			newNotes[i] += " ";
		}

		// Now put it all into a single return string
		String finalString = "";

		for(int i = 0; i < newNotes.length; i++) {
			finalString += newNotes[i];
		}
		return finalString;
	}

	@Override
	public String toString() {
		return null;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public int getOctave() {
		return octave;
	}


	public void setOctave(int octave) {
		this.octave = octave;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
