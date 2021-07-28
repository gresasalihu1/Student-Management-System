package application;

import java.util.Properties;


import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Mailer {

	
public static void send(String from,String password,String to,String sub,String msg){  
 
          //Get properties object    
          Properties props = new Properties(); 
          props.put("mail.smtp.user", from); 
          props.put("mail.smtp.host", "smtp.gmail.com");
          props.put("mail.smtp.port", "465"); 
          props.put("mail.smtp.starttls.enable", "true"); 
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
             
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
          });    
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(sub);    
           message.setFrom(new InternetAddress(from));
           message.setContent(msg,"text/html; charset=utf-8");    
           Transport.send(message);   
       	Alert successalert=new Alert(AlertType.CONFIRMATION);
		successalert.setTitle("Procesi shkoj me sukses");
		successalert.setContentText("Email u dergua me sukses");
		successalert.setHeaderText(null);
		successalert.showAndWait();
          } catch (Exception e) {
        
        	    Alert failAlert = new Alert(Alert.AlertType.ERROR);
				failAlert.setTitle("Error gjate dergimit te email");
				failAlert.setContentText("Ju lutem provoni perseri");
				failAlert.setHeaderText(null);
				failAlert.showAndWait();
				
          }    
             
}
}
 
	
	