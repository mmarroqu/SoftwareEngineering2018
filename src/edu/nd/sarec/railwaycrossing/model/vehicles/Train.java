package edu.nd.sarec.railwaycrossing.model.vehicles;

import java.util.Observable;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Represents the train entity object
 * @author jane
 *
 */
public class Train extends Observable implements IVehicle{
	private double currentX = 0;
	private double currentY = 0;
	private double originalX = 0;
	public boolean goingEast = false;
	private Image img;
	private ImageView imgView;
	private int trainLength = 35;
	
	public Train(int x, int y, boolean direction){
		this.currentX = x;
		this.currentY = y;
		originalX = x;
		goingEast = direction;
		if(direction){
			img = new Image("images\\TrainFlipped.PNG",120,trainLength,false,false);
		}
		else
			img = new Image("images\\Train.PNG",120,trainLength,false,false);
		imgView = new ImageView(img);
		imgView.setX(currentX);
		imgView.setY(currentY);
	}
	
	public double getVehicleX(){
		return currentX;
	}
	
	public double getVehicleY(){
		return currentY;
	}
	
	public void move(){
		if(goingEast)
			currentX+=2;
		else
			currentX-=2;
		imgView.setX(currentX);
		setChanged();
		notifyObservers();
	}
	
	public boolean offScreen(){
		if (currentX < -200 && !(goingEast))
			return true;
		else if (currentX > 1500 && goingEast)
			return true;
		else
			return false;				
	}
	
	public void reset(){
		currentX = originalX;
	}

	//@Override
	public Node getImageView() {
		return imgView;
	}
}