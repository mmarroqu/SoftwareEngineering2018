package edu.nd.se2018.homework.hwk2;
import edu.nd.se2018.homework.hwk2.Race;
public class Main {
	public static void main(String args[]) {
		Race myRace= new Race();
		
		
		myRace.addHorse("Alexis", 69, 5,1);
		myRace.addHorse("Joey", 4, 5,2);
		myRace.addHorse("Saury", 0, 5,3);
		
		myRace.startRace();
		
	}
}
