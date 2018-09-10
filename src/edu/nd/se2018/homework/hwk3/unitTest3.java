package edu.nd.se2018.homework.hwk3;
import edu.nd.se2018.homework.hwk3.Race;
import org.junit.Test;


// Checks if number of racers is being tracked correctly
public class unitTest3 {
	@Test
	public void test() {
		Race myRace= new Race();
		myRace.addHorse("Alexis", 20,1);
		myRace.addHorse("Saury", 20,1);
		myRace.addHorse("Manuel", 20,1);
		
		assert (myRace.Racers == 3);
		myRace.addHorse("Bob", 20,1);
		assert (myRace.Racers == 4);
		myRace.addHorse("Jerry", 20,1);
		myRace.addHorse("Timmy", 20,1);
		assert (myRace.Racers == 6); 
		
		
				   
	}
}
