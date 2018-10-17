package edu.nd.se2018.homework.hwk6.levels;

import java.util.Observable;
import java.util.Observer;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Gate implements Observer {
	public int X;
	public int Y;
	public boolean locked=true;
	public Gate(int x, int y,ObservableList<Node> root, String color) {
		// Set coordinates for portal
		X=x;
		Y=y;
		Image gateImage=new Image("images\\chip\\textures\\"+color+"KeyWall.png",35,35,true,true);
		ImageView tileImageView = new ImageView(gateImage);
		tileImageView.setX(x* 35);
		tileImageView.setY(y* 35);
		root.add(tileImageView);
	}
	
	
	@Override
	public void update(Observable o, Object arg1) {
		// TODO Auto-generated method stub
		if(o instanceof Key) {
			Key key=(Key)o;
			System.out.println(key.acquired);
			if(key.acquired==1) {
				System.out.println("got key");
				locked=false;
			}
		}
	}

}
