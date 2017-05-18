/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import model.Membre;
import service.CompteMembre;

/**
 * FXML Controller class
 *
 * @author amira
 */
public class FXMLListUserController implements Initializable {

    private ObservableList<ObservableList> data;
    @FXML
    private TableView table;
    @FXML
    private TableColumn id;

    @FXML
    private TableColumn firstName;

    @FXML
    private TableColumn lastName;

    @FXML
    private TableColumn login;

    @FXML
    private TableColumn email;

    @FXML
    private TableColumn solde;
    CompteMembre u = new CompteMembre();
    @FXML
    public AnchorPane usr;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        data = FXCollections.observableArrayList();
        ResultSet r = u.findAll();
        ObservableList<String> row = FXCollections.observableArrayList();
        try {
            for (int i = 1; i <= r.getMetaData().getColumnCount(); i++) {
                row.add(r.getString(i));
            }

            data.add(row);
            System.out.println("Data " + data);
            table.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLListUserController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
