package edu.nd.se2018.homework.ColombusGame;

import java.awt.Point;
import java.util.Observable;


public class Ship extends Observable{
	Point currentLocation = new Point();
	
	public Ship() {
		currentLocation.x = 10;
		currentLocation.y = 10;
			
	}
	
	public Point getShipLocation(){
		return currentLocation;
	}

	public void goEast(boolean[][] oceanGrid) {
		if(currentLocation.x!=24 && !oceanGrid[currentLocation.x+1][currentLocation.y]) {
			currentLocation.x+=1;
			setChanged();		// The observable object has moved.  To include recent changes you *MUST* have this line
			notifyObservers();  // Now notify observers.
		}
	}

	public void goWest(boolean[][] oceanGrid) {
		if(currentLocation.x!=0 && !oceanGrid[currentLocation.x-1][currentLocation.y]) {
			currentLocation.x-=1;
			setChanged();		// The observable object has moved.  To include recent changes you *MUST* have this line
			notifyObservers();  // Now notify observers.
		}
	}

	public void goNorth(boolean[][] oceanGrid) {
		if(currentLocation.y!=0 && !oceanGrid[currentLocation.x][currentLocation.y-1]) {
			currentLocation.y-=1;
			setChanged();		// The observable object has moved.  To include recent changes you *MUST* have this line
			notifyObservers();  // Now notify observers.
		}
	}

	public void goSouth(boolean[][] oceanGrid) {
		if(currentLocation.y!=24 && !oceanGrid[currentLocation.x][currentLocation.y+1]) {
			currentLocation.y+=1;
			setChanged();		// The observable object has moved.  To include recent changes you *MUST* have this line
			notifyObservers();  // Now notify observers.
		}
		
	}
	
}
