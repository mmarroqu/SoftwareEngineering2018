package edu.nd.se2018.homework.hwk3;
import edu.nd.se2018.homework.hwk3.Race;
public class Main {
	public static void main(String args[]) {
		Race firstRace= new Race();
	
		
		//addHorse(Name, maxSpeed, Strategy 1-3)
		firstRace.addHorse("Alexis", 20,1);
		firstRace.addHorse("Joey", 20,2);
		firstRace.addHorse("Saury", 20,2);
		
		firstRace.Horses[2].setStrategy(3);
		
		firstRace.startRace();
		// Alexis should win.
		
	
		
		
		
	}
}
