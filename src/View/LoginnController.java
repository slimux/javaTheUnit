/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import com.jfoenix.controls.JFXButton;
import custom.CustomPf;
import custom.CustomTf;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Administrateur;
import model.Membre;
import service.CompteAdministrateur;
import service.CompteMembre;

/**
 * FXML Controller class
 *
 * @author haythem
 */
public class LoginnController implements Initializable {

    @FXML
    private AnchorPane apMother;
    @FXML
    private AnchorPane apDesignPane;
    @FXML
    private TextField tfUserName;
    @FXML
    private PasswordField pfUserPassword;
    @FXML
    private Button btnUserNameTfClear;
    @FXML
    private Button btnPassFieldClear;
    @FXML
    private Button btnLogin;
    @FXML
    private AnchorPane logo;
    CustomTf cTF = new CustomTf();
    CustomPf cPF = new CustomPf();
Stage stage;
    Parent root;
    private Label createbtn;
    public static Membre user= new Membre();
    public static Administrateur  admin=new Administrateur();
    @FXML
    private Text alert;
    @FXML
    private Label register;
    @FXML
    private JFXButton fb;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cTF.clearTextFieldByButton(tfUserName, btnUserNameTfClear);
        cPF.clearPassFieldByButton(pfUserPassword, btnPassFieldClear);
        BooleanBinding boolenBinding = tfUserName.textProperty().isEmpty()
                .or(pfUserPassword.textProperty().isEmpty());

        btnLogin.disableProperty().bind(boolenBinding);
    }

   
    @FXML
    private void pfUserPassOnHitEnter(ActionEvent event) {
        try {
            btnLogin(event);
        } catch (IOException ex) {
            Logger.getLogger(LoginnController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void pfUserNameOnHitEnter(ActionEvent event) {
        try {
            btnLogin(event);
        } catch (IOException ex) {
            Logger.getLogger(LoginnController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnLogin(ActionEvent event) throws IOException 
//        ApplicationnController apController = new ApplicationnController();
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("/View/Applicationn.fxml"));
//        loader.load();
//        Parent parent = loader.getRoot();
//        Scene adminPanelScene = new Scene(parent);
//        Stage adminPanelStage = new Stage();
//        adminPanelStage.setMaximized(true);
//        adminPanelStage.setScene(adminPanelScene);
//        adminPanelStage.getIcons().add(new Image("/image/icon.png"));
//        adminPanelStage.show();
//        Stage stage = (Stage) btnLogin.getScene().getWindow();
//        stage.close();
        ///////////////////////
    /*    
     { Parent root=FXMLLoader.load(getClass().getResource("/View/Applicationn.fxml"));
        Scene scene=new Scene (root);
        Stage Sc=new Stage();
        Sc.setScene(scene);
        Sc.setMaximized(true);
        Sc.getIcons().add(new Image("/image/petit.png"));
        Sc.show();
        final Node source=(Node) event.getSource();
        final Stage stage=(Stage) source.getScene().getWindow();
     
           stage.close();  }*/
    {
     CompteMembre u=new CompteMembre();
     CompteAdministrateur a=new CompteAdministrateur();
    
       
      int l= u.login(tfUserName.getText(), pfUserPassword.getText());
      int l1= a.loginAdmin(tfUserName.getText(), pfUserPassword.getText());
      
      
        if(l==1)
        {
         
         user=u.findUserByLogin(tfUserName.getText());
          
         stage = (Stage) btnLogin.getScene().getWindow();
         
        
         root = FXMLLoader.load(getClass().getResource("/View/FXMLProfile.fxml"));
        
        Scene scene = new Scene(root);

        stage.setScene(scene);
        
        stage.show();// redirection a la page d'acceuil
        }
        if(l1==1){
            admin=a.findUserByLogin(tfUserName.getText());
          
         stage = (Stage) btnLogin.getScene().getWindow();
         
        
         root = FXMLLoader.load(getClass().getResource("/View/Applicationn.fxml"));
        
        Scene scene = new Scene(root);

        stage.setScene(scene);
        
        stage.show();
            
        }
        if((l==3)||(l1==3)){
           alert.setText(" mot de passe incorrect");
          pfUserPassword.setText(""); 
           
        }
         if((l==2)||(l1==2))
         {
          alert.setText("username n'existe pas");
          tfUserName.setText("");   
          pfUserPassword.setText("");   
         }
          if((l==4))
          {
          Alert alerte = new Alert (Alert.AlertType.INFORMATION);
          alerte.setTitle("Information Dialogs");
          alerte.setHeaderText("Look, An information ");
          alerte.showAndWait();
   
        
          }
 


  
    

   /* private void createC(ActionEvent event) throws IOException {
        
       Parent root=FXMLLoader.load(getClass().getResource("/View/Register.fxml"));
        Scene scene=new Scene (root);
        Stage Sc=new Stage();
        Sc.setScene(scene);
        Sc.setMaximized(true);
        Sc.getIcons().add(new Image("/image/petit.png"));
        Sc.show();
        final Node source=(Node) event.getSource();
        final Stage stage=(Stage) source.getScene().getWindow();
        stage.close();
        
        
    }*/
    }
    @FXML
    private void CreerCompte(MouseEvent event) throws IOException {
        stage = (Stage) register.getScene().getWindow();
         
         root = FXMLLoader.load(getClass().getResource("/View/Register.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);

        stage.show();
    }

    @FXML
    private void fbAuthentification(ActionEvent event) {
        FacebookController fbc = new FacebookController();
        fbc.start(new Stage());
    }

}
