package application.Controllers;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.BreakIterator;

import javax.swing.JOptionPane;

//import com.sun.prism.paint.Stop;

import application.Hashing;
import application.Mailer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ForgotPasswordController {
	@FXML
	private TextField EmailCode;

	@FXML
	private PasswordField NewPassword;

	@FXML
	private PasswordField NewPasswordConfirm;
	@FXML
	private TextField id;
	@FXML
	private Text ErrorText;
	@FXML
	private Text ErrorText1;
	

	Connection connection= DatabaseConnection.startConnection();

	PreparedStatement pst = null;
	boolean email = false;

	@FXML
	public void PranoEmail(ActionEvent event) {
		String hash = "";
		String emailAddress = "";
		String UserID = id.getText();
		if (UserID.equals("")) {
			ErrorText.setText("Ju duhet te shkruani id tuaj fillimisht");
		} 
		else {
			ErrorText.setText("");
			try {
				
				String sql = "Select * from perdoruesit1 where pid=" + id.getText() + "";
				Statement pst = connection.createStatement();
				ResultSet res = pst.executeQuery(sql);
				while (res.next()) {
					hash = res.getString("pfjalekalimi");
					emailAddress = res.getString("pemail");
				}

				pst.close();
				if (hash.equals("")) {
				
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setContentText("Perdoruesi nuk ekziston! ");
					alert.showAndWait();
				} 
				else {
					try {
						Mailer.send("linndaimmeri@gmail.com", "Go#Google312",emailAddress , "Reset Password",
								"<div>	\r\n"
										+ "<img src=\"https://preview.ibb.co/enfhY8/UP.gif\" style=\"float: left;\">\r\n"
										+ "<h1 style=\"padding-top:50 \">Sistemi Për Menaxhimin e Studentëve (SPMS)</h1>\r\n"
										+ "</div>\r\n" + "\r\n"
										+ "<div style=\"margin-top: 200px; margin-left: 200px;\">\r\n"
										+ "<h3 style=\"font-weight: bold;\">I/e nderuar ju keni bërë kërkesë për ndërrim të fjalëkalimit</h3>\r\n"
										+ "</div>\r\n" + "\r\n"
										+ "<div style=\" margin-top: 50px; margin-left: 200px;\">\r\n"
										+ "Kodi juaj:<h3 style=\"color: blue;border-bottom:1px solid gray; text-align: center; display: inline; margin-left:50px;\">"
										+ hash + "</h3>\r\n" + "</div>\r\n" + "\r\n"
										+ "<div style=\" margin-top: 200px; margin-left: 50px;\">\r\n"
										+ "<p style=\"font-style: italic;\">Ky është email i automatizuar, ju lutemi të mos ktheni përgjigje.</p>\r\n"
										+ "  <p style=\"font-style: italic;\"> SPMS, Universiteti i Prishtinës \"Hasan Prishtina\" </p>\r\n"
										+ "</div>");
						email = true;
						
					
					} catch (Exception e) {
						Alert failAlert = new Alert(Alert.AlertType.ERROR);
						failAlert.setTitle("Error gjate dergimit te email");
						failAlert.setContentText("Ju lutem provoni perseri");
						failAlert.setHeaderText(null);
						failAlert.showAndWait();
					}
				}
			} catch (Exception e) {
				Alert failAlert = new Alert(Alert.AlertType.ERROR);
				failAlert.setTitle("Gabim:Lidhja me databaze deshtoi");
				failAlert.setContentText("Ju lutem provoni perseri me vone");
				failAlert.setHeaderText(null);
				failAlert.showAndWait();
			}
		}
	}

	@FXML
	// Butoni Reset Password
	void Reset(ActionEvent event) {

		Hashing h = new Hashing();
		String fjalekalimi = "";
		String salt = "";
		if (email == true) {
			fjalekalimi = NewPassword.getText();
			salt = h.saltGenerator();
			fjalekalimi = fjalekalimi + salt;
			fjalekalimi = h.hashString(fjalekalimi, "SHA-1");
			String eCode = EmailCode.getText();
			String nPass = NewPassword.getText();
			String cPass = NewPasswordConfirm.getText();

			String userHash = "";
			try {
				String sql = "Select * from perdoruesit1 where pid=" + id.getText() + "";
				Statement pst = connection.createStatement();
				ResultSet res = pst.executeQuery(sql);
				
				while (res.next()) {
					userHash = res.getString("pfjalekalimi");
				}
			} catch (Exception e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Error gjate insertimit ne databaze!");
			}
			if (eCode.equals("") || nPass.equals("") || cPass.equals("")) {
				ErrorText.setText("Ju lutem plotesoni te gjitha fushat");
			} else if (!eCode.equals(userHash) && !eCode.equals("")) {
				ErrorText.setText("Kodi nuk perputhet");
			} else if (!nPass.equals(cPass)) {
				ErrorText.setText("Fjalekalimet nuk perputhen");
			}

			else {
				try {
					String sql = "Update perdoruesit1 set pfjalekalimi='" + fjalekalimi + "',psalt='" + salt
							+ "' where pid=" + id.getText() + " ";
					
					
					pst = connection.prepareStatement(sql);
					pst.execute();
					pst.close();
					
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setContentText("Fjalekalimi eshte ndryshuar");
					alert.showAndWait();
					
					EmailCode.setText("");
					NewPassword.setText("");
					NewPasswordConfirm.setText("");
					ErrorText.setText("");

				} catch (Exception e) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setContentText("Gabim gjate insertimit");
					alert.showAndWait();
				}

			}

		}

		else {
			ErrorText1.setText("Ju duhet te pranoni se pari emailin me kod");
		}
	}

	@FXML
	void button(ActionEvent event) throws IOException {
		Stage stage=new Stage();
		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/login.fxml"));
		stage.setScene(new Scene(pane));
		stage.show();
	}
}
