/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pid;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author SAMSUNG
 */
public class RegisterController implements Initializable {

    @FXML
    private JFXTextField username;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXPasswordField mdp1;
    @FXML
    private JFXTextField profession;
    @FXML
    private JFXButton register;
    @FXML
    private JFXDatePicker date;
    @FXML
    private ComboBox<?> pays;
    @FXML
    private Text usernameAlert;
    @FXML
    private Text dateAlert;
    @FXML
    private Text mdpAlert;
    @FXML
    private JFXPasswordField mdp2;
    @FXML
    private Text mdp2Alert;
    @FXML
    private JFXButton annuler;
    @FXML
    private JFXTextField email;
    @FXML
    private Text emailAlert;
    @FXML
    private Text nomAlert;
    @FXML
    private Text prenomAlert;
    @FXML
    private Text professionAlert;
    @FXML
    private Text paysAlert;
    @FXML
    private ImageView photo;
    @FXML
    private JFXButton browse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void verifierUsername(KeyEvent event) {
    }

    @FXML
    private void securitePassword(KeyEvent event) {
    }

    @FXML
    private void registerC(ActionEvent event) {
    }

    @FXML
    private void verifierBirthday(ActionEvent event) {
    }

    @FXML
    private void annuler(ActionEvent event) {
    }

    @FXML
    private void verifierEmail(KeyEvent event) {
    }

    @FXML
    private void addPhoto(ActionEvent event) {
    }
    
}
