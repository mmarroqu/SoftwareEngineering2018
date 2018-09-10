package edu.nd.se2018.homework.hwk2;
import edu.nd.se2018.homework.hwk2.Horse;


public class Race{
	
	// List to keep track of racers 
	Horse[] Horses=new Horse[10];
	// Keep track of how many horses we have
	int Racers = 0;
	
	// Add Horse
	void addHorse(String name, int number,int speed, int strategy){
		if(this.Racers >= 10) {
			System.out.println("Only 10 Horses allowed in a single Race!");
			return;
		}
		Horse myHorse= new Horse(name, number, speed, strategy);
		// Store horse in array of horses
		this.Horses[Racers]= myHorse;
		
		Racers++;
	}
	// Start Race
	void startRace() {
		System.out.println("\n\nREADY, SET GO!!!\n\n\n");
		// For each horse start a new thread
		for(int i=0; i < this.Racers; i++) {
			(new Thread(this.Horses[i])).start();
		}
		
	}	
	
}
