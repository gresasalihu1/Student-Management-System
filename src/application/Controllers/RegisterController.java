package application.Controllers;
import javafx.event.ActionEvent;


import javafx.scene.control.Alert;
import java.io.File;
import java.io.FileFilter;
import java.net.MalformedURLException;
import java.nio.file.Path;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.plaf.OptionPaneUI;


import application.Hashing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import com.mysql.jdbc.Statement;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegisterController{

	Hashing hash=new Hashing();

	ObservableList <String> shtetiList=FXCollections.observableArrayList("Kosove","Shqiperi","Mali i Zi","Maqedoni");
ObservableList<String> drejtimiList=FXCollections.observableArrayList("Automatikë e Kompjuterizuar dhe Robotikë","Elektroenergjetikë","Elektronikë"," Inxhinieri Kompjuterike","Telekomunikacion");
ObservableList<String> niveliList=FXCollections.observableArrayList("Bachelor","Master","Doktoraturë");
ObservableList<String> fakultetiList=FXCollections.observableArrayList("Fakulteti i Inxhinierisë Elektrike dhe Kompjuterike");
ObservableList<String> kosoveList=FXCollections.observableArrayList("Deçan","Sharr",	"Hani i Elezit",	
"Ferizaji","Gjakovë","Gjilan",	"Drenas",	"Graçanica","Burimi	","Juniku	","Kaçaniku","Dardana",	"Klina",	"Kllokot",	
"Fushë Kosovë",	"Albanik","Lipjani",	"Malishevë","Mamushë","Mitrovicë","Artana",	"Kastriot",	"Rahovec",
"Parteshi","Pejë",	"Prishtinë","Prizreni",	"Besiana",	"Ranillugu",	"Skënderaj",	
"Shtërpca",	"Shtime",	"Therandë",	"Viti",	"Vushtrri"	,"Zubin Potok","Zveçan");

ObservableList<String> shqiperiList=FXCollections.observableArrayList("Tirana	","Durrësi","Shkodra"	,"Elbasani",
"Vlora"	,"Korça"	,"Fieri	","Berati	","Lushnja"	,"Pogradeci	","Laçi"	,"Lezha	",
"Kukësi	","Gjirokastra");
ObservableList<String> maliList=FXCollections.observableArrayList("Andrijevica","Bellopoja","Berana","Budua","Çetina",
	"Danilovgradi","Golluboci","Herceg Novi","Koloshini","Kotorri","Mojkovaci","Nikshiqi","Plava","Plevla","Pluzhina");

	ObservableList<String> maqedoniaList=FXCollections.observableArrayList("Berova","Dellçeva","Koçani","Kamenica",	"Peçeva	",
		"Probishtipi","Shtipi","Vinica");
	@FXML
    private AnchorPane anchorP;

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
    private ImageView contact1;

    @FXML
    private ImageView settingsHelp1;

    @FXML
    private ImageView sendMessage1;

    @FXML
    private Label editmyProfile1;
    @FXML
    private Label logoutLabel;
    @FXML
    private Label homeLabel;
    
    @FXML
    private TextField txtAdresa;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtTel;


    @FXML
    private ComboBox<String> shtetiBox;

    @FXML
    private ComboBox<String> qytetiBox;

    @FXML
    private RadioButton rregullt;

    @FXML
    private ToggleGroup statusi;

    @FXML
    private RadioButton korrespodence;

    @FXML
    private ComboBox<String> fakultetiBox;

    @FXML
    private ComboBox<String> drejtimiBox;

    @FXML
    private ComboBox<String> niveliBox;
	
    @FXML
        private Label mbiemriLabel;	
		
    @FXML
        private Label personalnrLabel;
    @FXML
        private Label gjiniaLabel;	
	
    @FXML
        private Label basicLabel;	
	
    @FXML
        private Label infContactLabel;	
	
    @FXML
        private Label adminiLabel;	
	
    @FXML
        private Label registerLabel;		
		
    @FXML
        private Label shtetiLabel;	
    @FXML
        private Label adresaLabel;

    @FXML
        private Label emailLabel;
	
    @FXML
        private Label qytetiLabel;	
    @FXML
        private Label telLabel;	
    @FXML
        private Label fakultetiLabel;	
    @FXML
        private Label DrejtimiLabel;	
	
    @FXML
        private Label niveliLabel;	
	
    @FXML
        private Label StatusiLabel;	
    @FXML
        private Label nameLabel;	
    @FXML
        private Label prindiLabel;	
    @FXML
        private Label ditlindjaLabel;	


    @FXML
    private RadioButton male;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton female;
    
    @FXML
    private TextField txtEmri;

    @FXML
    private TextField txtPrindi;

    @FXML
    private TextField txtMbiemri;
    @FXML
    private Label studentet;

    @FXML
    private TextField txtPersonalNr;

    @FXML
    private DatePicker txtDitelindja;
    @FXML
    private Text textforLanguage;
    
    @FXML
    private Button btnzgjedhfoto;

    @FXML
    private Button regjistro;

    @FXML
    private ImageView foto;

    
    @FXML
    private Label lblError;
    private ResourceBundle bundle;
    private Locale locale;
    
    @FXML
    private void initialize() {	
    	lang();
		shtetiBox.setValue("Kosove");
        shtetiBox.setItems(shtetiList);
        qytetiBox.setValue("Skenderaj");
        qytetiBox.setItems(kosoveList);
          
    	drejtimiBox.setValue("Automatikë e Kompjuterizuar dhe Robotikë");
    	drejtimiBox.setItems(drejtimiList);
    	niveliBox.setValue("Bachelor");
    	niveliBox.setItems(niveliList);
    	fakultetiBox.setValue("Fakulteti i Inxhinierisë Elektrike dhe Kompjuterike");
    	fakultetiBox.setItems(fakultetiList);	    	   
	     
    }
    
    @FXML
    void fxmlChanges(MouseEvent event) throws IOException {
    if(event.getSource()==editmyProfile1)
    {
    	AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/MyProfile.fxml"));
    	anchorP.getChildren().setAll(pane);
    }
    else if(event.getSource()==registerSemester1)
    {
    	AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/fx.fxml"));
    	anchorP.getChildren().setAll(pane);
    }
    else if(event.getSource()==reportStudents1)
    {
    	AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/raport.fxml"));
    	anchorP.getChildren().setAll(pane);
    }
    else if(event.getSource()==searchStudents1)
    {
    	AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/EditDeleteUser.fxml"));
    	anchorP.getChildren().setAll(pane);
    }
    else if(event.getSource()==registerStudents1)
    {
    	AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/studentregister.fxml"));
    	anchorP.getChildren().setAll(pane);
    }
    else if(event.getSource()==sendMessage1)
    {
    	AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/WriteMessage.fxml"));
    	anchorP.getChildren().setAll(pane);
    }
    else if(event.getSource()==contact1)
    {
    	AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/ContactUs.fxml"));
    	anchorP.getChildren().setAll(pane);
    }
    else if(event.getSource()==logoutLabel)
    {
    	AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/login.fxml"));
    	anchorP.getChildren().setAll(pane);
    }
    else if(event.getSource()==homeLabel)
    {
    	AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/MainXML.fxml"));
    	anchorP.getChildren().setAll(pane);
    }
    else if(event.getSource()==settingsHelp1)
    {
    	Stage stage=new Stage();
    	AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/settings.fxml"));
    	stage.setScene(new Scene(pane));
    	stage.show();
    }
}
   

    @FXML
    private void shtetiCheck() {
    	if(shtetiBox.getValue().equals("Kosove")) {
    		qytetiBox.setValue("Skënderaj");
    		qytetiBox.setItems(kosoveList);
    	}
    	else if(shtetiBox.getValue().equals("Shqiperi")) {
    		qytetiBox.setValue("Tirana");
    		qytetiBox.setItems(shqiperiList);
    	}
    	else if(shtetiBox.getValue().equals("Mali i Zi")) {
    		qytetiBox.setValue("Plava");
    		qytetiBox.setItems(maliList);
    	}
    	else {
    		qytetiBox.setValue("Berova");
    		qytetiBox.setItems(maqedoniaList);
    		
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
    //maini

    homeLabel.setText(bundle.getString("homeLabel_stud"));
    shtetiLabel.setText(bundle.getString("shtetiLabel_stud"));
    adresaLabel.setText(bundle.getString("adresaLabel_stud"));
    emailLabel.setText(bundle.getString("emailLabel_stud"));
    qytetiLabel.setText(bundle.getString("qytetiLabel_stud"));
    telLabel.setText(bundle.getString("telLabel_stud"));
    fakultetiLabel.setText(bundle.getString("fakultetiLabel_stud"));
    DrejtimiLabel.setText(bundle.getString("DrejtimiLabel_stud"));
    niveliLabel.setText(bundle.getString("niveliLabel_stud"));
    rregullt.setText(bundle.getString("ierregulltLabel_stud"));
    korrespodence.setText(bundle.getString("korospodenceLabel_stud"));
    nameLabel.setText(bundle.getString("nameLabel_stud"));
    prindiLabel.setText(bundle.getString("prindiLabel_stud"));
    ditlindjaLabel.setText(bundle.getString("ditlindjaLabel_stud"));
    mbiemriLabel.setText(bundle.getString("mbiemriLabel_stud"));
    personalnrLabel.setText(bundle.getString("personalnrLabel_stud"));
    gjiniaLabel.setText(bundle.getString("gjiniaLabel_stud"));
    male.setText(bundle.getString("mashkullLabel_stud"));
    female.setText(bundle.getString("femerLabel_stud"));
    basicLabel.setText(bundle.getString("basicLabel_stud"));
    infContactLabel.setText(bundle.getString("infContactLabel_stud"));
    adminiLabel.setText(bundle.getString("adminiLabel_stud"));
    regjistro.setText(bundle.getString("registerLabel_stud"));
    btnzgjedhfoto.setText(bundle.getString("btnzgjedhfoto"));
    lblError.setText(bundle.getString("lblError_stud"));
    StatusiLabel.setText(bundle.getString("StatusiLabel_stud"));
    
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

    Image image1;
    @FXML
    void zgjedhFoto() {

        final FileChooser fileChooser = new FileChooser();

        final Button openButton = new Button("Choose Background Image");
            File file = fileChooser.showOpenDialog(null);
            if (file != null) {
             
            	Image image1 = new Image(file.toURI().toString());
                
            	
                ImageView ip = new ImageView(image1);
                
                foto.setImage(image1);
                
                
                
    }
              

    }
    @FXML
    String gender() {
		String gender="null";
		if(male.isSelected()) {
			gender=male.getText();
		}
		else if(female.isSelected()) {
			gender=female.getText();
		}
		return gender;

    }

    
    @FXML
    String statusi() {
		String statusi="null";
		if(rregullt.isSelected()) {
			statusi=rregullt.getText();
		}
		else if(korrespodence.isSelected()) {
			statusi=korrespodence.getText();
		}
		return statusi;

    }



	   @FXML
	    void regjistroStudentet(ActionEvent event)throws SQLException, IOException {

	
		   try {

				Connection connection= DatabaseConnection.startConnection();
				
			   /*
				java.sql.Connection connection=null;
				connection=databaseConnection.startConnection();//
				java.sql.Statement st = connection.createStatement();
				*/
				
				String emri=txtEmri.getText();
				String mbiemri = txtMbiemri.getText();
				String prindi = txtPrindi.getText();
				String nrPersonal = txtPersonalNr.getText();
				String ditelindja =txtDitelindja.getEditor().getText();
				String ditelindja1="mergogr";//masnej kthe nstring qetu
				SingleSelectionModel<String> shteti = shtetiBox.getSelectionModel();
				String shteti1=shteti.getSelectedItem();
				SingleSelectionModel<String> qyteti = qytetiBox.getSelectionModel();
				String qyteti1=qyteti.getSelectedItem();//////////////
				String adresa = txtAdresa.getText();
				String tel = txtTel.getText();
				String email = txtEmail.getText();
			 
			    String gjinia=gender();
			    String status=statusi();
				
				SingleSelectionModel<String> fakulteti = fakultetiBox.getSelectionModel();
				String fakulteti1=fakulteti.getSelectedItem();//////////////
				SingleSelectionModel<String> drejtimi = drejtimiBox.getSelectionModel();
				String drejtimi1=drejtimi.getSelectedItem();//////////////
				SingleSelectionModel<String> niveli = niveliBox.getSelectionModel();
				String niveli1=niveli.getSelectedItem();//////////////
			    String foto="null";
					

				
				if (emri.isEmpty() || mbiemri.isEmpty() || prindi.isEmpty() || nrPersonal.isEmpty() || ditelindja1.isEmpty()
						|| adresa.isEmpty() || email.isEmpty() ) {
						lblError.setText("Ju lutem plotesoni te dhenat!");
					} else if (nrPersonal.length() > 10) {
						lblError.setText("Nr personal jo valid");
					}  else if (!tel.matches("^\\+\\d{11}$")) {
						lblError.setText("Nr.Telefonit eshte gabim!");
						txtTel.requestFocus();
					} else if (!email.matches("^[A-Za-z0-9._\\-]+@[A-Za-z]+.[A-Za-z]{2,3}$")) {
						lblError.setText("Emaili eshte gabim!");
						txtEmail.requestFocus();
					}
				
					else {
						
					
					//else if(lblError.getText().isEmpty()) {

				PreparedStatement pst = null;
				String query="insert into studentet1 (semri, smbiemri, sprindi, snrpersonal, sditelindja,sshteti, sqyteti,sadresa, stel, semail,sgjinia, sfakulteti, sdrejtimi, sstatusi, sniveli,sfoto) values ('"+emri+"', '"+mbiemri+"' , '"+prindi+"' ,'"+nrPersonal+"' ,'"+ditelindja+"' ,'"+shteti1+"' ,'"+qyteti1+"' ,'"+adresa+"' ,'"+tel+"' ,'"+email+"' ,'"+gjinia+"' ,'"+fakulteti1+"' ,'"+drejtimi1+"' ,'"+status+"' ,'"+niveli1+"' ,'"+foto+"')";
				//int rs = st.executeUpdate(query);
				pst = connection.prepareStatement(query);
				pst.execute();
				pst.close();
				// Regjistrimi i studentit si perdorues i sistemit
				String queryId = "select max(sid) as id from studentet1";
				//Statement statement = connection.createStatement();
				
				pst = connection.prepareStatement(queryId);
				ResultSet res = pst.executeQuery(queryId);
				
				res.next();
				String idGjeneruar = res.getString("id");

				String txtID = idGjeneruar;
				if (idGjeneruar == null) {
					String vleraFillestare = "11800000";
					txtID = vleraFillestare;
				}
				// Gjenerimi i salted hash
				
				String saltValue = hash.saltGenerator();
				String fjalekalimi =txtID + saltValue;
				String fjalekalimiHash="";
				fjalekalimiHash = hash.hashString(fjalekalimi, "SHA-1");
				
				
				//String zb="s";
				String updatePerdoruesi = "update perdoruesit1 set pfjalekalimi='" + fjalekalimiHash + "', psalt='"
						+ saltValue + "'where pid='" + txtID + "'";
				Statement statement1 = connection.createStatement();

				statement1.executeUpdate(updatePerdoruesi);
				
				//String queryId = "insert into perdoruesit1 (pid,pemail,pfjalekalimi,psalt,ptipi) values ('"+nrPersonal+"', '"+email+"' , '"+fjalekalimiHash+"' ,'"+saltValue+"' ,'"+zb+"')"; 
				
				//Statement statement1 = connection.createStatement();

				//statement1.executeUpdate(queryId);
				



			
			    JOptionPane.showMessageDialog(null,"Studenti u regjistrua me sukses!");
	
			    txtEmri.setText("");
				txtMbiemri.setText("");
				txtPrindi.setText("");
				txtPersonalNr.setText("");
				txtDitelindja.getEditor().setText("");
				txtTel.setText("");
				shtetiBox.setValue("Kosove");
				drejtimiBox.setValue("Automatikë e Kompjuterizuar dhe Robotikë");
				niveliBox.setValue("Bachelor");
				txtEmail.setText("");
				txtAdresa.setText("");
				male.setSelected(true);
				female.setSelected(false);
				rregullt.setSelected(true);
				korrespodence.setSelected(false);
					
					}
				}
					
		   catch (Exception e1) {
						System.out.println(e1);
		   		}

				
				
	    }
	
    	  


    	    }
