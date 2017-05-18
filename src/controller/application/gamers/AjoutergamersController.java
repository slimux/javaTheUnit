/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.application.gamers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.StageStyle;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import model.Membre;
import service.CompteMembre;

/**
 * FXML Controller class
 *
 * @author SAMSUNG
 */
public class AjoutergamersController implements Initializable {

    @FXML
    public TextField nom;
    @FXML
    public Button btnSauvgarder;
    @FXML
    public Button btnModifier;
    @FXML
    public TextField prenom;
    @FXML
    public TextField email;
    @FXML
    public TextField pseudo;
    @FXML
    public DatePicker date;
    @FXML
    private TextField profession;
    @FXML
    private TextField pays;
    @FXML
    public Label lblCustomerContent;
    @FXML
    private Button btnClose;
    @FXML
    public PasswordField mdp;
    @FXML
    public TextField id;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    CompteMembre cm=new CompteMembre();

    @FXML
    private void btnSauvgarderOnAction(ActionEvent event) {
        /*Membre e = new Membre(0, nom.getText(), prenom.getText(), email.getText(), date.getDate(), mdp.getText(), pseudo.getText(), profession.getText(),pays.getText(),  );
        ss.ajouter(e);
        res.getInt("id_Membre"), res.getString("nom"),res.getString("prenom"), res.getString("email"), res.getDate("date_Naissance"), res.getString("mo_de_passe"), res.getString("pseudo"), res.getString("profession"), res.getString("pays"),res.getString("photo"));
        javafx.collections.ObservableList serviceData = ss.getAll();
        serviceData.add(e);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sucess");
        alert.setHeaderText("Sucess : save sucess");
        alert.setContentText("Serveur" + "  '" + tfAjouterServeur.getText() + "' " + "Added successfully");
        alert.initStyle(StageStyle.UNDECORATED);
        alert.showAndWait();
        alert.close();
        Stage stage = (Stage) btnModifier.getScene().getWindow();
        stage.close();*/
      /*  LocalDate localDate = date.getValue();
Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
java.util.Date d = java.util.Date.from(instant);


        Membre e = new Membre(0, nom.getText(), prenom.getText(),email.getText(), (Date) d,mdp.getText(),pseudo.getText(),profession.getText(),pays.getText() );
      cm.ajouterMembre(e);
        javafx.collections.ObservableList serviceData = (javafx.collections.ObservableList) cm.afficherMembre();
        serviceData.add(e);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucess");
            alert.setHeaderText("Sucess : save sucess");
            alert.setContentText("Membre" + "  '" + nom.getText() + "' " + "Added successfully");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();
            alert.close();*/
   
        Membre e = new Membre(0, nom.getText(), prenom.getText(), email.getText(), java.sql.Date.valueOf(date.valueProperty().getValue()),mdp.getText(), pseudo.getText(), pays.getText(), profession.getText(),null);
        cm.ajouterMembre(e);
        javafx.collections.ObservableList serviceData = cm.getAll();
        serviceData.add(e);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sucess");
        alert.setHeaderText("Sucess : save sucess");
        alert.setContentText("Membre" + "  '" + nom.getText()+ prenom.getText() + "' " + "Added successfully");
        alert.initStyle(StageStyle.UNDECORATED);
        alert.showAndWait();
        alert.close();
        Stage stage = (Stage) btnModifier.getScene().getWindow();
        stage.close();
    }
 @FXML
    private void btnModifierOnAction(ActionEvent event) {
    }

    @FXML
    private void btnCloseOnAction(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
    
}
