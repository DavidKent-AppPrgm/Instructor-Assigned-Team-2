package application;

import javafx.application.Application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

/*
 * Purpose:
 * 	
 * Parameters:
 * 	
 * Returns:
 * 	
 * Notes:
 * 	
 */
/**
 * Main class is a subclass of Application that launches the application.
 * @author 
 *
 */
public class Main extends Application {

	@Override
	/**
	 * Creates the stage and loads the initial scene.
	 */
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("view/Login.fxml"));
			Scene scene = new Scene(root,800,800);
			scene.getStylesheets().add(getClass().getResource("view/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}