package edu.nd.se2018.homework.hwk6;




import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class chipsChallenge extends Application {
	
	// Scene and Stage
	AnchorPane myPane = new AnchorPane();
	Scene scene = new Scene(myPane,900,900);
	levelMap myMap= new levelMap();
	Player player = new Player();

	
	// Imageviews
	ImageView playerImageView;
	int scale = 35;
	
	
	@Override
	public void start(Stage levelStage) throws Exception {
		
		myMap.drawMap(myPane.getChildren(), scale);
		levelStage.setScene(scene);
		levelStage.setTitle("Colombus Game");
		
		// Set image for columbus ship
		
		Image playerImage = new Image("images\\chip\\textures\\chipDown.png",34,34,true,true);
		playerImageView = new ImageView(playerImage);
		playerImageView.setX(player.getPlayerLocation().x * scale);
		playerImageView.setY(player.getPlayerLocation().y * scale);
		myPane.getChildren().add(playerImageView);
		
		
		levelStage.show();
		startSailing();
	}

	
	private void startSailing(){
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
		// Key event handlers
		@Override
		public void handle(KeyEvent ke) {
			switch(ke.getCode()){
				case RIGHT:
						player.goRight(myMap.oceanGrid);
						Image playerImage = new Image("images\\chip\\textures\\chipRight.png",34,34,true,true);
						myPane.getChildren().remove(playerImageView);
						playerImageView = new ImageView(playerImage);
						playerImageView.setX(player.getPlayerLocation().x * scale);
						playerImageView.setY(player.getPlayerLocation().y * scale);
						myPane.getChildren().add(playerImageView);
						break;
				case LEFT:
						player.goLeft(myMap.oceanGrid);
						myPane.getChildren().remove(playerImageView);
						playerImage = new Image("images\\chip\\textures\\chipLeft.png",34,34,true,true);
						playerImageView = new ImageView(playerImage);
						playerImageView.setX(player.getPlayerLocation().x * scale);
						playerImageView.setY(player.getPlayerLocation().y * scale);
						myPane.getChildren().add(playerImageView);
						break;
				case UP:
						player.goUp(myMap.oceanGrid);
						myPane.getChildren().remove(playerImageView);
						playerImage = new Image("images\\chip\\textures\\chipUp.png",34,34,true,true);
						playerImageView = new ImageView(playerImage);
						playerImageView.setX(player.getPlayerLocation().x * scale);
						playerImageView.setY(player.getPlayerLocation().y * scale);
						myPane.getChildren().add(playerImageView);
						break;
				case DOWN:
						player.goDown(myMap.oceanGrid);
						myPane.getChildren().remove(playerImageView);
						playerImage = new Image("images\\chip\\textures\\chipDown.png",34,34,true,true);
						playerImageView = new ImageView(playerImage);
						playerImageView.setX(player.getPlayerLocation().x * scale);
						playerImageView.setY(player.getPlayerLocation().y * scale);
						myPane.getChildren().add(playerImageView);
				default:
						break;
			}			
			//Update position for columbus ship
			playerImageView.setX(player.getPlayerLocation().x*scale);
			playerImageView.setY(player.getPlayerLocation().y*scale);
		
		}
		});
		
	}
	

		
	public static void main(String[] args) {
		launch(args);
	}
	
}
