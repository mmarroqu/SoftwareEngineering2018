package edu.nd.se2018.homework.ColombusGame;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class OceanExplorer extends Application{
	
	AnchorPane myPane = new AnchorPane();
	Scene scene = new Scene(myPane,900,900);
	OceanMap myOcean= new OceanMap();
	Ship ship = new Ship();
	PirateShip pirate = new PirateShip(myOcean.oceanGrid);
	ImageView shipImageView;
	ImageView pirateImageView;
	int scale = 35;
	
	@Override
	public void start(Stage oceanStage) throws Exception {
		
		myOcean.drawMap(myPane.getChildren(), scale);
		oceanStage.setScene(scene);
		oceanStage.setTitle("Colombus Game");
		
		Image shipImage = new Image("images\\ColumbusShip.png",41,41,true,true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(ship.getShipLocation().x * scale);
		shipImageView.setY(ship.getShipLocation().y * scale);
		myPane.getChildren().add(shipImageView);
		
		Image pirateImage = new Image("images\\pirateship.gif",41,41,true,true);
		pirateImageView = new ImageView(pirateImage);
		pirateImageView.setX(pirate.getShipLocation().x * scale);
		pirateImageView.setY(pirate.getShipLocation().y * scale);
		myPane.getChildren().add(pirateImageView);
		
		ship.addObserver(pirate);
		
		oceanStage.show();
		startSailing();
	}
	
	private void startSailing(){
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
		
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
			}			shipImageView.setX(ship.getShipLocation().x*scale);
			shipImageView.setY(ship.getShipLocation().y*scale);
			pirateImageView.setX(pirate.getShipLocation().x*scale);
			pirateImageView.setY(pirate.getShipLocation().y*scale);
			}
		});
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
