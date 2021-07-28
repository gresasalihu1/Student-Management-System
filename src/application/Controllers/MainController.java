package application.Controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class MainController implements Initializable {

	
	
    @FXML
    private AnchorPane anchorMain;
    @FXML
    private Label registerStudents1;

    @FXML
    private Label searchStudents1;

    @FXML
    private Label reportStudents1;

    @FXML
    private Label semesterStudents1;

    @FXML
    private Label registerSemester1;

    @FXML
    private Label homeLabel;
    @FXML
    private ImageView contact1;

    @FXML
    private ImageView settingsHelp1;

    @FXML
    private ImageView sendMessage1;

    @FXML
    private Label editmyProfile1;

    @FXML
    private Label registerStudentsmain1;

    @FXML
    private Label contactMain1;

    @FXML
    private Label ReportStudentsMain1;

    @FXML
    private Label searchStudentsMain1;

    @FXML
    private Label registerSemesterMain1;
    @FXML
    private Label studentet;
    @FXML
    private Label manageLabel;
    @FXML
    private Label sendMessageMain1;
    
    @FXML
    private Label logoutLabel;
    
    @FXML
    private Text textforclock;
    @FXML
    private Text textforclock1;
    @FXML
    private Text textforLanguage;
    private ResourceBundle bundle;
    private Locale locale;
  

    
    @FXML
    void fxmlChanges(MouseEvent event) throws IOException {
    	if(event.getSource()==editmyProfile1)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/MyProfile.fxml"));
    		anchorMain.getChildren().setAll(pane);

    	}
    	else if(event.getSource()==registerSemester1 || event.getSource()==registerSemesterMain1)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/fx.fxml"));
    		anchorMain.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==reportStudents1 || event.getSource()==ReportStudentsMain1)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/raport.fxml"));
    		anchorMain.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==searchStudents1 || event.getSource()==searchStudentsMain1)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/EditDeleteUser.fxml"));
    		anchorMain.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==registerStudentsmain1 || event.getSource()==registerStudents1)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/studentregister.fxml"));
    		anchorMain.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==sendMessageMain1 || event.getSource()==sendMessage1)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/WriteMessage.fxml"));
    		anchorMain.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==contact1 || event.getSource()==contactMain1)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/ContactUs.fxml"));
    		anchorMain.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==settingsHelp1)
    	{
    		Stage stage=new Stage();
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/settings.fxml"));
    		stage.setScene(new Scene(pane));
    		stage.show();
    	}
    	else if(event.getSource()==textforLanguage)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/MainXML.fxml"));
    		anchorMain.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==logoutLabel)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/login.fxml"));
    		anchorMain.getChildren().setAll(pane);
    	}
	
    }
    public void loadLang(String lang)
    {
    	locale=new Locale(lang);
    	bundle=ResourceBundle.getBundle("application.bundles.lang",locale);
    	homeLabel.setText(bundle.getString("homeLabel_lbl_main"));
    	studentet.setText(bundle.getString("studentet_lbl_main"));
    	registerStudents1.setText(bundle.getString("regjistro_lbl_main"));
    	searchStudents1.setText(bundle.getString("kerko_edito_lbl_main"));
    	reportStudents1.setText(bundle.getString("raporte_lbl_main"));
    	semesterStudents1.setText(bundle.getString("semestri_lbl_main"));
    	registerSemester1.setText(bundle.getString("regjistro_sms_lbl_main"));
    	editmyProfile1.setText(bundle.getString("editoprofilin_lbl_main"));
    	logoutLabel.setText(bundle.getString("logoutLabel_main"));
    	
    	
    	manageLabel.setText(bundle.getString("systemlabel_main"));
    	registerStudentsmain1.setText(bundle.getString("regjistro1_lbl_main"));
    	contactMain1.setText(bundle.getString("contact_lbl_main"));
    	ReportStudentsMain1.setText(bundle.getString("raporte1_lbl_main"));
    	searchStudentsMain1.setText(bundle.getString("kerko1_edito_lbl_main"));
    	registerSemesterMain1.setText(bundle.getString("regjistro_sms_lbl_main"));
    	sendMessageMain1.setText(bundle.getString("sendmessage_lbl_main"));
    	
    	
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		DataTani();
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


	private void DataTani() {
		Timer timer = new Timer();
		//LocalDateTime datetime1;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
            	LocalDateTime date = LocalDateTime.now();  
            	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
                textforclock.setText("Data: "+date.format(format).toString());
            }
        }, 0, 1000);
		
	}
	



}
