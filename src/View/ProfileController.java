/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static View.LoginnController.user;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import model.Membre;
import service.CompteMembre;

/**
 * FXML Controller class
 *
 * @author SAMSUNG
 */
public class ProfileController implements Initializable {

    @FXML
    private JFXTextField firstName;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXButton upload;
    @FXML
    private JFXTextField lastName;
    @FXML
    private ImageView image;
    @FXML
    private TextArea description;
    @FXML
    private JFXDatePicker birthday;
    @FXML
    private JFXTextField address;
    @FXML
    private JFXTextField pays;
    @FXML
    private JFXButton cancel;
    @FXML
    private JFXButton update;
    CompteMembre c=new CompteMembre();
    Membre m;
    Membre m2;
     private File file;
    private Image ima;
    String pic;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         m=   LoginnController.user;
         m2=FacebookController.user; 
         
      

      if((m.getPseudo()!=null)){
      firstName.setText(m.getPrenom());
        lastName.setText(m.getNom());
         address.setText(m.getProfession());
         pays.setText(m.getPays());
         Date d= (Date) m.getDateN();
        birthday.setValue(d.toLocalDate());
        
       
      pic= m.getPic();
      if(pic!=null)
      {
      ima= new Image(pic);
      image.setImage(ima);
      }
    //  description.setText(user.getDescription());
        email.setText(m2.getEmail());}
    else
    {
        firstName.setText(m2.getPrenom());
        lastName.setText(m2.getNom());
         address.setText(m2.getProfession());
         email.setText(m2.getEmail());
       
    }
       /*   firstName.setText(user.getPrenom());
        lastName.setText(user.getNom());
         address.setText(user.getAdresse());
         Date d= (Date) user.getDateDeNaissance();
        birthday.setValue(d.toLocalDate());
        
        sexe.getSelectionModel().select(user.getSexe());
       pic= user.getPhoto();
        i= new Image(pic);
        image.setImage(i);
        description.setText(user.getDescription());
        email.setText(user.getMail());*/
      
      
    }    

    @FXML
    private void addPhoto(ActionEvent event) {
         FileChooser fileChooser = new FileChooser();
        file= fileChooser.showOpenDialog(null);
         FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
              
        pic=(file.toURI().toString());
        ima= new Image(pic);
        image.setImage(ima);
    }
   
    @FXML
    private void modifierProfile(ActionEvent event) {
         m.setNom(lastName.getText());
        m.setPrenom(firstName.getText());
        m.setProfession(address.getText());
        m.setEmail(email.getText());
       
        m.setDateN(java.sql.Date.valueOf(birthday.valueProperty().getValue()));
        m.setPic(pic);
             
        c.modifierMembre(m);
    }
    
}
