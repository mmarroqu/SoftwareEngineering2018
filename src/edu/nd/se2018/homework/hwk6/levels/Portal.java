package edu.nd.se2018.homework.hwk6.levels;

import java.util.Observable;
import java.util.Observer;

import edu.nd.se2018.homework.hwk6.Player;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Portal implements Observer {
	int X;
	int Y;

	public Portal(int x, int y,ObservableList<Node> root) {
		// Set coordinates for portal
		X=x;
		Y=y;
		Image portalImage=new Image("images\\chip\\textures\\portal.png",35,35,true,true);
		ImageView tileImageView = new ImageView(portalImage);
		tileImageView.setX(x* 35);
		tileImageView.setY(y* 35);
		root.add(tileImageView);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if( o instanceof Player) {
			Player player = (Player)o;
			if(player.getPlayerLocation().x==X && player.getPlayerLocation().y==Y) {
				player.nextLevel=1;
			}
		}
		
	}

}
