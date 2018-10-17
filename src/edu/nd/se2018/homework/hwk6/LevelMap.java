package edu.nd.se2018.homework.hwk6;



import java.util.LinkedList;
import java.util.List;

import edu.nd.se2018.homework.hwk6.levels.Gate;
import edu.nd.se2018.homework.hwk6.levels.Key;
import edu.nd.se2018.homework.hwk6.levels.Level;
import edu.nd.se2018.homework.hwk6.levels.Level01;
import edu.nd.se2018.homework.hwk6.levels.Level02;
import edu.nd.se2018.homework.hwk6.levels.Monster;
import javafx.collections.ObservableList;
import javafx.scene.Node;



public class LevelMap {
	int[][] levelGrid;
	final int dimensions = 25;
	Level level;
	
	List <Key> keys= new LinkedList<Key>();
    List <Gate> gates= new LinkedList<Gate>();
    List <Monster> monsters= new LinkedList<Monster>();
    
	public LevelMap(){
		
	}
	
	public void drawMap(ObservableList<Node> root, int lv, Player player) {
		
		
		
		if(lv==1) {
			// Create walls for level 1
			levelGrid= new int[25][25];
			level= new Level01();
			level.buildWalls(root, levelGrid, player, keys, gates, monsters);
			
		}
		else{
			keys= new LinkedList<Key>();
		    gates= new LinkedList<Gate>();
		    monsters= new LinkedList<Monster>();
			System.out.println("Level 2");
			levelGrid = new int[25][25];
			level = new Level02();
			level.buildWalls(root, levelGrid, player,keys,gates, monsters);
			System.out.println(monsters);
		}

				
		
		
	
	}
}