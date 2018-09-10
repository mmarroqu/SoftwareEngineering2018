package edu.nd.se2018.homework.hwk3;
import edu.nd.se2018.homework.hwk3.Race;
import org.junit.Test;


// Checks if strategy is being changed correctly
public class unitTest2 {
	@Test
	public void test() {
		Race myRace= new Race();
		myRace.addHorse("Alexis", 20,1);
		myRace.addHorse("Saury", 20,1);
		myRace.addHorse("Manuel", 20,1);
		
		assert (myRace.Horses[0].Strategy == 1);
		assert (myRace.Horses[1].Strategy == 1); 
		assert (myRace.Horses[2].Strategy == 1); 
		
		myRace.Horses[0].setStrategy(2);
		myRace.Horses[1].setStrategy(3);
		myRace.Horses[2].setStrategy(3);
		
		assert (myRace.Horses[0].Strategy == 2);
		assert (myRace.Horses[1].Strategy == 3); 
		assert (myRace.Horses[2].Strategy == 3); 
				   
	}
}
