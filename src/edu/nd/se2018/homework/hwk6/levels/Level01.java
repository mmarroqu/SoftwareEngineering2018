package edu.nd.se2018.homework.hwk6.levels;


import java.util.List;

import edu.nd.se2018.homework.hwk6.Player;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import edu.nd.se2018.homework.hwk6.levels.Key;

public class Level01 implements Level {

	
	@Override
	public void buildWalls(ObservableList<Node> root, int[][] levelGrid, Player player,List <Key> keys ,List <Gate> gates, List <Monster> monsters) {
		Image wallImage=new Image("images\\chip\\textures\\Wall.png",35,35,true,true);
		Image blankImage;
		ImageView tileImageView;
		
		
		
		for(int x = 0; x < 25; x++) {
			for(int y = 0; y < 25; y++) {	
				if(x==21||x==3||y==21||y==3) {
		
					tileImageView = new ImageView(wallImage);
					tileImageView.setX(x * 35);
					tileImageView.setY(y * 35);
					root.add(tileImageView);
					levelGrid[x][y] = 1;
				}
				else {
					blankImage = new Image("images\\chip\\textures\\BlankTile.png",35,35,true,true);
					tileImageView = new ImageView(blankImage);
					tileImageView.setX(x * 35);
					tileImageView.setY(y * 35);
					root.add(tileImageView);
					levelGrid[x][y] = 0;
				}
			}
		}
		
		int[] cornersX = {6,6,6,5,4,3,
				         18,18,18,19,20,21,
				         6,6,6,5,4,3,
				         18,18,18,19,20,21,
				         10,11,12,10,12,10,12};
		int[] cornersY = {4,6,7,7,7,7,
						 4,6,7,7,7,7,
						 20,19,17,17,17,17,
						 20,19,17,17,17,17,
						 11,11,11,12,12,13,13};
		
		// Build Corners
		for(int i=0; i<31; i++) {
			tileImageView = new ImageView(wallImage);
			tileImageView.setX(cornersX[i]* 35);
			tileImageView.setY(cornersY[i]* 35);
			root.add(tileImageView);
			levelGrid[cornersX[i]][cornersY[i]] = 1;
		}
		
		// Place Keys
		Key redKey= new Key(4,4,root,false,"red");
		keys.add(redKey);
		player.addObserver(redKey);
		Key blueKey= new Key(4,20,root,false,"blue");
		keys.add(blueKey);
		player.addObserver(blueKey);
		Key greenKey= new Key(20,4,root,false,"green");
		keys.add(greenKey);
		player.addObserver(greenKey);
		Key yellowKey= new Key(20,20,root,false,"yellow");
		keys.add(yellowKey);
		player.addObserver(yellowKey);
	
		int[] keysX = {4,4,20,20};
		int[] keysY = {4,20,4,20};
	
		for(int i=0; i<4; i++) {
			levelGrid[keysX[i]][keysY[i]] = 3;
			// Set Observer relationship between keys and gate
			
		}
		// Place Gates
		Gate redGate = new Gate(18,18,root,"red");
		redKey.addObserver(redGate);
		gates.add(redGate);
		levelGrid[18][18] = 1;
		
		Gate yellowGate = new Gate(18,5,root,"yellow");
		yellowKey.addObserver(yellowGate);
		gates.add(yellowGate);
		levelGrid[18][5] = 1;
		
		Gate greenGate = new Gate(6,18,root,"green");
		greenKey.addObserver(greenGate);
		gates.add(greenGate);
		levelGrid[6][18] = 1;
		
	
		Gate blueGate = new Gate(11,13,root,"blue");
		blueKey.addObserver(blueGate);
		gates.add(blueGate);
		levelGrid[11][13] = 1;
		
		
		// Place Portal
		Portal exitPortal = new Portal(11,12, root);
		levelGrid[11][12] = 5;
		player.addObserver(exitPortal);
		
		
	
	}

}
