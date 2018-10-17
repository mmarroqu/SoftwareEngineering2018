package edu.nd.se2018.homework.hwk6.levels;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Monster {
	public int X;
	public int Y;
	public int counter=0;
	public int moveLimit;
	public int moveDirection=0; 
	public boolean Inverted;
	ImageView monsterImageView; 
	Image monsterImageUp = new Image("images\\chip\\textures\\monsterUp.png",34,34,true,true);
	Image monsterImageDown = new Image("images\\chip\\textures\\monsterDown.png",34,34,true,true);
	Image monsterImageLeft = new Image("images\\chip\\textures\\monsterLeft.png",34,34,true,true);
	Image monsterImageRight = new Image("images\\chip\\textures\\monsterRight.png",34,34,true,true);
	Monster(int x, int y, int Limit, ObservableList<Node> root, boolean inverted){
		X = x;
		Y = y;
		Inverted = inverted;
		moveLimit = Limit;
		monsterImageView = new ImageView(monsterImageDown);
		monsterImageView.setX(X* 35);
		monsterImageView.setY(Y* 35);
		root.add(monsterImageView);
	}
	
	public void Move(ObservableList<Node> root) {
		if(counter==moveLimit) {
			moveDirection++;
			counter=0;
			if(moveDirection==4)
				moveDirection=0;
		}
		
		if(moveDirection==0) {
			root.remove(monsterImageView);
			if(Inverted) {
				Y++;
				root.remove(monsterImageView);
				monsterImageView = new ImageView(monsterImageDown);
			}
			else {
				X++;
				root.remove(monsterImageView);
				monsterImageView = new ImageView(monsterImageRight);
			}
		}
		else if(moveDirection==1) {
			if(Inverted) {
				X++;
				root.remove(monsterImageView);
				monsterImageView = new ImageView(monsterImageRight);
			}
			else {
				Y++;
				root.remove(monsterImageView);
				monsterImageView = new ImageView(monsterImageDown);
			}
		}
		else if(moveDirection==2) {
			if(Inverted){
				Y--;
				root.remove(monsterImageView);
				monsterImageView = new ImageView(monsterImageUp);
			}
			else {
				X--;
				root.remove(monsterImageView);
				monsterImageView = new ImageView(monsterImageLeft);
			}
		}
		else if(moveDirection==3) {
			if(Inverted){
				X--;
				root.remove(monsterImageView);
				monsterImageView = new ImageView(monsterImageLeft);
			}
			else {
				Y--;
				root.remove(monsterImageView);
				monsterImageView = new ImageView(monsterImageUp);
			}
		}
		monsterImageView.setX(X* 35);
		monsterImageView.setY(Y* 35);
		root.add(monsterImageView);
			
		counter++;
		
	}
	
}
