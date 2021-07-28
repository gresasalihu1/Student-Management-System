package application.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ContactUs implements Initializable{

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView returnbutton;
    @FXML
    private Label headerLabel;
    private ResourceBundle bundle;
    private Locale locale;

    @FXML
    void onReturnClicked(MouseEvent event) throws IOException{

    	if(event.getSource()==returnbutton)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/MainXML.fxml"));
    		anchorPane.getChildren().setAll(pane);
    	}
    }
    public void loadLang(String lang)
    {
    	locale=new Locale(lang);
    	bundle=ResourceBundle.getBundle("application.bundles.lang",locale);
    	headerLabel.setText(bundle.getString("headerLabel_lbl"));

    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ClassForLanguage cl=new ClassForLanguage();
		String language="";
		try {
			language = cl.getLanguage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Alert alert=new Alert(AlertType.ERROR);
			alert.setContentText("Can't choose this language");
			alert.setHeaderText("!");
			alert.show();
		}
		
	}

}
