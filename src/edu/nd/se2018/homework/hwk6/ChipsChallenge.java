package edu.nd.se2018.homework.hwk6;




import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import edu.nd.se2018.homework.hwk6.levels.Key;
import edu.nd.se2018.homework.hwk6.levels.Monster;
import edu.nd.se2018.homework.hwk6.levels.Gate;
public class ChipsChallenge extends Application {
	
	// Scene and Stage
	AnchorPane myPane;
	Scene scene;
	LevelMap myMap;
	Player player;
	
	final Canvas canvas = new Canvas(5000,5000);
	
	
	// Imageviews
	ImageView playerImageView;
	int scale = 35;
	int currentLevel = 1;
	long updates=0;
	
	@Override
	public void start(Stage levelStage) throws Exception {
		myPane = new AnchorPane();
		scene = new Scene(myPane,900,900);
		myMap= new LevelMap();
		player = new Player(12,18);
		myMap.drawMap(myPane.getChildren(), currentLevel, player);
		levelStage.setScene(scene);
		levelStage.setTitle("Chips Challenge");
		
	

		// Set player sprite image
		Image playerImage = new Image("images\\chip\\textures\\chipDown.png",34,34,true,true);
		playerImageView = new ImageView(playerImage);
		playerImageView.setX(player.getPlayerLocation().x * scale);
		playerImageView.setY(player.getPlayerLocation().y * scale);
		myPane.getChildren().add(playerImageView);
		
		
		levelStage.show();
		startGame();
	}
	public void reset() {
		myMap= new LevelMap();
		player = new Player(4,4);
		myMap.drawMap(myPane.getChildren(), currentLevel, player);
		
		Image playerImage = new Image("images\\chip\\textures\\chipDown.png",34,34,true,true);
		playerImageView = new ImageView(playerImage);
		playerImageView.setX(4 * scale);
		playerImageView.setY(4 * scale);
		myPane.getChildren().add(playerImageView);
	}

	
	private void startGame(){
		
		new AnimationTimer() {
			
			@Override
			public void handle(long now) {
		
				// Pick Up Keys
				for(Key key: myMap.keys) {
					if(key.acquired==1 && (player.currentLocation.x!=key.X || player.currentLocation.y!=key.Y)) {
						Image blankImage = new Image("images\\chip\\textures\\BlankTile.png",35,35,true,true);
						ImageView tileImageView = new ImageView(blankImage);
						tileImageView.setX(key.X * 35);
						tileImageView.setY(key.Y * 35);
						myPane.getChildren().add(tileImageView);
						myMap.levelGrid[key.X][key.Y] = 0;
					}
					if(key.acquired==1 && key.rigged) {
						// If Died reset
						System.out.println("You Died: Choose Wisely....");
						reset();
					}
					
				}
				// Gate Control
				for(Gate gate: myMap.gates) {
					if(!gate.locked) {
						myMap.levelGrid[gate.X][gate.Y] = 0;
					}
					
					
				}
			
			    updates++;
				// Move Enemies
		    	for(Monster monster: myMap.monsters) {
		    		 if(updates>=8) {
		    			 monster.Move(myPane.getChildren());
		    		 }
		    		 if(player.currentLocation.x==monster.X&&player.currentLocation.y==monster.Y) {
		    			 player.killed=true;
		    			 System.out.println("You Died: Watch out for Demon Frogs!....");
		    		 }
					
				}
		    	if(updates>=8) {
	    			updates=0;
	    		 }
		    	
			    // Check if player steps on monster
			   
				
				// Check Game Win/Lose Condition
				if(player.killed || player.nextLevel==1) {
					if(!player.killed)
						currentLevel++;
					if(player.nextLevel==1 && currentLevel>2 ) {
						GraphicsContext gc   = canvas.getGraphicsContext2D();
						gc.setStroke(Color.GREEN);
						gc.setFill(Color.RED);
						gc.setFont(Font.font("Arial", FontWeight.BOLD, 80));
						gc.fillText("YOU WON!", 250,350);
						myPane.getChildren().add(canvas);
						this.stop();
					}
					else {
						reset();
					}
					
				}
					
			}
			
		
			
			
		}.start();
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
		// Key event handlers
			
			
			
		// Player Movement and Key Handling
		@Override
		public void handle(KeyEvent ke) {
			switch(ke.getCode()){
				case RIGHT:
						player.goRight(myMap.levelGrid);
						Image playerImage = new Image("images\\chip\\textures\\chipRight.png",34,34,true,true);
						myPane.getChildren().remove(playerImageView);
						playerImageView = new ImageView(playerImage);
						playerImageView.setX(player.getPlayerLocation().x * scale);
						playerImageView.setY(player.getPlayerLocation().y * scale);
						myPane.getChildren().add(playerImageView);
						break;
				case LEFT:
						player.goLeft(myMap.levelGrid);
						myPane.getChildren().remove(playerImageView);
						playerImage = new Image("images\\chip\\textures\\chipLeft.png",34,34,true,true);
						playerImageView = new ImageView(playerImage);
						playerImageView.setX(player.getPlayerLocation().x * scale);
						playerImageView.setY(player.getPlayerLocation().y * scale);
						myPane.getChildren().add(playerImageView);
						break;
				case UP:
						player.goUp(myMap.levelGrid);
						myPane.getChildren().remove(playerImageView);
						playerImage = new Image("images\\chip\\textures\\chipUp.png",34,34,true,true);
						playerImageView = new ImageView(playerImage);
						playerImageView.setX(player.getPlayerLocation().x * scale);
						playerImageView.setY(player.getPlayerLocation().y * scale);
						myPane.getChildren().add(playerImageView);
						break;
				case DOWN:
						player.goDown(myMap.levelGrid);
						myPane.getChildren().remove(playerImageView);
						playerImage = new Image("images\\chip\\textures\\chipDown.png",34,34,true,true);
						playerImageView = new ImageView(playerImage);
						playerImageView.setX(player.getPlayerLocation().x * scale);
						playerImageView.setY(player.getPlayerLocation().y * scale);
						myPane.getChildren().add(playerImageView);
						break;
				case ESCAPE:
						Platform.exit();
						break;
				default:
						break;
			}			
			//Update player position
			playerImageView.setX(player.getPlayerLocation().x*scale);
			playerImageView.setY(player.getPlayerLocation().y*scale);
		
		}
		});
		
	}
	

		
	public static void main(String[] args) {
		launch(args);
	}
	
}
