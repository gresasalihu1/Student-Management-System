package application.Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RaportController implements Initializable{
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
   private ImageView contact1;

   @FXML
   private ImageView settingsHelp1;

   @FXML
   private ImageView sendMessage1;

   @FXML
   private Label editmyProfile1;

   @FXML
   private Text textforLanguage;

   @FXML
   private Label homeLabel;

   @FXML
   private Label logoutLabel;

   @FXML
   private AnchorPane anch;

   @FXML
   private Label nrStudLabel;

   @FXML
   private TextField txtViti4;

   @FXML
   private TextField txtElektronike;

   @FXML
   private TextField txtAutomatike;

   @FXML
   private Label universiteti;

   @FXML
   private Label automatike;

   @FXML
   private Label elektronike;

   @FXML
   private TextField txtViti1;

   @FXML
   private TextField txtViti2;

   @FXML
   private Label vitiLabel;

   @FXML
   private Label viti3Label;

   @FXML
   private Label viti2Label;

   @FXML
   private Label viti4Label;

   @FXML
   private Label elektro;

   @FXML
   private Label telekomunikacion;

   @FXML
   private TextField txtElektroenergjetike;

   @FXML
   private TextField txtTelekomunikacion;

   @FXML
   private Label raport;

   @FXML
   private Label inxhineri;

   @FXML
   private TextField txtKompjuterike;

   @FXML
   private TextField txtMeshkuj;

   @FXML
   private TextField txtFemra;

   @FXML
   private Label studentm;

   @FXML
   private Label studentf;

   @FXML
   private Button gjenero;

   @FXML
   private Button ruaj;

   @FXML
   private TextField txtViti3;

    private ResourceBundle bundle;
    private Locale locale;

    @FXML
    private TextField txtNumriTotal;
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
    private void handleSaveClicked() {
        ruaj.setVisible(false);
        gjenero.setVisible(false);

        Printer printer = Printer.getDefaultPrinter();
        PageLayout pageLayout = printer.createPageLayout(Paper.A3,
                PageOrientation.PORTRAIT, Printer.MarginType.EQUAL);
        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null && job.showPrintDialog(anch.getScene().getWindow())) {
            boolean success = job.printPage(pageLayout, anch);
            if (success) {
                job.endJob();
            }
        }
        ruaj.setVisible(true);
        gjenero.setVisible(true);
    }

public void Btngjenero(ActionEvent actionEvent) throws SQLException {

        Connection conn = DatabaseConnection.startConnection();

        ResultSet res;
        PreparedStatement pst;
        try {
            String query = "select count(*) as 'Totali' from studentet1";
            pst = conn.prepareStatement(query);
            res = pst.executeQuery();
            while (res.next()) {
                String rez = res.getString("Totali");
                txtNumriTotal.setText(rez);
            }


            //Viti i pare

            String query1 = "select count(*) as 'Totali' from studentet1 s where s.ssemestri = 1 or s.ssemestri = 2";
            pst = conn.prepareStatement(query1);
            res = pst.executeQuery();
            while (res.next()) {
                String rez = res.getString("Totali");
                txtViti1.setText(rez);
            }


            //Viti i dyte

            String query2 = "select count(*) as 'Totali' from studentet1 s where s.ssemestri = 3 or s.ssemestri = 4";
            pst = conn.prepareStatement(query2);
            res = pst.executeQuery();
            while (res.next()) {
                String rez = res.getString("Totali");
                txtViti2.setText(rez);
            }


            //Viti i trete
            String query3 = "select count(*) as 'Totali' from studentet1 s where s.ssemestri = 5 or s.ssemestri = 6";
            pst = conn.prepareStatement(query3);
            res = pst.executeQuery();
            while (res.next()) {
                String rez = res.getString("Totali");
                txtViti3.setText(rez);
            }


            //Viti i katert
            String query4 = "select count(*) as 'Totali' from studentet1 s where s.ssemestri = 7 or s.ssemestri = 8";
            pst = conn.prepareStatement(query4);
            res = pst.executeQuery();
            while (res.next()) {
                String rez = res.getString("Totali");
                txtViti4.setText(rez);
            } 


            //Inxhinieri Kompjuterike // automatiken pe qet kto tjerat jo piken provo hekja qitu posht
            String query5 = "select count(*) as 'Totali' from studentet1 s where s.sdrejtimi = 'Inxhinieri Kompjuterike'";
            pst = conn.prepareStatement(query5);
            res = pst.executeQuery();
            while (res.next()) {
                String rez = res.getString("Totali");
                txtKompjuterike.setText(rez);
            }
//("Automatikë e Kompjuterizuar dhe Robotikë","Elektroenergjetikë","Elektronikë"," Inxhinieri Kompjuterike","Telekomunikacion");

            //Telekomunikacion

            String query6 = "select count(*) as 'Totali' from studentet1 s where s.sdrejtimi = 'Telekomunikacion'";
            pst = conn.prepareStatement(query6);
            res = pst.executeQuery();
            while (res.next()) {
                String rez = res.getString("Totali");
                txtTelekomunikacion.setText(rez);
            }

            //Elektroenergjetike
            String query7 = "select count(*) as 'Totali' from studentet1  s where s.sdrejtimi = 'Elektroenergjetikë'";
            pst = conn.prepareStatement(query7);
            res = pst.executeQuery();
            while (res.next()) {
                String rez = res.getString("Totali");
                txtElektroenergjetike.setText(rez);
            }


            //Elektronike
            String query8 = "select count(*) as 'Totali' from studentet1 s where s.sdrejtimi ='Elektronikë' ";
            pst = conn.prepareStatement(query8);
            res = pst.executeQuery();
            while (res.next()) {
                String rez = res.getString("Totali");
                txtElektronike.setText(rez);
            }


            //Automatike nqofse e qet kta duhet me qit edhe ata 
            String query9 = "select count(*) as 'Totali' from studentet1 s where s.sdrejtimi = 'Automatikë e Kompjuterizuar dhe Robotikë'";
            pst = conn.prepareStatement(query9);
            res = pst.executeQuery();
            while (res.next()) {
                String rez = res.getString("Totali");
                txtAutomatike.setText(rez);
            }


            //Gjithesejt meshkuj// 
            String query11 = "select count(*) as 'Totali' from studentet1  where sgjinia = 'Mashkull'";
            pst = conn.prepareStatement(query11);
            res = pst.executeQuery();
            while (res.next()) {
                String rez = res.getString("Totali");
                txtMeshkuj.setText(rez);
            }

            //gjithesejt femra
            String query12 = "select count(*) as 'Totali' from studentet1  where sgjinia = 'Femër'";
            pst = conn.prepareStatement(query12);
            res = pst.executeQuery();
            while (res.next()) {
                String rez = res.getString("Totali");
                txtFemra.setText(rez);
            }

        }
        catch (Exception e) {
e.getMessage();
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


//vitiLabel,viti2Label,viti3Label,viti4Label,elektronike,automatike,elektro,telekomunikacion
//inxhineri,studentm,studentf,gjenero,ruaj
vitiLabel.setText(bundle.getString("vitiLabel_raport"));
viti2Label.setText(bundle.getString("viti2Label_raport"));
viti3Label.setText(bundle.getString("viti3Label_raport"));
viti4Label.setText(bundle.getString("viti4Label_raport"));
elektronike.setText(bundle.getString("elektronike_raport"));
automatike.setText(bundle.getString("automatike_raport"));
elektro.setText(bundle.getString("elektro_raport"));
telekomunikacion.setText(bundle.getString("telekomunikacion_raport"));
inxhineri.setText(bundle.getString("inxhineri_raport"));
studentm.setText(bundle.getString("studentm_raport"));
studentf.setText(bundle.getString("studentf_raport"));
gjenero.setText(bundle.getString("gjenero_raport"));
ruaj.setText(bundle.getString("ruaj_raport"));
universiteti.setText(bundle.getString("universiteti_raport"));
nrStudLabel.setText(bundle.getString("nrStudLabel_raport"));

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
@Override
public void initialize(URL arg0, ResourceBundle arg1) {
lang();

}

}
