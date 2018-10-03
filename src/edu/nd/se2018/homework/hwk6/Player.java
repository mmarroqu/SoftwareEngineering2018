package edu.nd.se2018.homework.hwk6;

import java.awt.Point;
import java.util.Observable;


public class Player extends Observable{
	Point currentLocation = new Point();
	
	public Player() {
		currentLocation.x = 10;
		currentLocation.y = 10;
			
	}
	
	public Point getPlayerLocation(){
		return currentLocation;
	}

	public void goRight(boolean[][] levelGrid) {
		
		if(currentLocation.x!=24 && !levelGrid[currentLocation.x+1][currentLocation.y]) {
			currentLocation.x+=1;
			
			//setChanged();		// The observable object has moved.  To include recent changes you *MUST* have this line
			//notifyObservers();  // Now notify observers.
		}
	}

	public void goLeft(boolean[][] levelGrid) {
		if(currentLocation.x!=0 && !levelGrid[currentLocation.x-1][currentLocation.y]) {
			currentLocation.x-=1;
			//setChanged();		// The observable object has moved.  To include recent changes you *MUST* have this line
			//notifyObservers();  // Now notify observers.
		}
	}

	public void goUp(boolean[][] levelGrid) {
		if(currentLocation.y!=0 && !levelGrid[currentLocation.x][currentLocation.y-1]) {
			currentLocation.y-=1;
			//setChanged();		// The observable object has moved.  To include recent changes you *MUST* have this line
			//notifyObservers();  // Now notify observers.
		}
	}

	public void goDown(boolean[][] levelGrid) {
		if(currentLocation.y!=24 && !levelGrid[currentLocation.x][currentLocation.y+1]) {
			currentLocation.y+=1;
			//setChanged();		// The observable object has moved.  To include recent changes you *MUST* have this line
			//notifyObservers();  // Now notify observers.
		}
		
	}
	
}
