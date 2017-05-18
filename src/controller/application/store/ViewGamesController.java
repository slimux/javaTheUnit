/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.application.store;

import connexion.Connect;
import connexion.MyConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Membre;

/**
 * FXML Controller class
 *
 * @author macbookpro
 */
public class ViewGamesController implements Initializable {

    @FXML
    public AnchorPane acCustomerMainContent;
    @FXML
    private TextField tfSearch;
    @FXML
    private Button btnRefresh;
    @FXML
    private ChoiceBox<?> cbCategorie;
    @FXML
    private Button btnDetail;
    @FXML
    private TableView<Membre> tblGames;
    @FXML
        private TableColumn<Membre, String> tblClmNom;
    @FXML
    private TableColumn<Membre, String> tblClmDescription;
    @FXML
    private TableColumn<Membre, String> tblClmPrix;
    @FXML
    private TableColumn<Membre, String> tblClmCategorie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         tblClmNom.setCellValueFactory(new PropertyValueFactory<Membre, String>("nom"));
        tblClmDescription.setCellValueFactory(new PropertyValueFactory<Membre, String>("prenom"));
        tblClmPrix.setCellValueFactory(new PropertyValueFactory<Membre, String>("email"));
        tblClmCategorie.setCellValueFactory(new PropertyValueFactory<Membre, String>("pseudo"));

        try {
            getGames();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewGamesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
        // TODO
       
       private Connect conn;
ObservableList<Membre> member;
public void getGames() throws ClassNotFoundException {
        try {
            conn = new Connect();
            conn.open();
            member = FXCollections.observableArrayList();
            ResultSet rs = conn.getData("SELECT * FROM membre");

            while (rs.next()) {
                Membre m = new Membre(rs.getInt("id_Membre"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getDate("Date_Naissance"),
                        rs.getString("mo_de_passe"),
                        rs.getString("pseudo"),
                        rs.getString("pays"),
                        rs.getString("profession"),
                        rs.getString("photo")
                );
                member.add(m);
            }

            tblGames.setItems(member);
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ViewGamesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void tfSearchOnKeyReleased(KeyEvent event) {
    }

    @FXML
    private void btnRefreshOnAction(ActionEvent event) {
    }

    @FXML
    private void btnDetailOnAction(ActionEvent event) {
    }

    @FXML
    private void tblCustomerOnClick(MouseEvent event) {
    }

    @FXML
    private void handle(MouseEvent event) {
    }
    
}
