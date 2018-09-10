package edu.nd.se2018.homework.hwk3;
import edu.nd.se2018.homework.hwk3.Race;
import org.junit.Test;

// Checks if horses are getting created properly
public class unitTest1 {
	@Test
	public void test() {
		Race myRace= new Race();
		myRace.addHorse("Alexis", 20,1);
		myRace.addHorse("Saury", 20,1);
		myRace.addHorse("Manuel", 20,1);
		
		assert (myRace.Horses[0].Name == "Alexis");
		assert (myRace.Horses[1].Name == "Saury"); 
		assert (myRace.Horses[2].Name == "Manuel"); 
				   
	}
}
