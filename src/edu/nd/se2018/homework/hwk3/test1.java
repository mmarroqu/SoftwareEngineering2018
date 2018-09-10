package edu.nd.se2018.homework.hwk3;
import edu.nd.se2018.homework.hwk3.Race;
public class test1 {
	public static void main(String args[]) {
		Race myRace= new Race();
	
		
		//addHorse(Name, maxSpeed, Strategy 1-3)
		myRace.addHorse("Alexis", 23,1);
		myRace.addHorse("Joey", 20,2);
		myRace.addHorse("Saury", 21,2);
		myRace.addHorse("Speedy", 35,3);
		myRace.addHorse("Winston", 20,2);
		
		myRace.startRace();
		// Speedy should win.
		
	
		
		
		
	}
}
