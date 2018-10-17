package edu.nd.se2018.homework.hwk6.levels;

import java.util.Observable;
import java.util.Observer;

import edu.nd.se2018.homework.hwk6.Player;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Key extends Observable implements Observer {
	public int X;
	public int Y;
	public int acquired=0;
	public boolean rigged=false;
	public Key(int x, int y,ObservableList<Node> root,boolean Rigged, String color){
		X = x;
		Y = y;
		rigged= Rigged;
		Image KeyImage=new Image("images\\chip\\textures\\"+color+"Key.png",35,35,true,true);
		ImageView tileImageView = new ImageView(KeyImage);
		tileImageView.setX(X* 35);
		tileImageView.setY(Y* 35);
		
		root.add(tileImageView);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if( o instanceof Player) {
			Player player = (Player)o;
			if(player.getPlayerLocation().x==X && player.getPlayerLocation().y==Y) {
				acquired = 1;
				setChanged();
				notifyObservers();
				
			}
		}
	}

}
