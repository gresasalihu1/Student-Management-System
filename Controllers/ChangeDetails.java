package application.Controllers;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ChangeDetails { 
	//jo linda e ka shtu
	@FXML
	private TextField NdryshoAdresen;
    @FXML
    private AnchorPane panemyprofileedit;

    @FXML
    private Label backlabel;

	@FXML
	private TextField NderroNumrin;

	@FXML
	private TextField EmailIri;

	@FXML //j
	void RuajEmailAdresen(ActionEvent event) {
		try {
			Connection connection= DatabaseConnection.startConnection();

			//Merre perdoruesin nga Profili
			String perdoruesi=getId();
			String emailIRi=EmailIri.getText();
			String sql ="select * from perdoruesit1 where pid='"+perdoruesi+"'";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if(resultSet.next()) {


				String sql1 = "Update perdoruesit1 set pemail='" +emailIRi 
						+ "' where pid=" + perdoruesi + " ";
				Statement statement1 = connection.createStatement();
				statement1.executeUpdate(sql1);

				Alert alert=new Alert(AlertType.CONFIRMATION) ;
				alert.setContentText("Email Adresa u nderrua me sukses");
				alert.showAndWait();
			}
			else {
				Alert alert=new Alert(AlertType.ERROR) ;
				alert.setContentText("Personi nuk ekziston ne databaze");
				alert.showAndWait();
			}
		}
		catch (Exception e) {

			Alert alert=new Alert(AlertType.ERROR) ;
			alert.setContentText("Error:Gabim gjate nderrimit");
			alert.showAndWait();
		}
	}

	@FXML
	void onBackClicked(MouseEvent event) throws IOException {
		//Shto opsionin per me u kthy te Edit profile
		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/MyProfile.fxml"));
    	panemyprofileedit.getChildren().setAll(pane);
	
	}
	@FXML
	void RuajNumrin(ActionEvent event) {
		try{
			Connection connection= DatabaseConnection.startConnection();
			//Merre perdoruesin nga Profili
			String perdoruesi=getId();
			String NumriIRi=NderroNumrin.getText();
			String sql ="select * from perdoruesit1 where pid='"+perdoruesi+"'";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if(resultSet.next()) {

				String sql1 = "Update studentet1 set stel='" +NumriIRi 
						+ "' where sid=" + perdoruesi + " ";
				Statement statement1 = connection.createStatement();
				statement1.executeUpdate(sql1);
				Alert alert=new Alert(AlertType.CONFIRMATION) ;
				alert.setContentText("Numri i telefonit u nderrua me sukses");
				alert.showAndWait();
			}
			else {
				Alert alert=new Alert(AlertType.ERROR) ;
				alert.setContentText("Personi nuk ekziston ne databaze");
				alert.showAndWait();
			}
		}
		catch (Exception e) {
			Alert alert=new Alert(AlertType.ERROR) ;
			alert.setContentText("Error: Gabim gjate nderrimit");
			alert.showAndWait();
		}
	}
	@FXML
	void RuajAdresen(ActionEvent event) {
		try{
			Connection connection= DatabaseConnection.startConnection();
			//Merre perdoruesin nga Profili
			String perdoruesi=getId();
			String AdresaERe=NdryshoAdresen.getText();
			String sql ="select * from perdoruesit1 where pid='"+perdoruesi+"'";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			if(resultSet.next()) {

				String sql1 = "Update studentet1 set sadresa='" +AdresaERe 
						+ "' where sid=" + perdoruesi + " ";
				Statement statement1 = connection.createStatement();

				statement1.executeUpdate(sql1);
				Alert alert=new Alert(AlertType.CONFIRMATION) ;
				alert.setContentText("Adresa u nderrua me sukses");
				alert.showAndWait();
			}
			else {
				Alert alert=new Alert(AlertType.ERROR) ;
				alert.setContentText("Personi nuk ekziston ne databaze");
				alert.showAndWait();
			}
		}
		catch (Exception e) {
			Alert alert=new Alert(AlertType.ERROR) ;
			alert.setContentText("Error: Gabim gjate ndryshimit");
			alert.showAndWait();
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
			Alert alert=new Alert(AlertType.ERROR);
			alert.setContentText("Gabim gjate skanimit");
			alert.showAndWait();
		}
		return ss;
	}
}







