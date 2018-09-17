package edu.nd.se2018.homework.ColombusGame;


import java.util.LinkedList;
import java.util.List;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class OceanExplorer extends Application{
	
	// Scene and Stage
	AnchorPane myPane = new AnchorPane();
	Scene scene = new Scene(myPane,900,900);
	OceanMap myOcean= new OceanMap();
	
	// Ships 
	int pirateCount = 5;
	Ship ship = new Ship();
	List<PirateShip> pirates;
	
	// Imageviews
	ImageView shipImageView;
	ImageView []pirateImageView=new ImageView[pirateCount];
	int scale = 35;
	
	// Constructor
	public OceanExplorer() {
		pirates = new LinkedList<PirateShip>();
		
		for(int j = 0; j < pirateCount; j++)
			pirates.add(new PirateShip(myOcean.oceanGrid));
		
		for(PirateShip pirate: pirates)
			ship.addObserver(pirate);
		
	}
	
	@Override
	public void start(Stage oceanStage) throws Exception {
		
		myOcean.drawMap(myPane.getChildren(), scale);
		oceanStage.setScene(scene);
		oceanStage.setTitle("Colombus Game");
		
		// Set image for columbus ship
		Image shipImage = new Image("images\\ColumbusShip.png",41,41,true,true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(ship.getShipLocation().x * scale);
		shipImageView.setY(ship.getShipLocation().y * scale);
		myPane.getChildren().add(shipImageView);
		
		// Set ships for pirates
		int i = 0;
		Image pirateImage = new Image("images\\pirateship.gif",41,41,true,true);
		for(PirateShip pirate: pirates) {
				pirateImageView[i] = new ImageView(pirateImage);
				pirateImageView[i].setX(pirate.getShipLocation().x * scale);
				pirateImageView[i].setY(pirate.getShipLocation().y * scale);
				myPane.getChildren().add(pirateImageView[i]);
				i++;
		}
		
		oceanStage.show();
		startSailing();
	}
	
	private void startSailing(){
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
		// Key event handlers
		@Override
		public void handle(KeyEvent ke) {
			switch(ke.getCode()){
				case RIGHT:
						ship.goEast(myOcean.oceanGrid);
						break;
				case LEFT:
						ship.goWest(myOcean.oceanGrid);
						break;
				case UP:
						ship.goNorth(myOcean.oceanGrid);
						break;
				case DOWN:
						ship.goSouth(myOcean.oceanGrid);
				default:
						break;
			}			
			//Update position for columbus ship
			shipImageView.setX(ship.getShipLocation().x*scale);
			shipImageView.setY(ship.getShipLocation().y*scale);
			int i=0;
			// Update positions for each pirate ship
			for(PirateShip pirate: pirates) {
				pirateImageView[i].setX(pirate.getShipLocation().x*scale);
				pirateImageView[i].setY(pirate.getShipLocation().y*scale);
				i++;
			}
		}
		});
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
