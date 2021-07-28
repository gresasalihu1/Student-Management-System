
package application.Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.ModelTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SemestriController implements Initializable{
	@FXML
	private AnchorPane anchorPane;

	 @FXML
	    private Label studentet;

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
	    private Label editmyProfile1;

	    @FXML
	    private Label homeLabel;

	    @FXML
	    private ImageView contact1;

	    @FXML
	    private ImageView settingsHelp1;

	    @FXML
	    private ImageView sendMessage1;

	    @FXML
	    private Label logoutLabel;

    @FXML
    private Button btnKerko;

    @FXML
    private Button btnRegjistro;

    @FXML
    private TextField stdID;

    @FXML
    private Label lblData;

    @FXML
    private Label lblKoha;

    @FXML
    private TableView<ModelTable> tblStudentet;

    @FXML
    private TableColumn<ModelTable, String> colID;

    @FXML
    private TableColumn<ModelTable, String> colEmri;

    @FXML
    private TableColumn<ModelTable, String> colMbiemri;

    @FXML
    private TableColumn<ModelTable, String> colDtl;

    @FXML
    private TableColumn<ModelTable, String> colFk;

    @FXML
    private TableColumn<ModelTable, String> colSemestri;

    @FXML
    private TableColumn<ModelTable, String> colGjinia;

    @FXML
    private TableColumn<ModelTable, String> colLloji;

    @FXML
    private TableColumn<ModelTable, String> colData;
    @FXML
    private Label registerSLabel;
    @FXML
    private Label kerkoidLabel;
    @FXML
    private TableColumn<ModelTable, String> colPaguar;
    private ResourceBundle bundle;
    private Locale locale;
	
	@FXML
	private Label regSemester;
	@FXML
	private Label kerkoLabel;
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
    	lang();
    	//updateTable("SELECT studentet.sid, studentet.semri, studentet.smbiemri, studentet.sditelindja, fakultetet.femri, studentet.ssemestri, studentet.sgjinia, fletpagesat.flloji, fletpagesat.fdata, fletpagesat.fpaguar FROM studentet LEFT JOIN fletpagesat ON studentet.sid = fletpagesat.fstudenti LEFT JOIN fakultetet ON studentet.sfakulteti = fakultetet.fid");
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
    	
    	
    	
    	colID.setText(bundle.getString("colID_semester"));
    	colEmri.setText(bundle.getString("colEmri_semester"));
    	colMbiemri.setText(bundle.getString("colMbiemri_semester"));
    	colDtl.setText(bundle.getString("colDtl_semester"));
    	colFk.setText(bundle.getString("colFk_semester"));
    	colSemestri.setText(bundle.getString("colSemestri_semester"));
    	colGjinia.setText(bundle.getString("colGjinia_semester"));
    	colLloji.setText(bundle.getString("colLloji_semester"));
    	colData.setText(bundle.getString("colData_semester"));
    	colPaguar.setText(bundle.getString("colPaguar_semester"));
    	regSemester.setText(bundle.getString("regSemester_semester"));
    	kerkoLabel.setText(bundle.getString("kerkoLabel_semester"));
    	btnKerko.setText(bundle.getString("btnKerko_semester"));
    	btnRegjistro.setText(bundle.getString("btnRegjistro_semester"));
    	
		
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
    void kerkoStudentin(ActionEvent event) 
    {
    	updateTable("SELECT studentet1.sid, studentet1.semri, studentet1.smbiemri, studentet1.sditelindja, fakultetet.femri, studentet1.ssemestri, studentet1.sgjinia, fletpagesat.flloji, fletpagesat.fdata, fletpagesat.fpaguar FROM studentet1 LEFT JOIN fletpagesat ON studentet1.sid = fletpagesat.fstudenti LEFT JOIN fakultetet ON studentet1.sfakulteti = fakultetet.fid WHERE studentet1.sid =" +stdID.getText());
    }
    @FXML
    void fxmlChanges(MouseEvent event) throws IOException {
    	if(event.getSource()==editmyProfile1)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/MyProfile.fxml"));
    		anchorPane.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==registerSemester1)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/fx.fxml"));
    		anchorPane.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==reportStudents1)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/raport.fxml"));
    		anchorPane.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==searchStudents1)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/EditDeleteUser.fxml"));
    		anchorPane.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==registerStudents1)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/studentregister.fxml"));
    		anchorPane.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==sendMessage1)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/WriteMessage.fxml"));
    		anchorPane.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==contact1)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/ContactUs.fxml"));
    		anchorPane.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==logoutLabel)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/login.fxml"));
    		anchorPane.getChildren().setAll(pane);
    	}
    	else if(event.getSource()==homeLabel)
    	{
    		AnchorPane pane=FXMLLoader.load(getClass().getResource("../Fxmls/MainXML.fxml"));
    		anchorPane.getChildren().setAll(pane);
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
    void regjistroSemestrin(ActionEvent event) throws SQLException 
    {
    	Connection conn = DatabaseConnection.startConnection();
    	PreparedStatement pst=null;
    	ResultSet res=null;
    	
    	int id = Integer.parseInt(stdID.getText());
    	
    	if (id != 0) {
			String paguar = "";
			String perdorur="";
			String studenti = "";
			String semestri = "";
			int semestriint = 1;
			try {
				String sql = "Select * from studentet1 s,fletpagesat fl,qytetet q,fakultetet f "
						+ "where s.sid=fl.fstudenti and s.sqyteti=q.qid and f.fid=s.sfakulteti and s.sid='" + id
						+ "'";
				pst = conn.prepareStatement(sql);
				res = pst.executeQuery();
				while (res.next()) {
					paguar = res.getString("fpaguar");
					perdorur=res.getString("fperdorur");
					studenti = res.getString("semri") + " " + res.getString("smbiemri");
					semestri = res.getString("ssemestri");
					semestriint = Integer.parseInt(semestri);
					semestriint += 1;
					
				}
				pst.close();

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "InsertError");
			}

			if (semestriint != 1 && paguar.equals("PO") && perdorur.equals("0")) {
				try {
					String sql1 = "Update studentet1 set ssemestri='" + semestriint + "' where sid='" + id
							+ "' ";

					pst = conn.prepareStatement(sql1);
					pst.execute();
					updateTable("SELECT studentet1.sid, studentet1.semri, studentet1.smbiemri, studentet1.sditelindja, fakultetet.femri, studentet1.ssemestri, studentet1.sgjinia, fletpagesat.flloji, fletpagesat.fdata, fletpagesat.fpaguar FROM studentet1 LEFT JOIN fletpagesat ON studentet1.sid = fletpagesat.fstudenti LEFT JOIN fakultetet ON studentet1.sfakulteti = fakultetet.fid");
					pst.close();
					
					String sql2 = "Update fletpagesat set fperdorur=" + 1 + " where fstudenti=" + id;
					pst = conn.prepareStatement(sql2);
					pst.execute();
					pst.close();
					
					JOptionPane.showMessageDialog(null,
					"Student:" + studenti +" "+"regjistrom semestrin" + semestriint);

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "InsertError");
					//Ku eshte gabimi
					System.out.println(e);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Student:" + studenti + "nuk regjistrohet");
			}
		}
    }
    
    
    public void updateTable(String sql)
	{
    	ObservableList<ModelTable> obList = FXCollections.observableArrayList();
    	
    	Connection conn;
    	ResultSet res;
    	try {
			conn = DatabaseConnection.startConnection();
			res = conn.createStatement().executeQuery(sql);
		    while(res.next())
		    {
		    	obList.add(new ModelTable(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10), sql));
		    }
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	colID.setCellValueFactory(new PropertyValueFactory<>("ID"));
    	colEmri.setCellValueFactory(new PropertyValueFactory<>("EMRI"));
    	colMbiemri.setCellValueFactory(new PropertyValueFactory<>("MBIEMRI"));
    	colDtl.setCellValueFactory(new PropertyValueFactory<>("DATELINDJA"));
    	colFk.setCellValueFactory(new PropertyValueFactory<>("FAKULTETI"));
    	colSemestri.setCellValueFactory(new PropertyValueFactory<>("SEMESTRI"));
    	colGjinia.setCellValueFactory(new PropertyValueFactory<>("GJINIA"));
    	colLloji.setCellValueFactory(new PropertyValueFactory<>("LLOJI"));
    	colData.setCellValueFactory(new PropertyValueFactory<>("DATA"));
    	colPaguar.setCellValueFactory(new PropertyValueFactory<>("PAGUAR"));
    	
    	tblStudentet.setItems(obList);
		
	}
    

}

    



