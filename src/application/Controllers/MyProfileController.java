package application.Controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class MyProfileController implements Initializable {

    @FXML
    private AnchorPane panemyprofile;

    @FXML
    private ImageView editicon;

    @FXML
    private Label editlabel;

    @FXML
    private Label backlabel;
    @FXML
    void onBackClicked(ActionEvent event) throws IOException {
    	AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/MainXML.fxml"));
		panemyprofile.getChildren().setAll(pane);
    }

    @FXML
    void onEditClicked(ActionEvent event) throws IOException {
    	AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/editProfile.fxml"));
    	panemyprofile.getChildren().setAll(pane);
    }
 

   




	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	
		}
   
}

		
