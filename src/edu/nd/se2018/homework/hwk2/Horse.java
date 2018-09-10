package edu.nd.se2018.homework.hwk2;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
	
public class Horse implements Runnable{
	public String Name;
	public double Distance;
	int Number;
	int Strategy;
	int Speed;
	
	Horse(String name, int number, int speed, int strategy){
		System.out.println("New Horse Created\n Name: "+ name + ""
		  + " Number: "+ number + " Strategy: "+ strategy);
		this.Number = number;
		this.Name = name;
		this.Speed = speed;
		this.Strategy = strategy;
		this.Distance = 0;
	}
	
	void setStrategy(int strategy){
		
		
	}
	
	// For debugging purposes
	void displayHorse() {
		System.out.println("Name: "+ this.Name + ""
		  + " Number: "+ this.Number + " Strategy: "+ this.Strategy);
		
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
			
			
			// Depending the strategy speed will change
			counter = counter + this.Speed;
			this.Distance= counter/10000;
			
			
			// Check if we are done with the race.
			if(counter > 10000) {
				System.out.println("====="+this.Name + " Has Finished!"+"=====");
				done=1;
				
			}
			
		}
		raceTimer.cancel();
	}
	
	
	
	
	
}
