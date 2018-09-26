package edu.nd.se2018.homework.hwk5;

import java.util.Observable;
import java.util.Observer;

import edu.nd.sarec.railwaycrossing.model.infrastructure.gate.CrossingGate;
import edu.nd.sarec.railwaycrossing.model.vehicles.IVehicle;
import edu.nd.sarec.railwaycrossing.view.CarImageSelector;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

/**
 * Represents Car object
 * @author jane
 *
 */
public class Car extends Observable implements IVehicle, Observer{
	private ImageView ivCar;
	public double currentX = 0;
	public double currentY = 0;
	private double originalY = 0;
	private double originalX = 0;
	private boolean gateDown = false;
	private double leadCarY = -1;  // Current Y position of car directly infront of this one
	private double leadCarX = -1;
	private double speed = 0.5;
	public boolean horizontalMove = false;
	public boolean canMerge = false;
	
		
	/**
	 * Constructor
	 * @param x initial x coordinate of car
	 * @param y initial y coordinate of car
	 */
	public Car(int x, int y){
		this.currentX = x;
		this.currentY = y;
		originalY = y;
		originalX = x;
		ivCar = new ImageView(CarImageSelector.getImage());
		ivCar.setX(getVehicleX());
		ivCar.setY(getVehicleY());
	}
		
	@Override
	public Node getImageView() {
		return ivCar;
	}
	
	public boolean gateIsClosed(){
		return gateDown;
	}
	
	public double getVehicleX(){
		return currentX;
	}
	public double getVehicleY(){
		return currentY;
	}
	
	public void move(){
		boolean canMove = true; 
	
		// First case.  Car is at the front of the stopping line.
		if (gateDown && getVehicleY() < 430 && getVehicleY()> 390)
			canMove = false;
		
		// Second case. Car is too close to other car going south.
		if (leadCarY != -1 && getDistanceToLeadCar() < 50) {
			canMove = false;
			
		}
		
		// If moving horizontally and xDistance of leadCar not short
		if (leadCarY == -1 &&(leadCarY-currentY)<3 && horizontalMove && getXDistanceToLeadCar() < 50) {
			canMove = false;
			//System.out.println("cant move");
		}
		// If waiting to re merge
		if(horizontalMove && currentX > 398 && currentX < 401) {
			canMove = false;
			canMerge = true;
		}
		
		// If moving down
		if (canMove && !horizontalMove){
			currentY+=speed;
			ivCar.setY(currentY);
		}
		
		// If moving horizontal
		else if (canMove && horizontalMove) {
			currentX-=speed;
			ivCar.setX(currentX);
			ivCar.setY(currentY);
		}
		setChanged();
		notifyObservers();
		// If car is at T randomly turn 
		if(currentY > 794.5 && currentY < 795.5 && currentX>400) {
			horizontalMove = true;
		}
		
	
		
		
		
	}
	
	public void setSpeed(double speed){
		this.speed = speed;
	}
	
	public void setGateDownFlag(boolean gateDown){
		this.gateDown = gateDown;
	}
	
	public boolean offScreen(){
		if (currentY > 1020) {
			setChanged();
			notifyObservers();
			return true;
		}
		else if(currentX < 0)
			return true;
		else
			return false;			
	}
		
	public void reset(){
		currentY = originalY;
	}
	
	public double getDistanceToLeadCar(){
		return Math.abs(leadCarY-getVehicleY());
	}
	public double getXDistanceToLeadCar(){
		//System.out.println(leadCarX);
		//if(leadCarX<=-1)
			//return 51;
		return Math.abs(getVehicleX()-leadCarX);
	}
	public void removeLeadCar(){
		leadCarY = -1;
	}

	@Override
	public void update(Observable o, Object arg1) {
		if (o instanceof Car){
			leadCarY = (((Car)o).getVehicleY());
			if(((Car)o).horizontalMove == true)		
				leadCarX = (((Car)o).getVehicleX());
			
			// If car goes off screen
			if (leadCarY > 1000 ) {
				leadCarY = -1;
				leadCarX = -1;
			}
			
			if(leadCarX < originalX && ((Car)o).horizontalMove == true) {
				removeLeadCar();
			}
			
		}
		else if (o instanceof CrossingGate){
			CrossingGate gate = (CrossingGate)o;
			if(gate.getTrafficCommand()=="STOP")			
				gateDown = true;
			else
				gateDown = false;
					
		}
		
		
			
		
	}

	public boolean turned() {
		// If direction is between range and direction of 
		return (currentX < originalX);
	}
	public boolean canMerge() {
		// If direction is between range and direction of 
		return (canMerge);
	}	
}
