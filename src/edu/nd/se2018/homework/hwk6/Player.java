package edu.nd.se2018.homework.hwk6;

import java.awt.Point;
import java.util.Observable;


public class Player extends Observable{
	Point currentLocation = new Point();
	public int nextLevel;
	public boolean killed;
	public Player(int x, int y) {
		currentLocation.x = x;
		currentLocation.y = y;
		nextLevel = 0;
		killed = false;
	}
	
	public Point getPlayerLocation(){
		return currentLocation;
	}

	public void goRight(int[][] levelGrid) {
		
		if(currentLocation.x!=24 && levelGrid[currentLocation.x+1][currentLocation.y]!=1) {
			currentLocation.x+=1;
			
			setChanged();		// The observable object has moved.  To include recent changes you *MUST* have this line
			notifyObservers();  // Now notify observers.
		}
	}

	public void goLeft(int[][] levelGrid) {
		if(currentLocation.x!=0 && levelGrid[currentLocation.x-1][currentLocation.y]!=1) {
			currentLocation.x-=1;
			setChanged();		// The observable object has moved.  To include recent changes you *MUST* have this line
			notifyObservers();  // Now notify observers.
		}
	}

	public void goUp(int[][] levelGrid) {
		if(currentLocation.y!=0 && levelGrid[currentLocation.x][currentLocation.y-1]!=1) {
			currentLocation.y-=1;
			setChanged();		// The observable object has moved.  To include recent changes you *MUST* have this line
			notifyObservers();  // Now notify observers.
		}
	}

	public void goDown(int[][] levelGrid) {
		if(currentLocation.y!=24 && levelGrid[currentLocation.x][currentLocation.y+1]!=1) {
			currentLocation.y+=1;
			setChanged();		// The observable object has moved.  To include recent changes you *MUST* have this line
			notifyObservers();  // Now notify observers.
		}
		
	}
	
}
