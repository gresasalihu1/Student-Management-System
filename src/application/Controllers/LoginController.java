package application.Controllers;
import java.awt.Color;
import java.awt.Container;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;

import application.Hashing;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class LoginController implements Initializable{

	@FXML
	private TextField txtusername;

	@FXML
	private PasswordField txtpassword;

	@FXML
    private Text lblStatus;
	@FXML
    private Slider s;
    @FXML
    private TextArea txtarea;
    @FXML
    private Label txtlabel;
    @FXML
    private Button forgetPasswordbutton;
    @FXML
    private Button kyqyButton;
    @FXML
    private ImageView albaniaLang;
    @FXML
    private ImageView englishLang;
    @FXML
    private ImageView refreshImg;
    @FXML
    private AnchorPane anchorPane;
    private ResourceBundle bundle;
    private Locale locale;
    

	Hashing hash = new Hashing();

//Login Control
	public void button(ActionEvent actionEvent) throws SQLException, IOException {
		
		try {
			 
		    Connection connection= DatabaseConnection.startConnection();
			
			String perdoruesi = txtusername.getText().toString();
			String password = txtpassword.getText().toString();
			
			String sql ="select * from perdoruesit1 where pid='"+perdoruesi+"'";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			
			
			if(resultSet.next()) {
				String saltValue=resultSet.getString("psalt");
				System.out.println(saltValue);
				String fjalekalimi=password+saltValue;
				String fjalekalimiHash="";
				fjalekalimiHash=hash.hashString(fjalekalimi, "SHA-1");
				System.out.println(fjalekalimiHash);
				if(perdoruesi.equals(resultSet.getString("pid")) && fjalekalimiHash.equals(resultSet.getString("pfjalekalimi"))) {
					if(resultSet.getString("ptipi").equals("s")) {
						setId(perdoruesi);
						AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/MainXML.fxml"));
			    		anchorPane.getChildren().setAll(pane);
						
					}
					else if(resultSet.getString("ptipi").equals("r")) {
						setId(perdoruesi);
						AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/MainXML.fxml"));
			    		anchorPane.getChildren().setAll(pane);
					}
				}
				else {
					lblStatus.setText("Gabim ,, te perdoruesi ose fjalekalimi");
				}
			}
			else 
			{
				
				 lblStatus.setText("Gabim , te perdoruesi ose fjalekalimi");
			}
			}
		 catch (Exception e) {
			
			 
			Alert failAlert = new Alert(Alert.AlertType.ERROR);
			failAlert.setTitle("Gabim:Lidhja me databaze deshtoi");
			failAlert.setContentText("Ju lutem provoni perseri me vone");
			failAlert.setHeaderText(null);
			failAlert.showAndWait();
			
		}

	}
	public void setId(String ss) throws FileNotFoundException
	{
		File file=new File("forid.txt");
		//String ss=s;
		PrintWriter print=new PrintWriter(file);
		print.println(ss);
		print.close();
	}

	//Forgot Password
	@FXML
    public void button1(ActionEvent event) throws IOException {
		Stage primaryStage=new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("../Fxmls/ForgotPassword.fxml"));
		Scene scene=new Scene(root,330,500);

		primaryStage.setTitle("Reseto Fjalekalimin");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	 public void loadLang(String lang)
	    {
	    	locale=new Locale(lang);
	    	bundle=ResourceBundle.getBundle("application.bundles.lang",locale);
	    	txtusername.setPromptText(bundle.getString("txtusername"));
	    	txtpassword.setPromptText(bundle.getString("txtpassword"));
	    	kyqyButton.setText(bundle.getString("kyqyButton"));
	    	forgetPasswordbutton.setText(bundle.getString("forgetPasswordbutton"));

	    		
		}
	 public void lang() {
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
			if(language.equals("en")){
				loadLang("en");

			}
	 }
	 	@FXML
	 	void onSettingsClicked(MouseEvent event) throws IOException {

	    	if(event.getSource()==englishLang)
	    	{
	    		File file=new File("forlang.txt");
	    		String ss="en";
	    		PrintWriter print=new PrintWriter(file);
	    		print.println(ss);
	    		print.close();
	    		refreshImg.setVisible(true);
	    	}
	    	else if(event.getSource()==albaniaLang)
	    	{
	    		File file=new File("forlang.txt");
	    		String ss="al";
	    		PrintWriter print=new PrintWriter(file);
	    		print.println(ss);
	    		print.close();
	    		refreshImg.setVisible(true);
	    	}
	    	else if(event.getSource()==refreshImg)
	    	{
	    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/login.fxml"));
	    		anchorPane.getChildren().setAll(pane);
	    	}
	 	}
	@Override
	public void initialize(java.net.URL arg0, ResourceBundle arg1) {
		refreshImg.setVisible(false);
		lang();
		
	}
		
		
	}

		
		
	
