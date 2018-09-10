package edu.nd.se2018.homework.hwk3;
import edu.nd.se2018.homework.hwk3.Race;

public class test2 {
	public static void main(String args[]) {
		Race firstRace= new Race();
	
		
		//addHorse(Name, maxSpeed, Strategy 1-3)
		firstRace.addHorse("Alexis", 23,1);
		firstRace.addHorse("Joey", 20,1);
		firstRace.addHorse("Saury", 21,1);
		firstRace.addHorse("Horse", 33,1);
		firstRace.addHorse("Winston", 35,1);
	
		firstRace.startRace();
		// Winston should win.
		
	
		
		
		
	}
}
