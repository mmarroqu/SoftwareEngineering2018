package edu.nd.se2018.homework.ColombusGame;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javafx.scene.image.ImageView;



public class PirateShip implements Observer{
	Point piratePosition = new Point();
	ImageView pirateImageView;
	Point ccPosition = new Point();
	boolean[][] mapGrid= new boolean[25][25];
	
	public PirateShip(boolean[][] oceanGrid) {
		
		// Find a random place to put the pirate ship thats empty
		Random random = new Random();
		mapGrid = oceanGrid;
		int empty = 0;
		int xRandom = 0;
		int yRandom = 0; 
		while(empty == 0) {
	        xRandom=random.nextInt(25) ;
		    yRandom=random.nextInt(25);
		    if(oceanGrid[xRandom][yRandom] == false)
		    	empty = 1;
		}
		piratePosition.x = xRandom;
		piratePosition.y = yRandom;
			
	}
	
	public ImageView getImageView(){
		return pirateImageView;
	}
	
	@Override
	public void update(Observable s, Object arg1) {
		if (s instanceof Ship){
			ccPosition = ((Ship)s).getShipLocation();
			movePirate();			
		}	
	}
	
	private void movePirate() {
		
		if (piratePosition.x - ccPosition.x < 0 && !mapGrid[piratePosition.x+1][piratePosition.y])
			piratePosition.x++;
		else if(!mapGrid[piratePosition.x-1][piratePosition.y])
			piratePosition.x--;
		
		if (piratePosition.y - ccPosition.y < 0 && !mapGrid[piratePosition.x][piratePosition.y+1])
			piratePosition.y++;
		else if (!mapGrid[piratePosition.x][piratePosition.y-1])
			piratePosition.y--;
		
		
	}

	public Point getShipLocation() {
		return piratePosition;
	}

}
