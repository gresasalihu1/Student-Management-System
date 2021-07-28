package application.Controllers;
import java.io.IOException;


import javafx.scene.Scene;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		Parent parent = FXMLLoader.load(getClass().getResource("../Fxmls/login.fxml"));
		//Pane parent=new Pane();
		
		Scene scene=new Scene(parent);
		scene.getStylesheets().add("Css/style.css");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}


	 public static void main(String[] args) {
	 Application.launch(args);
	 }
}

