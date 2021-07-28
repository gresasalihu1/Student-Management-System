package application.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class editProfileController implements Initializable {
    
    @FXML
    private AnchorPane panemyprofileedit;
    @FXML
    private Label backlabel;
    @FXML
    void onBackClicked(MouseEvent event) throws IOException {
    	AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/myprofile.fxml"));
    	panemyprofileedit.getChildren().setAll(pane);
    }
    @FXML
    void NdryshoAdresen(ActionEvent event) throws IOException {
    	Stage primaryStage=new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("../Fxmls/NdryshoAdresen.fxml"));
		Scene scene=new Scene(root,648,194);

		primaryStage.setTitle("Ndrysho Adresen");
		primaryStage.setScene(scene);
		primaryStage.show();
    
    }

    @FXML
    void NdryshoEmailAdresen(ActionEvent event) throws IOException {
    	
    	Stage primaryStage=new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("../Fxmls/NdryshoEmailAdresen.fxml"));
		Scene scene=new Scene(root,648,194);

		primaryStage.setTitle("Ndrysho Email Adresen");
		primaryStage.setScene(scene);
		primaryStage.show();
    }

    @FXML
    void NdryshoFjalekalimin(ActionEvent event) throws IOException {
    	Stage primaryStage=new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("../Fxmls/NdryshoFjalekalimin.fxml"));
		Scene scene=new Scene(root,648,230);

		primaryStage.setTitle("Ndrysho Fjalekalimin");
		primaryStage.setScene(scene);
		primaryStage.show();
    	
    }

    @FXML
    void NdryshoNumrinETelefonit(ActionEvent event) throws IOException {

    	Stage primaryStage=new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("../Fxmls/NdryshoNumrinETelefonit.fxml"));
		Scene scene=new Scene(root,648,194);

		primaryStage.setTitle("Ndrysho Numrin E Telefonit");
		primaryStage.setScene(scene);
		primaryStage.show();
    	
    }
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
