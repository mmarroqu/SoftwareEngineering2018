package edu.nd.se2018.homework.hwk6;



import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class levelMap {
	boolean[][] oceanGrid= new boolean[25][25];
	final int dimensions = 25;
	final int numIslands = 10;
	
	public void drawMap(ObservableList<Node> root, int scale) {
		
		
		
		
		// Map Walls, I want to use strategy for this to make maps
		for(int x = 0; x < dimensions; x++) {
			for(int y = 0; y < dimensions; y++) {
				
				// Create walking space
				if(x<21 && x>3 && y>3 && y<21) {
					Image blankImage = new Image("images\\chip\\textures\\BlankTile.png",34,34,true,true);
					ImageView tileImageView = new ImageView(blankImage);
					tileImageView.setX(x * scale);
					tileImageView.setY(y * scale);
					root.add(tileImageView);
					oceanGrid[x][y] = false;
				}
				// Create wall
				else {
					Image blankImage = new Image("images\\chip\\textures\\Wall.png",34,34,true,true);
					ImageView tileImageView = new ImageView(blankImage);
					tileImageView.setX(x * scale);
					tileImageView.setY(y * scale);
					root.add(tileImageView);
					oceanGrid[x][y] = true;
				}
				
			}
		}
		
				
		
		
	
	}
}