package View;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import model.Membre;
import service.CompteMembre;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
    private JFXTextField address;
    @FXML
    private JFXButton register;
    @FXML
    private JFXDatePicker date;
    @FXML
    private ComboBox<String> pays;
    @FXML
    private Text usernameAlert;
    @FXML
    private Text dateAlert;
    @FXML
    private Text mdpAlert;
    @FXML
    private JFXPasswordField mdp2;
    @FXML
    private JFXButton annuler;
    @FXML
    private JFXTextField email;
    @FXML
    private Text emailAlert;

    /**
     * Initializes the controller class.
     */
     Stage stage;
    Parent root;
    
    Membre user=new Membre();
    CompteMembre u=new CompteMembre();
    
    @FXML
    private JFXTextField profession;
    
    
    
    
    @FXML
    private Text mdp2Alert;
    @FXML
    private Text nomAlert;
    @FXML
    private Text prenomAlert;
    @FXML
    private Text professionAlert;
    @FXML
    private Text paysAlert;
    
    ObservableList<String> list = FXCollections.observableArrayList("Afghanistan", "Afrique du Sud", "Akrotiri\n", "Albanie\n"
   ,"Algérie", "Allemagne\n", "Andorre\n", "Angola\n", "Anguilla\n", "Antarctique\n", "Antigua-et-Barbuda\n", "Antilles néerlandaises\n", "Arabie saoudite\n", "Arctic Ocean\n"
            ,"Argentine\n", "Arménie\n"
            , "Aruba\n"
            , "Ashmore and Cartier Islands\n"
            , "Atlantic Ocean\n"
            , "Australie\n"
            , "Autriche\n"
            , "Azerbaïdjan\n"
            , "Bahamas\n"
            , "Bahreïn\n"
            , "Bangladesh\n"
            , "Barbade\n"
            , "Belau\n"
            , "Belgique\n"
            , "Belize\n"
            , "Bénin\n"
            , "Bermudes\n"
            , "Bhoutan\n"
            , "Biélorussie\n"
           , "Birmanie\n"
            , "Bolivie\n"
            , "Bosnie-Herzégovine\n"
            , "Botswana\n"
            , "Brésil\n"
            , "Brunei\n"
            , "Bulgarie\n"
            , "Burkina Faso\n"
            , "Burundi\n"
            , "Cambodge\n"
            , "Cameroun\n"
            , "Canada\n"
            , "Cap-Vert\n"
            , "Chili\n"
            , "Chine\n"
            , "Chypre\n"
            , "Clipperton Island\n"
            , "Colombie\n"
            , "Comores\n"
            , "Congo\n"
            , "Coral Sea Islands\n"
            , "Corée du Nord\n"
            ,"Terres australes françaises"
            , "Territoire britannique de l'Océan Indien"
            ,"Thaïlande"
            ,"Timor Oriental"
            ,"Togo"
            , "Tokélaou"
            , "Tonga"
            , "Trinité-et-Tobago"
            ,"Tunisie"
            ,"Turkménistan"
            , "Turquie"
            , "Tuvalu"
            , "Ukraine"
            , "Union européenne"
            , "Uruguay"
            ,"Vanuatu"
            , "Venezuela"
            ,"Viêt Nam"
            ,"Wake Island"
           , "Wallis-et-Futuna"
            , "West Bank"
            ,"Yémen"
            , "Zambie"
            , "Zimbabwe");
    @FXML
    private ImageView photo;
    @FXML
    private JFXButton browse;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         pays.setItems(list);
        // TODO
    }    

    @FXML
    private void verifierUsername(KeyEvent event) {
         if (u.seekUserByLogin(username.getText()) == true)
            usernameAlert.setText("username existe déjà");
       
        else
            usernameAlert.setText("");
    }
    

    @FXML
    private void securitePassword(KeyEvent event) {
        int maj=0,number=0;
        int totale=0;
        mdpAlert.setText("");
        totale=mdp1.getText().length();
        
       
        for(int i = 0; i<mdp1.getText().length();i++)
        {
        if(Character.isUpperCase(mdp1.getText().charAt(i)))
            maj++;

        else if(Character.isDigit(mdp1.getText().charAt(i)))
            number++;
        }
        if(maj>=1&&number>=1&totale>8)
        {mdpAlert.setText("mot de passe securisé");}
         if(totale<8&totale>0) // >0 car si j'effece le mot passe text devient vide
        {mdpAlert.setText("minim 8 caractere");}
         if((maj<1||number<1)&(totale>8))
          {mdpAlert.setText("minimun une lettre majuscule et un numero");}
        
    }
    

    @FXML
    private void registerC(ActionEvent event) throws IOException {
        
     
        usernameAlert.setText("");
        emailAlert.setText("");
        nomAlert.setText("");
        prenomAlert.setText("");
        mdpAlert.setText("");
        mdp2.setText("");
        dateAlert.setText("");
        
        
        boolean champsValide = true;
       boolean controle = false;
        if (prenom.getText().isEmpty()) {
            nomAlert.setText("Veuillez saisir votre prenom ");
            champsValide = false;
        }
        if (nom.getText().isEmpty()) {
            prenomAlert.setText("Veuillez saisir votre nom");
            champsValide = false;
        }
          String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
                        + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
               Pattern pattern = Pattern.compile(masque);
               Matcher controler = pattern.matcher(email.getText());
               if (controler.matches()){
                     emailAlert.setText("email correct");
                     controle=true;
               }
               if(!controle){
                     emailAlert.setText("email incorrect");
                     champsValide=false;
               }
    
         else{
        if (email.getText().isEmpty()) {
            emailAlert.setText("Veuillez saisir votre e-mail ");
            champsValide = false;
        } else if (u.seekUserByEmail(email.getText())) {
            emailAlert.setText("Cet email existe déjà");
            champsValide = false;
            }
}
        if (mdp1.getText().isEmpty()) {
            mdpAlert.setText("Veuillez saisir votre mot de passe");
            champsValide = false;
        }
        else if(mdp1.getText().equals(mdp2.getText()))
        {
            champsValide = true;
        }
        if (username.getText().isEmpty())
        {
            usernameAlert.setText("Veuillez saisir un pseudo");
            champsValide = false;
        }
        else if (u.seekUserByLogin(username.getText()) == true)
        {
            usernameAlert.setText("Ce login existe déjà");
            champsValide = false;
        }
        if(date.valueProperty().getValue()==null)
        {
            dateAlert.setText("Veuillez selectionner votre date de naissance");
            champsValide = false;
        }
        else if (new Date().before(java.sql.Date.valueOf(date.valueProperty().getValue())))
        {
         dateAlert.setText("cette date n'est pas encore passée!!!");
         champsValide = false;
        }
        if (pays.getValue()==null)
        {
            paysAlert.setText("Veuillez selectionner votre pays");
            champsValide = false;
        }
        if(profession.getText().isEmpty())
        { champsValide = false;
          professionAlert.setText("saisir votre profession");
        }
        
            if (champsValide) {
                 Membre user = new Membre(0, nom.getText(), prenom.getText(),email.getText(), java.sql.Date.valueOf(date.valueProperty().getValue()),mdp1.getText(),username.getText(),profession.getText(),pays.getValue(),pic );
                 
              u.ajouterMembre(user);
               stage = (Stage) register.getScene().getWindow();
         
                root = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));

                 Scene scene = new Scene(root);

                 stage.setScene(scene);

                 stage.show();
            }
    
    }

        
    

    @FXML
    private void verifierBirthday(ActionEvent event) {
         dateAlert.setText("");
        if(date.valueProperty().getValue()==null)
        {
            dateAlert.setText("Veuillez selectionner votre date de naissance");
        }
        else if (new Date().before(java.sql.Date.valueOf(date.valueProperty().getValue())))
        {
         dateAlert.setText("cette date n'est pas encore passée !!!!");
        }
    }

    @FXML
    private void verifierEmail(KeyEvent event) {
         String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"
                        + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
               Pattern pattern = Pattern.compile(masque);
               Matcher controler = pattern.matcher(email.getText());
               if (controler.matches()){
                     emailAlert.setText("email correct");
               }
               else{
                     emailAlert.setText("email incorrect");
               }
    }

    @FXML
    private void annuler(ActionEvent event) throws IOException {
         Parent root=FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
        Scene scene=new Scene (root);
        Stage Sc=new Stage();
        Sc.setScene(scene);
        Sc.setMaximized(true);
        Sc.getIcons().add(new Image("/image/petit.png"));
        Sc.show();
        final Node source=(Node) event.getSource();
        final Stage stage=(Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void addPhoto(ActionEvent event) {
        
         FileChooser fileChooser = new FileChooser();
        file= fileChooser.showOpenDialog(null);
         FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
              
        pic=(file.toURI().toString());
        image= new Image(pic);
        photo.setImage(image);
    }
      
    private File file;
    private Image image;
    String pic;
    
}
