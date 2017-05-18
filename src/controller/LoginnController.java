/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author SAMSUNG
 */
public class LoginnController implements Initializable {

    @FXML
    private AnchorPane apMother;
    @FXML
    private AnchorPane apDesignPane;
    @FXML
    private TextField username;
    @FXML
    private PasswordField mdp;
    @FXML
    private Button btnUserNameTfClear;
    @FXML
    private Button btnPassFieldClear;
    @FXML
    private Button btnLogin;
    @FXML
    private Text alert;
    @FXML
    private Label register;
    @FXML
    private AnchorPane logo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void pfUserPassOnHitEnter(ActionEvent event) {
    }

    @FXML
    private void pfUserNameOnHitEnter(ActionEvent event) {
    }

    @FXML
    private void btnLogin(ActionEvent event) {
    }

    @FXML
    private void CreerCompte(MouseEvent event) {
    }
    
}
