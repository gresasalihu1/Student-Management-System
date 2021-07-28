package application.Controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.text.StyledEditorKit.BoldAction;

import com.itextpdf.text.Font.FontStyle;
//import com.sun.glass.ui.Size;
import com.sun.mail.imap.Rights.Right;

import application.Mailer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class WriteMessageControl implements Initializable {
	 @FXML
	    private AnchorPane anchorPane;
	@FXML
	private ColorPicker colorpicker;
	@FXML
	private Slider TextSizeSlider;
	@FXML
	private Text mytext;
	@FXML
	private TextArea textarea;
	@FXML
    private ImageView returnbutton;

	@FXML
	private Button dergo;
	
	 @FXML
	 void onReturnClicked(MouseEvent event) throws IOException {
		 if(event.getSource()==returnbutton)
	    	{
	    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/MainXML.fxml"));
	    		anchorPane.getChildren().setAll(pane);
	    	}
	    }
	@FXML
	void changecolor(ActionEvent event) {
		Color c = colorpicker.getValue();
		mytext.setFill(c);

		int color = colorpicker.getValue().hashCode();
		String c2 = Integer.toHexString(color);

		textarea.setStyle("-fx-background-color: #" + c2);
		dergo.setStyle("-fx-background-color: #" + c2);

	}

	@FXML
	void dergo(ActionEvent event) {
		try{Mailer.send("linndaimmeri@gmail.com", "Go#Google312", "linndaimmeri@gmail.com", "", textarea.getText());
		textarea.setText("");}
		catch (Exception e) {
			
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	void SetCenter(MouseEvent event) {
		mytext.setTextAlignment(TextAlignment.CENTER);
	}

	@FXML
	void BoldText(MouseEvent event) {
		mytext.setStyle("-fx-font-style:" + FontWeight.BOLD);
	}

	@FXML
	void SetLeft(MouseEvent event) {
		mytext.setTextAlignment(TextAlignment.LEFT);
	}

	@FXML
	void SetRight(MouseEvent event) {
		mytext.setTextAlignment(TextAlignment.RIGHT);
	}

	@FXML
	void italicText(MouseEvent event) {
		mytext.setStyle("-fx-font-style:" + FontStyle.ITALIC);
	}

	@FXML
	void underline(MouseEvent event) {
		mytext.setStyle("-fx-font-style:" + FontStyle.UNDERLINE);
	}

	@FXML
	void ChangeTextSize(MouseEvent event) {
		double vlera = TextSizeSlider.getValue();
		textarea.setStyle("-fx-font-size:" + vlera);

	}

}
