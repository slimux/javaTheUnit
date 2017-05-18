/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.application.Administrateur;


import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Alert;
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
import model.Administrateur;
import service.CompteAdministrateur;

/**
 * FXML Controller class
 *
 * @author SAMSUNG
 */
public class ViewAdminController implements Initializable {

    @FXML
    public AnchorPane acAdminMainContent;
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
    private TableColumn<Administrateur, Integer> idC;
    @FXML
    private TableColumn<Administrateur, String> nomC;
    @FXML
    private TableColumn<Administrateur, String> PrenomC;
    @FXML
    private TableColumn<Administrateur, String> emailC;
    @FXML
    private TableColumn<Administrateur, String> mdpC;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
     CompteAdministrateur cm=new CompteAdministrateur();
    List<Administrateur> mm;
private ObservableList<Administrateur> data = FXCollections.observableArrayList();
    @FXML
    private TableView<Administrateur> tableA;
    public ViewAdminController() {
        
        mm = cm.afficherAdmin();
        
        data.addAll(0, mm);
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         idC.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getId()));
        nomC.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
        PrenomC.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrenom()));
       
        emailC.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
        
        mdpC.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMdp()));
        
        tableA.setItems(data);
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
         AjouterAdminController acc = new AjouterAdminController();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.setLocation(getClass().getResource("/View/AjouteAdmin.fxml"));
        try {
            fXMLLoader.load();
            Parent parent = fXMLLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            AjouterAdminController addCustomerController = fXMLLoader.getController();
            addCustomerController.btnModifier.setVisible(false);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ViewAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnModifierOnAction(ActionEvent event) {
        if (tableA.getSelectionModel().getSelectedItem() != null) {
            AjouterAdminController acc = new AjouterAdminController();
            FXMLLoader fXMLLoader = new FXMLLoader();
            fXMLLoader.setLocation(getClass().getResource("/View/AjouteAdmin.fxml"));
            try {
                fXMLLoader.load();
                Parent parent = fXMLLoader.getRoot();
                Scene scene = new Scene(parent);
                scene.setFill(new Color(0, 0, 0, 0));
                AjouterAdminController addServeurController = fXMLLoader.getController();
                addServeurController.nom.setText(tableA.getSelectionModel().getSelectedItem().getNom());
                addServeurController.prenom.setText(tableA.getSelectionModel().getSelectedItem().getPrenom());
                addServeurController.email.setText(tableA.getSelectionModel().getSelectedItem().getEmail());
                addServeurController.mdp.setText(tableA.getSelectionModel().getSelectedItem().getMdp());

                addServeurController.btnSauvgarder.setVisible(false);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.TRANSPARENT);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ViewAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Veuillez Selectionner un serveur !");

            alert.showAndWait();
        }
    }

    @FXML
    private void btnSupprimerOnAction(ActionEvent event) {
        cm.supprimerAdmin(tableA.getSelectionModel().getSelectedItem());
        data.remove(tableA.getSelectionModel().getSelectedItem());
        
        tableA.setItems(data);
    }

    @FXML
    private void tblCustomerOnClick(MouseEvent event) {
    }
    
}
