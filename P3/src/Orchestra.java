import org.jfugue.player.Player;
import java.util.ArrayList;

// P3 Assignment
// Author: alaswell
// Date: Sep 18, 2015
// Class: CS161
// Email: alaswell@cs.colostate.edu

public class Orchestra {

	// Instance vars
	
	private ArrayList<Instrument> instruments;
	
	// Constructors
	
	public Orchestra() {
		instruments = new ArrayList();
	}

	public void addInstrument(Instrument instrument) {
		instruments.add(instrument);		
	}
	
	@Override
	public String toString() {
		return instruments.toString();
	}
	
	
	public String jfugueString() {
		String returnString = "";
		for(int i = 0; i < instruments.size(); i++){
			returnString += "V" + i + " I[" + instruments.get(i).toString() + "] " + instruments.get(i).getNotes() + " ";
		}
		return returnString;
	}
	
	public ArrayList<String> whoPlays(String instrumentName) {
		ArrayList<String> returnString = new ArrayList<String>();
		
		for(int i = 0; i < instruments.size(); i++) {
			if(instruments.get(i).toString().equalsIgnoreCase(instrumentName))
				returnString.add(instruments.get(i).getMember().toString());
		}
		return returnString;
	}
	
	public String playedBy(String memberName) {
		String returnString = null;
		
		for(int i = 0; i < instruments.size(); i++) {
			if(instruments.get(i).getMember().toString().equalsIgnoreCase((memberName)))
				returnString = instruments.get(i).toString();
		}
		return returnString;
	}
	
	public void play() {
	     String jfugueString = jfugueString();
	     Player player = new Player();
	     System.out.println(jfugueString); // what is it printing? 
	     player.play(jfugueString);
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

