/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import controller.application.gamers.AjoutergamersController;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Membre;
import service.CompteMembre;

/**
 * FXML Controller class
 *
 * @author SAMSUNG
 */
public class ViewGamerController implements Initializable {

   
    @FXML
    private TextField tfSearch;
    @FXML
    private Button btnRefresh;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnSupprimer;
    private TableColumn<Membre, Integer> idC;
    private TableColumn<Membre, String> nomC;
    private TableColumn<Membre, String> PrenomC;
    private TableColumn<Membre, String> emailC;
    private TableColumn<Membre, String> mdpC;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
     CompteMembre cm=new CompteMembre();
    List<Membre> mm;
private ObservableList<Membre> datas = FXCollections.observableArrayList();
   

    @FXML
    private TableView<Membre> tableM;
    
    @FXML
    public AnchorPane Content1;
    @FXML
    private TableColumn<Membre, Object> id;
    @FXML
    private TableColumn<Membre, String> nom;
    @FXML
    private TableColumn<Membre, String> prenom;
    @FXML
    private TableColumn<Membre, String> email;
    @FXML
    private TableColumn<Membre, String> mdp;
    @FXML
    private TableColumn<Membre, String> pseudo;
    @FXML
    private TableColumn<Membre, String> profession;
    @FXML
    private TableColumn<Membre, String> pays;
    public ViewGamerController() {
        
        mm = cm.displayMembre();
        
        datas.addAll(0, mm);
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         id.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getId()));
        nom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
        prenom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrenom()));
       
        email.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
        
        mdp.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMdp()));
         pseudo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPseudo()));
        
    
        profession.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProfession()));
        pays.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPays()));
        
        tableM.setItems(datas);
        // TODO
    }    

    @FXML
    private void tfSearchOnKeyReleased(KeyEvent event) {
    }

    @FXML
    private void btnRefreshOnAction(ActionEvent event) {
    }

    @FXML
    private void btnAjouterOnAction(ActionEvent event) {
         AjoutergamersController acc = new AjoutergamersController();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.setLocation(getClass().getResource("/View/AjouterGamer.fxml"));
        try {
            fXMLLoader.load();
            Parent parent = fXMLLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
           AjoutergamersController addCustomerController = fXMLLoader.getController();
            addCustomerController.btnModifier.setVisible(false);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ViewGamerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnModifierOnAction(ActionEvent event) {
    }

    @FXML
    private void btnSupprimerOnAction(ActionEvent event) {
        cm.supprimerMembre(tableM.getSelectionModel().getSelectedItem());
        datas.remove(tableM.getSelectionModel().getSelectedItem());
        
        tableM.setItems(datas);
    }

    @FXML
    private void tblCustomerOnClick(MouseEvent event) {
    }
    
}
