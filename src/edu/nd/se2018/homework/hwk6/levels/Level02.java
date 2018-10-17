package edu.nd.se2018.homework.hwk6.levels;

import java.util.List;

import edu.nd.se2018.homework.hwk6.Player;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Level02 implements Level {
	Image wallImage=new Image("images\\chip\\textures\\Wall.png",35,35,true,true);
	Image blankImage;
	ImageView tileImageView;
	
	@Override
	public void buildWalls(ObservableList<Node> root, int[][] levelGrid, Player player, List<Key> keys,List<Gate> gates,  List <Monster> monsters) {
		// Build perimeter
		for(int x = 0; x < 25; x++) {
			for(int y = 0; y < 25; y++) {	
				if(x==21||x==3||y==21||y==3||y==7 ) {
		
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
		// Build Room separators
		for(int y=4; y<7; y++){
			tileImageView = new ImageView(wallImage);
			tileImageView.setX(7 * 35);
			tileImageView.setY(y * 35);
			root.add(tileImageView);
			levelGrid[7][y] = 1;
			tileImageView = new ImageView(wallImage);
			tileImageView.setX(13 * 35);
			tileImageView.setY(y * 35);
			root.add(tileImageView);
			levelGrid[13][y] = 1;
		}
		
		// Build Gates
		Gate greenGate = new Gate(7,5,root,"green");
		gates.add(greenGate);
		levelGrid[7][5] = 1;
		
		Gate yellowGate = new Gate(13,5,root,"yellow");
		gates.add(yellowGate);
		levelGrid[13][5] = 1;
		
		Gate redGate = new Gate(17,7,root,"red");
		gates.add(redGate);
		levelGrid[17][7] = 1;
		
		// Build Keys
		// Correct Key
		Key greenKey= new Key(6,4,root,false,"green");
		keys.add(greenKey);
		player.addObserver(greenKey);
		greenKey.addObserver(greenGate);
		// Fake Key
		Key greenFake= new Key(6,6,root,true,"green");
		keys.add(greenFake);
		player.addObserver(greenFake);
		
		
		Key yellowKey= new Key(10,4,root,false,"yellow");
		keys.add(yellowKey);
		player.addObserver(yellowKey);
		yellowKey.addObserver(yellowGate);
		
		Key yellowFake01= new Key(9,6,root,true,"yellow");
		keys.add(yellowFake01);
		player.addObserver(yellowFake01);
		
		Key yellowFake02= new Key(11,6,root,true,"yellow");
		keys.add(yellowFake02);
		player.addObserver(yellowFake02);
		
		Key redKey= new Key(20,6,root,false,"red");
		keys.add(redKey);
		player.addObserver(redKey);
		redKey.addObserver(redGate);
		
		Key redFake01= new Key(14,6,root,true,"red");
		keys.add(redFake01);
		player.addObserver(redFake01);
		
		Key redFake02= new Key(16,4,root,true,"red");
		keys.add(redFake02);
		player.addObserver(redFake02);
		
		Key redFake03= new Key(18,4,root,true,"red");
		keys.add(redFake03);
		player.addObserver(redFake03);
		
		
		// Build Enemies
		Monster outerMonster = new Monster(7,9,10,root,false);
		monsters.add(outerMonster);
		
		Monster middleMonster = new Monster(9,11,6,root,true);
		monsters.add(middleMonster);
		
		Monster innerMonster = new Monster(11,13,2,root,false);
		monsters.add(innerMonster);
		
		Monster leftTopMonster = new Monster(4,8,2,root,false);
		monsters.add(leftTopMonster);
		
		Monster leftBottomMonster = new Monster(4,18,2,root,true);
		monsters.add(leftBottomMonster);
		
		Monster rightTopMonster = new Monster(18,8,2,root,true);
		monsters.add(rightTopMonster);
		
		Monster rightbottomMonster = new Monster(18,18,2,root,false);
		monsters.add(rightbottomMonster);
		
		
		// Place portal
		Portal exitPortal = new Portal(12,14, root);
		levelGrid[12][14] = 5;
		player.addObserver(exitPortal);
		
	}

}
