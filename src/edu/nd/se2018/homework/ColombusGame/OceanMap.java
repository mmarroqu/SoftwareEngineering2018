package edu.nd.se2018.homework.ColombusGame;

import java.util.Random;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class OceanMap {
	boolean[][] oceanGrid= new boolean[25][25];
	final int dimensions = 25;
	final int numIslands = 10;
	
	public void drawMap(ObservableList<Node> root, int scale) {
		for(int x = 0; x < dimensions; x++) {
			for(int y = 0; y < dimensions; y++) {
				Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
				
				rect.setStroke(Color.BLACK);	// We want the black outline
				rect.setFill(Color.PALETURQUOISE); // Because she likes this better than blue
				root.add(rect); 	// Add to the node tree in the pane
				oceanGrid[x][y] = false;
				
			}
		}
		for(int i = 0; i < numIslands; i++) {
				// Calculate 2 random numbers between 0-24
				Random random = new Random();
				int empty = 0;
				int xRandom = 0;
				int yRandom = 0; 
				while(empty==0) {
			        xRandom=random.nextInt(25) ;
				    yRandom=random.nextInt(25);
				    if(oceanGrid[xRandom][yRandom] == false)
				    	empty = 1;
				}
				
				// Check if place is empty otherwise reroll
				Rectangle rect = new Rectangle(xRandom*scale, yRandom*scale, scale, scale);
				rect.setStroke(Color.BLACK);	// We want the black outline
				rect.setFill(Color.GREEN); // Because she likes this better than blue
				root.add(rect); 	// Add to the node tree in the pane
				oceanGrid[xRandom][yRandom] = true;
				
			
		}
		
	
	}
}
