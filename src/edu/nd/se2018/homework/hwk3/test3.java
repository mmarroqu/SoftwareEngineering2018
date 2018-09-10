package edu.nd.se2018.homework.hwk3;
import edu.nd.se2018.homework.hwk3.Race;

public class test3 {
	public static void main(String args[]) {
		Race firstRace= new Race();
	
		
		//addHorse(Name, maxSpeed, Strategy 1-3)
		firstRace.addHorse("Paul", 15,1);
		firstRace.addHorse("Carrot", 20,2);
		firstRace.addHorse("George", 25,3);
		
		
		firstRace.startRace();
		// George should win.
		
	}
}
