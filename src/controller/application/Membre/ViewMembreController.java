/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.application.Membre;

import com.jfoenix.validation.RequiredFieldValidator;
import controller.application.gamers.AjoutergamersController;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
public class ViewMembreController implements Initializable {

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
    @FXML
    private TableView<Membre> tableM;
    @FXML
    private TableColumn<Membre, String> PrenomC;
    @FXML
    private TableColumn<Membre, String> emailC;
    @FXML
    private TableColumn<Membre, String> mdpC;
    @FXML
    private TableColumn<Membre, String> dateC;
    @FXML
    private TableColumn<Membre, String> professionC;
    @FXML
    private TableColumn<Membre, String> pseudoC;
    @FXML
    private TableColumn<Membre, String> paysC;
    @FXML
    private TableColumn<Membre, Integer> idC;
    @FXML
    private TableColumn<Membre, String> nomC;
    @FXML
    public AnchorPane acMembreMainContent;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    CompteMembre cm=new CompteMembre();
    List<Membre> mm;
private ObservableList<Membre> data = FXCollections.observableArrayList();
    public ViewMembreController() {
        
        mm = cm.displayMembre();
        
        data.addAll(0, mm);
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         idC.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getId()));
        nomC.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
        PrenomC.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrenom()));
        pseudoC.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPseudo()));
        
        emailC.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
        professionC.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProfession()));
        paysC.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPays()));
        dateC.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getDateN()));
        mdpC.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMdp()));
        
        tableM.setItems(data);
         
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
            Logger.getLogger(ViewMembreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnModifierOnAction(ActionEvent event) {
    }

    @FXML
    private void btnSupprimerOnAction(ActionEvent event) {
        cm.supprimerMembre(tableM.getSelectionModel().getSelectedItem());
        data.remove(tableM.getSelectionModel().getSelectedItem());
        
        tableM.setItems(data);
    }

    @FXML
    private void tblCustomerOnClick(MouseEvent event) {
    }
    
}
