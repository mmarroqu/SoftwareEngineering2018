package edu.nd.se2018.homework.hwk5;

import java.util.Observable;

public class TrainsPresent extends Observable{
	public Train[] Trains= new Train[2];
	int trainCount=0;
	
	
	public TrainsPresent(Train train){
		Trains[trainCount]= train;
		trainCount++;
	}
	
	public void addTrain(Train train) {
		Trains[trainCount] = train;
		trainCount++;
		
	}
	
	public void trainCheck(){
		setChanged();
		notifyObservers();
	}
	
}
