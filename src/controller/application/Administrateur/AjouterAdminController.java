/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.application.Administrateur;

import Interface.IServeurService;
import Interface.Iadministrateur;
import Interface.Imembre;
import connexion.MyConnection;
import java.net.URL;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Administrateur;
import model.Membre;
import model.Serveur;
import service.CompteAdministrateur;
import service.CompteMembre;

/**
 * FXML Controller class
 *
 * @author SAMSUNG
 */
public class AjouterAdminController implements Initializable {

    @FXML
     TextField nom;
    @FXML
     Button btnSauvgarder;
    @FXML
     Button btnModifier;
    @FXML
     TextField prenom;
    @FXML
     TextField email;
    @FXML
     PasswordField mdp;
    @FXML
    private Label lblCustomerContent;
    @FXML
    private Button btnClose;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 CompteAdministrateur cm=new CompteAdministrateur();
    @FXML
    private void btnSauvgarderOnAction(ActionEvent event) {

        Administrateur e = new  Administrateur(0, nom.getText(), prenom.getText(),email.getText(),mdp.getText());
      cm.ajouterAdmin(e);
        javafx.collections.ObservableList serviceData = (javafx.collections.ObservableList) cm.afficherAdmin();
        serviceData.add(e);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucess");
            alert.setHeaderText("Sucess : save sucess");
            alert.setContentText("Membre" + "  '" + nom.getText() + "' " + "Added successfully");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();
            alert.close();
    }

    @FXML
    public void btnModifierOnAction(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/View/ViewAdministrateur.fxml"));
        String nomc =nom.getText();
        String prenomc = prenom.getText();
        String emailc = email.getText();
        String mdpc= mdp.getText();
        
        Administrateur m = new  Administrateur();
        m.setNom(nomc);
        m.setPrenom(prenomc);
        m.setEmail(emailc);
        m.setMdp(mdpc);
        
        
        Iadministrateur iss = new CompteAdministrateur();
        iss.modifierAdmin(m);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucess");
            alert.setHeaderText("Sucess : modified sucess");
            alert.setContentText("membre" + "  '" +nom.getText() + "' " + "à été modifié !!");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();
            alert.close();
        
        Stage stage = (Stage) btnModifier.getScene().getWindow();
        stage.close();
        
      
    }

    @FXML
    private void btnCloseOnAction(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
    
}
