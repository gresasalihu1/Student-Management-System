package application.Controllers;
import java.io.IOException;
import java.net.URL;
import javafx.application.Platform;

import javafx.scene.Scene;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class MainEditDelete extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		 URL url = getClass().getResource("EditDeleteUser.fxml");
	        if (url == null) {
	            System.out.println("Can't load FXML file");
	            Platform.exit();
	        }
	        

		
		
	        Parent parent = FXMLLoader.load(url);
	       
	     
	     Scene scene=new Scene(parent);
	   scene.getStylesheets().add("../Css/style.css");
	   
			
			primaryStage.setScene(scene);
			primaryStage.show();
		
	}


	 public static void main(String[] args) {
	 Application.launch(args);
	 }
}
