package edu.nd.se2018.homework.hwk3;

import java.util.Timer;
import java.util.TimerTask;

	
public class Horse implements Runnable{
	public String Name;
	public double Distance;
	int Strategy;
	double Speed;
	double startSpeed;
	
	// Constructor for Horse class
	Horse(String name, int speed, int strategy){
		String strategyStr;
		this.Name = name;
		this.startSpeed = speed;
		this.Speed = speed;
		this.Strategy = strategy;
		this.Distance = 0;
		
		// Associate number strategy to a human readable string
		if(strategy==1)
			strategyStr= "Early Sprint";
		else if(strategy==2)
			strategyStr= "Steady Run";
		else
			strategyStr= "Slow Start";
		
		// Print out info
		System.out.println("New Horse Created\n\tName: "+ name
		  + "\tStrategy: "+ strategyStr + "\tMax Speed: "+ startSpeed);
		
	}
	
	void setStrategy(int strategy){
		this.Strategy = strategy;
		String strategyStr;
		if(strategy==1)
			strategyStr= "Early Sprint";
		else if(strategy==2)
			strategyStr= "Steady Run";
		else
			strategyStr= "Slow Start";
		System.out.println("\nStrategy Updated\n\tName: "+ this.Name
				  + "\tStrategy: "+ strategyStr + "\tMax Speed: "+ startSpeed);
	}
	
	// Function that makes the horse start running
	public void run() {
		
		// Method to print out horse locations
		TimerTask reportLocation = new TimerTask(){
			public void run() {
				System.out.println(Name + " has run "+ String.format("%.3f", Distance*10) + " miles!");
			}
		};
		
		System.out.println(this.Name + " has started running!");
		
		int done=0;
		int slowDown=0;
		int speedUp=0;
		int maxSpeed=0;
		double counter=0;
		
		
		//start a timer to print out where each horse is
		Timer raceTimer = new Timer();
		raceTimer.scheduleAtFixedRate(reportLocation, 500, 500);
		
		while(done==0){
			// to slow down the program
			try{
			    Thread.sleep(1);
			}
			catch(InterruptedException ex){
			    Thread.currentThread().interrupt();
			}
			
			
			// Advance the horse
			counter = counter + this.Speed;
			
			// Calculate distance gone so far
			this.Distance= counter/100000;
			
			// Implementation of strategies
			switch(this.Strategy) {
				// The early sprint strategy
				case 1:
					if(this.Distance > 2.0 && slowDown==0) {
						this.Speed= this.startSpeed * 0.75;
						slowDown=1;
					}
					break;
				// The steady run strategy
				case 2:
					if(slowDown==0) {
						this.Speed= this.startSpeed * 0.80;
						slowDown=1;
					}
					break;
				// The slow run strategy
				case 3:
					if(slowDown==0) {
						this.Speed= this.startSpeed * 0.75;
						slowDown=1;
					}
					else if(this.Distance > 6.0 && speedUp==0) {
						this.Speed= this.startSpeed * .90; 
						speedUp=1;
					}
					else if(this.Distance>9.0 && maxSpeed==0) {
						this.Speed = this.startSpeed;
						maxSpeed = 1;
					}
					
					break;
				
			}
			
			// Check if we are done with the race.
			if(counter > 100000) {
				System.out.println("\t\t====="+this.Name + " Has Finished!"+"=====");
				done=1;
				
			}
			
		}
		raceTimer.cancel();
	}
	
}
