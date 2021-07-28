package application.Controllers;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import application.Hashing;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChangePasswordController {
	Hashing hash = new Hashing();
    @FXML
    private TextField FjalekalimiiVjeter;

    @FXML
    private TextField Fjalekalimiiri;

    @FXML
    private TextField KonfirmoFjalekalimin;
    @FXML
    private Text errorlabel;
    @FXML
    void onBackClicked(MouseEvent event) throws IOException {
    	//AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/MyProfile.fxml"));
    	//Kalo Te Profili
    }
    
    
    @FXML
    void RuajFjalekalimin(ActionEvent event) throws IOException {
    String FVjeter=FjalekalimiiVjeter.getText();
    String fiRi=FjalekalimiiVjeter.getText();
    String FKonfirm=FjalekalimiiVjeter.getText();
    
    Connection connection= DatabaseConnection.startConnection();
	//Merre perdoruesin nga Profili
	String perdoruesi=getId();
	try {
	String sql ="select * from perdoruesit1 where pid='"+perdoruesi+"'";
	Statement statement = connection.createStatement();
	ResultSet resultSet = statement.executeQuery(sql);
	

	if(resultSet.next()) {
		String saltValue=resultSet.getString("psalt");
		
		String fjalekalimi=FVjeter+saltValue;
		String fjalekalimiHash="";
		fjalekalimiHash=hash.hashString(fjalekalimi, "SHA-1");
		
		if(perdoruesi.equals(resultSet.getString("pid")) && fjalekalimiHash.equals(resultSet.getString("pfjalekalimi"))) {
			if(fiRi.equals(FKonfirm)) {
				// Gjenerimi i salted hash
				String saltValue1 = hash.saltGenerator();
				String fjalekalimi1 = fiRi + saltValue1;
				String fjalekalimiHash1="";
				fjalekalimiHash1 = hash.hashString(fjalekalimi1, "SHA-1");
				String sql1 = "Update perdoruesit1 set pfjalekalimi='" + fjalekalimiHash1 + "',psalt='" + saltValue1
						+ "' where pid=" + perdoruesi + " ";
				Statement statement1 = connection.createStatement();

				statement1.executeUpdate(sql1);
				Alert alert=new Alert(AlertType.CONFIRMATION) ;
				alert.setContentText("Fjalekalimi eshte ndryshuar");
				alert.showAndWait();

			}
			else {
				errorlabel.setText("Fjalekalimet nuk perputhen");
			}}
		else {
			errorlabel.setText("Fjalekalimi i pasakte");
			}
	}
		
    else {
			Alert alert=new Alert(AlertType.ERROR) ;
			alert.setContentText("Personi nuk ekziston ne databaze");
			alert.showAndWait();
			
		}
	}
    catch (Exception e) {
    	System.out.println(e);
    /*	Alert alert=new Alert(AlertType.ERROR) ;
		alert.setContentText("Error: Gabim gjate ndryshimit");
		alert.showAndWait();*/
	}
   }
    public String getId() throws IOException{
		
		File file=new File("forid.txt");
		String ss="";
		try
		{
			Scanner scanner=new Scanner(file);
			while(scanner.hasNext())
			{
				ss+=scanner.nextLine();
			}
			//Linda e ka shtu
			scanner.close();
		} 
		catch (Exception e)
		{
			//System.out.println(e.getMessage());
		}
		return ss;
	}
    }
