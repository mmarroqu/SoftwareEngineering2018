package edu.nd.se2018.homework.hwk5;

import java.util.ArrayList;
import java.util.Collection;

import edu.nd.sarec.railwaycrossing.model.infrastructure.Direction;
import edu.nd.sarec.railwaycrossing.model.infrastructure.MapBuilder;
import edu.nd.sarec.railwaycrossing.model.infrastructure.RailwayTracks;
import edu.nd.sarec.railwaycrossing.model.infrastructure.Road;
import edu.nd.sarec.railwaycrossing.model.infrastructure.gate.CrossingGate;
import edu.nd.sarec.railwaycrossing.model.vehicles.Car;
import edu.nd.sarec.railwaycrossing.model.vehicles.Train;
import edu.nd.sarec.railwaycrossing.model.vehicles.TrainsPresent;
import edu.nd.sarec.railwaycrossing.view.MapDisplay;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Simulation extends Application{
	
	private Pane root;
	private Scene scene;
	private MapBuilder mapBuilder;
	private MapDisplay mapDisplay;
	private TrainsPresent allTrains;
	private Car previousCar= null;
	@Override  
	public void start(Stage stage) throws Exception {
		
		root = new Pane();
		
		// Build infrastructure
		mapBuilder = new MapBuilder();
		mapDisplay = new MapDisplay(root, mapBuilder.getRoads(), mapBuilder.getTracks(),mapBuilder.getAllGates());					
		mapDisplay.drawTracks();		
		mapDisplay.drawRoad();
		mapDisplay.drawGate();
		
		scene = new Scene(root,1200,1000);
		stage.setTitle("Railways");
		stage.setScene(scene);
		stage.show();
				
		// Train
		RailwayTracks track = mapBuilder.getTrack("Royal");
		Train train = new Train(track.getEndX()+100,track.getEndY()-25, false);
		root.getChildren().add(train.getImageView());
		
		// Second Train
		RailwayTracks secondTrack = mapBuilder.getTrack("Rumble");
		Train secondTrain = new Train(secondTrack.getEndX()-1200,secondTrack.getEndY()-25, true);
		root.getChildren().add(secondTrain.getImageView());
		
		// Add trains to the observable object allTrains
		allTrains = new TrainsPresent(train);
		allTrains.addTrain(secondTrain);
		
		for(CrossingGate gate: mapBuilder.getAllGates()) {
			//train.addObserver(gate);
			//secondTrain.addObserver(gate);
			allTrains.addObserver(gate);
		}
				
		// Sets up a repetitive loop i.e., in handle that runs the actual simulation
		new AnimationTimer(){

			@Override
			public void handle(long now) {
			
				
				transferCars(mapBuilder.roads.get("Western Highway"), mapBuilder.roads.get("EastWest"));
				if(!mapBuilder.roads.get("EastWest").carFactory.carsToMerge.isEmpty())
					remergeCars(mapBuilder.roads.get("EastWest"), mapBuilder.roads.get("Skyway"));
				createCar();
				train.move();
				secondTrain.move();
				// Prompts observer of trains to check if we can close gates
				allTrains.trainCheck();
				
				for(CrossingGate gate: mapBuilder.getAllGates())
					gate.operateGate();
				
				if (train.offScreen())
					train.reset();
				
				if (secondTrain.offScreen())
					secondTrain.reset();
						
				clearCars();				
			}

		
		}.start();
	}
	
	private void transferCars(Road roadFrom, Road roadTo) {
		// Get Cars from East Road
		for(Car car: roadFrom.carFactory.turnedCars) {
			// Append Cars to end of list for eastWest
			root.getChildren().remove(car.getImageView());
			roadTo.carFactory.addCar(car);
			
			// Create Observer Relationship
			if(previousCar!=null)
					previousCar.addObserver(car);
			root.getChildren().add(car.getImageView());
			previousCar=car;
		}
		// Reset the list
		roadFrom.carFactory.turnedCars= new ArrayList<Car>();
		
		
	}
	
	private void remergeCars(Road roadFrom, Road roadTo) {
		Car lastCar = new Car(0,0);

		for(Car car: roadFrom.carFactory.carsToMerge) {
			lastCar=roadTo.carFactory.cars.get(0);
			// Check if first car is before intersection
			//System.out.println(lastCar.currentY);
			if(lastCar.currentY < 750) {
				//System.out.println("can merge");
				car.horizontalMove=false;
				//roadFrom.carFactory.removeCar(car);
				//roadFrom.carFactory.carsToMerge.remove(car);
				//root.getChildren().remove(car.getImageView());
				//roadTo.carFactory.addCar(car);
				//root.getChildren().add(car.getImageView());
				
				
			}
			else {
				//System.out.println(lastCar.currentY);
				//System.out.println("CANT merge");
			}
		}
		
	}
	
	// Clears cars as they leave the simulation
	private void clearCars(){
		Collection<Road> roads = mapBuilder.getRoads();
		for(Road road: roads){			
			if (road.getCarFactory()!= null){
				ArrayList<Car> junkCars = road.getCarFactory().removeOffScreenCars();	
				mapDisplay.removeCarImages(junkCars);
				
			}
		}
	}
	
	private void createCar(){
		Collection<Road> roads = mapBuilder.getRoads();
		for(Road road: roads){
			if (road.getCarFactory() != null){
				if ((int)(Math.random() * 100) == 15 && road.getDirection() != Direction.EAST){
					Car car = road.getCarFactory().buildCar();
					if (car != null){
						root.getChildren().add(car.getImageView());
					}
				}
					
			}
		}
	}
	
	public static void main(String[] args){
		launch(args);
	}
}

