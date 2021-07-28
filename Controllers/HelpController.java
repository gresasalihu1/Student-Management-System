package application.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class HelpController implements Initializable{

    @FXML
    private ImageView foto2id;

    @FXML
    private ImageView foto1id;

    @FXML
    private ImageView leftimg;

    @FXML
    private ImageView rightimg;

    @FXML
    void onLRClick(MouseEvent event) {
    	if(event.getSource()==rightimg)
    	{
    		foto2id.setVisible(true);
    		foto1id.setVisible(false);
    	}
    	else if(event.getSource()==leftimg)
    	{
    		foto1id.setVisible(true);
    		foto2id.setVisible(false);
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		foto2id.setVisible(false);
		
	}

}

